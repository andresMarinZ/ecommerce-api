package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.ProductModel;
import com.acs.ecommerce.api.service.iservice.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    private static  List<ProductModel> productsModel = new ArrayList<>();
    private static UserService _UserService;
    private static ShoppingService _IShoppingService;

    @Autowired
    public ProductService(List<ProductModel> productInjection, UserService userService, ShoppingService shoppingInjection) {
        _UserService = userService;
        productsModel = productInjection;
        _IShoppingService = shoppingInjection;
    }

    @Override
    public ProductModel getProductById(String idProduct) {
        Optional<ProductModel> optionalProduct = productsModel.stream()
                .filter(product -> product.getIdProduct().equals(idProduct))
                .findFirst();
        return optionalProduct.orElse(null);
    }

    @Override
    public ProductModel create(ProductModel productModel) {

        if(!this.ValidateProductByUser(productModel.getUserId())||
           !this.UrlValida(productModel.getUrlProductImage())||
           !this.DatesValidate(productModel)||
           !this.ValidateSellByUser(productModel.getUserId(),productModel.getAmountToSell())
        ) return new ProductModel();
        productModel.setIdProduct(UUID.randomUUID().toString());
        productsModel.add(productModel);

        return productModel;
    }

    @Override
    public ProductModel update(String idProduct, ProductModel productModel) {

        ProductModel product = this.getProductById(idProduct);

        if (Objects.isNull(product)) {
            return new ProductModel();
        } else {
            product.setProductName(productModel.getProductName());
            product.setProductDescription(productModel.getProductDescription());
            product.setUrlProductImage(productModel.getUrlProductImage());
            if(this.ValidateShoppingByProductId(idProduct)) {
                product.setIdCategory(productModel.getIdCategory());
                product.setAmountToSell(productModel.getAmountToSell());
                return product;
            }
            return product;
        }
    }

    public Boolean delete(String idProduct) {

        ProductModel product = this.getProductById(idProduct);

        if (Objects.isNull(product) && this.ValidateShoppingByProductId(idProduct)) {
                return false;
            }
        productsModel.remove(product);
        return true;
    }
    @Override
    public List<ProductModel> getByIdCategory(long idCategory) {
        return productsModel.stream()
                .filter(product -> product.getIdCategory() == idCategory)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductModel> getProductByKeyword(String Keyword) {
        return productsModel.stream()
                .filter(product -> product.getProductName().contains(Keyword))
                .collect(Collectors.toList());
    }

    private boolean ValidateProductByUser(String userId){
        var user = _UserService.getByIdUser(userId);
        return Objects.nonNull(user) && user.getUserType().equals("Buyer");
    }
    private boolean ValidateSellByUser(String userId, int amountToSell){
        var user = _UserService.getByIdUser(userId);
        return Objects.nonNull(user) && user.getMaxSell()>0 && user.getMaxSell()<amountToSell;
    }

    private boolean ValidateShoppingByProductId(String idProduct){
        var shopping = _IShoppingService.getShoppingIdProduct(idProduct);
        return !Objects.nonNull(shopping) || !shopping.getStateBuy().equals("Created");
    }

    private boolean UrlValida(String url) {
        String regex = "((http|https)://)(www.)?"
                + "[a-zA-Z0-9@:%._~#?&/=]"
                + "{2,256}\\.[a-z]"
                + "{2,6}\\b([-a-zA-Z0-9@:%"
                + "._+~#?&/=]*)";
        Pattern p = Pattern.compile(regex);
        if (url == null) {
            return false;
        }
        Matcher m = p.matcher(url);
        return m.matches();
    }

    private boolean DatesValidate(ProductModel productModel) {
        return (productModel.getProductName() != null) ||
                (productModel.getProductDescription() != null) ||
                (productModel.getUserId() != null);
    }
}
