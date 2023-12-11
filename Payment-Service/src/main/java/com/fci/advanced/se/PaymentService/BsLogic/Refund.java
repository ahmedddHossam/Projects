package com.fci.advanced.se.PaymentService.BsLogic;

import com.fci.advanced.se.PaymentService.DB.DataBase;
import com.fci.advanced.se.PaymentService.Models.Customer;
import com.fci.advanced.se.PaymentService.Models.RechargeItem;
import com.fci.advanced.se.PaymentService.Models.Transaction;

import java.util.ArrayList;

public class Refund {

    DataBase table;
    ArrayList<Transaction> refundList=new ArrayList<Transaction>();
    ArrayList<Transaction> transactionsTable;
    ArrayList<Customer> customersTable;
    CustomerBSL customerBSL;
    public Refund()
    {
        customerBSL=new CustomerBSL();
        table=DataBase.getInstance();
        refundList=table.getRefundItemsTable();
        customersTable=table.getCustomerTable();
        transactionsTable=table.getTransactionsTable();
    }

    public String refundRequest(int id)
    {
        if(!validate(id))
            return "Transaction not found";
        for(Transaction obj:transactionsTable)
        {
            if(obj.getId()==id)
            {
                refundList.add(obj);
                break;
            }
        }
        return "Request has done successfully";
    }
    private boolean validate(int id)
    {
        return id<=transactionsTable.size() && id>0;
    }
    public ArrayList<Transaction> listRequests()
    {
        refundList=table.getRefundItemsTable();
        return refundList;
    }
    public String remove(int indx,String status)
    {
        String email=refundList.get(indx-1).getEmail();
        Customer customer=customerBSL.getCustomer(email);
        return notify(customer,status,indx);
    }
    private String notify(Customer customer,String status,int indx)
    {
        double amount=refundList.get(indx-1).getAmount();
        if(status.equals("Yes"))
        {
            customer.getWallet().setBalance(refundList.get(indx-1).getAmount());
        }
        refundList.remove(indx-1);
        return customer.update(status,amount);

    }
}
