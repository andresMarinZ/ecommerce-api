package com.acs.ecommerce.api.service;
import java.time.*;
import java.time.temporal.*;
import java.time.format.*;

import com.acs.ecommerce.api.model.Shopping;
import com.acs.ecommerce.api.model.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingService implements com.acs.ecommerce.api.service.IShoppingService {

    public static List<Shopping> shopping = new ArrayList<>();
    public static List<Shopping> shoppingDelete = new ArrayList<>();
    //public static  ShoppingCartImp IShoppingCart;
    public ShoppingService(List<Shopping> shoppingInjected){
        shopping=shoppingInjected;
        //IShoppingCart= shoppingCartInjected;
    }

    @Override
    public  List<Shopping> getShopping() {
        return shopping;
    } //No permite dejar el override si esta en estatico
    public  List<Shopping> getShoppingDelete() {return shoppingDelete;}
    public LocalTime Time(){
        LocalTime cancelTime = LocalTime.now();
        return cancelTime;
    }
    // Method for get shopping of the seller
    @Override
    public List<Shopping> getShoppingSeller(int idSeller) {
        List<Shopping> shoppingTemp=new ArrayList<>();
        for(Shopping shop : getShopping()){
            if (shop.getIdSeller()==idSeller){
                shoppingTemp.add(shop);
            }
        }
        if(shoppingTemp.size()<0){
            return null;
        }
        return shoppingTemp;
    }
    // Method for get shopping of the shopper
    @Override
    public List<Shopping> getShoppingUser(int idShopper) {
        List<Shopping> shoppingTemp=new ArrayList<>();
        for(Shopping shop : getShopping()){
            if (shop.getIdShopping()==idShopper){
                shoppingTemp.add(shop);
            }
        }
        if(shoppingTemp.size()<0){
            return null;
        }
        return shoppingTemp;
    }

    @Override
    public String buyProduct(int idShopping,String idproduct,int amountProduct, int idSeller, String address, String addressF, String payment ) {
        Shopping buy = new Shopping();
        buy.setIdShopper(idShopping);
        buy.setIdProduct(idproduct);
        buy.setIdSeller(idSeller);
        buy.setAmountProduct(amountProduct);
        buy.setAddressSend(address);
        buy.setAddressFact(addressF);
        buy.setPaymentGateway(payment);
        buy.setDateBuy(Time());
        buy.setIdShopping(getShopping().size()+1);
        buy.setStateBuy("Created");
        shopping.add(buy);
        return buy.getStateBuy().toString();
    }

    @Override
    public String cancelShopping(int id) {
        LocalTime cancelT = Time();
        for(Shopping shop : getShopping()){
            int minutesBuy = (int) ChronoUnit.MINUTES.between(shop.getDateBuy(), cancelT);
            if(shop.getIdShopping() == id && minutesBuy <= 5){
                shop.setStateBuy("Deleted");
                shoppingDelete.add(shop);
                shopping.remove(shop);
                return shop.getStateBuy();
            }
        }
        return "No es posible eliminar la compra";
    }

    //Consult the list shopping deleted
    @Override
    public List<Shopping> getShoppingDeleteId(int id){
        List<Shopping> shoppingTemp=new ArrayList<>();
        for(Shopping shop : getShoppingDelete()){
            if (shop.getIdShopping()==id){
                shoppingTemp.add(shop);
            }
        }
        if(shoppingTemp.size()<0){
            return null;
        }
        return shoppingTemp;
    }

    //Consult the shopping by id shopping
    public Shopping getShoppingId(int id) {
        for(Shopping shop : getShopping()){
            if (shop.getIdShopping()==id){
                return shop;
            }
        }
        return null;
    }

    //Consult the list shoppings by id product
    @Override
    public Shopping getShoppingIdProduct(String idProduct) {
        for(Shopping shop : getShopping()){
            if (shop.getIdProduct().equals(idProduct)){
                return shop;
            }
        }
        return null;
    }

    //Consult list shopping by seller
    @Override
    public List<Shopping> getCancelShoppingSeller(int idSeller) {
        List<Shopping> shoppingTemp=new ArrayList<>();
        for(Shopping shop : getShoppingDelete()){
            if (shop.getIdShopping()==idSeller){
                shoppingTemp.add(shop);
            }
        }
        if(shoppingTemp.size()<0){
            return null;
        }
        return shoppingTemp;
    }
}