package com.acs.ecommerce.api.controller;

import com.acs.ecommerce.api.service.IShoppingService;
import com.acs.ecommerce.api.service.ShoppingCartService;
import com.acs.ecommerce.api.model.Shopping;
import com.acs.ecommerce.api.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerShopping {

    @Autowired
    IShoppingService iShoppingService;
    @Autowired
    ShoppingCartService iShoppingCart;

    //

    @PostMapping("/createbuy")
    public String BuyProduct(@RequestBody Shopping shop){
        String buy1 = iShoppingService.buyProduct(shop.getIdShopper(),shop.getIdProduct(), shop.getAmountProduct(),
                shop.getIdSeller(), shop.getAddressSend(), shop.getAddressFact(),  shop.getPaymentGateway());
        return buy1;
    }

    @GetMapping(path = "getshoppingbyid", params = "idShopping")
    public Shopping getShoppingId(@RequestParam int idShopping){
        Shopping shopping = iShoppingService.getShoppingId(idShopping);
        return shopping;
    }
    @DeleteMapping(path = "/delete", params = "idShopping")
    public String cancelShopping(@RequestParam int idShopping){
          String delete = iShoppingService.cancelShopping(idShopping);
          return  delete;
    }
    @GetMapping(path = "/getByShopper", params = "idShopper")
    public List<Shopping> getShoppingUser(@RequestParam int idShopper){
        List<Shopping> shopping = iShoppingService.getShoppingUser(idShopper);
        return  shopping;
    }

    @GetMapping(path = "/getBySeller", params = "idSeller")
    public List<Shopping> getShoppingSeller(@RequestParam int idSeller){
        List<Shopping> shopping = iShoppingService.getShoppingSeller(idSeller);
        return  shopping;
    }
    @GetMapping(path = "/getByDeleted")
    public List<Shopping> getShoppingbyState(){
        List<Shopping> shopping = iShoppingService.getShoppingDelete();
        return shopping;
    }
    @GetMapping(path = "/getShoppings")
    public List<Shopping> getShopping(){
        List<Shopping> shopping = iShoppingService.getShopping();
        return shopping;
    }
}
