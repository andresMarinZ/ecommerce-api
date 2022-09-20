package com.acs.ecommerce.api.service;
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

import static org.junit.jupiter.api.Assertions.*;

class ShoppingServiceTest {
    public static List<Shopping> shoppingMocklist =new ArrayList<>();
    private final ShoppingService shoppingService;

    public ShoppingServiceTest() {
        this.shoppingService = new ShoppingService(shoppingMocklist);
    }

    @Test /*Validando lo que entrea a la lista*/
    void testbuyProduct() {
        String shopCreated = shoppingService.buyProduct(getNewshop().get(0));
        String shopCreated2 = shoppingService.buyProduct(getNewshop().get(1));

        String barrio = shoppingService.getShoppingId(0);
        String barrio2 = shoppingService.getShoppingId(1);

        assertAll(
                () -> Assertions.assertEquals("Created", shopCreated),
                () -> Assertions.assertEquals("san javier", barrio),
                () -> Assertions.assertEquals("Created", shopCreated2),
                () -> Assertions.assertEquals("san carlos", barrio2)

                );
     }

    @Test
    void cancelShopping() {

    }

    private List<Shopping> getNewshop() {
        //Shopping shopPrueba=new Shopping();
        List<Shopping> shops=new ArrayList<>();
        Shopping shop = new Shopping(2,2,30,"san javier","55421","bancolombia");
        Shopping shop2 = new Shopping(1,14,20,"san carlos","34556","PSE");

        shops.add(shop);
        shops.add(shop2);

        return shops;
     }
}