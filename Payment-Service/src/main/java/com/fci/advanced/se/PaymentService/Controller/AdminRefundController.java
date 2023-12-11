package com.fci.advanced.se.PaymentService.Controller;

import com.fci.advanced.se.PaymentService.BsLogic.Refund;
import com.fci.advanced.se.PaymentService.DB.DataBase;
import com.fci.advanced.se.PaymentService.Models.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AdminRefundController
{
    Refund refund ;
    DataBase table ;
    public AdminRefundController()
    {
        table=DataBase.getInstance();
        refund=new Refund();
    }
    @GetMapping(value = "/Admin/Refund/listRefundRequests")
    public ArrayList<Transaction> listRequests()
    {
        return this.refund.listRequests();

    }
    @GetMapping(value = "/Admin/listAllTransaction")
    public ArrayList<Transaction> listAllTransaction()
    {
        return this.table.getTransactionsTable();

    }
    ///Admin/refundStatus?indx=  &status=
    @GetMapping(value = "/Admin/Refund/refundStatus")
    public String refundStatus(@RequestParam("indx") int indx, @RequestParam("status") String status){
        return this.refund.remove(indx,status);
    }
}
