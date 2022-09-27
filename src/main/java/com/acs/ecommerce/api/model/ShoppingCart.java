package com.acs.ecommerce.api.model;

public class ShoppingCart {
    private String idShoppingCart;
    private int idShopping;
    private String idProduct;
    private int amountToSell;

    public String getIdShoppingCart() {
        return idShoppingCart;
    }

    public void setIdShoppingCart(String idShoppingCart) {
        this.idShoppingCart = idShoppingCart;
    }

    public int getIdShopping() {
        return idShopping;
    }

    public void setIdShopping(int idShopping) {
        this.idShopping = idShopping;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public int getAmountToSell() {
        return amountToSell;
    }

    public void setAmountToSell(int amountToSell) {
        this.amountToSell = amountToSell;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }
}