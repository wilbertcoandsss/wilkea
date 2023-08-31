package com.example.androidproject_lc077.database;

import android.content.Context;

import com.example.androidproject_lc077.model.Product;
import com.example.androidproject_lc077.model.User;

import java.util.Vector;

public class Database {

    private static Database _instance = null;
    private ProductHelper productHelper;

    private Database(Context context){
        productHelper = new ProductHelper(context);
    }

    public static Database getInstance(Context context) {
        if (_instance == null) {
            synchronized (Database.class) {
                if (_instance == null) {
                    _instance = new Database(context);
                }
            }
        }
        return _instance;
    }

    public Vector<Product> getAllProducts(){
        return productHelper.getAllProduct();
    }

    public void insertProduct(Product product){
        productHelper.insert(product);
    }

    public void deleteProduct(int deletedId){
        productHelper.delete(deletedId);
    }

}
