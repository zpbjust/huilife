package com.hui.life.service;

import com.hui.life.db.entity.ShopHomeImagesEntity;
import com.hui.life.db.mapper.ShopHomeImagesMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShopHomeImageService {
    private final ShopHomeImagesMapper shopHomeImagesMapper;

    public void addImageToShop(ShopHomeImagesEntity entity) {
        shopHomeImagesMapper.insert(entity);
    }

    public void deleteImage(Integer id) {
        shopHomeImagesMapper.deleteById(id);
    }

    public List<ShopHomeImagesEntity> getImagesByShopId(Integer shopId) {
        return shopHomeImagesMapper.findByShopId(shopId);
    }

    public void deleteByShopId(Integer shopId) {
        shopHomeImagesMapper.deleteByShopId(shopId);
    }

    public ShopHomeImagesEntity getImageById(Integer id) {
        return shopHomeImagesMapper.findById(id);
    }

}
