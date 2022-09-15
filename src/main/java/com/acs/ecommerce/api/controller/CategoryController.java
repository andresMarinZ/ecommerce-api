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


    @PostMapping("/create")
    public ResponseEntity<CategoryModel> create(@RequestBody CategoryModel categoryModel) {
        return ResponseEntity.ok(categoryService.create(categoryModel));
    }

    @DeleteMapping("/delete/{idProduct}")
    public ResponseEntity<Boolean> delete(@PathVariable String idProduct) {
        return ResponseEntity.ok(categoryService.delete(idProduct));
    }

    @PutMapping("/update/{idProduct}")
    public ResponseEntity<CategoryModel> update(@PathVariable String idProduct, @RequestBody CategoryModel categoryModel) {
        return ResponseEntity.ok(categoryService.update(idProduct, categoryModel));
    }


}