package com.hui.life.controller;

import com.hui.life.adapt.HomeImagesApi;
import com.hui.life.db.entity.ShopHomeImagesEntity;
import com.hui.life.model.ShopHomeImages;
import com.hui.life.service.FileService;
import com.hui.life.service.ShopHomeImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShopHomeImageController implements HomeImagesApi {
    private final ShopHomeImageService shopHomeImageService;

    private final FileService fileService;

    @Override
    public ResponseEntity<List<ShopHomeImages>> getHomeImagesByShopId(Integer shopId) {
        return ResponseEntity.ok(shopHomeImageService.getImagesByShopId(shopId).stream().map(this::parserShopHomeImagesEntity).toList());
    }

    @Override
    public ResponseEntity<ShopHomeImages> addHomeImageToShop(Integer shopId, MultipartFile image) {
        String path = generalFilePath(shopId, image);
        fileService.uploadFile(image, path);
        shopHomeImageService.addImageToShop(ShopHomeImagesEntity.builder().shopId(shopId).imageUrl(path).build());
        return ResponseEntity.ok().build();
    }


    @Override
    public ResponseEntity<Void> deleteHomeImage(Integer id) {
        ShopHomeImagesEntity shopHomeImagesEntity = shopHomeImageService.getImageById(id);
        fileService.deleteFile(shopHomeImagesEntity.getImageUrl());
        shopHomeImageService.deleteImage(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteAllHomeImagesOfShop(Integer shopId) {
        List<ShopHomeImagesEntity> shopHomeImagesEntities = shopHomeImageService.getImagesByShopId(shopId);
        shopHomeImagesEntities.forEach(shopHomeImagesEntity -> fileService.deleteFile(shopHomeImagesEntity.getImageUrl()));
        shopHomeImageService.deleteByShopId(shopId);
        return ResponseEntity.ok().build();
    }

    private ShopHomeImages parserShopHomeImagesEntity(ShopHomeImagesEntity shopHomeImagesEntity) {
        return new ShopHomeImages().id(shopHomeImagesEntity.getId()).shopId(shopHomeImagesEntity.getShopId()).imageUrl(shopHomeImagesEntity.getImageUrl());
    }

    private String generalFilePath(Integer shopId, MultipartFile image) {
        return String.format("shop_home/%d/%s", shopId, image.getOriginalFilename());
    }
}
