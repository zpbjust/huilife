package com.hui.life.db.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShopIntroImagesEntity {
    private Integer id;

    private Integer shopId;

    private String imageUrl;

    private Integer weight;
}
