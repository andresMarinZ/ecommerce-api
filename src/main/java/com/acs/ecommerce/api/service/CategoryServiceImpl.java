package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.CategoryModel;
import com.acs.ecommerce.api.service.iservice.ICategory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("category")
public class CategoryServiceImpl implements ICategory {

    public Integer user = 1;


    private static final List<CategoryModel> categories = new ArrayList<>();


    public CategoryModel getByProduct(String idProduct) {
        Optional<CategoryModel> optionalCategory = categories.stream()
                .filter(product -> product.getIdProduct.equals(idProduct))
                .findFirst();

        return optionalCategory.orElse(null);
    }

    public CategoryModel create(CategoryModel categoryModel) {
        if (user == 1) {
            categoryModel.setId(Long.valueOf(UUID.randomUUID().toString()));
            categoryModel.setCreationDate(new Date(System.currentTimeMillis()));
            categories.add(categoryModel);
            return categoryModel;
        } else {
            return null;
        }
    }

    @Override
    public CategoryModel update(String idProduct, CategoryModel categoryModel) {
        return null;
    }

    public boolean delete(String idProduct) {
        return false;
    }

}
