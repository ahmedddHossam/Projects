package com.fci.advanced.se.PaymentService.Controller;

import com.fci.advanced.se.PaymentService.BsLogic.*;
import com.fci.advanced.se.PaymentService.Models.RechargeItem;
import com.fci.advanced.se.PaymentService.Models.Transaction;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
    private Providers provider;
    private Services services;
    private Refund refund;
    public ServiceController()
    {
        refund=new Refund();

    }
    @PostMapping(value = "/Customer/Recharge")
    public String recharge(@RequestBody RechargeItem rechargeItem)
    {
        if(rechargeItem.getService().equals("Mobile"))
        {
            services= Mobile.getInstance();
        }
        else if(rechargeItem.getService().equals("Internet"))
        {
            services=Internet.getInstance();
        }
        else if (rechargeItem.getService().equals("Landline"))
        {
            services=Landline.getInstance();
        }
        else if (rechargeItem.getService().equals("Donation"))
        {
            services=Donation.getInstance();
        }
        else
            return "Wrong data";
        provider=services.getProvider(rechargeItem.getProvider());
        return provider.recharge(rechargeItem);
    }
    @PostMapping(value = "/Customer/Refund")
    public String refund(@RequestBody Transaction transaction)
    {
//        refund=new Refund();
        return refund.refundRequest(transaction.getId());
    }
}
