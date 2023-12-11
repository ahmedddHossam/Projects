package com.fci.advanced.se.PaymentService.Models;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Customer
{
    private int id ;
    private String email;
    private String password;
    private String userName;
    private double amount ;

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    //private CreditCard card=null;
    private Wallet wallet;
    //private CreditCard creditCard;


    public Customer(){
        wallet = new Wallet();
    }

    public void setAmount(double amount) {
        this.amount = wallet.getBalance();
    }

    public Wallet getWallet() {
        return wallet;
    }

    public int getId() {
        return id;
    }

    public Customer(int id , String email, String password, String userName , double money)
    {
        this.id = id ;
        this.email=email;
        this.password=password;
        this.userName=userName;
//        this.wallet.setBalance(money);
        //this.creditCard=creditCard;
        wallet=new Wallet();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public String getUserName() {
        return userName;
    }

    public String update(String status,double amount)
    {
        if(status.equals("Yes"))
        {
            return ("Refund has been accepted successfully and "+amount+" added to wallet" );}
        else
            return ("Refund has been rejected");

    }
    public String updateDiscount(double offer ,String service)
    {
        return "you have ( "+(offer*100.0)+"% ) on "+service+" services";
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
