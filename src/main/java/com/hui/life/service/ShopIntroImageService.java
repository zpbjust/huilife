package com.hui.life.service;

import com.hui.life.db.entity.ShopIntroImagesEntity;
import com.hui.life.db.mapper.ShopIntroImageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShopIntroImageService {
    private final ShopIntroImageMapper shopIntroImageMapper;

    public void deleteImage(Integer id) {
        shopIntroImageMapper.deleteById(id);
    }

    public void deleteByShopId(Integer shopId) {
        shopIntroImageMapper.deleteByShopId(shopId);
    }

    public void addImageToShop(ShopIntroImagesEntity entity) {
        shopIntroImageMapper.insert(entity);
    }

    public ShopIntroImagesEntity getImageById(Integer id) {
        return shopIntroImageMapper.findById(id);
    }

    public List<ShopIntroImagesEntity> getImagesByShopId(Integer shopId) {
        return shopIntroImageMapper.findByShopId(shopId);
    }
}
