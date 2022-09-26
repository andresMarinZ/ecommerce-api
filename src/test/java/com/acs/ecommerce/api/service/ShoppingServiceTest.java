package com.acs.ecommerce.api.Service;
import com.acs.ecommerce.api.model.ShoppingCart;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.acs.ecommerce.api.model.Shopping;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingServiceTest {
    public static List<Shopping> shoppingMocklist =new ArrayList<>();
    public static List<ShoppingCart> shoppingCartMocklist =new ArrayList<>();
    private final com.acs.ecommerce.api.Service.ShoppingService shoppingService;

    private final ShoppingCart shoppingCart;

    public ShoppingServiceTest() {
        this.shoppingService = new com.acs.ecommerce.api.Service.ShoppingService(shoppingMocklist);
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

        String shopCreated = shoppingService.buyProduct(shoppingCart,5,"san javier","55421","TSE");
        String shopCreated2 =shoppingService.buyProduct(shoppingCart,10,"san antonio","54647","PSE");


        Shopping barrio = shoppingService.getShoppingId(1);
        Shopping barrio2 = shoppingService.getShoppingId(2);

        assertAll(
                () -> Assertions.assertEquals("Created", shopCreated),
                () -> Assertions.assertEquals("san javier", barrio.getAddressSend()),
                () -> Assertions.assertEquals("Created", shopCreated2),
                () -> Assertions.assertEquals(10, barrio2.getIdSeller())
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