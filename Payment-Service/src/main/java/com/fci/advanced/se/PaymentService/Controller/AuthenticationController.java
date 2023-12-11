package com.fci.advanced.se.PaymentService.Controller;
import com.fci.advanced.se.PaymentService.BsLogic.Authentication;
import com.fci.advanced.se.PaymentService.Models.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {
    Authentication authentication ;
    public AuthenticationController(Authentication authentication) {
        this.authentication = authentication ;
    }

@PostMapping(value = "/Customer/signup")
    public String signUp (@RequestBody Customer customer){
        return authentication.signUp(customer);
    }
    @PostMapping(value = "/Customer/login")
    public String login (@RequestBody Customer customer ) {
        return authentication.logIn(customer);
    }
    @GetMapping (value = "/Customer/{email}")
    public Customer getCustomer (@PathVariable("email") String email) {
        return authentication.getCustomer(email);
    }
}
