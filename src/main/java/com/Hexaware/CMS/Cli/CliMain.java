package com.Hexaware.CMS.Cli;

import java.util.Scanner;
import java.util.Date;


import com.Hexaware.CMS.Factory.OrderFactory;
import com.Hexaware.CMS.Factory.CustomerFactory;
import com.Hexaware.CMS.Model.Menu;
import com.Hexaware.CMS.Model.Customer;
import com.Hexaware.CMS.Model.Vendor;
import com.Hexaware.CMS.Factory.VendorFactory;
import com.Hexaware.CMS.Factory.MenuFactory;
import com.Hexaware.CMS.Factory.WalletFactory;
import com.Hexaware.CMS.Model.Wallet;
import com.Hexaware.CMS.Model.Orders;
import com.Hexaware.CMS.Model.OrdStatus;
import com.Hexaware.CMS.Factory.OrdersFactory;
/**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
public class CliMain {
    
    static Scanner sc=new Scanner(System.in);
/**
 * main method  used to display the option we had in the application.
 */
    public static void main( String[] args )
    {   
        int choice;
        do{   
        System.out.println( "Canteen Management System" ); 
        System.out.println("--------------------------------------");     
        System.out.println("Enter your choice....");
        System.out.println("1.Show Menu");
        System.out.println("2.Placing Order");
        System.out.println("3.Show Customer");
        System.out.println("4.Enter Customer Details");
        System.out.println("5.Search Customer");
        System.out.println("6.Show Vendors");
        System.out.println("7.search Vendors");
        System.out.println("8.Search Menu");
        System.out.println("9.Show Wallet");
        System.out.println("10.Search Wallet");
        System.out.println("11.Show Orders");
        System.out.println("12.Search orders");
        System.out.println("13.Accept or Reject Order");
        System.out.println("14.exit");
        choice=sc.nextInt();
        switch(choice){
            case 1:
                    try{
                        menuList();
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }   

                break;
            case 2:
                try
                {
                placeOrder();
                }catch(Exception e)
                {
                    e.printStackTrace();
                }    
                break;
            case 3:
            try{
                CustomerList();
            }catch(Exception e)
            {
                e.printStackTrace();
            } 
                 break;
            case 4: try{
            
                    AddCustomer();
                      } catch(Exception e)
                      {
                          e.printStackTrace();
                      }  
                 break;

            case 5:try
                {
                    Searchcustomer();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                break;     

            case 6: try{
                        vendorlist();
                    }catch(Exception e)
                    {
                        e.printStackTrace();
                    }   
                  break;
            case 7:
                    try{
                    Searchvendor();
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                break;    

            case 8: try{
                        SearchMenu();
                       }
                       catch(Exception e)
                       {
                           e.printStackTrace();
                       }

                break;
            case 9: try{
                    walletlist();
                    }catch(Exception e) {e.printStackTrace();}
                break;

            case 10: 
                    int ch;
                    do{
                      System.out.println("1.Search wallet by cus_id");
                      System.out.println("2.Search wallet by wal_id");
                      System.out.println("3.Search wallet by wal_source and cus_id");
                      System.out.println("4.Exit");
                      System.out.println("Enter your Choice");
                      ch=sc.nextInt();
                      switch(ch)
                      {
                          case 1: 
                                    try{
                                        SearchWallet_cus_id();
                                    }catch(Exception e)
                                    {
                                        e.printStackTrace();
                                    } 
                                break;
                          case 2:   try{
                                        Searchwallet();
                          } catch(Exception e)
                                     {
                                         e.printStackTrace();
                                     }   
                                    break;
                          case 3:      try{
                                         searchWallet_Wal_Source();
                                         }catch(Exception e){e.printStackTrace();} 
                                    break;
                          case 4: break;                         
                      }

                    }while(ch!=4);
                break;

            case 11:
                    try{
                     Showorders();
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                break;


            case 12: 
                int ch1;
                do
                {
                    
                    System.out.println("1.Search by Cus_id");
                    System.out.println("2.Search by Cus_id Pending Orders");
                    System.out.println("3.Search by Ven_id");
                    System.out.println("4.Search by ven_id Pending orders");
                    System.out.println("5.exit");
                    System.out.println("Enter your choice");
                    ch1=sc.nextInt();
                    switch(ch1)
                    {
                        case 1: try{
                                Searchorders();
                                
                                }catch(Exception e)
                                {
                                    e.printStackTrace();
                                }
                                break;
                        case 2: try{
                                advance_cus_search();
                                 }
                                catch(Exception e)
                                {
                                    e.printStackTrace();
                                }
                                break;
                                
                                
                            
                        case 3:try{
                                search_order_by_ven();
                                }
                                catch(Exception e)
                                {
                                    e.printStackTrace();
                                }
                                break;

                        case 4:     try
                                {
                                    advance_search_order_by_ven();
                                }catch(Exception e)
                                {
                                    e.printStackTrace();
                                }   
                                break;
                        case 5:  break;           
                    }
                }while(ch1!=5);
                break;


            case 13: 
                        try{
                        Accept_Reject_Order();
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                        break;
            case 14: Runtime.getRuntime().halt(0);
                
            default:
                System.out.println("Invalid Options......");
        }
        }while(choice!=14); 
    }
    /**
     * this method  is to place food order.
     */
        public static void placeOrder() throws Exception{
        Orders order=new Orders();
        //System.out.println("Enter the Food id");
        //order.Set_ord_id(sc.nextInt());
        System.out.println("Enter the Customer id");
        int cus_id=sc.nextInt();
        System.out.println("Enter wal Source");
        String wal_source=sc.next();
        System.out.println("Enter the vendor id");
        int ven_id=sc.nextInt();
        System.out.println(" Enter Menu_id");
        int menu_id=sc.nextInt();        
        Wallet wallet=WalletFactory.SearchWalllet_Wal_Source(cus_id, wal_source);
        Menu menu=MenuFactory.searchMenu(menu_id);
        Vendor vendor=VendorFactory.SearchVendor(ven_id);
        Customer cust=CustomerFactory.SearchCustomer(cus_id);
        if (wallet==null)
        {
            System.out.println("customer id and Wal Source not matching.. Please Enter  Correct Details.......");
            return;
        }
        if(vendor==null)
        {
            System.out.println("Vendor id not found .... Please verify the vendor details from Vendor Records");
            return ;
        }
        if(cust==null)
        {
            System.out.println("Customer id not found........Please, verify the  Customer details from Customer Records...");
            return;
        }
    else{
          order.Set_menu_id(menu_id);     
          order.Set_cus_id(cus_id);
          order.Set_Ven_id(ven_id);
        //System.out.println("Enter ord_date");
        //order.Set_Date(sc.next());

            
             System.out.println("Enter Order Quantity");
             order.Set_ord_qty(sc.nextInt());

            // System.out.println("Enter food price");
            // Double foodPrice=sc.nextDouble();
            // int qty1=order.Get_ord_qty();
             
             System.out.println("Enter order_status");
             String ord_status = sc.next();
            if (ord_status.toUpperCase().equals("ACCEPTED")) {
                 order.Set_ord_status(OrdStatus.ACCEPTED);
                 }
            if (ord_status.toUpperCase().equals("DENIED")) {
                order.Set_ord_status(OrdStatus.DENIED);
               }
            if(ord_status.toUpperCase().equals("PENDING")) {
                order.Set_ord_status(OrdStatus.PENDING);
              }
            if (ord_status.toUpperCase().equals("CANCELLED")) {
                order.Set_ord_status(OrdStatus.CANCELLED);
             }

        System.out.println("Enter order Comment");
        order.Set_ord_comment(sc.next());

        //Add other attributes to complete the functionality
        OrderFactory.OrderFood(order);
    }  
        //System.out.println(r+"   is inserted.....");
        }
/**
 * this method is to fetch Menu list.
 */
        public static void menuList() throws Exception{
        Menu m[]=OrderFactory.fetchMenu();
        System.out.println("                                   M E N U  R E C O R D S                               ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("  Food Id"+"    "+"  Food Name"+"    "+"       Food Price"+"                Rating"); 
        System.out.println("---------------------------------------------------------------------------------------");
        for(Menu m1:m)
        {
            System.out.println(m1);
        }
        System.out.println();
    }
     public static void CustomerList() throws Exception{
        Customer  c[]=CustomerFactory.fetchCustomer();
        //System.out.println("Food Id"+"    "+"Food Name"+"    "+"Food Price");
        System.out.println("                                                C U S T O M E R S    R E C O R D S                                                              ");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------"); 
        System.out.println("Cus_id"+ "     Name "+"        Mobile Number "+"      Username"+"       Password"+"     Email Id"+"                     DOB"+"              Address");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        for(Customer c1:c)
        {
            System.out.println(c1);
        }
    }
    public static void AddCustomer() throws Exception
    {   
        int cus_id;
        String Cus_name,ph_no, Cus_Username, Cus_Password,Cus_Email, Dob, Address;

        System.out.println("Add Customer Id");
        cus_id=sc.nextInt();
        System.out.println("Enter Customer Name");
        Cus_name=sc.next();
        System.out.println("Enter Customer Phone");
        ph_no=sc.next();
        System.out.println("Enter Customer Username");
        Cus_Username=sc.next();
        System.out.println("Enter Customer Password");
        Cus_Password=sc.next();
        System.out.println("Enter Customer Email");
        Cus_Email=sc.next();
        System.out.println("Enter Customer Dob");
        Dob=sc.next();
        System.out.println("Enter Customer Address");
        Address=sc.next();
        int r=CustomerFactory.Insertdb(cus_id,Cus_name,ph_no,Cus_Username,Cus_Password,Cus_Email,Dob, Address);
        System.out.println("Record Inserted Successfully................");

    }
    public static void Searchcustomer() throws Exception
    {
        Customer customer=new Customer();
        int cus_id;
        System.out.println("Enter Customer id to Search");
        cus_id=sc.nextInt();
        customer=CustomerFactory.SearchCustomer(cus_id);
        System.out.println("                                                C U S T O M E R S    R E C O R D S                                                              ");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Cus_id"+ "     Name "+"        Mobile Number "+"      Username"+"       Password"+"     Email Id"+"                     DOB"+"              Address");
         System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(customer);

    }
    public static void vendorlist() throws Exception
    {
        Vendor  v[]=VendorFactory.fetchCustomer();
        //System.out.println("Food Id"+"    "+"Food Name"+"    "+"Food Price"); 
        /*for(int i=0;i<v.length;i++){
            
              System.out.println(v[i].Get_ven_id()+"       "+v[i].Get_ven_name()+"       "+v[i].Get_ven_number()+"       "+v[i].Get_ven_username()+"     "+v[i].Get_Password()+"     "+v[i].Get_ven_email()+"       "+v[i].Get_ven_address());
           */
           System.out.println("                                                         V E N D O R S    R E C O R D S                                           ");
           System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
           System.out.println("     Ven_id"+"       Name"+ "        Mobile Numnber"+"       Username"+"     Passowrd"+"             Email"+"              Address");
           System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
           for (Vendor v1:v)
           {
               System.out.println(v1);
           }
           }
    
     public static void Searchvendor() throws Exception
    {
        Vendor  vendor=new Vendor();
        int ven_id;
        System.out.println("Enter vendor id to Search");
        ven_id=sc.nextInt();
        vendor=VendorFactory.SearchVendor(ven_id);
        System.out.println(vendor);


    }


    public static void SearchMenu() throws Exception
    {
        Menu menu=new Menu();
        int mid;

        System.out.println("Enter Menu id to search");
        mid=sc.nextInt();
        menu=MenuFactory.searchMenu(mid);
        System.out.println("                                   M E N U  R E C O R D S                               ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("  Food Id"+"    "+"  Food Name"+"    "+"       Food Price"+"                Rating"); 
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println(menu); 
     }
     public static void walletlist() throws Exception
     {
         Wallet  w[]=WalletFactory.fetchWallet();
        //System.out.println("Food Id"+"    "+"Food Name"+"    "+"Food Price"); 

        System.out.println("                    W A L L E T  R E C O R D S               ");
        System.out.println("-------------------------------------------------------------");
        System.out.println("  Cus_id"+"   Walllet _id"+"      Wal_amount"+"       Wal_source");
        System.out.println("-------------------------------------------------------------");
        for(Wallet w1:w)
        {
            System.out.println(w1);
        }
     }

      public static void Searchwallet() throws Exception
    {
        Wallet wallet=new Wallet();
        int wal_id;
        System.out.println("Enter Wallet id to search");
        wal_id=sc.nextInt();
        wallet=WalletFactory.SearchWallet(wal_id);
        System.out.println("-------------------------------------------------------------");
        System.out.println("  Cus_id"+"   Walllet _id"+"      Wal_amount"+"       Wal_source");
        System.out.println("-------------------------------------------------------------");
 
        System.out.println(wallet);

    }
    public static void SearchWallet_cus_id() throws Exception
    {
        Wallet wallet= new Wallet();
        int cus_id;
        System.out.println("Enter Customer id");
        cus_id=sc.nextInt();
        wallet=WalletFactory.SearchWallet_cus_id(cus_id);
        System.out.println("-------------------------------------------------------------");
        System.out.println("  Cus_id"+"   Walllet _id"+"      Wal_amount"+"       Wal_source");
        System.out.println("-------------------------------------------------------------");
 
        System.out.println(wallet);
    }
    public static void searchWallet_Wal_Source() throws Exception
    {
        Wallet wallet=new Wallet();
        wallet=null;
        int cus_id;
        String wal_source;
        System.out.println("Enter wallet id to Search ");
        cus_id=sc.nextInt();
        System.out.println("Enter Wallet Source");
        wal_source=sc.next();
 
        wallet=WalletFactory.SearchWalllet_Wal_Source(cus_id, wal_source);
        if(wallet!=null)
        {
          System.out.println("-------------------------------------------------------------");
          System.out.println("  Cus_id"+"   Walllet _id"+"      Wal_amount"+"       Wal_source");
          System.out.println("-------------------------------------------------------------");
            System.out.println(wallet);
        }
        else
        {
            System.out.println(" Customer or may be Walllet Source May be Wrong....");
        }
    }
    

    public static void Showorders() throws Exception
    {

        Orders [] order =OrdersFactory.fetchOrder();

        System.out.println("                                                                    O R D E R   R E C O R D S                                    ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" ord_id"+"         cus_id"+"     ven_id"+"       menu_id"+"        ord_date"+"             QTY"+"          Bill"+"         STATUS"+"         ORD_Comments");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(Orders o: order)
        {
            System.out.println(o);
        }


    }
    public static void Searchorders() throws Exception
    {
       
        Orders order=new Orders();
        int cus_id;
        System.out.println("Emter Customer id");
        cus_id=sc.nextInt();
         Orders [] orders =OrdersFactory.SearchOrder(cus_id);
      
        System.out.println("                                                                    O R D E R   R E C O R D S                                    ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" ord_id"+"         cus_id"+"     ven_id"+"       menu_id"+"        ord_date"+"             QTY"+"          Bill"+"         STATUS"+"         ORD_Comments");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");

       for (Orders o:orders)
       {
           System.out.println(o);
       }
    }

    public static void advance_cus_search() throws Exception
    {
        Orders order=new Orders();
        int cus_id;
        System.out.println("Emter Customer id");
        cus_id=sc.nextInt();
         Orders [] orders =OrdersFactory.Advance_cus_search(cus_id);

        System.out.println("                                                                    O R D E R   R E C O R D S                                    ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" ord_id"+"         cus_id"+"     ven_id"+"       menu_id"+"        ord_date"+"             QTY"+"          Bill"+"         STATUS"+"         ORD_Comments");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");

       for (Orders o:orders)
       {
           System.out.println(o);
       }
        
    }
    public static void search_order_by_ven() throws Exception
    {
        Orders order=new Orders();
        int ven_id;
        System.out.println("Emter Vendor id");
        ven_id=sc.nextInt();
         Orders [] orders =OrdersFactory.SearchOrder_ven(ven_id);
        System.out.println("                                                                    O R D E R   R E C O R D S                                    ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" ord_id"+"         cus_id"+"     ven_id"+"       menu_id"+"        ord_date"+"             QTY"+"          Bill"+"         STATUS"+"         ORD_Comments");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");


       for (Orders o:orders)
       {
           System.out.println(o);
       }
    }
    public static void advance_search_order_by_ven() throws Exception
    {
        Orders order=new Orders();
        int ven_id;
        System.out.println("Emter Vendor id");
        ven_id=sc.nextInt();
         Orders [] orders =OrdersFactory. advanceSearchOrder_ven(ven_id);

        System.out.println("                                                                    O R D E R   R E C O R D S                                    ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" ord_id"+"         cus_id"+"     ven_id"+"       menu_id"+"        ord_date"+"             QTY"+"          Bill"+"         STATUS"+"         ORD_Comments");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");

       for (Orders o:orders)
       {
           System.out.println(o);
       }
    }

    public static void Accept_Reject_Order() throws Exception
    {
        System.out.println("Enter ord_id");
        int ord_id=sc.nextInt();
        System.out.println("Enter Customer id");
        int cus_id=sc.nextInt();
        System.out.println("Enter Vendor id");

        int ven_id=sc.nextInt();
        System.out.println("Enter Status");
        String Status=sc.next();
      String Status1=OrdersFactory.Accept_reject_order(ord_id,ven_id,cus_id,Status);
      System.out.println(Status1);

    }
}  

/**
 * this method is to acceptRejectOrder.
 */
// public static String acceptRejectOrder(){}

 /**
 * this method is for customerProfile.
 */
// public static Customer customerProfile(){}

/**
 * this method is for VendorProfile.
 */
// public static Vendor vendorProfile(){}

/**
 * this method is for VendorOderHistory.
 */
// public static Vendor[] VendorOderHistory(){}

/**
 * this method is for CustomerOrderHistory.
 */
// public static Customer[] CustomerOrderHistory(){}


