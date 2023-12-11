package com.fci.advanced.se.PaymentService.BsLogic;

import com.fci.advanced.se.PaymentService.Models.Customer;
import com.fci.advanced.se.PaymentService.Models.Wallet;
import com.fci.advanced.se.PaymentService.PaymentServiceApplication;
import com.fci.advanced.se.PaymentService.PaymentServiceApplication;

import java.security.Provider;

public interface WalletPayment
{

    public double payByWallet(Customer customer, double amount , String service);
}
