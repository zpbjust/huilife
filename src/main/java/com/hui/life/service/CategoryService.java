package com.hui.life.service;

import com.hui.life.db.entity.CategoryEntity;
import com.hui.life.db.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryMapper categoryMapper;

    public void createCategory(CategoryEntity category) {
        categoryMapper.insert(category);
    }

    public void updateCategory(CategoryEntity category) {
        categoryMapper.update(category);
    }

    public void deleteCategory(Integer id) {
        categoryMapper.delete(id);
    }

    public CategoryEntity getCategoryById(Integer id) {
        return categoryMapper.findById(id);
    }

    public CategoryEntity getCategoryByDescription(String description) {
        return categoryMapper.findByDescription(description);
    }

    public List<CategoryEntity> getAllCategories() {
        return categoryMapper.findAll();
    }



}
