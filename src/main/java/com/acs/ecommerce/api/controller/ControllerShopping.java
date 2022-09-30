package com.acs.ecommerce.api.controller;

import com.acs.ecommerce.api.service.IShoppingService;
import com.acs.ecommerce.api.model.Shopping;
import com.acs.ecommerce.api.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerShopping {

    @Autowired
    IShoppingService iShoppingService;

    //

    @PostMapping("/Createbuy")
    public String BuyProduct(@RequestBody int idShopper,String idproduct,int amountProduct, int idSeller, String address, String addressF, String payment ){
        String buy1 = iShoppingService.buyProduct(idShopper,idproduct, amountProduct, idSeller, address,  addressF,  payment);
        return buy1;
    }

    @GetMapping("/delete/{id}")
    public String cancelShopping(@RequestBody int id){
          String delete = iShoppingService.cancelShopping(id);
          return  delete;
    }

    @GetMapping("/getById/{id}")
    public Shopping getShoppingId(int id){
        Shopping shopping = iShoppingService.getShoppingId(id);
        return shopping;
    }

    @GetMapping("/getByShopper/{idShopper}")
    public Shopping getShoppingUser(int idShopper){
        Shopping shopping = iShoppingService.getShoppingUser(idShopper);
        return  shopping;
    }

    @GetMapping("/getBySeller/{idSeller}")
    public  Shopping getShoppingSeller(int idSeller){
        Shopping shopping = iShoppingService.getShoppingSeller(idSeller);
        return  shopping;
    }

    @GetMapping("/getByDeleted/{state}")
    public Shopping getShoppingbyState(String state){
        Shopping shopping = iShoppingService.getShoppingbyState(state);
        return shopping;
    }

     /*@GetMapping("/buy") //No tengo claras esta ruta
    public String BuyProduct(@RequestBody ShoppingCart shoppingCart, int idSeller, String address, String addressF, String payment ){
        String buy = iShoppingService.buyProduct(shoppingCart, idSeller, address,  addressF,  payment);
        return buy;
    }*/
}
