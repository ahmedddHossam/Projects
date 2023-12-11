package com.fci.advanced.se.PaymentService.BsLogic;

public class Donation extends Services
{
    public static Donation instance=new Donation();
    private Donation()
    {}
    public static Donation getInstance()
    {
        return instance;
    }

    @Override
    public Providers getProvider(String provider) {
        if(provider.equals("NGOs"))
            this.provider=new NGOs();
        else if (provider.equals("Schools"))
        {
            this.provider=new Schools();
        }
        else if (provider.equals("CancerHospitals")) {
            this.provider = new CancerHospitals();
        }
        return this.provider;
    }
}
