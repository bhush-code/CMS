package com.Hexaware.CMS.Factory;

import com.Hexaware.CMS.Model.Customer;
import com.Hexaware.CMS.Persistence.CustomerDb;
import java.sql.SQLException;

/**
 * OrderFactory class used to fetch and insert data to database.
 * @author hexware
 */
public class CustomerFactory {
    
public static int Insertdb(int Cus_id,String Cus_name,String ph_no,String Cus_Username, String Cus_Password, String Cus_Email, String Dob, String Address) throws Exception
    {

       int result= CustomerDb.insertDb(Cus_id,Cus_name,ph_no,Cus_Username,Cus_Password,Cus_Email, Dob, Address);
       return result;
    }

    public static Customer[] fetchCustomer() throws SQLException, Exception {
        Customer customer[]=CustomerDb.fetchDb();
        return customer;
    }
    public static Customer  SearchCustomer(int Cus_id) throws Exception
    {
        CustomerDb db=new CustomerDb();
        return db.SearchDb(Cus_id);

    }
    }

