package com.example.androidproject_lc077;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject_lc077.adapters.ProductsAdapter;
import com.example.androidproject_lc077.database.Database;
import com.example.androidproject_lc077.model.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Vector;

public class ProductActivity extends AppCompatActivity {

    private RecyclerView rvProducts;
    private ProductsAdapter adapter;
    private Vector<Product> listProducts;

    private Database database;
    private FloatingActionButton fabAddBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        init();

        rvProducts.setLayoutManager(new LinearLayoutManager(this));
        rvProducts.setAdapter(adapter);

        fabAddBtn.setOnClickListener(e->{
            Intent intent = new Intent(ProductActivity.this, InsertActivity.class);
            startActivity(intent);
        });

    }

    private void init(){
        database = Database.getInstance(this);

        rvProducts = findViewById(R.id.rvProducts);
        listProducts = new Vector<>();

        // WKWKW nih harusnya udah bisa ko ketampil pas selesai insert
        listProducts = database.getAllProducts();
        adapter = new ProductsAdapter(this, listProducts);

        fabAddBtn = findViewById(R.id.addFabBtn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}