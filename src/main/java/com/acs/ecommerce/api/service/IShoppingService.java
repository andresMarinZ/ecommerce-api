package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.Shopping;

import java.util.ArrayList;
import java.util.List;

public interface IShoppingService {
    public List<Shopping> getShopping();
    public List<Shopping> getShoppingDelete();

    String buyProduct(int idShopper,int idSeller,String idProduct,int amount, String address,String addressF,String payment );

    public void cancelShopping(int id);
    public String getShoppingId(int id);
    public Shopping getShoppingUser(int idShopper);
    public List getCancelShopping();

    public Shopping getShoppingSeller(int idSeller);
}
