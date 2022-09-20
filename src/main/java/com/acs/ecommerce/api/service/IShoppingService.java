package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.Shopping;

import java.util.ArrayList;
import java.util.List;

public interface IShoppingService {
    public List<Shopping> getShopping();

    String buyProduct(Shopping buy);

    public String cancelShopping(int id);
    public String getShoppingId(int id);
    public Shopping getShoppingUser();
    public List getCancelShopping();
}
