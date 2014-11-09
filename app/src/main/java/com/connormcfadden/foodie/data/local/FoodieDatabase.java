package com.connormcfadden.foodie.data.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.connormcfadden.foodie.data.model.Grocery;
import com.connormcfadden.foodie.data.model.Meal;
import com.connormcfadden.foodie.data.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class FoodieDatabase extends SQLiteOpenHelper {

    //todo should most likely split up this class or else will be huge
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "foodie";

    private static final String TABLE_MEAL = "meal";
    private static final String TABLE_RECIPE = "recipe";
    private static final String TABLE_GROCERY = "grocery";

    //Meal Vars
    private static final String KEY_MEAL_NAME = "name";
    private static final String KEY_MEAL_DATE = "date";
    private static final String KEY_MEAL_INGREDIENTS = "ingredients";
    private static final String KEY_MEAL_PHOTO = "photo";

    //Recipe Vars
    private static final String KEY_RECIPE_NAME = "name";
    private static final String KEY_RECIPE_PREPARATION_TIME = "preparation";
    private static final String KEY_RECIPE_COOKING_TIME = "cooking_time";
    private static final String KEY_RECIPE_INGREDIENTS = "ingredients";
    private static final String KEY_RECIPE_PHOTO = "photo";

    //Grocery Vars
    private static final String KEY_GROCERY_ITEM = "name";
    private static final String KEY_GROCERY_ESTIMATED_PRICE = "date";
    private static final String KEY_GROCERY_FOOD_TYPE = "ingredients";

    public FoodieDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MEALS_TABLE = "CREATE TABLE " + TABLE_MEAL + "(" + KEY_MEAL_NAME + " TEXT,"
                + KEY_MEAL_DATE + " TEXT," + KEY_MEAL_INGREDIENTS + " TEXT," + KEY_MEAL_PHOTO + " TEXT" + ")";
        String CREATE_RECIPE_TABLE = "CREATE TABLE " + TABLE_RECIPE + "(" + KEY_RECIPE_NAME + " TEXT," + KEY_RECIPE_PREPARATION_TIME
                + " TEXT," + KEY_RECIPE_COOKING_TIME + " TEXT," + KEY_RECIPE_INGREDIENTS + " TEXT," + KEY_RECIPE_PHOTO + " TEXT" + ")";
        String CREATE_GROCERY_TABLE = "CREATE TABLE " + TABLE_GROCERY + "(" + KEY_GROCERY_ITEM + " TEXT,"
                + KEY_GROCERY_ESTIMATED_PRICE + " TEXT," + KEY_GROCERY_FOOD_TYPE + " TEXT" + ")";
        db.execSQL(CREATE_MEALS_TABLE);
        db.execSQL(CREATE_RECIPE_TABLE);
        db.execSQL(CREATE_GROCERY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEAL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GROCERY);
        onCreate(db);
    }

    public void addMeal(Meal meal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MEAL_NAME, meal.getName());
        values.put(KEY_MEAL_DATE, meal.getDate());
        values.put(KEY_MEAL_INGREDIENTS, meal.getIngredients());
        values.put(KEY_MEAL_PHOTO, meal.getPhoto());
        db.insert(TABLE_MEAL, null, values);
        db.close();
    }

    public void addRecipe(Recipe recipe) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_RECIPE_NAME, recipe.getName());
        values.put(KEY_RECIPE_PREPARATION_TIME, recipe.getPreparationTime());
        values.put(KEY_RECIPE_COOKING_TIME, recipe.getCookingTime());
        values.put(KEY_RECIPE_INGREDIENTS, recipe.getIngredients());
        values.put(KEY_RECIPE_PHOTO, recipe.getPhoto());
        db.insert(TABLE_RECIPE, null, values);
        db.close();
    }

    public void addGrocery(Grocery grocery) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_GROCERY_ITEM, grocery.getItem());
        values.put(KEY_GROCERY_ESTIMATED_PRICE, grocery.getEstimatedPrice());
        values.put(KEY_GROCERY_FOOD_TYPE, grocery.getFoodType());
        db.insert(TABLE_GROCERY, null, values);
        db.close();
    }

    public List<Meal> getAllMeals() {
        List<Meal> mealList = new ArrayList<Meal>();
        String selectQuery = "SELECT  * FROM " + TABLE_MEAL, ASC;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Meal meal = new Meal();
                meal.setName(cursor.getString(0));
                meal.setDate(cursor.getInt(1));
                meal.setIngredients(cursor.getString(2));
                meal.setPhoto(cursor.getString(3));
                mealList.add(meal);
            } while (cursor.moveToNext());
        }
        return mealList;
    }

    public List<Recipe> getAllRecipes() {
        List<Recipe> recipeList = new ArrayList<Recipe>();
        String selectQuery = "SELECT  * FROM " + TABLE_RECIPE, ASC;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Recipe recipe = new Recipe();
                recipe.setName(cursor.getString(0));
                recipe.setPreparationTime(cursor.getString(1));
                recipe.setCookingTime(cursor.getString(2));
                recipe.setIngredients(cursor.getString(3));
                recipe.setPhoto(cursor.getString(4));
                recipeList.add(recipe);
            } while (cursor.moveToNext());
        }
        return recipeList;
    }

    public List<Grocery> getAllGroceries() {
        List<Grocery> groceryList = new ArrayList<Grocery>();
        String selectQuery = "SELECT  * FROM " + TABLE_GROCERY, ASC;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Grocery grocery = new Grocery();
                grocery.setItem(cursor.getString(0));
                grocery.setEstimatedPrice(cursor.getInt(1));
                grocery.setFoodType(cursor.getString(2));
                groceryList.add(grocery);
            } while (cursor.moveToNext());
        }
        return groceryList;
    }

    public int updateMeal(Meal meal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MEAL_NAME, meal.getName());
        values.put(KEY_MEAL_DATE, meal.getDate());
        values.put(KEY_MEAL_PHOTO, meal.getIngredients());
        values.put(KEY_MEAL_INGREDIENTS, meal.getPhoto());
        return db.update(TABLE_MEAL, values, KEY_MEAL_NAME + " = " + meal.getName() + ")", null);
    }

    public int updateRecipe(Recipe recipe) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_RECIPE_NAME, recipe.getName());
        values.put(KEY_RECIPE_PREPARATION_TIME, recipe.getPreparationTime());
        values.put(KEY_RECIPE_COOKING_TIME, recipe.getCookingTime());
        values.put(KEY_RECIPE_INGREDIENTS, recipe.getIngredients());
        values.put(KEY_RECIPE_PHOTO, recipe.getPhoto());
        return db.update(TABLE_RECIPE, values, KEY_RECIPE_NAME + " = " + recipe.getName() + ")", null);
    }

    public int updateGrocery(Grocery grocery) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_GROCERY_ITEM, grocery.getItem());
        values.put(KEY_GROCERY_ESTIMATED_PRICE, grocery.getEstimatedPrice());
        values.put(KEY_GROCERY_FOOD_TYPE, grocery.getFoodType());
        return db.update(TABLE_GROCERY, values, KEY_GROCERY_ITEM + " = " + grocery.getItem() + ")", null);
    }

    // todo will be done better
    public boolean deleteMeal(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_MEAL, KEY_MEAL_NAME + "='" + name + "'", null) > 0;
    }

    public boolean deleteRecipe(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_RECIPE, KEY_RECIPE_NAME + "='" + name + "'", null) > 0;
    }

    public boolean deleteGrocery(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_GROCERY, KEY_GROCERY_ITEM + "='" + name + "'", null) > 0;
    }
}