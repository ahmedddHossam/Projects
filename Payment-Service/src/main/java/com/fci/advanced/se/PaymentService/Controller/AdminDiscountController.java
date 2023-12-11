package com.fci.advanced.se.PaymentService.Controller;

import com.fci.advanced.se.PaymentService.BsLogic.Discount;
import com.fci.advanced.se.PaymentService.BsLogic.Refund;
import com.fci.advanced.se.PaymentService.Models.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
public class AdminDiscountController {
    Discount discount;


    public AdminDiscountController() {
        discount=Discount.getInstance();
    }

    @PostMapping(value = "/Admin/Discount/AddOverAllDiscount")
    public String addOverAllDiscount(@RequestBody double offer)
    {
        return this.discount.SetOverAllDiscounts(offer);
    }
    @PutMapping (value = "/Admin/Discount/AddSpecificDiscount/{service}")
    public String addSpecificDiscount(@PathVariable("service")String service,@RequestBody double offer)
    {
        return this.discount.SetSpecificDiscounts(service,offer);
    }
    @PutMapping(value = "/Admin/Discount/RemoveSpecificDiscount/{service}")
    public String removeSpecificDiscount(@PathVariable("service") String service,@RequestBody double offer)
    {
        return this.discount.removeSpecificDiscounts(service,offer);
    }
    @PutMapping(value = "/Admin/Discount/RemoveOverAllDiscount")
    public String removeSpecificDiscount(@RequestBody double offer)
    {
        return this.discount.removeOverAllDiscounts(offer);
    }
}
