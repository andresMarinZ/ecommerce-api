package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.Shopping;

import java.util.ArrayList;
import java.util.List;

public interface IShoppingService {
    public List<Shopping> getShopping();
    public Shopping buyProduct();
    public String cancelShopping();
    public Shopping getShoppingId();
    public Shopping getShoppingUser();
    public List getCancelShopping();
}
