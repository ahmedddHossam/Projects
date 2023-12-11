package com.fci.advanced.se.PaymentService.Models;

public class CreditCard
{
    private String cardNumber;
    private double balance;
    public CreditCard()
    {
        balance=0;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void Withdrawal(double money)
    {
        this.balance-=money;
    }
    public void deposit(double money)
    {
        this.balance+=money;
    }

    public double getBalance() {
        return balance;
    }
    public String getCardNumber()
    {
        return cardNumber;
    }
}
