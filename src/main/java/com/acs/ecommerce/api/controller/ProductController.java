package com.acs.ecommerce.api.controller;

import com.acs.ecommerce.api.model.ProductModel;
import com.acs.ecommerce.api.service.iservice.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class ProductController {

    @Autowired
    IProductService iProductService;

    @GetMapping("/product/{idProduct}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable String idProduct) {
        ProductModel productModel = iProductService.getProductById(idProduct);

        return Objects.isNull(productModel) ? ResponseEntity.notFound().build() : ResponseEntity.ok(productModel);
    }
    @PostMapping("/product")
    public ResponseEntity<ProductModel> create(@RequestBody ProductModel productModel) {
        ProductModel newProductModel = iProductService.create(productModel);

        return ResponseEntity.ok(newProductModel);
    }
    @PutMapping("/product/{idProduct}")
    public ResponseEntity<ProductModel> update(@PathVariable String idProduct, @RequestBody ProductModel productModel) {

        ProductModel updateProductModel = iProductService.update(idProduct,productModel);

        return ResponseEntity.ok(updateProductModel);
    }
    @DeleteMapping("/product/{idProduct}")
    public ResponseEntity<ProductModel> delete(@PathVariable String idProduct, @RequestBody ProductModel productModel) {
        Boolean deleteProductModel = iProductService.delete(idProduct);

        return deleteProductModel ? ResponseEntity.notFound().build() : ResponseEntity.ok(productModel);
    }
    @GetMapping("/product/{Keyword}")
    public ResponseEntity<ProductModel> getProductByKeyword(@PathVariable String Keyword) {
        ProductModel productModel = (ProductModel) iProductService.getProductByKeyword(Keyword);

        return Objects.isNull(productModel) ? ResponseEntity.notFound().build() : ResponseEntity.ok(productModel);
    }
    @GetMapping("/product/{idCategory}")
    public ResponseEntity<ProductModel> getByIdCategory(@PathVariable long idCategory) {
        ProductModel productModel = (ProductModel) iProductService.getByIdCategory(idCategory);

        return Objects.isNull(productModel) ? ResponseEntity.notFound().build() : ResponseEntity.ok(productModel);
    }

}
