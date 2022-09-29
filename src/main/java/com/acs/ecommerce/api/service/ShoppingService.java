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
    public ShoppingService(List<Shopping> shoppingInjected){
        shopping=shoppingInjected;
    }

    @Override
    public  List<Shopping> getShopping() {
        return shopping;
    } //No permite dejar el override si esta en estatico
    public  List<Shopping> getShoppingDelete() {return shoppingDelete;}
    /*Crea compra con los datos que recibe desde el carrito*/

    /*Metodo para establecer la hora de compra*/ /*necesitariamos crear una hora de compra en constructor para que no se sobreescriba*/
    public LocalTime Time(){
        LocalTime cancelTime = LocalTime.now();
        return cancelTime;
    }
    @Override
    public Shopping getShoppingDeleteId(int id){
        for(Shopping shop : getShoppingDelete()){
            if (shop.getIdShopping()==id){
                return shop;
            }
        }
        return null;
    }

    @Override
    public String buyProduct(int idShopping,String idproduct,int amountProduct, int idSeller, String address, String addressF, String payment ) {

        // (ShoppingCart cart)
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

    /*Elimina compra segun el Id propio de compras*/
    @Override
    public String cancelShopping(int id) {
        LocalTime cancelT = Time();
        /*Comparar fecha del atributo getdate con la creada al momento de invocar a cancelShopping*/
        for(Shopping shop : getShopping()){
            int minutesBuy = (int) ChronoUnit.MINUTES.between(shop.getDateBuy(), cancelT);
            if(shop.getIdShopping() == id && minutesBuy <= 5){
                shop.setStateBuy("Deleted");
                shoppingDelete.add(shop);
                //shopping.remove(shop);
                return shop.getStateBuy();
            }
        }
        return "No es posible eliminar la compra";
    }


    public Shopping getShoppingId(int id) {
        for(Shopping shop : getShopping()){
            if (shop.getIdShopping()==id){
                return shop;
            }
        }
        return null;
    }

    public Shopping getShoppingbyState(String state) {
        for(Shopping shop : getShoppingDelete()){
            if (shop.getStateBuy()==state){
                return shop;
            }
        }
        return null;
    }

    public Shopping getShoppingIdProduct(String idProduct) {
        for(Shopping shop : getShopping()){
            if (shop.getIdProduct().equals(idProduct)){
                return shop;
            }
        }
        return null;
    }

    @Override
    public Shopping getShoppingUser(int idShopper) {
        for(Shopping shop : getShopping()){
            if (shop.getIdShopping()==idShopper){
                return shop;
            }
        }
        return null;
    }

    @Override
    public Shopping getShoppingSeller(int idSeller) {
        for(Shopping shop : getShopping()){
            if (shop.getIdShopping()==idSeller){
                return shop;
            }
        }
        return null;
    }


    @Override
    public List getCancelShopping() {
        return null;
    }


    /*
     * Metodo para generar compra
     */




}
