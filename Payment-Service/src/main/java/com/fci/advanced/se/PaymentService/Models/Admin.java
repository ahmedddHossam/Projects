package com.fci.advanced.se.PaymentService.Models;

public class Admin
{
    private String email;
    private String password;
    public Admin(){}
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }
    public String getPassword()
    {
        return password;
    }

}
