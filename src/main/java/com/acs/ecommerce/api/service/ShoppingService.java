package com.acs.ecommerce.api.service;
import java.time.*;
import java.time.temporal.*;
import java.time.format.*;

import com.acs.ecommerce.api.model.Shopping;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingService implements IShoppingService{

    public static List<Shopping> shopping = new ArrayList<>();
    public ShoppingService(List<Shopping> shoppingInjected){
        shopping=shoppingInjected;
    }

    @Override
    public  List<Shopping> getShopping() {
        return shopping;
    } //No permite dejar el override si esta en estatico

    /*Crea compra con los datos que recibe desde el carrito*/

    /*Metodo para establecer la hora de compra*/ /*necesitariamos crear una hora de compra en constructor para que no se sobreescriba*/
    public LocalTime cancel_time(){
        LocalTime cancelTime = LocalTime.now();
        return cancelTime;
    }
    @Override
    public String buyProduct(Shopping buy) {
        buy.setStateBuy("Created");
        shopping.add(buy);
        return buy.getStateBuy().toString();
    }

    /*Elimina compra segun el Id propio de compras*/
    @Override
    public String cancelShopping(int id ) {
        List<Shopping> shopping = getShopping();
        LocalTime cancelT = cancel_time();
         /*Comparar fecha del atributo getdate con la creada al momento de invocar a cancelShopping*/
        for(Shopping shop : shopping){
            int minutes = (int) ChronoUnit.MINUTES.between(shop.getDateBuy(), cancelT);
            if(shop.getIdShopping() == id && minutes > 5){
                shopping.remove(shop);
                return "compra eliminada";
            }
            return "Compra no se pudo eliminar, tiempo limite excedido";
        }
        return null;
    }


    public String getShoppingId(int id) {
        List<Shopping> shoppings=getShopping();
        for(Shopping shop : shoppings){
            if (shop.getIdShopping()==id){
                return shop.getAddressSend();
            }
        }
        return "Not found";
    }

    @Override
    public Shopping getShoppingUser() {
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
