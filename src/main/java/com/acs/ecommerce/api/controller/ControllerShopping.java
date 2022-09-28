package com.acs.ecommerce.api.controller;

import com.acs.ecommerce.api.model.Shopping;
import com.acs.ecommerce.api.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerShopping {
    @Autowired
    ShoppingService shoppingService;
    @PostMapping("./compra")
    public ResponseEntity<Shopping>createShopping(@RequestBody Shopping shopping){
        return ResponseEntity.ok(shoppingService.buyProduct(shopping));
    }

}
