package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.ProductModel;
import com.acs.ecommerce.api.service.iservice.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import java.util.regex.*;

@Service
public class ProductService implements IProductService {
    private static  List<ProductModel> productsModel = new ArrayList<>();
    private static UserService _UserService;
    @Autowired
    public ProductService(List<ProductModel> productInjection, UserService userService) {
        _UserService = userService;
        productsModel = productInjection;
    }

    @Override
    public List<ProductModel> get() {
        return null;
    }

    @Override
    public ProductModel getByid(String idProduct) {
        Optional<ProductModel> optionalProduct = productsModel.stream()
                .filter(product -> product.getIdProduct().equals(idProduct))
                .findFirst();
        return optionalProduct.orElse(null);
    }

    @Override
    public ProductModel create(ProductModel productModel) {

        if(!this.ValidateProductByUser(productModel.getUserId())||
           !this.UrlValida(productModel.getUrlProductImage())||
           !this.DatesValidate(productModel)) return new ProductModel();
        productModel.setIdProduct(UUID.randomUUID().toString());
        //tope de vendedor
        productsModel.add(productModel);

        return productModel;
    }

    @Override
    public ProductModel update(String idProduct, ProductModel productModel) {
        Optional<ProductModel> optionalProduct = productsModel.stream()
                .filter(product -> product.getIdProduct().equals(idProduct))
                .findFirst();
        if(optionalProduct!=null){
            return null;
        }
        //con restriccion cantidad a vender tope vendedor
        //categoria solo si no tiene ventas

        return null;
    }

    @Override
    public ProductModel delete(String idProduct, ProductModel productModel) {
        Optional<ProductModel> optionalProduct = productsModel.stream()
                .filter(product -> product.getIdProduct().equals(idProduct))
                .findFirst();
        if(optionalProduct!=null){
            return null;
        }
        //eliminar por ID solo si no tiene ventas
        return null;
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
    private boolean UrlValida(String url) {
        String regex = "((http|https)://)(www.)?"
                + "[a-zA-Z0-9@:%._\\+~#?&//=]"
                + "{2,256}\\.[a-z]"
                + "{2,6}\\b([-a-zA-Z0-9@:%"
                + "._\\+~#?&//=]*)";
        Pattern p = Pattern.compile(regex);
        if (url == null) {
            return false;
        }
        Matcher m = p.matcher(url);
        return m.matches();
    }
    private boolean DatesValidate(ProductModel productModel) {

        if((productModel.getProductName()!=null)||
           (productModel.getProductDescription()!=null)||
           (productModel.getUserId()!=null)){
            return true;
        }
        return false;
    }


}
