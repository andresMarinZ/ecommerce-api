package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.Shopping;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingService implements IShoppingService{

    public static List<Shopping> shopping =new ArrayList<>();
    public ShoppingService(List<Shopping> shoppingInjected){
        shopping=shoppingInjected;
    }

    @Override
    public static List<Shopping> getShopping() {
        return shopping;
    }

    /*
    * Metodo para generar compra
    */
    public Shopping buyProduct(Shopping buy) {
        shopping.add(buy);
        return null;
    }
}
