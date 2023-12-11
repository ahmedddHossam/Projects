package com.fci.advanced.se.PaymentService.BsLogic;

import com.fci.advanced.se.PaymentService.DB.DataBase;
import com.fci.advanced.se.PaymentService.Models.Customer;

import java.util.ArrayList;

public class CustomerBSL {
    private DataBase table ;
    ArrayList<Customer>customerArrayList;

    public CustomerBSL() {
        table =DataBase.getInstance();
        customerArrayList = table.getCustomerTable();
    }
    public Customer getCustomer(String email){
        Customer customer=new Customer();
        for ( Customer obj : customerArrayList){
            if (obj.getEmail().equals(email)){
                customer=obj;
                break;
            }
        }
        return customer;
    }

}
