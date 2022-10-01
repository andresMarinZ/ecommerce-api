package com.acs.ecommerce.api.model;

public class User {
    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
    private String userType;
    private String firstName;
    private String lastName;
    private String documentType;
    private int documentNumber;
    private String StoreName;

    public String getCreatedUserType() {
        return CreatedUserType;
    }

    public void setCreatedUserType(String createdUserType) {
        CreatedUserType = createdUserType;
    }

    private String CreatedUserType;

    //Pedido del equipo de Sebas
    private int maxSell;
    //Variable Henry
    private String idShoppingCart;

    public User(int maxSell) {
        this.maxSell = maxSell;
    }

    public int getMaxSell() {
        return maxSell;
    }

    public void setMaxSell(int maxSell) {
        this.maxSell = maxSell;
    }

    public User() {

    }

    public String getIdShoppingCart() {
        return idShoppingCart;
    }

    public void setIdShoppingCart(String idShoppingCart) {
        this.idShoppingCart = idShoppingCart;
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
        return StoreName;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }

    public User(String id, String userType, String firstName, String lastName, String documentType, int documentNumber, String storeName) {
        this.id = id;
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        StoreName = storeName;
    }
}

