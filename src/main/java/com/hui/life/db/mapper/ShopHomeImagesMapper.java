package com.hui.life.db.mapper;

import com.hui.life.db.entity.ShopHomeImagesEntity;

import java.util.List;

public interface ShopHomeImagesMapper {

    int insert(ShopHomeImagesEntity shopHomeImages);

    List<ShopHomeImagesEntity> findByShopId(Integer shopId);

    int deleteByShopId(Integer shopId);

    int deleteById(Integer id);

    int update(ShopHomeImagesEntity shopHomeImages);

    ShopHomeImagesEntity findById(Integer id);

}
