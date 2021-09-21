package com.Hexaware.CMS.Factory;

import com.Hexaware.CMS.Model.Vendor;
import com.Hexaware.CMS.Persistence.VendorDb;


public class VendorFactory
{
     public static int Insertdb(int ven_id,String ven_name,String Ven_number,String ven_username, String ven_password, String ven_email,  String ven_address)throws Exception{
    
       int result= VendorDb.insertDb(ven_id,ven_name,Ven_number,ven_username,ven_password,ven_email,ven_address);
       return result;
    }

    public static Vendor[] fetchCustomer() throws Exception{
        Vendor vendor[]=VendorDb.fetchDb();
        return vendor;
    }
    public static Vendor  SearchVendor(int ven_id) throws Exception
    {
        VendorDb db=new VendorDb();
        return db.SearchDb(ven_id);


    }
}