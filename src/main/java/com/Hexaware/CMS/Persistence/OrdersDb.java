package com.Hexaware.CMS.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.Hexaware.CMS.Model.Orders;
import com.Hexaware.CMS.Model.OrdStatus;

import java.sql.PreparedStatement;

public class OrdersDb{
   static int i;
   
    

public static Orders[] showOrders() throws SQLException, Exception{
      List<Orders> orderlist = new ArrayList<Orders>();
        Connection con=ConnectionHelper.GetConnection();
        String cmd = "select * from orders";
        PreparedStatement pst = con.prepareStatement(cmd);
        ResultSet rs = pst.executeQuery();
      
        Orders order = null;
        while(rs.next()) {
            order = new Orders();
            order.Set_ord_id(rs.getInt("ord_id"));
            order.Set_cus_id(rs.getInt("cus_id"));
            order.Set_Ven_id(rs.getInt("ven_id"));
            order.Set_menu_id(rs.getInt("menu_id"));
            order.Set_Date(rs.getDate("ord_date"));
            order.Set_ord_qty(rs.getInt("ord_qty"));
            order.Set_bill_amount(rs.getDouble("ord_billamount"));
            order.Set_ord_status(OrdStatus.valueOf(rs.getString("ord_status")));
            order.Set_ord_comment(rs.getString("ord_comments"));

            orderlist.add(order);           
        }
         
    return  orderlist.toArray(new Orders[orderlist.size()]);
} 
               
       

        public static Orders[] SearchDb(int cus_id) throws SQLException,Exception{
        Orders  order=null;
        List<Orders> orderlist=new ArrayList<Orders>();
          Connection con=ConnectionHelper.GetConnection();
            //Statement stmt=con.createStatement();
            String cmd="select *from  orders where cus_id=?";
            PreparedStatement stmt= con.prepareStatement(cmd);
            String str="PENDING";
            stmt.setInt(1,cus_id); 
            //stmt.setString(2, str);
            
            ResultSet rs=stmt.executeQuery();
                
            while(rs.next()) { 

            order=new Orders();
            order.Set_ord_id(rs.getInt("ord_id"));
            order.Set_cus_id(rs.getInt("cus_id"));
            order.Set_Ven_id(rs.getInt("ven_id"));
            order.Set_menu_id(rs.getInt("menu_id"));
            order.Set_Date(rs.getDate("ord_date"));
            order.Set_ord_qty(rs.getInt("ord_qty"));
            order.Set_bill_amount(rs.getDouble("ord_billamount"));
            order.Set_ord_status(OrdStatus.valueOf(rs.getString("ord_status")));
            order.Set_ord_comment(rs.getString("ord_comments"));
            orderlist.add(order);


                  } 
      
            
          return  orderlist.toArray(new Orders[orderlist.size()]);
    }

     public static Orders[] Advance_cus_SearchDb(int cus_id) throws SQLException, Exception{
        Orders  order=null;
        List<Orders> orderlist=new ArrayList<Orders>();
            Connection con=ConnectionHelper.GetConnection();
            //Statement stmt=con.createStatement();
            String cmd="select *from  orders where cus_id=? and ord_status=?";
            PreparedStatement stmt= con.prepareStatement(cmd);
            String str="PENDING";
            stmt.setInt(1,cus_id); 
            stmt.setString(2, str);
            
            ResultSet rs=stmt.executeQuery();
                
            while(rs.next()) { 

            order=new Orders();
            order.Set_ord_id(rs.getInt("ord_id"));
            order.Set_cus_id(rs.getInt("cus_id"));
            order.Set_Ven_id(rs.getInt("ven_id"));
            order.Set_menu_id(rs.getInt("menu_id"));
            order.Set_Date(rs.getDate("ord_date"));
            order.Set_ord_qty(rs.getInt("ord_qty"));
            order.Set_bill_amount(rs.getDouble("ord_billamount"));
            order.Set_ord_status(OrdStatus.valueOf(rs.getString("ord_status")));
            order.Set_ord_comment(rs.getString("ord_comments"));
            orderlist.add(order);


                  } 
          
            
          return  orderlist.toArray(new Orders[orderlist.size()]);
        }
          public static Orders[] SearchDb_ven(int ven_id) throws SQLException,Exception{
        Orders  order=null;
        List<Orders> orderlist=new ArrayList<Orders>();
          Connection con=ConnectionHelper.GetConnection();
            //Statement stmt=con.createStatement();
            String cmd="select *from  orders where ven_id=?";
            PreparedStatement stmt= con.prepareStatement(cmd);
            String str="PENDING";
            stmt.setInt(1,ven_id); 
            //stmt.setString(2, str);
            
            ResultSet rs=stmt.executeQuery();
                
            while(rs.next()) { 

            order=new Orders();
            order.Set_ord_id(rs.getInt("ord_id"));
            order.Set_cus_id(rs.getInt("cus_id"));
            order.Set_Ven_id(rs.getInt("ven_id"));
            order.Set_menu_id(rs.getInt("menu_id"));
            order.Set_Date(rs.getDate("ord_date"));
            order.Set_ord_qty(rs.getInt("ord_qty"));
            order.Set_bill_amount(rs.getDouble("ord_billamount"));
            order.Set_ord_status(OrdStatus.valueOf(rs.getString("ord_status")));
            order.Set_ord_comment(rs.getString("ord_comments"));
            orderlist.add(order);


                  } 
          
            
          return  orderlist.toArray(new Orders[orderlist.size()]);
    }

    public static Orders[] Advance_SearchDb_ven(int ven_id) throws SQLException, Exception {
        Orders  order=null;
        List<Orders> orderlist=new ArrayList<Orders>();
          Connection con=ConnectionHelper.GetConnection();
            //Statement stmt=con.createStatement();
            String cmd="select *from  orders where ven_id=? and ord_status=? ";
            PreparedStatement stmt= con.prepareStatement(cmd);
            String str="PENDING";
            stmt.setInt(1,ven_id); 
            stmt.setString(2, str);
            
            ResultSet rs=stmt.executeQuery();
                
            while(rs.next()) { 

            order=new Orders();
            order.Set_ord_id(rs.getInt("ord_id"));
            order.Set_cus_id(rs.getInt("cus_id"));
            order.Set_Ven_id(rs.getInt("ven_id"));
            order.Set_menu_id(rs.getInt("menu_id"));
            order.Set_Date(rs.getDate("ord_date"));
            order.Set_ord_qty(rs.getInt("ord_qty"));
            order.Set_bill_amount(rs.getDouble("ord_billamount"));
            order.Set_ord_status(OrdStatus.valueOf(rs.getString("ord_status")));
            order.Set_ord_comment(rs.getString("ord_comments"));
            orderlist.add(order);


                  } 
            
          return  orderlist.toArray(new Orders[orderlist.size()]);
    }



       
}