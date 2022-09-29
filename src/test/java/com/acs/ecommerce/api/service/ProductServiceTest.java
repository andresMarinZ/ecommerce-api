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

    private static final Shopping shoppingMockModel = new Shopping();

    public ProductServiceTest(){
        ShoppingService _IShoppingService = new ShoppingService(Mocklistshopping);
        UserService _UserService = new UserServiceImp(MocklistusersModel);
        productService = new ProductService(MocklistproductsModel, _UserService, _IShoppingService);
    }

    @BeforeEach
    public void initializeProductList() {
        MocklistproductsModel.clear();
        this.userModel();
        this.shoppingModel();
    }

    private void shoppingModel() {
        shoppingMockModel.setIdProduct("1");
        shoppingMockModel.setStateBuy("Created");
        Mocklistshopping.add(shoppingMockModel);
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
    void ValidateCreateProductByUserNotexist(){
        //Arrange
        productModel();
        userModel();
        productMockModel.setUserId("2");
        //Act
        ProductModel new_product_model = productService.create(productMockModel);
        //Assert
        Assertions.assertNull(new_product_model.getUserId());
    }

    @Test
    void ValidateCreateUrlNotValidate(){
        //Arrange
        productModel();
        productMockModel.setUrlProductImage("htts//:loquesea");
        //Act
        ProductModel new_product_model = productService.create(productMockModel);
        //Assert
        Assertions.assertNull(new_product_model.getUrlProductImage());
    }

    @Test
    void ValidateCreateDatesProductNameNotValidate(){
        //Arrange
        productModel();
        productMockModel.setProductName("cordones");
        //Act
        ProductModel new_product_model = productService.create(productMockModel);
        //Assert
        Assertions.assertNull(new_product_model.getProductName());
    }

    @Test
    void ValidateCreateDatesProductDescriptionNotValidate(){
        //Arrange
        productModel();
        productMockModel.setProductDescription("extra largos");
        //Act
        ProductModel new_product_model = productService.create(productMockModel);
        //Assert
        Assertions.assertNull(new_product_model.getProductDescription());
    }

    @Test
    void ValidateCreateDatesUserIdNotValidate(){
        //Arrange
        productModel();
        productMockModel.setUserId("2");
        //Act
        ProductModel new_product_model = productService.create(productMockModel);
        //Assert
        Assertions.assertNull(new_product_model.getUserId());
    }

    @Test
    void ValidateCreateSellByUserValidateAndAmountNotValidate(){
        //Arrange
        productModel();
        userModel();
        productMockModel.setUserId("1");
        productMockModel.setAmountToSell(150);
        //Act
        ProductModel new_product_model = productService.create(productMockModel);
        //Assert
        Assertions.assertNull(new_product_model.getUserId());
    }

    @Test
    void ValidateCreateSellByUserNotValidate(){
        //Arrange
        productModel();
        userModel();
        productMockModel.setUserId("2");
        productMockModel.setAmountToSell(50);
        //Act
        ProductModel new_product_model = productService.create(productMockModel);
        //Assert
        Assertions.assertNull(new_product_model.getUserId());
    }

    @Test
    void ValidateCreateAllOk(){
        //Arrange
        productModel();
        userModel();
        productMockModel.setIdProduct("1");
        productMockModel.setProductName("condones");
        productMockModel.setIdCategory(1);
        productMockModel.setProductDescription("extra grandes");
        productMockModel.setUrlProductImage("https://www.google.com");
        productMockModel.setUserId("1");
        productMockModel.setDocumentNumber(1);
        productMockModel.setAmountToSell(100);
        userMockModel.setId("1");
        userMockModel.setUserType("Buyer");
        userMockModel.setMaxSell(50);
        //Act
        ProductModel new_product_model = productService.create(productMockModel);
        //Assert
        Assertions.assertNotNull(new_product_model.getUserId());
    }

    @Test
    void ValidateUpdateProductIdNotValidate(){
        //Arrange
        productModel();
        shoppingModel();
        String id_product = "2";
        shoppingMockModel.setStateBuy("Created");
        //Act
        ProductModel new_product_model = productService.update(id_product,productMockModel);
        //Assert
        Assertions.assertNull(new_product_model.getUserId());
    }

    @Test
    void ValidateUpdateShoppingStateBuyNotValidate(){
        //Arrange
        productModel();
        shoppingModel();
        String id_product = "1";
        shoppingMockModel.setStateBuy("Delete");
        Long actualIdcategory = productMockModel.getIdCategory();
        productMockModel.setIdCategory(2);
        //Act
        ProductModel new_product_model = productService.update(id_product,productMockModel);
        //Assert
        Assertions.assertNotEquals(new_product_model.getIdCategory(),actualIdcategory);
    }

    @Test
    void ValidateUpdateShoppingByProductIdNotValidate(){
        //Arrange
        productModel();
        shoppingModel();
        String id_product = "1";
        shoppingMockModel.setStateBuy("Created");
        ProductModel producttestZ = new ProductModel();
        producttestZ.setIdCategory(2);
        shoppingMockModel.setIdProduct("2");
        //Act
        ProductModel new_product_model = productService.update(id_product,producttestZ);
        //Assert
        Assertions.assertNotEquals(new_product_model.getIdCategory(),producttestZ.getIdCategory());
    }

    @Test
    void ValidateUpdateAllOk(){
        //Arrange
        productModel();
        shoppingModel();
        String id_product = "1";
        shoppingMockModel.setStateBuy("Created");
        ProductModel producttestZ = new ProductModel();
        producttestZ.setIdCategory(2);
        shoppingMockModel.setIdProduct("1");
        //Act
        ProductModel new_product_model = productService.update(id_product,producttestZ);
        //Assert
        Assertions.assertEquals(new_product_model.getIdCategory(),producttestZ.getIdCategory());
    }

    @Test
    void ValidategetProductByKeywordNotexist(){
        //Arrange
        productModel();
        String keyword = "cordones";
        //Act
        List <ProductModel> productlist = new ArrayList<ProductModel>(productService.getProductByKeyword(keyword));
        //Assert
        Assertions.assertTrue(productlist.isEmpty());
    }

    @Test
    void ValidategetProductByKeywordexist(){
        //Arrange
        productModel();
        String keyword = "con";
        //Act
        List <ProductModel> productlist = new ArrayList<ProductModel>(productService.getProductByKeyword(keyword));
        //Assert
        Assertions.assertFalse(productlist.isEmpty());
    }

    @Test
    void ValidategetByIdCategoryNotexist(){
        //Arrange
        productModel();
        long idCategory = 2;
        //Act
        List <ProductModel> productlistBycategory = new ArrayList<ProductModel>(productService.getByIdCategory(idCategory));
        //Assert
        Assertions.assertTrue(productlistBycategory.isEmpty());
    }

    @Test
    void ValidategetByIdCategoryexist(){
        //Arrange
        productModel();
        long idCategory = 1;
        //Act
        List <ProductModel> productlistBycategory = new ArrayList<ProductModel>(productService.getByIdCategory(idCategory));
        //Assert
        Assertions.assertFalse(productlistBycategory.isEmpty());
    }

    /*Delete
    @Test
    void nnnn(){
        //Arrange
        productModel();
        productMockModel.setUserId("1");
        //Act
        //Assert
    }*/
}