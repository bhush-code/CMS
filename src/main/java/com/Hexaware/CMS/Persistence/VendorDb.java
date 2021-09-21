
package com.Hexaware.CMS.Persistence;

import com.Hexaware.CMS.Model.Vendor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


public class VendorDb{
    static int i;

  public static Vendor[] fetchDb() throws Exception{
        Vendor v[]=null;
            Connection con=ConnectionHelper.GetConnection();
            Statement stmt=con.createStatement();  
                    
            ResultSet rs=stmt.executeQuery("select * from vendor");  
            ArrayList<Vendor> list=new ArrayList<Vendor>();          
            while(rs.next()) { 
            list.add(new Vendor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
                v=new Vendor[list.size()];
                v= list.toArray(v);
                  } 
    
            
        return v;      
        }

        public static Vendor SearchDb(int ven_id) throws Exception{
        Vendor  vendor=null;
            Connection con=ConnectionHelper.GetConnection();
            //Statement stmt=con.createStatement();
            String cmd="select *from vendor where ven_id=?";
            PreparedStatement stmt= con.prepareStatement(cmd);
            stmt.setInt(1,ven_id);  
            
            ResultSet rs=stmt.executeQuery();
                
            if(rs.next()) { 

                 vendor=new Vendor();
                 vendor.Set_ven_id(rs.getInt("ven_id"));
                 vendor.Set_ven_name(rs.getString("ven_name"));
                 vendor.Set_ven_Number(rs.getString("ven_number"));
                 vendor.Set_ven_username(rs.getString("ven_user_name"));
                 vendor.Set_ven_password(rs.getString("ven_password"));
                 vendor.Set_ven_email(rs.getString("ven_email"));
                 vendor.Set_ven_address(rs.getString("ven_address"));
                 


                  } 
       
            
        return  vendor;
        }

        public static int insertDb(int ven_id,String ven_name,String Ven_number,String ven_username,String ven_password,String ven_email, String ven_address) throws Exception{        


         Connection con=ConnectionHelper.GetConnection();       
        PreparedStatement stmt=con.prepareStatement("insert into Vendor  values(?,?,?,?,?,?,?)");  
        stmt.setInt(1,ven_id);  
        stmt.setString(2,ven_name);  
        stmt.setString(3,Ven_number);
        stmt.setString(4,ven_username);   
        stmt.setString(5,ven_password);
        stmt.setString(6,ven_email);
        stmt.setString(7,ven_address);
        i=stmt.executeUpdate();  
        //System.out.println(i+" records inserted");  
        
                return i;
            }  
}

   