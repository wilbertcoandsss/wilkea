package com.example.androidproject_lc077.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private final String CREATE_TABLE_PRODUCT = "CREATE TABLE product (id integer PRIMARY KEY AUTOINCREMENT, " +
            "product_name text NOT NULL, " +
            "product_price integer NOT NULL, " +
            "image integer NOT NULL, " +
            "product_type text NOT NULL)";


    public DatabaseHelper(@Nullable Context context) {
        super(context, "wilkea", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PRODUCT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS product");
    }

}
