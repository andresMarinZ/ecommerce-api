package com.acs.ecommerce.api.controller;

import com.acs.ecommerce.api.model.CategoryModel;
import com.acs.ecommerce.api.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    //- La api deberá permitir consultar todas las categorías .
    @GetMapping("/category}")
    public ResponseEntity<List<CategoryModel>> getAllCategories() {
        if(categoryService.getAllCategories().isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    //- La api deberá permitir crear una categoría solamente a usuarios de tipo administrador.
    //- El nombre de la categoría no deberá superar los 100 caracteres.
    //- No se debe permitir la duplicidad de una categoría.
    @PostMapping("/category")
    public ResponseEntity<CategoryModel> createCategory(@RequestBody CategoryModel categoryModel) {
        CategoryModel categoryModelCreated = categoryService.createCategory(categoryModel);
        if (categoryModelCreated == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(categoryModelCreated);
    }

    //- La api deberá permitir editar una categoría sí y solo sí no se ha asociado a un producto.
    //- Solo se podrá editar el texto de la categoría.
    @PutMapping("/category/{idCategory}")
    public ResponseEntity<CategoryModel> updateCategory(@PathVariable String idCategory, @RequestBody CategoryModel categoryModel) {
        CategoryModel categoryModelUpdated = categoryService.updateCategory(idCategory, categoryModel);
        if (categoryModelUpdated == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(categoryModelUpdated);
    }


    //- La api deberá permitir eliminar una categoría sí y solo sí no se ha asociado a un producto.
    @DeleteMapping("/category/{idProduct}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable String idProduct) {
        if (categoryService.deleteCategory(idProduct)) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.badRequest().build();
    }



}