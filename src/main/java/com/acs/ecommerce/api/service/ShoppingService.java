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

    public static List<Shopping> shopping =new ArrayList<>();
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
    public Shopping buyProduct(Shopping buy) {
        shopping.add(buy);
        return null;
    }

    /*Elimina compra segun el Id propio de compras*/
    @Override
    public String cancelShopping(int id) {
        LocalTime cancelT = cancel_time();
        int minutes = (int) ChronoUnit.MINUTES.between(Shopping.getDateBuy(), cancelT); /*Comparar fecha del atributo getdate con la creada al momento de invocar a cancelShopping*/
        for(Shopping shop : shopping){
            if(Shopping.getIdShopping().equals(id) && minutes > 5){
                shopping.remove(shop);
                return "compra eliminada";
            }
            return "Compra no se pudo eliminar, tiempo limite excedido";
        }
        return null;
    }

    @Override
    public Shopping getShoppingId() {
        return null;
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
