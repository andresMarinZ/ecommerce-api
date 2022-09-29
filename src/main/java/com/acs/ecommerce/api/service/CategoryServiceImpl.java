package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.CategoryModel;
import com.acs.ecommerce.api.service.iservice.ICategory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("category")
public class CategoryServiceImpl implements ICategory {

    private static List<CategoryModel> categories = new ArrayList<>();

    public CategoryServiceImpl(List<CategoryModel> categoryMockList) {
        categories = categoryMockList;
    }

    //Get name of categories
    @Override
    public List<CategoryModel> getAllCategories() {
        return categories;
    }

    //    -The api should create a category only if the users type is ADMIN
    //- The name of the category should not pass 100 characters
    //- The category should not have the same name as another category
    @Override
    public CategoryModel createCategory(CategoryModel categoryModel) {
        if (categoryModel.getName().length() > 100) {
            return null;
        }
        if (categories.stream().anyMatch(category -> category.getName().equals(categoryModel.getName()))) {
            return null;
        }
        if (categories.stream().anyMatch(category -> category.getId().equals(categoryModel.getId()))) {
            return null;
        }
        categoryModel.setId(categoryModel.getId());
        categoryModel.setCreationDate(new Date());
        categories.add(categoryModel);
        return categoryModel;
    }


    //- Only can edit the name of the category

    @Override
    public CategoryModel updateCategory(Integer idCategory, CategoryModel categoryModel) {
        Optional<CategoryModel> categoryModelOptional = categories.stream().filter(category -> category.getId().equals(idCategory)).findFirst();
        if (categories.stream().anyMatch(category -> category.getName().equals(categoryModel.getName()))) {
            return null;
        }
        if (categoryModelOptional.isPresent()) {
            CategoryModel categoryModel1 = categoryModelOptional.get();
            categoryModel1.setName(categoryModel.getName());
            return categoryModel1;
        }
        return null;
    }


    //- The api should permit delete a category
    @Override
    public boolean deleteCategory(Integer idCategory) {
        Optional<CategoryModel> categoryModelOptional = categories.stream().filter(category -> category.getId().equals(idCategory)).findFirst();
        if (categoryModelOptional.isPresent()) {
            CategoryModel categoryModelFound = categoryModelOptional.get();
            categories.removeIf(category -> category.getId().equals(categoryModelFound.getId()));
            return true;
        }
        return false;
    }

}
