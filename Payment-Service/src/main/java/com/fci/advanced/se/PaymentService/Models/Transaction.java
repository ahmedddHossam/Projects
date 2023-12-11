package com.fci.advanced.se.PaymentService.Models;

public class Transaction
{
   private String email;
   private int id;
   private double amount;
   private String number;
   private String service;

   public Transaction()
   {}

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Transaction(String email, int id, double amount, String number, String service) {
        this.email = email;
        this.id = id;
        this.amount = amount;
        this.number = number;
        this.service=service;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int transactionId) {
        this.id = transactionId;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
