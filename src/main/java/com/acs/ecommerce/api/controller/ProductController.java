package com.acs.ecommerce.api.controller;

import com.acs.ecommerce.api.model.ProductModel;
import com.acs.ecommerce.api.model.ReviewModel;
// import com.acs.ecommerce.api.model.genericModel.Response;
import com.acs.ecommerce.api.service.iservice.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    IProductService iProductService;

   // private final List<ProductModel> productModels = new ArrayList<>();

    @GetMapping("/product/{idProduct}")
    public ResponseEntity<ProductModel> getById(@PathVariable String idProduct) {
        ProductModel productModel = iProductService.getByid(idProduct);

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
    @GetMapping("/product/{idProduct}")
    public ResponseEntity<ProductModel> delete(@PathVariable String idProduct, @RequestBody ProductModel productModel) {
        ProductModel deleteProductModel = iProductService.delete(idProduct,productModel);

        return Objects.isNull(deleteProductModel) ? ResponseEntity.notFound().build() : ResponseEntity.ok(productModel);
    }
    @GetMapping("/product/{Keyword}")
    public ResponseEntity<ProductModel> getProductByKeyword(@PathVariable String Keyword) {
        ProductModel productModel = (ProductModel) iProductService.getProductByKeyword(Keyword);

        return Objects.isNull(productModel) ? ResponseEntity.notFound().build() : ResponseEntity.ok(productModel);
    }

}
