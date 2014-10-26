package com.connormcfadden.foodie.data.model;

public class Grocery {

    public String item;
    public int estimated_price;
    public String food_type;

    public Grocery(){

    }

    public Grocery(String item, int estimated_price, String food_type){
        this.item = item;
        this.estimated_price = estimated_price;
        this.food_type = food_type;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getEstimatedPrice() {
        return estimated_price;
    }

    public void setEstimatedPrice(int estimated_price) {
        this.estimated_price = estimated_price;
    }

    public String getFoodType() {
        return food_type;
    }

    public void setFoodType(String food_type) {
        this.food_type = food_type;
    }

}
