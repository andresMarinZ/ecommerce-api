package com.acs.ecommerce.api.service.iservice;

import com.acs.ecommerce.api.model.ProductModel;

import java.util.List;


public interface IProductService {
    ProductModel getProductById(String idProduct);
    ProductModel create(ProductModel productModel);
    ProductModel update(String idProduct, ProductModel productModel);
    Boolean delete(String idProduct);
    List<ProductModel> getProductByKeyword(String Keyword);
    List<ProductModel> getByIdCategory(long idCategory);
}
