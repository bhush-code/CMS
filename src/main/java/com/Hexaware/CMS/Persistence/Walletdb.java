package com.Hexaware.CMS.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import java.util.ArrayList;

import com.Hexaware.CMS.Model.Wallet;
import com.Hexaware.CMS.Model.WalSource;
import java.sql.PreparedStatement;


public class Walletdb{
    static int i;

  public static Wallet[] fetchDb()throws Exception{
        Wallet w[]=null;
            Connection con=ConnectionHelper.GetConnection();
            Statement stmt=con.createStatement();  
                    
            ResultSet rs=stmt.executeQuery("select * from wallet");  
            ArrayList<Wallet> list=new ArrayList<Wallet>();          
            while(rs.next()) { 
            list.add(new  Wallet(rs.getInt(1),rs.getInt(2),rs.getDouble(3),WalSource.valueOf(rs.getString(4))));
                w=new Wallet[list.size()];
                w= list.toArray(w);
                  } 
       
            
        return w;      
        }

         public static Wallet SearchDb(int wal_id) throws  Exception{
        Wallet  wallet=null;
            Connection con=ConnectionHelper.GetConnection();
            //Statement stmt=con.createStatement();
            String cmd="select *from wallet where wal_id=?";
            PreparedStatement stmt= con.prepareStatement(cmd);
            stmt.setInt(1,wal_id);  
            
            ResultSet rs=stmt.executeQuery();
                
            if(rs.next()) { 

                 wallet=new Wallet();
                 wallet.Set_cus_id(rs.getInt("cus_id"));
                 wallet.Set_wal_id(rs.getInt("wal_id"));
                 wallet.Set_wal_amount(rs.getDouble("wal_amount"));
                 wallet.Set_wal_source(WalSource.valueOf(rs.getString("walsource")));
                 //System.out.println(wallet.Get_wal_source());
                 


                  } 
      
            
        return  wallet;
        }

        public static int insertDb(int cus_id, int wal_id, Double wal_amount, WalSource wal_source) throws Exception{        
            Connection con=ConnectionHelper.GetConnection();
            PreparedStatement stmt=con.prepareStatement("insert into Vendor  values(?,?,?,?)");  
        stmt.setInt(1,cus_id);  
        stmt.setInt(2,wal_id);  
        stmt.setDouble(3,wal_amount);
        stmt.setString(4,wal_source.toString());
           
        i=stmt.executeUpdate();  
        //System.out.println(i+" records inserted");  

                return i;
            }  

            public static Wallet SearchDb_Wal_Source(int wal_id,String wal_source) throws Exception{
                Wallet  wallet=null;
                Connection con=ConnectionHelper.GetConnection();
                //Statement stmt=con.createStatement();
                String cmd="select *from wallet where cus_id=? and walsource=?";
                PreparedStatement stmt= con.prepareStatement(cmd);
                stmt.setInt(1,wal_id); 
                stmt.setString(2,WalSource.valueOf(wal_source).toString()); 
            
                 ResultSet rs=stmt.executeQuery();
                
                if(rs.next()) { 

                     wallet=new Wallet();
                     wallet.Set_cus_id(rs.getInt("cus_id"));
                     wallet.Set_wal_id(rs.getInt("wal_id"));
                     wallet.Set_wal_amount(rs.getDouble("wal_amount"));
                     wallet.Set_wal_source(WalSource.valueOf(rs.getString("walsource")));
                 
                 


                  } 
     
            
        return  wallet;
        }


        public static Wallet SearchDb_cus_id(int cus_id) throws Exception{
        Wallet  wallet=null;
            Connection con=ConnectionHelper.GetConnection();
            //Statement stmt=con.createStatement();
            String cmd="select *from wallet where cus_id=?";
            PreparedStatement stmt= con.prepareStatement(cmd);
            stmt.setInt(1,cus_id);  
            
            ResultSet rs=stmt.executeQuery();
                
            if(rs.next()) { 

                 wallet=new Wallet();
                 wallet.Set_cus_id(rs.getInt("cus_id"));
                 wallet.Set_wal_id(rs.getInt("wal_id"));
                 wallet.Set_wal_amount(rs.getDouble("wal_amount"));
                 wallet.Set_wal_source(WalSource.valueOf(rs.getString("walsource")));
                 //System.out.println(wallet.Get_wal_source());
                 
                 


                  } 
      
            
        return  wallet;
        }
        public static void Update_wallet(int cus_id,Double wal_amount) throws Exception
        {
              Wallet  wallet=null;
                Connection con=ConnectionHelper.GetConnection();
            //Statement stmt=con.createStatement();
            String cmd="update wallet set wal_amount=? where cus_id=?";
            PreparedStatement stmt= con.prepareStatement(cmd);
            stmt.setDouble(1,wal_amount);
            stmt.setInt(2,cus_id);

            stmt.executeUpdate();


    }
}

   