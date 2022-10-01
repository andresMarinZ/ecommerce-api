package com.acs.ecommerce.api.model;

public class User {
    private String id;
    private String userType;
    private String firstName;
    private String lastName;
    private String documentType;
    private int documentNumber;
    private String storeName;
    private String createdUserType;
    //Pedido del equipo de Sebas
    private int maxSell;
    //Variable Henry
    private String idShoppingCart;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(int documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        storeName = storeName;
    }

    public String getCreatedUserType() {
        return createdUserType;
    }

    public void setCreatedUserType(String createdUserType) {
        this.createdUserType = createdUserType;
    }

    public int getMaxSell() {
        return maxSell;
    }

    public void setMaxSell(int maxSell) {
        this.maxSell = maxSell;
    }

    public String getIdShoppingCart() {
        return idShoppingCart;
    }

    public void setIdShoppingCart(String idShoppingCart) {
        this.idShoppingCart = idShoppingCart;
    }
}

