package com.hui.life.service;

import com.hui.life.db.entity.ShopRecommendationsEntity;
import com.hui.life.db.mapper.ShopRecommendationsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShopRecommendationsService {
    private final ShopRecommendationsMapper shopRecommendationsMapper;

    public void createShopRecommendation(ShopRecommendationsEntity shopRecommendations) {
        shopRecommendationsMapper.insert(shopRecommendations);
    }

    public void updateShopRecommendation(ShopRecommendationsEntity shopRecommendations) {
        shopRecommendationsMapper.update(shopRecommendations);
    }

    public void deleteShopRecommendation(Integer id) {
        shopRecommendationsMapper.delete(id);
    }

    public ShopRecommendationsEntity getShopRecommendationById(Integer id) {
        return shopRecommendationsMapper.findById(id);
    }

    public List<ShopRecommendationsEntity> getAllShopRecommendations() {
        return shopRecommendationsMapper.findAll();
    }
}
