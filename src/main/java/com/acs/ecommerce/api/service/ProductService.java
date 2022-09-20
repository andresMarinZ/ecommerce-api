package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.ProductModel;
import com.acs.ecommerce.api.service.iservice.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    private static  List<ProductModel> productsModel = new ArrayList<>();

    public ProductService(List<ProductModel> productInjection) {
        productsModel = productInjection;
    }

    @Override
    public List<ProductModel> get() {
        return null;
    }

    @Override
    public ProductModel getByid(String idProduct) {
        Optional<ProductModel> optionalProduct = productsModel.stream()
                .filter(product -> product.getIdProduct().equals(idProduct))
                .findFirst();

        return optionalProduct.orElse(null);
    }

    @Override
    public ProductModel create(ProductModel productModel) {
        productsModel.add(productModel);

        return productModel;
    }

    @Override
    public ProductModel update(String idProduct, ProductModel productModel) {
        return null;
    }

    @Override
    public ProductModel delete(String idQuote, ProductModel productModel) {
        return null;
    }

    @Override
    public ProductModel getByCategory(String productCategory) {
        Optional<ProductModel> optionalProduct = productsModel.stream()
        .filter(product -> product.getProductCategory().equals(productCategory))
        .findFirst();
        return optionalProduct.orElse(null);
    }
}
