package com.hui.life.db.mapper;

import com.hui.life.db.entity.ShopRecommendationsEntity;

import java.util.List;

public interface ShopRecommendationsMapper {
    int insert(ShopRecommendationsEntity shopRecommendations);

    ShopRecommendationsEntity findById(Integer id);

    List<ShopRecommendationsEntity> findAll();

    int update(ShopRecommendationsEntity shopRecommendations);

    int delete(Integer id);
}