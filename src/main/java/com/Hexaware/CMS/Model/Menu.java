package com.Hexaware.CMS.Model;

/**
 * food class used to display food information.
 * @author hexware
 */
public class Menu {
    private int foodId;
    private String foodName;
    private Double foodPrice;
    private int Rating;

    public Menu(){}

    public Menu(int foodId,String foodName, Double foodPrice, int Rating){
        this.foodId=foodId;
        this.foodName=foodName;
        this.foodPrice=foodPrice;
        this.Rating=Rating;

    }
    public void setFoodId(int foodId){
        this.foodId=foodId;
    }

    public int getFoodId(){
        return foodId;
    }

    public void setFoodName(String foodName){
        this.foodName=foodName;
    }

    public String getFoodName(){
        return foodName;
    }

    public void setFoodPrice(Double foodPrice){
        this.foodPrice=foodPrice;
    }

    public Double getFoodPrice(){
        return foodPrice;
    }
    public int Get_rating()
    {
        return Rating;
    }
    public void Set_Rating(int Rating)
    {
        this.Rating=Rating;
    }
    public String toString(){
        return String.format("%9s %15s %20s %20s",foodId,foodName, foodPrice, Rating);
    }
}
