package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.CategoryModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceImplTest {

    private static final List<CategoryModel> categoryMockList = new ArrayList<>();
    private final CategoryServiceImpl categoryService;

    CategoryModel categoryModel;


    public CategoryServiceImplTest() {
        categoryService = new CategoryServiceImpl(categoryMockList);
    }

    @BeforeEach
    public void initializeCategoryList() {
        categoryMockList.clear();
        categoryMockList.add(new CategoryModel(1L, "Category 1", null));
    }


    @Test
    void getAllCategories() {
        // Should return all categories
        categoryMockList.add(categoryModel);
        List<CategoryModel> categoryModelList = categoryService.getAllCategories();
        assertEquals(categoryModelList.size(), 1);
        assertEquals(categoryModelList.get(0).getId(), 1L);
        assertEquals(categoryModelList.get(0).getName(), "Category 1");
    }

    @Test
    void createCategory() {
        // Should create a new category
        CategoryModel categoryModelCreated = categoryService.createCategory(categoryModel);
        assertEquals(categoryModelCreated.getId(), 1L);
        assertEquals(categoryModelCreated.getName(), "Category 1");
    }

    @Test
    void updateCategory() {
        // Should update a category
        categoryMockList.add(categoryModel);
        CategoryModel categoryModelUpdated = new CategoryModel(1L, "Category 1 Updated", null);
        CategoryModel categoryModelUpdatedResult = categoryService.updateCategory("1", categoryModelUpdated);
        assertEquals(categoryModelUpdatedResult.getId(), 1L);
        assertEquals(categoryModelUpdatedResult.getName(), "Category 1 Updated");
    }

    @Test
    void deleteCategory() {
        // Should delete a category
        categoryMockList.add(categoryModel);
        boolean result = categoryService.deleteCategory("1");
        assertTrue(result);
    }
}