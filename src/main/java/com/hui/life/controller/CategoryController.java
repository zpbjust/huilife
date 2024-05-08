package com.hui.life.controller;

import com.hui.life.adapt.CategoriesApi;
import com.hui.life.db.entity.CategoryEntity;
import com.hui.life.model.Category;
import com.hui.life.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController implements CategoriesApi {

    private final CategoryService categoryService;

    @Override
    public ResponseEntity<Category> createCategory(Category category) {
        categoryService.createCategory(parserCategory(category));
        return ResponseEntity.ok(category);
    }

    @Override
    public ResponseEntity<Category> getCategoryById(Integer id) {
        categoryService.getCategoryById(id);
        return ResponseEntity.ok(parserCategoryEntity(categoryService.getCategoryById(id)));
    }

    @Override
    public ResponseEntity<Category> updateCategory(Integer id, Category category) {
        categoryService.updateCategory(parserCategory(category));
        return ResponseEntity.ok(category);
    }

    @Override
    public ResponseEntity<List<Category>> getAllCategories() {
        List<CategoryEntity> categoryEntities = categoryService.getAllCategories();
        List<Category> categories = categoryEntities.stream().map(this::parserCategoryEntity).toList();
        return ResponseEntity.ok(categories);
    }

    @Override
    public ResponseEntity<Void> deleteCategory(Integer id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }

    private CategoryEntity parserCategory(Category category) {
        return CategoryEntity.builder()
                .name(category.getName())
                .description(category.getDescription()).id(category.getId())
                .build();
    }

    private Category parserCategoryEntity(CategoryEntity categoryEntity) {
        return new Category().name(categoryEntity.getName())
                .description(categoryEntity.getDescription())
                .parentId(categoryEntity.getParentId())
                .id(categoryEntity.getId());
    }
}
