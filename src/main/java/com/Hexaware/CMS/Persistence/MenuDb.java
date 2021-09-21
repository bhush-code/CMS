package com.Hexaware.CMS.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Hexaware.CMS.Model.Menu;

import java.sql.PreparedStatement;


public class MenuDb
{

public static Menu SearchDb(int menu_id) throws SQLException,Exception{
        Menu  menu=null;
        //try{  
           // Class.forName("com.mysql.cj.jdbc.Driver");  
         //  Connection con=DriverManager.getConnection(  
            //"jdbc:mysql://localhost:3306/CMS61999","root","Password123");
            //Statement stmt=con.createStatement();
            Connection con=ConnectionHelper.GetConnection();
            String cmd="select *from menu where mid=?";
            PreparedStatement stmt= con.prepareStatement(cmd);
            stmt.setInt(1,menu_id);  
            
            ResultSet rs=stmt.executeQuery();
                
            if(rs.next()) { 

                 menu=new Menu();
                  menu.setFoodId(rs.getInt("mid"));
                  menu.setFoodName(rs.getString("MenuName"));
                  menu.setFoodPrice(rs.getDouble("Menuprice"));
                  menu.Set_Rating(rs.getInt("Rating"));  

                  } 
      //  }catch(Exception e){ System.out.println(e);}  
            
        return  menu;
        }
}        