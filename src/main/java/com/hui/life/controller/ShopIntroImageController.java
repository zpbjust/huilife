package com.hui.life.controller;

import com.hui.life.adapt.IntroImagesApi;
import com.hui.life.db.entity.ShopIntroImagesEntity;
import com.hui.life.model.ShopIntroImages;
import com.hui.life.service.FileService;
import com.hui.life.service.ShopIntroImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShopIntroImageController implements IntroImagesApi {

    private final ShopIntroImageService shopIntroImageService;

    private final FileService fileService;


    @Override
    public ResponseEntity<ShopIntroImages> getIntroImageById(Integer id) {
        ShopIntroImagesEntity introImagesEntity = shopIntroImageService.getImageById(id);
        return ResponseEntity.ok(parserShopIntroImagesEntity(introImagesEntity));
    }

    @Override
    public ResponseEntity<List<ShopIntroImages>> getIntroImagesByShopId(Integer shopId) {
        return ResponseEntity.ok(shopIntroImageService.getImagesByShopId(shopId).stream().map(this::parserShopIntroImagesEntity).toList());
    }

    @Override
    public ResponseEntity<ShopIntroImages> addIntroImageToShop(Integer shopId, MultipartFile image) {
        String path = generalFilePath(shopId, image);
        fileService.uploadFile(image, path);
        shopIntroImageService.addImageToShop(ShopIntroImagesEntity.builder().shopId(shopId).imageUrl(path).build());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteAllIntroImagesOfShop(Integer shopId) {
        List<ShopIntroImagesEntity> shopIntroImagesEntities = shopIntroImageService.getImagesByShopId(shopId);
        shopIntroImagesEntities.forEach(shopIntroImagesEntity -> fileService.deleteFile(shopIntroImagesEntity.getImageUrl()));
        shopIntroImageService.deleteByShopId(shopId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteIntroImage(Integer id) {
        ShopIntroImagesEntity shopIntroImagesEntity = shopIntroImageService.getImageById(id);
        fileService.deleteFile(shopIntroImagesEntity.getImageUrl());
        shopIntroImageService.deleteImage(id);
        return ResponseEntity.ok().build();
    }


    private String generalFilePath(Integer shopId, MultipartFile image) {
        return String.format("shop_intro/%d/%s", shopId, image.getOriginalFilename());
    }

    private ShopIntroImages parserShopIntroImagesEntity(ShopIntroImagesEntity shopIntroImagesEntity) {
        return new ShopIntroImages().id(shopIntroImagesEntity.getId()).shopId(shopIntroImagesEntity.getShopId()).imageUrl(shopIntroImagesEntity.getImageUrl());
    }

}
