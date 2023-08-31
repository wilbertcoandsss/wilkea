package com.example.androidproject_lc077;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button pageBtn, aboutUsBtn, logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        pageBtn.setOnClickListener(e ->{
            Intent intent = new Intent(HomeActivity.this, ProductActivity.class);
            startActivity(intent);
        });

        aboutUsBtn.setOnClickListener(e->{
            Intent intent = new Intent(HomeActivity.this, AboutUsActivity.class);
            startActivity(intent);
        });

        logoutBtn.setOnClickListener(e->{
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void init(){

        pageBtn = findViewById(R.id.prodPageBtn);
        aboutUsBtn = findViewById(R.id.aboutUsBtn);
        logoutBtn = findViewById(R.id.logoutBtn);
    }
}