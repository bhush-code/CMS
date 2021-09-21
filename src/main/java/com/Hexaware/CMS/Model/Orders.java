package com.Hexaware.CMS.Model;

import java.util.Date;


public class Orders{

 private int ord_id;
 private int cus_id;
 private int ven_id;
 private int menu_id;
 private  Date date;
 private int ord_qty;
 private Double billamount;
 private OrdStatus ord_status;
 private String ord_comments;

 public void Set_ord_id(int ord_id)
 {
     this.ord_id=ord_id;


 }
 public int Get_ord_id()
 {
     return ord_id;
 }
 public void Set_cus_id(int cus_id)
 {
     this.cus_id=cus_id;
 }
 public int Get_cus_id()
 {
     return cus_id;
 }
 public void Set_Ven_id(int ven_id)
 {

    this.ven_id=ven_id;
 }

 public int Get_ven_id()
 {
     return ven_id;
 }
 public void Set_ven_id(int menu_id)
 {
     this.menu_id=menu_id;
 }
 public void Set_menu_id(int menu_id)
 {
     this.menu_id=menu_id;
 }

 public int Get_menu_id()
 {
     return menu_id;

 }

 public void Set_Date(Date date)
 {
     this.date=date;
 }
 public Date Get_Date()
 {
     return date;
 }

 public void Set_ord_qty(int ord_qty)
 {
     this.ord_qty=ord_qty;
 }

 public int Get_ord_qty()
 {
     return ord_qty;

 }
public void Set_bill_amount(Double billamount)
{
    this.billamount=billamount;
}
public Double Get_bill_amount()
{
    return billamount;
}

public void Set_ord_status(OrdStatus ord_status)

{
    this.ord_status=ord_status;
}

public OrdStatus Get_ord_status()
{
    return ord_status;
}

public void Set_ord_comment(String ord_comments)
{
    this.ord_comments=ord_comments;
}

public String Get_ord_comments()
{
    return ord_comments;
}


public Orders()
{

}
public  Orders(int ord_id, int cus_id, int ven_id, int menu_id, Date date, int ord_qty, Double billamount, OrdStatus ord_status, String ord_comments)
{

    this.ord_id=ord_id;
    this.cus_id=cus_id;
    this.ven_id=ven_id;
    this.menu_id=menu_id;
    this.date=date;
    this.ord_qty=ord_qty;
    this.billamount=billamount;
    this.ord_status=ord_status;
    this.ord_comments=ord_comments;
} 

@Override
public String toString()
{
    return String.format("%5s %12s %12s %12s %18s %15s %13s %15s %15s ",ord_id,cus_id,ven_id,menu_id,date, ord_qty,billamount,ord_status,ord_comments);

}




 

}