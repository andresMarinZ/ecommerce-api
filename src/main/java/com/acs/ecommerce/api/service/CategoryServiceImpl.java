package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.CategoryModel;
import com.acs.ecommerce.api.service.iservice.ICategory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("category")
public class CategoryServiceImpl implements ICategory {

    private static final List<CategoryModel> categories = new ArrayList<>();

//    - La api deberá permitir consultar todas las categorías asociadas a un producto.
    @Override
    public CategoryModel getByProduct(String idProduct) {
        Optional<CategoryModel> optionalCategory = categories.stream()
                .filter(product -> product.getIdProduct.equals(idProduct))
                .findFirst();

        return optionalCategory.orElse(null);
    }

//    - La api deberá permitir crear una categoría solamente a usuarios de tipo administrador.
//- El nombre de la categoría no deberá superar los 100 caracteres.
//- No se debe permitir la duplicidad de una categoría.
    @Override
    public CategoryModel create(CategoryModel categoryModel) {
        if (categoryModel.getName().length() > 100) {
            return null;
        }

        Optional<CategoryModel> optionalCategory = categories.stream()
                .filter(category -> category.getName().equals(categoryModel.getName()))
                .findFirst();

        if (optionalCategory.isPresent()) {
            return null;
        }

        if (user.getRole().equals("admin")) {
            categoryModel.setId(Long.valueOf(UUID.randomUUID().toString()));
            categoryModel.setCreationDate(new Date(System.currentTimeMillis()));
            categories.add(categoryModel);

        }

        return categoryModel;

    }


//    - La api deberá permitir editar una categoría sí y solo sí no se ha asociado a un producto.
//- Solo se podrá editar el texto de la categoría.

    @Override
    public CategoryModel update(String idProduct, CategoryModel categoryModel) {
        CategoryModel oldCategory = getByProduct(idProduct);

        if (Objects.isNull(oldCategory)) {
            return null;
        }

        oldCategory.setName(categoryModel.getName());

        return oldCategory;
    }

    //- La api deberá permitir eliminar una categoría sí y solo sí esta no ha sido asociada a un producto.
    @Override
    public boolean delete(String idProduct) {
        CategoryModel category = getByProduct(idProduct);

        if (Objects.isNull(category)) {
            return false;
        }

        categories.remove(category);

        return true;
    }
}
