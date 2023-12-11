package com.fci.advanced.se.PaymentService.BsLogic;

import com.fci.advanced.se.PaymentService.Models.CreditCard;
import com.fci.advanced.se.PaymentService.Models.Customer;

public class Payment implements CreditCardPayment,WalletPayment
{
    private Discount discount;
    public Payment()
    {
        discount=Discount.getInstance();
    }


    @Override
    public double payByWallet(Customer customer, double amount , String service) {
        double money=amount;
        if(discount.servicesDiscountDetails.containsKey(service))
            money-=(amount*(discount.servicesDiscountDetails.get(service)/100.0));
        if(discount.customerDiscountsDetails.containsKey(customer.getEmail()))
            money-=(amount*(discount.customerDiscountsDetails.get(customer.getEmail())/100.0));
        if(customer.getWallet().getBalance()>=money)
        {
            customer.getWallet().Withdrawal(money);
            return money;
        }
        return -1;
    }

    @Override
    public double payByCredit(Customer customer,CreditCard card, double amount, String service)
    {
        double money=amount;
        if(discount.servicesDiscountDetails.containsKey(service))
            money-=(amount*(discount.servicesDiscountDetails.get(service)/100.0));
        if(discount.customerDiscountsDetails.containsKey(customer.getEmail()))
            money-=(amount*(discount.customerDiscountsDetails.get(customer.getEmail())/100.0));
        if(card.getBalance()>=money)
        {
            card.Withdrawal(money);
            return money;
        }
        return -1;
    }
}