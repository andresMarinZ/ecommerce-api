package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.Shopping;
import com.acs.ecommerce.api.model.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public interface IShoppingService {
    public List<Shopping> getShopping();
    public List<Shopping> getShoppingDelete();
    String buyProduct(int idShopping, String idproduct,int amount, int idSeller, String address, String addressF, String payment );
    public List<Shopping> getShoppingDeleteId(int id);
    public Shopping getShoppingIdProduct(String idProduct);
    public String cancelShopping(int id);
    public Shopping getShoppingId(int id);
    public List<Shopping> getShoppingUser(int idShopper);
    public List<Shopping> getCancelShoppingSeller(int idSeller);
    public List<Shopping> getShoppingSeller(int idSeller);
}
