package com.fci.advanced.se.PaymentService.Models;

import com.fci.advanced.se.PaymentService.DB.DataBase;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Wallet
{
    private double balance;
    private DataBase table;

    public Wallet()
    {
        balance=0;
        table=DataBase.getInstance();
    }
    public String deposit( Customer customer,CreditCard card,double money)

    {
        if(card.getBalance()<money)
            return "Not enough balance";
        this.balance+=money;
        card.Withdrawal(money);
        table.getWalletTransactionsTable().add(new WalletTransaction(customer,card,money));
        return "amount added successfully"+this.balance;
    }

    public boolean setBalance(double balance) {
        this.balance += balance;
        return true;
    }

    public boolean Withdrawal(double money)

    {
        this.balance-=money;
        return true;
    }

    public double getBalance() {
        return balance;
    }
}
