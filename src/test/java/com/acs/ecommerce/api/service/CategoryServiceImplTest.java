package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.CategoryModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceImplTest {

    private static final List<CategoryModel> categoryMockList = new ArrayList<>();
    private final CategoryServiceImpl categoryService;

    CategoryModel categoryModel;


    public CategoryServiceImplTest() {
        categoryService = new CategoryServiceImpl(categoryMockList);
    }

    @BeforeEach
    void setUp() {
        categoryModel = new CategoryModel(1, "Category", null);
        categoryMockList.add(categoryModel);
    }

    @Test
    void getAllCategories() {
        List<CategoryModel> categoryModelList = categoryService.getAllCategories();
        assertEquals(2, categoryModelList.size());
    }

    @Test
    void createCategory() {
        CategoryModel categoryModel = new CategoryModel(2, "Category2", null);
        CategoryModel categoryModelCreated = categoryService.createCategory(categoryModel);
        assertEquals(categoryModelCreated, categoryModel);
    }


    @Test
    void createCategoryWithSameId() {
        CategoryModel categoryModel = new CategoryModel(1, "Category 2", null);
        CategoryModel categoryModelCreated = categoryService.createCategory(categoryModel);
        assertNull(categoryModelCreated);
    }

    @Test
    void createCategoryWithSameName() {
        CategoryModel categoryModel = new CategoryModel(2, "Category", null);
        CategoryModel categoryModelCreated = categoryService.createCategory(categoryModel);
        assertNull(categoryModelCreated);
    }

    @Test
    void deleteCategory() {
        categoryService.deleteCategory(1);
        List<CategoryModel> categoryModelList = categoryService.getAllCategories();
        assertEquals(0, categoryModelList.size());
    }






}