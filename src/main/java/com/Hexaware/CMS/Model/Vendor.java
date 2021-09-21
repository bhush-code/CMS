package com.Hexaware.CMS.Model;


public class Vendor{
    private int ven_id;
    private String ven_name;
    private String Ven_number;
    private String ven_username;
    private String ven_password;
    private String ven_email;
    private String ven_address;

    public void Set_ven_id(int ven_id)
    {
        this.ven_id=ven_id;
    }
    public int Get_ven_id()
    {

        return ven_id;
    }
    public void Set_ven_name(String ven_name)
    {
        this.ven_name=ven_name;
    }
    public String Get_ven_name()
    {
        return ven_name;
    }
    public void Set_ven_Number(String Ven_number)
    {
        this.Ven_number=Ven_number;
    }
    public String Get_ven_number()
    {
        return Ven_number;
    }
    public void Set_ven_username(String ven_username)
    {
        this.ven_username=ven_username;
    }
    public String Get_ven_username()
    {
        return ven_username;

    }
    public void Set_ven_password(String ven_password)
    {
        this.ven_password=ven_password;
    }
    public String Get_Password()
    {
        return ven_password;
    }
    public void Set_ven_email(String ven_email)
    {
        this.ven_email=ven_email;
    }
    public String Get_ven_email()
    {
        return ven_email;
    }
    public void Set_ven_address(String ven_address)
    {
        this.ven_address=ven_address;
    }
    public String Get_ven_address()
    {
        return ven_address;
    }
    public Vendor()
    {

    }
    public Vendor(int ven_id,String ven_name, String Ven_number,String ven_username,String ven_password, String ven_email, String ven_address)
    {
        this.ven_id=ven_id;
        this.ven_name=ven_name;
        this.Ven_number=Ven_number;
        this.ven_username=ven_username;
        this.ven_password=ven_password;
        this.ven_email=ven_email;
        this.ven_address=ven_address;

    }

    @Override
    public String toString()
    {
        return String.format("%12s %12s %15s %15s %15s %20s %18s", ven_id,ven_name,Ven_number,ven_username,ven_password,ven_email,ven_address);


    }
}