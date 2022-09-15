package com.acs.ecommerce.api.service.iservice;

import com.acs.ecommerce.api.model.ProductModel;

import java.util.List;

public interface IProductService {
    List<ProductModel> get();
    ProductModel getByid(String idProduct);
    ProductModel create(ProductModel productModel);
    ProductModel update(String idProduct, ProductModel productModel);
    boolean delete(String idQuote);

}
