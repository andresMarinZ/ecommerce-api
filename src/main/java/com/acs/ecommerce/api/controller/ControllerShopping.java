package com.acs.ecommerce.api.controller;

import com.acs.ecommerce.api.Service.IShoppingService;
import com.acs.ecommerce.api.model.Shopping;
import com.acs.ecommerce.api.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerShopping {

    @Autowired
    IShoppingService iShoppingService;

    //
    @GetMapping("/buy") //No tengo claras esta ruta
    public String BuyProduct(@RequestBody ShoppingCart shoppingCart, int idSeller, String address, String addressF, String payment ){
        String buy = iShoppingService.buyProduct(shoppingCart, idSeller, address,  addressF,  payment);
        return buy;
    }

    @GetMapping("/delete")
    public String cancelShopping(@RequestBody int id){
          String delete = iShoppingService.cancelShopping(id);
          return  delete;
    }

    @GetMapping("/getById")
    public Shopping getShoppingId(int id){
        Shopping shopping = iShoppingService.getShoppingId(id);
        return shopping;
    }

    @GetMapping("/getByShopper")
    public Shopping getShoppingUser(int idShopper){
        Shopping shopping = iShoppingService.getShoppingUser(idShopper);
        return  shopping;
    }

    @GetMapping("/getBySeller")
    public  Shopping getShoppingSeller(int idSeller){
        Shopping shopping = iShoppingService.getShoppingSeller(idSeller);
        return  shopping;
    }

}
