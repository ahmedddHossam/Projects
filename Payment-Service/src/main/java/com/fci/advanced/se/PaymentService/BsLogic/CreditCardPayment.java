package com.fci.advanced.se.PaymentService.BsLogic;

import com.fci.advanced.se.PaymentService.Models.CreditCard;
import com.fci.advanced.se.PaymentService.Models.Customer;
import com.fci.advanced.se.PaymentService.PaymentServiceApplication;
import com.fci.advanced.se.PaymentService.PaymentServiceApplication;

public interface CreditCardPayment
{
    public double payByCredit(Customer customer,CreditCard card, double amount,String service);
}
