package com.hui.life.db.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShopRecommendationsEntity {
    private Integer id;

    private Integer shopId;

    private Integer weight;
}
