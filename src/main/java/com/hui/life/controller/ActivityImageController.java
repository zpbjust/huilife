package com.hui.life.controller;

import com.hui.life.adapt.ActivityImagesApi;
import com.hui.life.db.entity.ActivityImagesEntity;
import com.hui.life.model.ActivityImages;
import com.hui.life.service.ActivityImageService;
import com.hui.life.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ActivityImageController implements ActivityImagesApi {
    private final FileService fileService;
    private final ActivityImageService activityImageService;

    @Override
    @Transactional
    public ResponseEntity<ActivityImages> addImageToActivity(Integer activityId, MultipartFile image) {
        String path = generalFilePath(activityId, image);
        fileService.uploadFile(image, path);
        activityImageService.addImageToActivity(ActivityImagesEntity.builder().activityId(activityId).imageUrl(path).build());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<ActivityImages> getImageById(Integer id) {
        ActivityImagesEntity entity = activityImageService.getImageById(id);
        return ResponseEntity.ok(parserActivityImageEntity(entity));
    }

    @Override
    public ResponseEntity<List<ActivityImages>> getImagesByActivityId(Integer activityId) {
        List<ActivityImagesEntity> entities = activityImageService.getImagesByActivityId(activityId);
        return ResponseEntity.ok(entities.stream().map(this::parserActivityImageEntity).toList());
    }

    @Override
    @Transactional
    public ResponseEntity<Void> deleteImage(Integer id) {
        ActivityImagesEntity entity = activityImageService.getImageById(id);
        fileService.deleteFile(entity.getImageUrl());
        activityImageService.deleteImage(id);
        return ResponseEntity.ok().build();
    }

    private String generalFilePath(Integer activityId, MultipartFile image) {
        return String.format("activity/%d/%s", activityId, image.getOriginalFilename());
    }

    private ActivityImages parserActivityImageEntity(ActivityImagesEntity entity) {
        return new ActivityImages().activityId(entity.getActivityId()).id(entity.getId()).imageUrl(entity.getImageUrl());
    }

    private ActivityImagesEntity parserActivityImage(ActivityImages activityImages) {
        return ActivityImagesEntity.builder().activityId(activityImages.getActivityId()).id(activityImages.getId()).imageUrl(activityImages.getImageUrl()).build();
    }
}
