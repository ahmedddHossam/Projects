package com.fci.advanced.se.PaymentService.Models;

import com.fci.advanced.se.PaymentService.BsLogic.CancerHospitals;

public class RechargeItem {
    String number;
    double amount;
    String email;

    public CreditCard getCard() {
        return card;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }

    CreditCard card;

    public void setNumber(String number) {
        this.number = number;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    String provider;
    String service;
    String paymentMethod ;

    public RechargeItem() {
    }

    public String getNumber() {
        return number;
    }

    public double getAmount() {
        return amount;
    }

    public String getEmail() {
        return email;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getService() {
        return service;
    }



    public RechargeItem(String service, String number, double amount, String email, String paymentMethod,CreditCard card) {
        this.card=card;
        this.service=service;
        this.number = number;
        this.amount = amount;
        this.email = email;
        this.paymentMethod = paymentMethod;
    }
}
