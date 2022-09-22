package com.acs.ecommerce.api.model;

import java.time.LocalDateTime;
import java.util.Date;

public class ProductModel {
    private String idProduct;
    private String productName;
    private String productDescription;
    private int amountToSell;
    private String productCategory;
    private String urlProductImage;
    private LocalDateTime dateAddProduct = LocalDateTime.now();

    public ProductModel(){

    }

    public ProductModel(String idProduct, String productName, String productDescription, int amountToSell, String productCategory, String urlProductImage, LocalDateTime dateAddProduct, int documentNumber) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.productDescription = productDescription;
        this.amountToSell = amountToSell;
        this.productCategory = productCategory;
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

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
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

    @Override
    public String toString() {
        return "ProductModel{" +
                "idProduct='" + idProduct + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", amountToSell=" + amountToSell +
                ", productCategory='" + productCategory + '\'' +
                ", urlProductImage='" + urlProductImage + '\'' +
                ", dateAddProduct=" + dateAddProduct +
                ", documentNumber=" + documentNumber +
                '}';
    }


}
