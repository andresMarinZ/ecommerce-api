package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.Shopping;
import com.acs.ecommerce.api.model.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertAll;

class ShoppingServiceTest {
    public static List<Shopping> shoppingMocklist =new ArrayList<>();
    public static List<ShoppingCart> shoppingCartMocklist =new ArrayList<>();
    private final ShoppingService shoppingService;

    private final ShoppingCart shoppingCart;

    public ShoppingServiceTest() {
        this.shoppingService = new ShoppingService(shoppingMocklist);
        this.shoppingCart =new ShoppingCart();
    }

    @Test
    void testDelete(){
        assertAll(
                () -> Assertions.assertEquals("Delete",shoppingService.getShoppingId(1).getStateBuy())
        );
    }

    @Test /*Validando lo que entrea a la lista*/
    void testbuyProduct() throws InterruptedException {

        String shopCreated = shoppingService.buyProduct(5,"2",15,5,"san javier","cristobal","PSE");
        String shopCreated2 =shoppingService.buyProduct(5,"1",15,5,"san carlos","cristobal","PSE");


        Shopping barrio = shoppingService.getShoppingId(1);
        Shopping barrio2 = shoppingService.getShoppingId(2);

        assertAll(
                () -> Assertions.assertEquals("Created", shopCreated),
                () -> Assertions.assertEquals("san javier", barrio.getAddressSend()),
                () -> Assertions.assertEquals("Created", shopCreated2),
                () -> Assertions.assertEquals("san carlos", barrio2.getAddressSend())
          );
        TimeUnit.MINUTES.sleep(6);
        this.shoppingService.cancelShopping(1);
        assertAll(
                () -> Assertions.assertEquals("Created",shoppingService.getShoppingId(1).getStateBuy())
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