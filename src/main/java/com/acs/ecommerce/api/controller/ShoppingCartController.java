package com.acs.ecommerce.api.controller;

import com.acs.ecommerce.api.Service.ShoppingCartService;
import com.acs.ecommerce.api.model.ShoppingCart;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;


@RestController
public class ShoppingCartController {

   /* @GetMapping("shoppingcart/{idShoppingCart}")
    public ResponseEntity<ShoppingCart> getById(@PathVariable String idShoppingCart) {
        ShoppingCart quote = ShoppingCartService.getById(idShoppingCart);

        return Objects.isNull(quote) ? ResponseEntity.notFound().build() : ResponseEntity.ok(quote);
    }*/


    /*Consult some static data*/
    @GetMapping("/shoppingcart")
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


    /*We consult a specific data*/
    @GetMapping("/shoppingcart/{id}")
    public String ConsultId(@PathVariable("id") String id) {
        return "Id of the consulted Shopping Cart";
    }

    /*post any posible buy in the shopping cart*/
    @PostMapping("/shoppingcart")
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

    /*Deleting the buy for they id*/
    @DeleteMapping("/shoppingcart/{id}")
    public String DeleteShoppingCart(@PathVariable("id") String id) {
        return "Deleted by buying id number";
    }

}
