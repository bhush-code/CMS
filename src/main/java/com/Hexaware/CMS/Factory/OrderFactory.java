package com.Hexaware.CMS.Factory;

import com.Hexaware.CMS.Model.Menu;
import com.Hexaware.CMS.Model.Wallet;
import com.Hexaware.CMS.Model.WalSource;
import com.Hexaware.CMS.Persistence.Walletdb;
import com.Hexaware.CMS.Factory.WalletFactory;
import com.Hexaware.CMS.Factory.MenuFactory;
import com.Hexaware.CMS.Persistence.PlaceOrder;
import com.Hexaware.CMS.Model.OrdStatus;
import com.Hexaware.CMS.Model.Orders;

/**
 * OrderFactory class used to fetch and insert data to database.
 * @author hexware
 */
public class OrderFactory {
    
    public static void OrderFood(Orders order) throws Exception {
        int menu_id=order.Get_menu_id();

        Menu menu=MenuFactory.searchMenu(menu_id);

        Double menu_price=menu.getFoodPrice();
        Double bill;
        bill=menu_price*order.Get_ord_qty();
        int cus_id=order.Get_cus_id();
        

        //bill=order.Get_bill_amount();
        Wallet wallet=WalletFactory.SearchWallet_cus_id(cus_id);
        Double wal_amount=wallet.Get_wal_amount();
        if(bill<=wal_amount)
        {
            wal_amount=wal_amount-bill;
            order.Set_bill_amount(bill);
            PlaceOrder.insertDb(order);
            //WalletFactory.Update_Wallet(cus_id,wal_amount);
             
        }
        else
        {
            System.out.println("Insufficient Fund");
        }
       //return result;
    }

    public static Menu[] fetchMenu()throws Exception{
        Menu menu[]=PlaceOrder.fetchDb();
        return menu;
    }

    // public static Customer customerProfile(){}
    // public static Vendor vendorProfile(){}
    // public static Order[] customerOrderHistory(){}
    // public static Order[] vendorOrderHistory(){}
    // public static String acceptRejectOrder(){}
}
