package com.acs.ecommerce.api.service.iservice;


import com.acs.ecommerce.api.model.CategoryModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategory {
    List<CategoryModel> getAllCategories();

    CategoryModel createCategory(CategoryModel categoryModel);
    CategoryModel updateCategory(String idProduct, CategoryModel categoryModel);
    boolean deleteCategory(String idProduct);

}
