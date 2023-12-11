package com.fci.advanced.se.PaymentService.BsLogic;

import com.fci.advanced.se.PaymentService.DB.DataBase;
import com.fci.advanced.se.PaymentService.Models.Customer;
import com.fci.advanced.se.PaymentService.Models.RechargeItem;
import com.fci.advanced.se.PaymentService.Models.Transaction;

import java.util.ArrayList;

public abstract class Providers
{
    DataBase table;
    ArrayList<Transaction> transactionsTable;
    ArrayList<Customer>customerTable;
    ArrayList<Transaction> refundItemsTable;
    Payment Method;

    abstract public String recharge(RechargeItem rechargeItem);


}
