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
import com.Hexaware.CMS.Model.Wallet;
import com.Hexaware.CMS.Model.WalSource;
import com.Hexaware.CMS.Factory.WalletFactory;

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



      public static String accept_reject_order(int ord_id,int cus_id,int ven_id, String Status) throws Exception

      {
        Connection con=ConnectionHelper.GetConnection();

        if(Status.toUpperCase().equals("YES"))
        {
          Wallet wallet=new Wallet();
          String cmd="update orders set ord_status='ACCEPTED' where ord_id=?";
          PreparedStatement pst=con.prepareStatement(cmd);
          pst.setInt(1,ord_id);
          pst.executeUpdate();
          Orders order=Search_by_ord_id(ord_id);
           Double Bills=order.Get_bill_amount();
          
          wallet=Walletdb.SearchDb_cus_id(cus_id);
           Double wal_amount=wallet.Get_wal_amount();
          wal_amount=wal_amount-Bills;
          Walletdb.Update_wallet(cus_id,wal_amount);

          String setSubject="Order: Accepted  Ammmmmulyyyyyyyyyaaaa";
          String Email="amulya.hc99@gmail.com";
          String Content="Your Order is accepted Successfullyyyyyy----------";
          SendEmailTLS.Sendmail(Email,setSubject,Content);

        return "Order Accepted Successfully";

        }
        else
        {
              String cmd="update orders set ord_status='REJECTED' where ord_id=?";
              PreparedStatement pst=con.prepareStatement(cmd);
              pst.setInt(1,ord_id);
              pst.executeUpdate();

              // Wallet Amount Should be Updated!!

              Orders order=Search_by_ord_id(ord_id);
              Wallet wallet=new Wallet();
               cus_id=order.Get_cus_id();
             wallet=Walletdb.SearchDb_cus_id(cus_id);
             //String wal_source=OrdStatus.valueOf(order.Get_ord_()).toString();
              WalSource wal_source=wallet.Get_wal_source();
              Double ord_billamount=order.Get_bill_amount();

              cmd="update wallet set wal_amount=wal_amount+? where cus_id=? and walsource=?";
              pst=con.prepareStatement(cmd);
              pst.setDouble(1,ord_billamount);
              pst.setInt(2,cus_id);
              pst.setString(3,wal_source.toString());
              pst.executeUpdate();


              return "Order Rejected Amount Refunded";

              
        }
    


        
      }



      public static Orders Search_by_ord_id(int ord_id) throws Exception

      {
        
            Orders order=null;
            Connection con=ConnectionHelper.GetConnection();
           String cmd="select *from  orders where ord_id=?";
            PreparedStatement stmt= con.prepareStatement(cmd);
          
            stmt.setInt(1,ord_id); 
           // stmt.setString(2, str);
            
            ResultSet rs=stmt.executeQuery();
                
            if(rs.next()) { 

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
           // orderlist.add(order);
                  } 

             return order;     

          
            
          
      }

      



       
}