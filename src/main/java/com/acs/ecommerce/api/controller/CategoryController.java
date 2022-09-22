package com.acs.ecommerce.api.controller;

import com.acs.ecommerce.api.model.CategoryModel;
import com.acs.ecommerce.api.model.ProductModel;
import com.acs.ecommerce.api.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    //- La api deberá permitir consultar todas las categorías asociadas a un producto.
    @GetMapping("/category/{idProduct}")
    public ResponseEntity<CategoryModel> getCategory(@PathVariable String idCategory) {
        CategoryModel categoryModel = categoryService.getCategory(idCategory);
        return ResponseEntity.ok(categoryModel);
    }

    //- La api deberá permitir crear una categoría solamente a usuarios de tipo administrador.
    //- El nombre de la categoría no deberá superar los 100 caracteres.
    //- No se debe permitir la duplicidad de una categoría.
    @PostMapping("/category")
    public ResponseEntity<CategoryModel> create(@RequestBody CategoryModel categoryModel) {
        CategoryModel categoryModelCreated = categoryService.create(categoryModel);
        return ResponseEntity.ok(categoryModelCreated);
    }

    //- La api deberá permitir editar una categoría sí y solo sí no se ha asociado a un producto.
    //- Solo se podrá editar el texto de la categoría.
    @PutMapping("/category/{idProduct}")
    public ResponseEntity<CategoryModel> update(@PathVariable String idProduct, @RequestBody CategoryModel categoryModel) {
        CategoryModel categoryModelUpdated = categoryService.update(idProduct, categoryModel);
        return ResponseEntity.ok(categoryModelUpdated);
    }

    }

    //- La api deberá permitir eliminar una categoría sí y solo sí no se ha asociado a un producto.
    @DeleteMapping("/category/{idProduct}")
    public ResponseEntity<Boolean> delete(@PathVariable String idProduct) {
        boolean deleted = categoryService.delete(idProduct);
        return ResponseEntity.ok(deleted);
    }



}