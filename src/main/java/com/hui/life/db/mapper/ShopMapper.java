package com.hui.life.db.mapper;

import com.hui.life.db.entity.ShopEntity;

import java.util.List;

public interface ShopMapper {
    int insert(ShopEntity shop);

    ShopEntity findById(Integer id);

    List<ShopEntity> findAll();

    int update(ShopEntity shop);

    int delete(Integer id);

    List<ShopEntity> findByCategoryId(Integer categoryId);
}