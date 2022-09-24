package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.Shopping;
import com.acs.ecommerce.api.model.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public interface IShoppingService {
    public List<Shopping> getShopping();
    public List<Shopping> getShoppingDelete();

    String buyProduct(ShoppingCart shoppingCart, int idSeller, String address, String addressF, String payment );
    public Shopping getShoppingDeleteId(int i);
    public void cancelShopping(int id);
    public Shopping getShoppingId(int id);
    public Shopping getShoppingUser(int idShopper);
    public List getCancelShopping();

    public Shopping getShoppingSeller(int idSeller);
}
