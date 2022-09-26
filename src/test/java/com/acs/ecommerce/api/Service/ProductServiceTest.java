package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.ProductModel;
import com.acs.ecommerce.api.model.Shopping;
import com.acs.ecommerce.api.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ProductServiceTest {

    private final ProductService productService;
    private static final List<ProductModel> MocklistproductsModel = new ArrayList<>();

    private static final ProductModel productMockModel = new ProductModel();

    private static final List<User> MocklistusersModel = new ArrayList<>();

    private static final User userMockModel = new User();

    public static List<Shopping> Mocklistshopping = new ArrayList<>();

    public ProductServiceTest(){
        ShoppingService _IShoppingService = new ShoppingService(Mocklistshopping);
        UserService _UserService = new UserServiceImp(MocklistusersModel);
        productService = new ProductService(MocklistproductsModel, _UserService, _IShoppingService);
    }

    @BeforeEach
    public void initializeProductList() {
        MocklistproductsModel.clear();
        this.userModel();
    }

    private void userModel() {
        userMockModel.setId("1");
        userMockModel.setUserType("Buyer");
        userMockModel.setMaxSell(150);
        MocklistusersModel.add(userMockModel);
    }

    private void productModel() {
        productMockModel.setIdProduct("1");
        productMockModel.setProductName("condones");
        productMockModel.setIdCategory(1);
        productMockModel.setProductDescription("extra grandes");
        productMockModel.setUrlProductImage("https://www.google.com");
        productMockModel.setUserId("1");
        productMockModel.setDocumentNumber(1);
        productMockModel.setAmountToSell(100);
        MocklistproductsModel.add(productMockModel);
    }

    @Test
    void getProductByIdExistTest() {
        //Arrange
        productModel();
        String id_product = "1";
        //Act
        ProductModel productModel = productService.getProductById(id_product);
        //Assert
        Assertions.assertNotNull(productModel);
    }

    @Test
    void getProductByIdNotExistTest() {
        //Arrange
        productModel();
        String id_product = "2";
        //Act
        ProductModel productModel = productService.getProductById(id_product);
        //Assert
        Assertions.assertNull(productModel);
    }

    @Test
    void ValidateProductByUserNotexistent(){
        //Arrange
        productModel();
        productMockModel.setUserId("2");
        //Act
        ProductModel new_product_model = productService.create(productMockModel);
        //Assert
        Assertions.assertNull(new_product_model.getUserId());
    }
    /*
    @Test
    void ValidateProductByUserexistent(){
        //Arrange
        productModel();
        productMockModel.setUserId("1");
        //Act
        ProductModel new_product_model = productService.create(productMockModel);
        //Assert
        Assertions.assertNotNull(new_product_model.getUserId());
    }*/

    @Test
    void ValidateUrlNotValidate(){
        //Arrange
        productModel();
        productMockModel.setUrlProductImage("htts//:loquesea");
        //Act
        ProductModel new_product_model = productService.create(productMockModel);
        //Assert
        Assertions.assertNull(new_product_model.getUrlProductImage());
    }

    @Test
    void ValidateDatesProductNameNotValidate(){
        //Arrange
        productModel();
        productMockModel.setProductName("cordones");
        //Act
        ProductModel new_product_model = productService.create(productMockModel);
        //Assert
        Assertions.assertNull(new_product_model.getProductName());
    }

    @Test
    void ValidateDatesProductDescriptionNotValidate(){
        //Arrange
        productModel();
        productMockModel.setProductDescription("extra largos");
        //Act
        ProductModel new_product_model = productService.create(productMockModel);
        //Assert
        Assertions.assertNull(new_product_model.getProductDescription());
    }

    @Test
    void ValidateDatesUserIdNotValidate(){
        //Arrange
        productModel();
        productMockModel.setUserId("2");
        //Act
        ProductModel new_product_model = productService.create(productMockModel);
        //Assert
        Assertions.assertNull(new_product_model.getUserId());
    }

    @Test
    void ValidateSellByUserNotValidate(){
        //Arrange
        productModel();
        userModel();
        productMockModel.setUserId("2");
        userMockModel.setMaxSell(10);
        //Act
        ProductModel new_product_model = productService.create(productMockModel);
        //Assert
        Assertions.assertNull(new_product_model.getUserId());
    }
    /*
    @Test
    void nnnn(){
        //Arrange
        productModel();
        productMockModel.setUserId("1");
        //Act
        //Assert
    }*/
}