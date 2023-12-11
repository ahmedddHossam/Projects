package com.fci.advanced.se.PaymentService.BsLogic;

import com.fci.advanced.se.PaymentService.DB.DataBase;
import com.fci.advanced.se.PaymentService.Models.Customer;

import java.util.ArrayList;
import java.util.HashMap;

public class Discount
{
    DataBase table;
    HashMap<String,Double> customerDiscountsDetails;
    HashMap<String,Double>servicesDiscountDetails;
    ArrayList<Customer>customersTable;
    public static Discount instance=new Discount();

    private Discount()
    {
        table=DataBase.getInstance();
        customerDiscountsDetails=table.getCustomerDiscountDetails();
        servicesDiscountDetails=table.getServicesDiscountDetails();
        customersTable=table.getCustomerTable();
    }

    public static Discount getInstance() {
        return instance;
    }
    public String SetOverAllDiscounts(double offer)
    {
        for (Customer cust : customersTable)
        {
            if(customerDiscountsDetails.containsKey(cust.getEmail()))
                customerDiscountsDetails.put(cust.getEmail(),customerDiscountsDetails.get(cust.getEmail())+offer);
            else
                customerDiscountsDetails.put(cust.getEmail(),offer);
            cust.updateDiscount(offer,"all");
        }
        return "Discount has been submitted successfully";
    }
    public String SetSpecificDiscounts(String service,double offer)
    {
        if(servicesDiscountDetails.containsKey(service))
            servicesDiscountDetails.put(service,customerDiscountsDetails.get(service)+offer);
        else
            servicesDiscountDetails.put(service,offer);
        for (Customer cust : customersTable)
        {
            cust.updateDiscount(offer,service);
        }
        return "Discount has been submitted successfully";
    }
    public String removeSpecificDiscounts(String service,double offer)
    {
        if(servicesDiscountDetails.containsKey(service))
            servicesDiscountDetails.put(service,customerDiscountsDetails.get(service)-offer);
        else
            servicesDiscountDetails.put(service,0.0);
        return "Discount has been removed successfully";
    }
    public String removeOverAllDiscounts(double offer)
    {
        for (Customer cust : customersTable)
        {
            if(customerDiscountsDetails.containsKey(cust.getEmail()))
                customerDiscountsDetails.put(cust.getEmail(),customerDiscountsDetails.get(cust.getEmail())-offer);
            else
                customerDiscountsDetails.put(cust.getEmail(),0.0);
        }
        return "Discount has been removed successfully";
    }
}
