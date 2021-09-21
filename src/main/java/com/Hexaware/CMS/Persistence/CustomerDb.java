package com.Hexaware.CMS.Persistence;
import com.Hexaware.CMS.Model.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import com.Hexaware.CMS.Model.Customer;

import java.sql.PreparedStatement;

public class CustomerDb{
   static int i;
   
    public static int insertDb(int Cus_id,String Cus_name,String ph_no,String Cus_Username,String Cus_Password,String Cus_Email, String Dob, String Address)
    throws Exception
    {        
        Connection con=ConnectionHelper.GetConnection();

            PreparedStatement stmt=con.prepareStatement("insert into Customer  values(?,?,?,?,?,?,?,?)");  
        stmt.setInt(1,Cus_id);  
        stmt.setString(2,Cus_name);  
        stmt.setString(3,ph_no);
        stmt.setString(4,Cus_Username);   
        stmt.setString(5,Cus_Password);
        stmt.setString(6,Cus_Email);
        stmt.setString(7,Dob);
        stmt.setString(8,Address);
        i=stmt.executeUpdate();  
        //System.out.println(i+" records inserted");  

                return i;
            }  

    public static Customer[] fetchDb() throws Exception{
        
            Connection con=ConnectionHelper.GetConnection();
            Statement stmt=con.createStatement();  
              Customer customer=null;      
            ResultSet rs=stmt.executeQuery("select * from customer");  
            ArrayList<Customer> customerlist=new ArrayList<Customer>();          
            while(rs.next()) { 
                customer=new Customer();
                customer.SetCus_id(rs.getInt("cus_id"));
                 customer.SetCusname(rs.getString("cus_name"));
                 customer.Set_phno(rs.getString("cus_phnno"));
                 customer.Set_Username(rs.getString("cus_Username"));
                 customer.Set_Password(rs.getString("cus_Password"));
                 customer.Set_Email(rs.getString("cus_email"));
                 customer.Set_dob(rs.getDate("Cus_dob"));
                 customer.Set_address(rs.getString("cus_address"));
                 customerlist.add(customer);

                  
                  } 

                 return  customerlist.toArray(new Customer[customerlist.size()]); 
 
                              
        }
        public static Customer SearchDb(int Cus_id)throws SQLException,Exception{
        Customer  customer=null;
            Connection con=ConnectionHelper.GetConnection();
            String cmd="select * from customer where Cus_id=?";
            PreparedStatement stmt= con.prepareStatement(cmd);
            stmt.setInt(1,Cus_id);  
            
            ResultSet rs=stmt.executeQuery();
                
            if(rs.next()) { 

                 customer=new Customer();
                 customer.SetCus_id(rs.getInt("cus_id"));
                 customer.SetCusname(rs.getString("cus_name"));
                 customer.Set_phno(rs.getString("cus_phnno"));
                 customer.Set_Username(rs.getString("cus_Username"));
                 customer.Set_Password(rs.getString("cus_Password"));
                 customer.Set_Email(rs.getString("cus_email"));
                 customer.Set_dob(rs.getDate("Cus_dob"));
                 customer.Set_address(rs.getString("cus_address"));


                  } 
        
            
                 return  customer;
        }
}

