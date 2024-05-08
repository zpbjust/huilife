package com.hui.life.controller;

import com.hui.life.adapt.ShopRecommendationsApi;
import com.hui.life.db.entity.ShopRecommendationsEntity;
import com.hui.life.model.ShopRecommendations;
import com.hui.life.service.ShopRecommendationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShopRecommendationsController implements ShopRecommendationsApi {

    private final ShopRecommendationsService shopRecommendationsService;

    @Override
    public ResponseEntity<ShopRecommendations> createShopRecommendation(ShopRecommendations shopRecommendations) {
        shopRecommendationsService.createShopRecommendation(parserShopRecommendations(shopRecommendations));
        return ResponseEntity.ok(shopRecommendations);
    }

    @Override
    public ResponseEntity<Void> deleteShopRecommendation(Integer id) {
        shopRecommendationsService.deleteShopRecommendation(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<ShopRecommendations> getShopRecommendationById(Integer id) {
        return ResponseEntity.ok(parserShopRecommendationsEntity(shopRecommendationsService.getShopRecommendationById(id)));
    }

    @Override
    public ResponseEntity<List<ShopRecommendations>> getAllShopRecommendations() {
        List<ShopRecommendationsEntity> shopRecommendationsEntities = shopRecommendationsService.getAllShopRecommendations();
        List<ShopRecommendations> shopRecommendations = shopRecommendationsEntities.stream().map(this::parserShopRecommendationsEntity).toList();
        return ResponseEntity.ok(shopRecommendations);
    }

    @Override
    public ResponseEntity<ShopRecommendations> updateShopRecommendation(Integer id, ShopRecommendations shopRecommendations) {
        shopRecommendationsService.updateShopRecommendation(parserShopRecommendations(shopRecommendations));
        return ResponseEntity.ok(shopRecommendations);
    }

    private ShopRecommendations parserShopRecommendationsEntity(ShopRecommendationsEntity shopRecommendationsEntity) {
        return new ShopRecommendations().weight(shopRecommendationsEntity.getWeight()).shopId(shopRecommendationsEntity.getShopId()).id(shopRecommendationsEntity.getId());
    }

    private ShopRecommendationsEntity parserShopRecommendations(ShopRecommendations shopRecommendations) {
        return ShopRecommendationsEntity.builder()
                .shopId(shopRecommendations.getShopId())
                .weight(shopRecommendations.getWeight())
                .id(shopRecommendations.getId())
                .build();
    }
}
