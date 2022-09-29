package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.CategoryModel;
import com.acs.ecommerce.api.service.iservice.ICategory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("category")
public class CategoryServiceImpl implements ICategory {

    private static List<CategoryModel> categories = new ArrayList<>();
    //instanciar servicio de productos

    public CategoryServiceImpl(List<CategoryModel> categoryMockList) {
        categories = categoryMockList;
    }

    //    - La api deberá permitir retornar todos los nombres de las categorias categorías.
    @Override
    public List<CategoryModel> getAllCategories() {
        return categories;
    }

//    - La api deberá permitir crear una categoría solamente a usuarios de tipo administrador.
//- El nombre de la categoría no deberá superar los 100 caracteres.
//- No se debe permitir la duplicidad de una categoría.
    @Override
    public CategoryModel createCategory(CategoryModel categoryModel) {
        if (categoryModel.getName().length() > 100) {
            return null;
        }

        Optional<CategoryModel> optionalCategory = categories.stream()
                .filter(category -> category.getName().equals(categoryModel.getName()))
                .findFirst();

        if (optionalCategory.isPresent()) {
            return null;
        }


            categoryModel.setId(Long.valueOf(UUID.randomUUID().toString()));
            categoryModel.setCreationDate(new Date(System.currentTimeMillis()));
            categories.add(categoryModel);
            return categoryModel;



    }


//    - La api deberá permitir editar una categoría sí y solo sí no se ha asociado a un producto.
//- Solo se podrá editar el texto de la categoría.

    @Override
    public CategoryModel updateCategory(String idCategory, CategoryModel categoryModel) {

        Optional<CategoryModel> optionalCategory = categories.stream()
                .filter(category -> category.getId().equals(idCategory))
                .findFirst();

        if (optionalCategory.isPresent()) {
            CategoryModel categoryModelFound = optionalCategory.get();
            categoryModelFound.setName(categoryModel.getName());
            return categoryModelFound;
        }
        return null;
    }

    //- La api deberá permitir eliminar una categoría sí y solo sí esta no ha sido asociada a un producto.
    @Override
    public boolean deleteCategory(String idProduct) {
        Optional<CategoryModel> optionalCategory = categories.stream()
                .filter(category -> category.getId().equals(idProduct))
                .findFirst();

        if (optionalCategory.isPresent()) {
            CategoryModel categoryModelFound = optionalCategory.get();
                categories.remove(categoryModelFound);
                return true;
        }

        return false;


    }
}
