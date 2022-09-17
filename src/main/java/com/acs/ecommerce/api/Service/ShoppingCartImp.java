package com.acs.ecommerce.api.Service;

import com.acs.ecommerce.api.model.ShoppingCart;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ShoppingCartImp implements ShoppingCartService{
    private static List<ShoppingCart> shoppingcarts = new ArrayList<>();

    public ShoppingCartImp(List<ShoppingCart> shoppingcartInjected) {
        shoppingcarts = shoppingcartInjected;
    }

    public List<ShoppingCart> get() {
        return shoppingcarts;
    }

    public ShoppingCart getById(String idShoppingCart) {
        Optional<ShoppingCart> optionalShoppingCart = shoppingcarts.stream()
                .filter(shoppingcart -> shoppingcart.getIdShoppingCart().equals(idShoppingCart))
                .findFirst();

        return optionalShoppingCart.orElse(null);
    }

    public ShoppingCart create(ShoppingCart shoppingcart) {
        shoppingcart.setIdShoppingCart(UUID.randomUUID().toString());
        shoppingcarts.add(shoppingcart);

        return shoppingcart;
    }

    public boolean delete(String idShoppingCart) {
        ShoppingCart shoppingcart = getById(idShoppingCart);

        if (Objects.isNull(shoppingcart)) {
            return false;
        }

        return shoppingcarts.removeIf(q -> q.getIdShoppingCart().equals(idShoppingCart));
    }
}
