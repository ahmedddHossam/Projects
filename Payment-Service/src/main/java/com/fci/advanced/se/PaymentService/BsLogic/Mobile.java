package com.fci.advanced.se.PaymentService.BsLogic;

public class Mobile extends Services
{
    public static Mobile instance=new Mobile();
    private Mobile()
    {}
    public static Mobile getInstance()
    {
        return instance;
    }

    public Providers getProvider(String provider)
    {
        if(provider.equals("We"))
            this.provider=new WeMobileService();
        else if (provider.equals("Vodafone"))
        {
            this.provider=new VodafoneMobileService();
        } else if (provider.equals("Etisalat"))
        {
            this.provider=new EtisalatMobileService();
        }
        else
            this.provider=new OrangeMobileService();

        return this.provider;
    }


}
