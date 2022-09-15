package com.acs.ecommerce.api.Service;
import com.acs.ecommerce.api.model.ShoppingCart;
import java.util.List;

public interface ShoppingCartService {
    List<ShoppingCart> get();
    ShoppingCart getById(String idShoppingCart);
    ShoppingCart create(ShoppingCart shoppingcart);
    boolean delete(String idShoppingCart);
}
