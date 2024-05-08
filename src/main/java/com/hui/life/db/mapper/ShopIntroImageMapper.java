package com.hui.life.db.mapper;

import com.hui.life.db.entity.ShopIntroImagesEntity;

import java.util.List;

public interface ShopIntroImageMapper {
    int insert(ShopIntroImagesEntity shopIntroImages);

    List<ShopIntroImagesEntity> findByShopId(Integer shopId);

    int deleteByShopId(Integer shopId);

    int deleteById(Integer id);

    int update(ShopIntroImagesEntity shopIntroImages);

    ShopIntroImagesEntity findById(Integer id);
}
