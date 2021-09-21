package com.Hexaware.CMS.Model;


public class Wallet
{
    private int cus_id;
    private int wal_id;
    private Double wal_amount;
    private WalSource wal_source;

    public void Set_cus_id(int cus_id)
    {
        this.cus_id=cus_id;

    }
    public int Get_cus_id()
    {
        return cus_id;
    }
    public void Set_wal_id(int wal_id)
    {
        this.wal_id=wal_id;
    }
    public int Get_wal_id()
    {
        return wal_id;
    }
    public void Set_wal_amount(Double wal_amount)
    {
        this.wal_amount=wal_amount;
    }

    public Double  Get_wal_amount()
    {
        return wal_amount;
    }

    public void Set_wal_source(WalSource  wal_source)
    {
        this.wal_source=wal_source;
    
    }
    public WalSource Get_wal_source()
    {
        return wal_source;

    }

    public Wallet() {}


    public Wallet(int cus_id, int wal_id, Double wal_amount, WalSource wal_source)
    {
        this.cus_id=cus_id;
        this.wal_id=wal_id;
        this.wal_amount=wal_amount;
        this.wal_source=wal_source;

    }

    @Override
    public String toString()
    {
        return String.format("%5s %12s %18s %18s",cus_id,wal_id,wal_amount,wal_source);


    }


}