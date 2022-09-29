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

    //Get name of categories
    @GetMapping("/category")
    public ResponseEntity<List<CategoryModel>> getAllCategories() {
        List<CategoryModel> categoryModelList = categoryService.getAllCategories();
        return categoryModelList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(categoryService.getAllCategories());
    }

    //    -The api should create a category only if the users type is ADMIN
    //- The name of the category should not pass 100 characters
    //- The category should not have the same name as another category
    @PostMapping("/category")
    public ResponseEntity<CategoryModel> createCategory(@RequestBody CategoryModel categoryModel) {
        return ResponseEntity.ok(categoryService.createCategory(categoryModel));
    }


    //- La api deberá permitir editar una categoría sí y solo sí no se ha asociado a un producto.
    //- Only can edit the name of the category
    @PutMapping("/category/{idCategory}")
    public ResponseEntity<CategoryModel> updateCategory(@PathVariable Integer idCategory, @RequestBody CategoryModel categoryModel) {
        CategoryModel categoryModel1 = categoryService.updateCategory(idCategory, categoryModel);
        return categoryModel1 == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(categoryModel1);
    }


    //- The api should permit delete a category sí y solo sí no se ha asociado a un producto.
    @DeleteMapping("/category/{idCategory}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable String idCategory) {
        if (categoryService.deleteCategory(Integer.valueOf(idCategory))) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.ok(categoryService.deleteCategory(Integer.valueOf(idCategory)));
    }



}