package com.Hexaware.CMS.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.sql.Date;

import java.util.ArrayList;
import java.util.Date;

import com.Hexaware.CMS.Model.Menu;
import com.Hexaware.CMS.Model.Orders;
import com.Hexaware.CMS.Model.OrdStatus;

import java.sql.PreparedStatement;

/**
 * OrderDb class used to connect to data base.
 * @author hexware
 */
public class PlaceOrder {
   static int i;
   
   public static void insertDb(Orders order) throws Exception{        
            Connection con=ConnectionHelper.GetConnection();
            PreparedStatement stmt=con.prepareStatement("insert into orders (cus_id, ven_id, menu_id,ord_date,ord_qty,ord_billamount,ord_status, ord_comments) values(?,?,?,?,?,?,?,?)"); 
            Date today=new Date();
            java.sql.Date sqlDate=new java.sql.Date(today.getTime());
            //order.Set_Date(sqldDate); 
       // stmt.setInt(1,order.Get_ord_id());  
        stmt.setInt(1,order.Get_cus_id());  
        stmt.setInt(2,order.Get_ven_id());
        stmt.setInt(3,order.Get_menu_id());   
        stmt.setDate(4,sqlDate);
        stmt.setInt(5,order.Get_ord_qty());
        stmt.setDouble(6,order.Get_bill_amount());
        stmt.setString(7,order.Get_ord_status().toString());
        stmt.setString(8,order.Get_ord_comments());
        stmt.executeUpdate();  
        //System.out.println(i+" records inserted");  
      
            
            }  

    public static Menu[] fetchDb() throws Exception{
        Menu m[]=null;
            Connection con=ConnectionHelper.GetConnection();
            Statement stmt=con.createStatement();  
                    
            ResultSet rs=stmt.executeQuery("select * from menu");  
            ArrayList<Menu> list=new ArrayList<Menu>();          
            while(rs.next()) { 
            list.add(new Menu(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4)));
                m=new Menu[list.size()];
                m= list.toArray(m);
                  } 
        
            
        return m;      
        }
        

      //  public static Customer customerProfileDb(){}
      // public static Vendor vendorProfileDb(){}
      // public static order[] customerOderHistoryDb(){}
      // public static Vendor[] vendorOderHistoryDb(){}
      // public static String acceptRejectDb(){}
    }

