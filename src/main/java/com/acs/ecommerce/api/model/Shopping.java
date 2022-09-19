package com.acs.ecommerce.api.model;

import java.time.LocalTime;

/* package com.acs.ecommerce.api.service; */ /* lo comento por que saca error y no se porque*/
public class Shopping{
    private int idShopping;
    private int idShopper;
    private int idProduct;
    private int amountProduct;
    private String addressSend;

/*Otra opcion es crear el objeto localtime desde aqui*/
    private int increment=0;
    public Shopping(int idShopper, int idProduct, int amountProduct, String addressSend, String addressFact, String paymentGateway, String dateBuy) {
        this.idShopping=increment;
        this.idShopper = idShopper;
        this.idProduct = idProduct;
        this.amountProduct = amountProduct;
        this.addressSend = addressSend;
        this.addressFact = addressFact;
        this.paymentGateway = paymentGateway;
        this.dateBuy = dateBuy;
        this.increment++;
    }

    private String addressFact;
    private String paymentGateway;
    private String dateBuy;

    public int getIdShopping() {
        return idShopping;
    }

    public void setIdShopping(int idShopping) {
        this.idShopping = idShopping;
    }

    public int getIdShopper() {
        return idShopper;
    }

    public void setIdShopper(int idShopper) {
        this.idShopper = idShopper;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(int amountProduct) {
        this.amountProduct = amountProduct;
    }

    public String getAddressSend() {
        return addressSend;
    }

    public void setAddressSend(String addressSend) {
        this.addressSend = addressSend;
    }

    public String getAddressFact() {
        return addressFact;
    }

    public void setAddressFact(String addressFact) {
        this.addressFact = addressFact;
    }

    public String getPaymentGateway() {
        return paymentGateway;
    }

    public void setPaymentGateway(String paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(String dateBuy) {
        this.dateBuy = dateBuy;
    }
}
