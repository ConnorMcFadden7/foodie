package com.connormcfadden.foodie.data.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.connormcfadden.foodie.data.model.Meal;

import java.util.ArrayList;
import java.util.List;

public class FoodieDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "foodie";

    private static final String TABLE_MEAL = "meal";

    private static final String KEY_MEAL_NAME = "name";
    private static final String KEY_MEAL_DATE = "date";
    private static final String KEY_MEAL_LOCATION = "ingredients";
    private static final String KEY_MEAL_PHOTO = "photo";

    public FoodieDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MEALS_TABLE = "CREATE TABLE " + TABLE_MEAL + "(" + KEY_MEAL_NAME + " TEXT,"
                + KEY_MEAL_DATE + " TEXT," + KEY_MEAL_LOCATION + " TEXT," + KEY_MEAL_PHOTO + " TEXT" + ")";
        db.execSQL(CREATE_MEALS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEAL);
        onCreate(db);
    }

    void addMeal(Meal meal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MEAL_NAME, meal.getName());
        values.put(KEY_MEAL_DATE, meal.getDate());
        values.put(KEY_MEAL_LOCATION, meal.getIngredients());
        values.put(KEY_MEAL_PHOTO, meal.getPhoto());
        db.insert(TABLE_MEAL, null, values);
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

    public int updateMeal(Meal meal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MEAL_NAME, meal.getName());
        values.put(KEY_MEAL_DATE, meal.getDate());
        values.put(KEY_MEAL_PHOTO, meal.getIngredients());
        values.put(KEY_MEAL_LOCATION, meal.getPhoto());
        return db.update(TABLE_MEAL, values, KEY_MEAL_NAME + " = " + meal.getName() + ")", null);
    }

    // todo will be done better
    public boolean updateMeal(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_MEAL, KEY_MEAL_NAME + "='" + name + "'", null) > 0;
    }
}