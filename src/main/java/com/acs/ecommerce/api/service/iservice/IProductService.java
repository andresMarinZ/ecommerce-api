package com.acs.ecommerce.api.service.iservice;

import com.acs.ecommerce.api.model.ProductModel;
import com.acs.ecommerce.api.model.ReviewModel;

import java.util.List;
import java.util.Optional;

public interface IProductService {
   List<ProductModel> get();
   ProductModel getByid(String idProduct);
    //ProductModel getByid(String idProduct);
    ProductModel create(ProductModel productModel);
    ProductModel update(String idProduct, ProductModel productModel);
    ProductModel delete(String idQuote, ProductModel productModel);
}
