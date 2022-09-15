package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.CategoryModel;
import com.acs.ecommerce.api.service.iservice.ICategory;

import java.util.*;

public class CategoryServiceImpl implements ICategory {


    private static final List<CategoryModel> categories = new ArrayList<>();

    public List<CategoryModel> get() {
        return categories;
    }

    public CategoryModel getByProduct(String idProduct) {
        Optional<CategoryModel> optionalCategory = categories.stream(
                .filter(product -> product.getIdProduct.equals(idProduct))
                .findFirst();

        return optionalCategory.orElse(null);
    }

    public CategoryModel create(CategoryModel categoryModel) {
        if (user == "Admin") {
            categoryModel.setId(Long.valueOf(UUID.randomUUID().toString()));
            categoryModel.setCreationDate(new Date(System.currentTimeMillis()));
            categories.add(categoryModel);
            return categoryModel;
        } else {
            return null;
        }
    }


    //    - La api deberá permitir editar una categoría sí y solo sí no se ha asociado a un producto.
//- Solo se podrá editar el texto de la categoría.
    public ResponseEntity<CategoryModel> editCategory(@RequestBody CategoryModel categoryModel) {
        return null;
    }



    //  - La api deberá permitir eliminar una categoría sí y solo sí esta no ha sido asociada a un producto.
    public ResponseEntity<CategoryModel> deleteCategory(@RequestBody CategoryModel categoryModel) {
        if(categoryModel.getProducts().isEmpty()){
            categories.remove(categoryModel);
            return ResponseEntity.ok(categoryModel);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

}
