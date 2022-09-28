package com.acs.ecommerce.api.controller;

import com.acs.ecommerce.api.service.ShoppingCartService;
import com.acs.ecommerce.api.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;


@RestController
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingcartService;

    /* Visualization of the shoppingcart*/
    @GetMapping("shoppingcarts")
    public ResponseEntity<List<ShoppingCart>> get() {
        List<ShoppingCart> shoppingcarts = shoppingcartService.get();

        return shoppingcarts.isEmpty() ? ResponseEntity.badRequest().body(shoppingcarts) : ResponseEntity.ok(shoppingcarts);
    }

    /* Consult of the shoppingcart for id*/
    @GetMapping("shoppingcarts/{idShoppingCart}")
    public ResponseEntity<ShoppingCart> getById(@PathVariable String idShoppingCart) {
        ShoppingCart shoppingcart = shoppingcartService.getById(idShoppingCart);

        return Objects.isNull(shoppingcart) ? ResponseEntity.notFound().build() : ResponseEntity.ok(shoppingcart);
    }

    /*We post the shoppingcart information*/
    @PostMapping("shoppingcarts")
    public ResponseEntity<ShoppingCart> create(@RequestBody ShoppingCart shoppingcart) {
        return ResponseEntity.ok(shoppingcartService.create(shoppingcart));
    }

    @DeleteMapping("shoppingcarts/{idShoppingCart}")
    public ResponseEntity delete(@PathVariable String idShoppingCart) {
        boolean deleted = shoppingcartService.delete(idShoppingCart);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
