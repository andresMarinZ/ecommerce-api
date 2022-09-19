package com.acs.ecommerce.api.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    void buyProduct() {
        Shopping shopCreated = shoppingService.create(getNewshop());

        return Assertions.assertAll(
                () -> Assertions.assertEquals(2, shopCreated.getIdShopping()),
                () -> Assertions.assertEquals(2, shopCreated.getIdProduct()),
                () -> Assertions.assertEquals(30, shopCreated.getAmountProduct()),
                () -> Assertions.assertEquals("san javier", shopCreated.getAddressSend()),
                () -> Assertions.assertEquals("55421", shopCreated.getAddressFact()),
                () -> Assertions.assertEquals("bancolombia", shopCreated.getPaymentGateway()),
                () -> Assertions.assertEquals("11:05", shopCreated.getDateBuy()))
        );
     }

    @Test
    void cancelShopping() {

    }

    private Shopping getNewshop() {
        Shopping shop = new Shopping(2,2,30,"san javier","55421","bancolombia","11:05");

        return shop;
    }
}