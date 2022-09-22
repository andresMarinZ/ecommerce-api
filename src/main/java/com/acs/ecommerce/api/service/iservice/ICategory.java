package com.acs.ecommerce.api.service.iservice;


import com.acs.ecommerce.api.model.CategoryModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategory {
    CategoryModel getCategory(String idCategory);
    CategoryModel create(CategoryModel categoryModel);
    CategoryModel update(String idProduct, CategoryModel categoryModel);
    boolean delete(String idProduct);

}
