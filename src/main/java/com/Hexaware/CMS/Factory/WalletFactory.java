package com.Hexaware.CMS.Factory;

import com.Hexaware.CMS.Persistence.Walletdb;

import com.Hexaware.CMS.Model.Wallet;
import com.Hexaware.CMS.Model.WalSource;


public class WalletFactory
{
     public static int Insertdb(int cus_id,int wal_id,Double wal_amount, WalSource wal_source) throws Exception{
    
       int result= Walletdb.insertDb(cus_id, wal_id, wal_amount, wal_source);
       return result;
    }

    public static Wallet[] fetchWallet() throws Exception{
        Wallet wallet[]=Walletdb.fetchDb();
        return wallet;
    }
    public static Wallet  SearchWallet(int wal_id) throws Exception
    {
        Walletdb db=new Walletdb();
        return db.SearchDb(wal_id);


    }

    public static Wallet SearchWalllet_Wal_Source(int cus_id, String wal_source) throws Exception
    {
        Walletdb db=new Walletdb();
        
            return db.SearchDb_Wal_Source(cus_id, wal_source);
             
    }
    public static Wallet  SearchWallet_cus_id(int cus_id) throws Exception
    {
        Walletdb db=new Walletdb();
        return db.SearchDb_cus_id(cus_id);


    }

    public static void Update_Wallet(int cus_id,Double wal_amount) throws Exception
    {
        Walletdb.Update_wallet(cus_id,wal_amount);
        
    }
}