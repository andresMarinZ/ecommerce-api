package com.acs.ecommerce.api.service;
import com.acs.ecommerce.api.model.ShoppingCart;
import org.junit.jupiter.api.*;
import com.acs.ecommerce.api.model.Shopping;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingServiceTest {
    public static List<Shopping> shoppingMocklist =new ArrayList<>();
    public static List<ShoppingCart> shoppingCartMocklist =new ArrayList<>();
    private final com.acs.ecommerce.api.service.ShoppingService shoppingService;

    private final ShoppingCart shoppingCart;

    public ShoppingServiceTest() {
        this.shoppingService = new com.acs.ecommerce.api.service.ShoppingService(shoppingMocklist);
        this.shoppingCart =new ShoppingCart();
    }

    @Test
    void testDelete(){
        assertAll(
                () -> Assertions.assertEquals("Deleted",shoppingService.getShoppingId(1).getStateBuy())
        );
    }

    @Test /*Validando lo que entrea a la lista*/
    void testbuyProduct() throws InterruptedException {

        String shopCreated = shoppingService.buyProduct(3,"9",5,5,"san javier","55421","TSE");
        String shopCreated2 =shoppingService.buyProduct(4,"10",9,10,"san antonio","54647","PSE");


        Shopping barrio = shoppingService.getShoppingId(1);
        Shopping barrio2 = shoppingService.getShoppingId(2);

        assertAll(
                () -> Assertions.assertEquals("Created", shopCreated),
                () -> Assertions.assertEquals("san javier", barrio.getAddressSend()),
                () -> Assertions.assertEquals("Created", shopCreated2),
                () -> Assertions.assertEquals(10, barrio2.getIdSeller())
          );
        TimeUnit.MINUTES.sleep(1);
        this.shoppingService.cancelShopping(1);
        assertAll(
                () -> Assertions.assertEquals("Deleted",shoppingService.getShoppingId(1).getStateBuy())
        );
     }

    @Test
    void cancelShopping() {

    }

    private List<Shopping> getNewshop() {
        //Shopping shopPrueba=new Shopping();
        List<Shopping> shops=new ArrayList<>();
        Shopping shop = new Shopping();
        Shopping shop2 = new Shopping();
        shops.add(shop);
        shops.add(shop2);

        return shops;
     }
}