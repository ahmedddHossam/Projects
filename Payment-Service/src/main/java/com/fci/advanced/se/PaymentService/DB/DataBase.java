package com.fci.advanced.se.PaymentService.DB;

import com.fci.advanced.se.PaymentService.Models.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class DataBase {
    ArrayList<Customer> customerTable ;
    ArrayList<Transaction> refundItemsTable ;
    ArrayList<Transaction> transactionsTable;
    HashMap<String,Double> customerDiscountDetails;
    HashMap<String,Double> servicesDiscountDetails;
    ArrayList<WalletTransaction> walletTransactionsTable;

    public ArrayList<WalletTransaction> getWalletTransactionsTable() {
        return walletTransactionsTable;
    }

    public static DataBase obj;
   private  DataBase(){

    customerTable = new ArrayList<>();
    refundItemsTable = new ArrayList<>();
    transactionsTable=new ArrayList<>();
    customerDiscountDetails=new HashMap<String,Double>();
    servicesDiscountDetails=new HashMap<String,Double>();
    walletTransactionsTable=new ArrayList<>();
}
public static DataBase getInstance(){
        if(obj==null)
        {
            obj=new DataBase();
        }
        return obj;
}
    public void setCustomerTable(ArrayList<Customer> customerTable) {
        this.customerTable = customerTable;
    }

    public ArrayList<Customer> getCustomerTable() {
        return customerTable;
    }

    public ArrayList<Transaction> getRefundItemsTable() {
        return refundItemsTable;
    }
    public ArrayList<Transaction> getTransactionsTable() {
        return transactionsTable;
    }

    public HashMap<String, Double> getCustomerDiscountDetails() {
        return customerDiscountDetails;
    }

    public HashMap<String, Double> getServicesDiscountDetails() {
        return servicesDiscountDetails;
    }
}

