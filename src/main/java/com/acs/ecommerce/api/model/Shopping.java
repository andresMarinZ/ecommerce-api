package com.acs.ecommerce.api.model;

import java.time.LocalTime;

/* package com.acs.ecommerce.api.service; */ /* lo comento por que saca error y no se porque*/
public class Shopping{

    private int idShopping;
    private int idShopper;
    private String idProduct;
    private int amountProduct;
    private String addressSend;
    private String addressFact;
    private String paymentGateway;
    private LocalTime dateBuy;

    private int idSeller;

    public String getStateBuy() {
        return stateBuy;
    }

    public void setStateBuy(String stateBuy) {
        this.stateBuy = stateBuy;
    }

    private String stateBuy;
/*Otra opcion es crear el objeto localtime desde aqui*/
    private int increment=0;

    public Shopping(){}

    public Shopping(int idShopper, int idSeller, String idProduct, int amountProduct, String addressSend, String addressFact, String paymentGateway) {
        this.idShopping=increment;
        this.idShopper = idShopper;
        this.idSeller = idSeller;
        this.idProduct = idProduct;
        this.amountProduct = amountProduct;
        this.addressSend = addressSend;
        this.addressFact = addressFact;
        this.paymentGateway = paymentGateway;
        this.dateBuy = LocalTime.now();
    }





    public int getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(int idSeller) {
        this.idSeller = idSeller;
    }

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

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
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

    public LocalTime getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(LocalTime dateBuy) {
        this.dateBuy = dateBuy;
    }
}
