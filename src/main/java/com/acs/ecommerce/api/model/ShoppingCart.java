package com.acs.ecommerce.api.model;

public class ShoppingCart {
    private String id;
    private int idBuyer;
    private String idProduct;
    private int productQuantity;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdBuyer() {
        return idBuyer;
    }

    public void setIdBuyer(int idBuyer) {
        this.idBuyer = idBuyer;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }
}