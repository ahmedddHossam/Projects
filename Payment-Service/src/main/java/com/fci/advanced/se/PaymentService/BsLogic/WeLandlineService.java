package com.fci.advanced.se.PaymentService.BsLogic;

import com.fci.advanced.se.PaymentService.DB.DataBase;
import com.fci.advanced.se.PaymentService.Models.Customer;
import com.fci.advanced.se.PaymentService.Models.RechargeItem;
import com.fci.advanced.se.PaymentService.Models.Transaction;
import org.springframework.stereotype.Service;

@Service
public class WeLandlineService extends Providers implements MonthlyPay,QuarterPay{
    public WeLandlineService() {
        table= DataBase.getInstance();
        transactionsTable=table.getTransactionsTable();
        customerTable=table.getCustomerTable();
        refundItemsTable=table.getRefundItemsTable();
        Method=new Payment();
    }

    @Override
    public String recharge(RechargeItem rechargeItem) {
        boolean flag = false ;
        Customer customer=new Customer();
        for (Customer obj: customerTable)
        {
            if(obj.getEmail().equals(rechargeItem.getEmail()))
            {
                flag = true ;
                customer=obj;
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
            money=Method.payByWallet(customer,rechargeItem.getAmount(),"Mobile");
            if(money<0)
            {
                return "Not enough balance";
            }

        }
        else
        {
            money=Method.payByCredit(customer,rechargeItem.getCard(),rechargeItem.getAmount(),"Mobile");
            if(money<0)
            {
                return "Not enough balance";
            }
        }
        if(rechargeItem.getProvider().equals("We Landline Service-Monthly receipt"))
            return MonthlyPay(rechargeItem,money);
        return QuarterPay(rechargeItem,money);
    }

    @Override
    public String MonthlyPay(RechargeItem rechargeItem,double money) {
        transactionsTable.add(new Transaction(rechargeItem.getEmail(),transactionsTable.size()+1,rechargeItem.getAmount(),rechargeItem.getNumber(),"We Landline Service - Monthly receipt"));
        return "payment for monthly receipt has done successfully and your operation ID is "+transactionsTable.size()+" and you pay "+money+" only";
    }

    @Override
    public String QuarterPay(RechargeItem rechargeItem,double money) {
        transactionsTable.add(new Transaction(rechargeItem.getEmail(),transactionsTable.size()+1,rechargeItem.getAmount(),rechargeItem.getNumber(),"We Landline Service - Quarter receipt"));
        return "payment for quarter receipt has done successfully and your operation ID is "+transactionsTable.size()+" and you pay "+money+" only";    }
}
