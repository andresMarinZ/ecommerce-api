package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShoppingCartImp implements com.acs.ecommerce.api.service.ShoppingCartService {
    private static List<ShoppingCart> shoppingcarts = new ArrayList<>();

    public ShoppingCartImp(List<ShoppingCart> shoppingcartInjected) {
        shoppingcarts = shoppingcartInjected;
    }

    public List<ShoppingCart> get() {
        return shoppingcarts;
    }

    /*Consult Service*/
    public ShoppingCart getById(String idShoppingCart) {
        Optional<ShoppingCart> optionalShoppingCart = shoppingcarts.stream()
                .filter(shoppingcart -> shoppingcart.getIdShoppingCart().equals(idShoppingCart))
                .findFirst();

        return optionalShoppingCart.orElse(null);
    }
    /*Create Service*/
    public ShoppingCart create(ShoppingCart idShoppingCart) {
        idShoppingCart.setIdShoppingCart(UUID.randomUUID().toString());

        shoppingcarts.add(idShoppingCart);

        return idShoppingCart;
    }

    /*Delete Service*/
    public boolean delete(String idShoppingCart) {
        ShoppingCart shoppingcart = getById(idShoppingCart);

        if (Objects.isNull(shoppingcart)) {
            return false;
        }

        return shoppingcarts.removeIf(q -> q.getIdShoppingCart().equals(idShoppingCart));
    }
}
