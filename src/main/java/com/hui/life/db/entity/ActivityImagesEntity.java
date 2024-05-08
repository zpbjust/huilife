package com.hui.life.db.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActivityImagesEntity {
    private Integer id;

    private Integer activityId;

    private String imageUrl;

}
