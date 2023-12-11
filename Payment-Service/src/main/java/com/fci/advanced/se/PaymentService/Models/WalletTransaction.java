package com.fci.advanced.se.PaymentService.Models;

public class WalletTransaction
{
    private Customer customer;
    private double amount;
    private CreditCard card;

    public WalletTransaction() {
        customer=new Customer();
        card=new CreditCard();
    }
    public WalletTransaction(Customer customer,CreditCard card,double amount) {
        this.customer=customer;
        this.card=card;
        this.amount=amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public CreditCard getCard() {
        return card;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }
}
