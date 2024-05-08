package com.hui.life.service;

import com.hui.life.db.entity.ActivityImagesEntity;
import com.hui.life.db.mapper.ActivityImagesMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ActivityImageService {
    private final ActivityImagesMapper activityImagesMapper;

    public void addImageToActivity(ActivityImagesEntity entity) {
        activityImagesMapper.insert(entity);
    }

    public void deleteImage(Integer id) {
        activityImagesMapper.delete(id);
    }

    public ActivityImagesEntity getImageById(Integer id) {
        return activityImagesMapper.findById(id);
    }

    public List<ActivityImagesEntity> getImagesByActivityId(Integer activityId) {
        return activityImagesMapper.findActivityImagesByActivityId(activityId);
    }
}
