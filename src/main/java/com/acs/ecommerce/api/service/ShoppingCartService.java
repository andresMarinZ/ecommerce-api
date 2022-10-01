package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    List<ShoppingCart> get();
    ShoppingCart getById(String idShoppingCart);
    ShoppingCart create(ShoppingCart idShoppingCart);
    boolean delete(String idShoppingCart);
}
