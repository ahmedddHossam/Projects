package com.fci.advanced.se.PaymentService.BsLogic;

import com.fci.advanced.se.PaymentService.DB.DataBase;
import com.fci.advanced.se.PaymentService.Models.Customer;
import com.fci.advanced.se.PaymentService.Models.RechargeItem;
import com.fci.advanced.se.PaymentService.Models.Transaction;

import java.util.ArrayList;

public class VodafoneInternetService extends Providers{

    public VodafoneInternetService()
    {
        table=DataBase.getInstance();
        transactionsTable=table.getTransactionsTable();
        customerTable=table.getCustomerTable();
        refundItemsTable=table.getRefundItemsTable();
        Method=new Payment();
    }
    @Override
    public String recharge(RechargeItem rechargeItem)
    {
        boolean flag = false ;
        Customer customer=new Customer();
        for (Customer obj: customerTable)
        {
            if(obj.getEmail().equals(rechargeItem.getEmail()))
            {
                customer=obj;
                flag=true;
                break;
            }
        }
        if(!flag)
        {
            return "Wrong Email";
        }
        double money=0.0;
        if(rechargeItem.getPaymentMethod().equals("Wallet"))
        {
            money=Method.payByWallet(customer,rechargeItem.getAmount(),"Internet");
            if(money<0)
            {
                return "Not enough balance";
            }

        }
        else
        {
            money=Method.payByCredit(customer,rechargeItem.getCard(),rechargeItem.getAmount(),"Internet");
            if(money<0)
            {
                return "Not enough balance";
            }
        }
        transactionsTable.add(new Transaction(rechargeItem.getEmail(),transactionsTable.size()+1,rechargeItem.getAmount(),rechargeItem.getNumber(),"Vodafone Internet Service"));
        return "Recharge has done successfully and your operation ID is "+transactionsTable.size()+" you pay "+money+" only Vodafone Internet service";
    }


}
