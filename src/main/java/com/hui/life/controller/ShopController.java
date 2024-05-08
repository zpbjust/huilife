package com.hui.life.controller;

import com.hui.life.adapt.ShopsApi;
import com.hui.life.db.entity.ShopEntity;
import com.hui.life.model.Shop;
import com.hui.life.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShopController implements ShopsApi {

    private final ShopService shopService;

    @Override
    public ResponseEntity<Shop> createShop(Shop shop) {

        shopService.createShop(parserShop(shop));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Shop> updateShop(Integer id, Shop shop) {
        shopService.updateShop(parserShop(shop));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteShop(Integer id) {
        shopService.deleteShop(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Shop>> getShopsByCategoryId(Integer categoryId) {
        List<ShopEntity> shopEntities = shopService.getShopsByCategoryId(categoryId);
        List<Shop> shops = shopEntities.stream().map(this::parserShopEntity).toList();
        return ResponseEntity.ok(shops);
    }

    @Override
    public ResponseEntity<List<Shop>> getAllShops() {
        List<ShopEntity> shopEntities = shopService.getAllShops();
        List<Shop> shops = shopEntities.stream().map(this::parserShopEntity).toList();
        return ResponseEntity.ok(shops);
    }

    private ShopEntity parserShop(Shop shop) {
        return ShopEntity.builder()
                .phone(shop.getPhone())
                .id(shop.getId())
                .name(shop.getName())
                .address(shop.getAddress())
                .categoryId(shop.getCategoryId())
                .description(shop.getDescription())
                .latitude(shop.getLatitude())
                .longitude(shop.getLongitude()).build();
    }

    @Override
    public ResponseEntity<Shop> getShopById(Integer id) {
        ShopEntity shopEntity = shopService.getShopById(id);
        return ResponseEntity.ok(parserShopEntity(shopEntity));
    }

    private Shop parserShopEntity(ShopEntity shopEntity) {
        Shop shop = new Shop();
        shop.address(shopEntity.getAddress())
                .categoryId(shopEntity.getCategoryId())
                .description(shopEntity.getDescription())
                .latitude(shopEntity.getLatitude())
                .longitude(shopEntity.getLongitude())
                .name(shopEntity.getName())
                .phone(shopEntity.getPhone())
                .id(shopEntity.getId());
        return shop;
    }
}
