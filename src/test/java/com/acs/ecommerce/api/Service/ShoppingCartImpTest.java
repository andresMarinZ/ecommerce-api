package com.acs.ecommerce.api.Service;

import com.acs.ecommerce.api.model.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.booleanThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ShoppingCartImpTest {
    private final List<ShoppingCart> shoppingcartMockList = new ArrayList<>();
    private final ShoppingCartService shoppingcartService;

    public ShoppingCartImpTest() {
        this.shoppingcartService = new ShoppingCartImp(shoppingcartMockList);
    }

    @BeforeEach
    public void initializeShoppingCartList() {
        shoppingcartMockList.clear();
    }


    @Test
    public void getEmptyShoppingCartTest() {
        List<ShoppingCart> shoppingcartResult = shoppingcartService.get();
        Assertions.assertTrue(shoppingcartResult.isEmpty());
    }


    @Test
    public void createShoppingCartTest() {
        ShoppingCart shoppingcartCreated = shoppingcartService.create(getNewShoppingCart());
        Assertions.assertAll(
                () -> Assertions.assertEquals("1", shoppingcartCreated.getIdProduct())
        );
    }

    @Test
    public void deleteShoppingCartTest() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(false, shoppingcartService.delete(getNewShoppingCart().getIdShoppingCart()))
        );
    }
    private ShoppingCart getNewShoppingCart() {
        ShoppingCart shoppingcart = new ShoppingCart();
        shoppingcart.setIdProduct("1");

        return shoppingcart;
    }
}
