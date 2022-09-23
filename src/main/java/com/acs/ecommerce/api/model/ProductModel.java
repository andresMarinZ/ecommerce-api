package com.acs.ecommerce.api.model;

import java.time.LocalDateTime;

public class ProductModel {
    private String idProduct;
    private String productName;
    private String productDescription;
    private int amountToSell;

    private long idCategory;
    private String urlProductImage;
    private LocalDateTime dateAddProduct = LocalDateTime.now();
    private String userId;

    public ProductModel(){

    }

    public ProductModel(String idProduct, String productName, String productDescription, int amountToSell, long idCategory, String urlProductImage, LocalDateTime dateAddProduct, int documentNumber) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.productDescription = productDescription;
        this.amountToSell = amountToSell;
        this.idCategory = idCategory;
        this.urlProductImage = urlProductImage;
        this.dateAddProduct = dateAddProduct;
        this.documentNumber = documentNumber;
    }

    private int documentNumber;

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getAmountToSell() {
        return amountToSell;
    }

    public void setAmountToSell(int amountToSell) {
        this.amountToSell = amountToSell;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public void setProductCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public String getUrlProductImage() {
        return urlProductImage;
    }

    public void setUrlProductImage(String urlProductImage) {
        this.urlProductImage = urlProductImage;
    }

    public LocalDateTime getDateAddProduct() {
        return dateAddProduct;
    }

    public void setDateAddProduct(LocalDateTime dateAddProduct) {
        this.dateAddProduct = dateAddProduct;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(int documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    @Override
    public String toString() {
        return "ProductModel{" +
                "idProduct='" + idProduct + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", amountToSell=" + amountToSell +
                ", productCategory='" + idCategory + '\'' +
                ", urlProductImage='" + urlProductImage + '\'' +
                ", dateAddProduct=" + dateAddProduct +
                ", documentNumber=" + documentNumber +
                '}';
    }
}
