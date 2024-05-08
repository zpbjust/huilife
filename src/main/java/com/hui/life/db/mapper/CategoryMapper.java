package com.hui.life.db.mapper;


import com.hui.life.db.entity.CategoryEntity;

import java.util.List;

public interface CategoryMapper {
    int insert(CategoryEntity category);

    CategoryEntity findById(Integer id);

    CategoryEntity findByDescription(String description);

    CategoryEntity findByName(String name);

    List<CategoryEntity> findAll();


    int update(CategoryEntity category);

    int delete(Integer id);
}
