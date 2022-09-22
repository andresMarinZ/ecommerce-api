package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.Shopping;

import java.util.ArrayList;
import java.util.List;

public interface IShoppingService {
    public List<Shopping> getShopping();

    String buyProduct(Shopping buy);

    /*
        * En el metodo de getShoppingCart debemos incluir la clase de carrito que esta desarrollando henry
        * La cual corresponde a l nombre de ShoppingCart
    */
    String getShoppingCart(int idCart, String IdProduct,int amountProduct);
    public String cancelShopping(int id);
    public String getShoppingId(int id);
    public Shopping getShoppingUser();
    public List getCancelShopping();
}
