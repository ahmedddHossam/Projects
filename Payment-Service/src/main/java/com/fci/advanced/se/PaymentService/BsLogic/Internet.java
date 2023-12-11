package com.fci.advanced.se.PaymentService.BsLogic;

public class Internet extends Services
{
    public static Internet instance=new Internet();
    private Internet()
    {}
    public static Internet getInstance()
    {
        return instance;
    }
    public Providers getProvider(String provider)
    {
        if(provider.equals("We"))
            this.provider=new WeInternetService();
        else if (provider.equals("Vodafone"))
        {
            this.provider=new VodafoneInternetService();
        } else if (provider.equals("Etisalat"))
        {
            this.provider=new EtisalatInternetService();
        }
        else
            this.provider=new OrangeInternetService();

        return this.provider;
    }

}
