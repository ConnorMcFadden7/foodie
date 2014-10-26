package com.connormcfadden.foodie.data.model;

import java.util.List;

public class Recipe {

    //todo ingredients should probs be list of grocery
    public String name;
    public int cooking_time;
    public List<String> ingredients;
    public String photo;

    public Recipe(){

    }

    public Recipe(String name, int cooking_time, List<String> ingredients, String photo){
        this.name = name;
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

    public int getCookingTime() {
        return cooking_time;
    }

    public void setCookingTime(int cooking_time) {
        this.cooking_time = cooking_time;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
