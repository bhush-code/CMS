package com.Hexaware.CMS.Factory;

import com.Hexaware.CMS.Model.Menu;
import com.Hexaware.CMS.Persistence.MenuDb;

public class MenuFactory
{
     public static Menu  searchMenu(int mid) throws Exception
    {
        MenuDb db=new MenuDb();
        return db.SearchDb(mid);

    }
}