package com.Hexaware.CMS.Factory;

import com.Hexaware.CMS.Model.Orders;

import com.Hexaware.CMS.Persistence.OrdersDb;

public class OrdersFactory
{
     public static Orders[] fetchOrder() throws Exception{
        Orders order[]=OrdersDb.showOrders();
        return order;
    }
    public static Orders[] SearchOrder(int cus_id) throws Exception
    {
       Orders order[]=OrdersDb. SearchDb(cus_id);
        return order;


    }
    public static Orders [] Advance_cus_search(int cus_id) throws Exception
    {


        //OrdersDb db=new OrdersDb();

        Orders order[]=OrdersDb.Advance_cus_SearchDb(cus_id);
        return order;
    }

    // by Ven_id


     public static Orders[] SearchOrder_ven(int ven_id) throws Exception
    {
       Orders order[]=OrdersDb. SearchDb_ven(ven_id);
        return order;


    }
    
    public static Orders[] advanceSearchOrder_ven(int ven_id) throws Exception
    {
       Orders order[]=OrdersDb.Advance_SearchDb_ven(ven_id);
        return order;


    }
}