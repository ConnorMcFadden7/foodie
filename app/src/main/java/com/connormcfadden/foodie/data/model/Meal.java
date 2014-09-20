package com.connormcfadden.foodie.data.model;

public class Meal {

    public String name;
    public int date;
    public String ingredients;
    public String photo;

    public Meal(){

    }

    public Meal(String name, int date, String ingredients, String photo){
        this.name = name;
        this.date = date;
        this.ingredients = ingredients;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
