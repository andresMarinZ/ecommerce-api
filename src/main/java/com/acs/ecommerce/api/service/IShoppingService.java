package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.Shopping;

import java.util.ArrayList;
import java.util.List;

public interface IShoppingService {
    public static List<Shopping> shopping =new ArrayList<>();
    public Shopping buyProduct();
    public String cancelShopping();
    public Shopping getShoppingId();
    public Shopping getShoppingUser();
    public List getCancelShopping();
}
