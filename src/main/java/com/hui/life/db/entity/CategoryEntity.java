package com.hui.life.db.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryEntity {
    private String name;
    private Integer id;
    private String description;
    private Integer parentId;

}
