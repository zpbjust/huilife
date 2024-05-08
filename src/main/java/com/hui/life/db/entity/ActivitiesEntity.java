package com.hui.life.db.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActivitiesEntity {
    private Integer id;

    private String title;

    private String content;

    private Integer weight;

    private Integer shopId;
}
