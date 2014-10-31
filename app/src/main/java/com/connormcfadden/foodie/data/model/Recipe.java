package com.connormcfadden.foodie.data.model;

import java.util.List;

public class Recipe {

    //todo ingredients should probs be list of grocery
    public String name;
    public String preparation_time;
    public String cooking_time;
    public String ingredients;
    public String photo;

    public Recipe(){

    }

    public Recipe(String name, String preparation_time, String cooking_time, String ingredients, String photo){
        this.name = name;
        this.preparation_time = preparation_time;
        this.cooking_time = cooking_time;
        this.ingredients = ingredients;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreparationTime() { return preparation_time; }

    public void setPreparationTime(String preparation) { this.preparation_time = preparation; }

    public String getCookingTime() {
        return cooking_time;
    }

    public void setCookingTime(String cooking_time) {
        this.cooking_time = cooking_time;
    }

    //todo probs wont work cause it'll get entire list
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
