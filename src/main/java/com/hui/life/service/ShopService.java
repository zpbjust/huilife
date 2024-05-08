package com.hui.life.service;

import com.hui.life.db.entity.ShopEntity;
import com.hui.life.db.mapper.ShopMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopMapper shopMapper;

    public void createShop(ShopEntity shop) {
        shopMapper.insert(shop);
    }

    public void updateShop(ShopEntity shop) {
        shopMapper.update(shop);
    }

    public void  deleteShop(Integer id) {
        shopMapper.delete(id);
    }

    public ShopEntity getShopById(Integer id) {
        return shopMapper.findById(id);
    }

    public List<ShopEntity> getAllShops() {
        return shopMapper.findAll();
    }

    public List<ShopEntity> getShopsByCategoryId(Integer categoryId) {
        return shopMapper.findByCategoryId(categoryId);
    }
}
