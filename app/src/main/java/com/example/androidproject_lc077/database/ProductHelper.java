package com.example.androidproject_lc077.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.androidproject_lc077.model.Product;

import java.util.Vector;

public class ProductHelper {

    private final DatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private final String TABLE_NAME = "product";

    public ProductHelper(Context context){
        dbHelper = new DatabaseHelper(context);
    }

    public Vector<Product> getAllProduct(){
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM product", null);
        Vector<Product> listProducts = new Vector<>();

        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            Product product = new Product();
            product.setId(cursor.getInt(0));
            product.setTitle(cursor.getString(1));
            product.setPrice(cursor.getInt(2));
            product.setImage(cursor.getInt(3));
            product.setType(cursor.getString(4));
            listProducts.add(product);
            cursor.moveToNext();
        }

        db.close();
        cursor.close();

        return listProducts;
    }

    public void insert(Product product){
        db = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("product_name", product.getTitle());
        contentValues.put("product_price", product.getPrice());
        contentValues.put("image", product.getImage());
        contentValues.put("product_type", product.getType());

        db.insert(TABLE_NAME, null, contentValues);

        db.close();
    }

    public void delete(int deletedId){
        db = dbHelper.getWritableDatabase();
        db.delete(TABLE_NAME, "id = ?", new String[]{deletedId + ""});
        db.close();
    }
}
