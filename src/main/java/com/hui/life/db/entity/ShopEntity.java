package com.hui.life.db.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShopEntity {
    private Integer id;

    private String name;

    private String description;

    private String address;

    private Integer categoryId;

    private Double latitude;

    private Double longitude;

    private String phone;
}
