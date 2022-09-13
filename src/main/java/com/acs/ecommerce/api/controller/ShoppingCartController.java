package com.acs.ecommerce.api.controller;

import com.acs.ecommerce.api.model.ShoppingCart;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartController {

    /*Quemamos Datos Para Hacer La Consulta*/
    @GetMapping("/ShoppingCart")
    public List<ShoppingCart> getShoppingCart() {

        ArrayList<ShoppingCart> list = new ArrayList<ShoppingCart>();
        ShoppingCart shoppingList = new ShoppingCart();
        shoppingList.setId("9z8x7c");
        shoppingList.setIdBuyer(54321);
        shoppingList.setIdProduct("1q2w3e");
        shoppingList.setProductQuantity(2);

        list.add(shoppingList);
        return list;
    }
    /*Hacemos la consulta del producto*/

    /*Agregamos compras al carrito*/
    @PostMapping("/ShoppingCart")
    public String addProduct(@RequestBody ShoppingCart Product) {
        return String.format("Shopping cart id: %s" +
                        "\nBuyer id: %s" +
                        "\nProduct id: %s" +
                        "\nProduct quantity: %s",
                Product.getId(),
                Product.getIdBuyer(),
                Product.getIdProduct(),
                Product.getProductQuantity());
    }

    /*Borramos La compra por su id*/
    @DeleteMapping("/ShoppingCart/{id}")
    public String DeleteShoppingCart(@PathVariable("id") String id) {
        return "Deleted by buying id number";
    }

}
