package com.fci.advanced.se.PaymentService.BsLogic;

import com.fci.advanced.se.PaymentService.DB.DataBase;
import com.fci.advanced.se.PaymentService.Models.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
@Service
public class Authentication {
    DataBase table ;
    ArrayList<Customer> customerTable ;

    public Authentication() {
        table=DataBase.getInstance();
        customerTable = table.getCustomerTable();
    }
    public String signUp(Customer customer)
    {
        for ( Customer obj : customerTable){
            if (obj.getEmail().equals(customer.getEmail()) ){
                return "You already signed up";
            }
        }
        customerTable.add(customer);
        table.setCustomerTable(customerTable);
        return "User signed up successfully";
    }

    public String logIn(Customer customer)
    {
        boolean flag = false ;
        for ( Customer obj : customerTable){
            if (obj.getEmail().equals(customer.getEmail()) && obj.getPassword().equals(customer.getPassword()) ){
                flag = true ;
                break;
            }
        }
        if (!flag)
            return "Wrong email or password";
        return "login successfully";
    }

    public Customer getCustomer(String email) {
        for (Customer obj : customerTable) {
            if (obj.getEmail().equals(email)) {
                return obj;
            }
        }
        return null;
    }
}
