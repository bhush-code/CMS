package com.Hexaware.CMS.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    public static Connection GetConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection con=DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/CMS61999","root","Password123"); 
        return con;
    }
}