package com.Hexaware.CMS.Model;
import java.util.Date;

public class Customer
{
    private int Cus_id;
    private String  Cus_name;
    private String ph_no;
    private String Cus_Username;
    private String Cus_Password;
    private String Cus_Email;
    private Date  Dob;
    private String Address;

    public void SetCus_id(int Cus_id)
    {
        this.Cus_id=Cus_id;
    }
    public int GetCus_id()
    {
        return Cus_id;
    }
    public void SetCusname(String Cus_name)
    {
        this.Cus_name=Cus_name;
    }
    public String Getcusname()
    {
        return Cus_name;
    }
    public void Set_phno(String ph_no)
    {
        this.ph_no=ph_no;
    }

    public  String Get_phno()
    {
        return ph_no;
    }
    public void Set_Username(String Cus_Username)
    {
        this.Cus_Username=Cus_Username;
    }
    public String Get_Username()

    {
        return Cus_Username;
    }
    public void Set_Password(String  Cus_Password)
    {
         this.Cus_Password=Cus_Password;
    }
    public String Get_Password()
    {
        return Cus_Password;
    }
    public void Set_Email(String Cus_Email)
    {
        this.Cus_Email=Cus_Email;

    }
    public String Get_Email()
    {
        return Cus_Email;
    }
    public void Set_dob(Date Dob)


    {
            this.Dob=Dob;
    }
    public Date Get_dob()
    {
        return Dob;
    }
    public void Set_address(String Address)
    {
        this.Address=Address;
    }
    public String Get_address()
    {
        return Address;
    }

    public Customer()

    {}
    public Customer(int Cus_id, String Cus_name,String ph_no, String Cus_Username, String Cus_Password, String Cus_Email, Date Dob, String Address)
    {
        this.Cus_id=Cus_id;
        this.Cus_name=Cus_name;
        this.ph_no=ph_no;
        this.Cus_Username=Cus_Username;
        this.Cus_Password=Cus_Password;
        this.Cus_Email=Cus_Email;
        this.Dob=Dob;
        this.Address=Address;
    }

    @Override
    public  String toString()
    {
        return String.format("%3s %15s %15s %15s %15s %20s %18s %15s",Cus_id,Cus_name,ph_no,Cus_Username,Cus_Password,Cus_Email,Dob,Address);
    }
}
