package com.fci.advanced.se.PaymentService.BsLogic;

public class Landline extends Services
{
    public static Landline instance=new Landline();
    private Landline()
    {}
    public static Landline getInstance()
    {
        return instance;
    }
    @Override
    public Providers getProvider(String provider) {
        if(provider.equals("We Landline Service-Monthly receipt") ||
                provider.equals("We Landline Service-Quarter receipt"))
            this.provider=new WeLandlineService();
        return this.provider;
    }
}
