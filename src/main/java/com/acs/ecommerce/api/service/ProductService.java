package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.enums.UserTypeEnum;
import com.acs.ecommerce.api.model.ProductModel;
import com.acs.ecommerce.api.model.User;
import com.acs.ecommerce.api.service.iservice.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
        //permite buscar por palabras clave relacionado con el nombre
        return optionalProduct.orElse(null);
    }

    @Override
    public ProductModel create(ProductModel productModel) {
        //vendedor?
        //URL
        //tope de vendedor
        //no nullos en campos
        //fecha automatica
        productsModel.add(productModel);

        return productModel;
    }

    @Override
    public ProductModel update(String idProduct, ProductModel productModel) {
        //sin restriccion editar nombre descripcion y url
        //con restriccion cantidad a vender tope vendedor
        //categoria solo si no tiene ventas

        return null;
    }

    @Override
    public ProductModel delete(String idQuote, ProductModel productModel) {
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

    /*public static boolean UrlValida(String Url) {

        try {
            (new URl(Url)).openStream().close();
    private boolean ValidateReviewByUser(String userId){
        var user = _UserService.getByIdUser(userId);

        if(Objects.nonNull(user) && user.getUserType().equals("Buyer")){
            return true;
        }
        return false;
    }

            return true;
        } catch (Exception) {
        }

        return false;

    }*/
}
