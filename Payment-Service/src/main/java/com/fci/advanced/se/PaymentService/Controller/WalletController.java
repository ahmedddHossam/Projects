package com.fci.advanced.se.PaymentService.Controller;

import com.fci.advanced.se.PaymentService.BsLogic.CustomerBSL;
import com.fci.advanced.se.PaymentService.DB.DataBase;
import com.fci.advanced.se.PaymentService.Models.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class WalletController
{
    CustomerBSL customerBSL ;
    DataBase table;
    public WalletController()
    {
        customerBSL=new CustomerBSL();
        table=DataBase.getInstance();
    }

    @PutMapping(value = "Customer/Wallet/addToWallet/{email}/{money}")
    public String addToWallet (@PathVariable("email") String email , @RequestBody CreditCard creditCard,
                               @PathVariable("money") double money){
        Customer customer = customerBSL.getCustomer(email);
        return customer.getWallet().deposit(customer,creditCard,money);
    }
    @GetMapping(value = "/Admin/Wallet/listAllTransaction")
    public ArrayList<WalletTransaction> listRequests()
    {
        return this.table.getWalletTransactionsTable();

    }

}
