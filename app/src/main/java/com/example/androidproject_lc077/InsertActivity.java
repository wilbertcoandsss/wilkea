package com.example.androidproject_lc077;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.androidproject_lc077.database.Database;
import com.example.androidproject_lc077.model.Product;
import com.example.androidproject_lc077.model.User;

public class InsertActivity extends AppCompatActivity{

    private Database database;
    private EditText edtTitle, edtPrice, edtType;
    private Button btnInsert;

    private Spinner spinner, getSpinner;

    private SmsManager smsManager;
    private int sendSmsPermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        init();

        spinner = findViewById(R.id.insertProdImage);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.product_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        btnInsert.setOnClickListener(e->{
            String title = edtTitle.getText().toString();
            Integer price = new Integer(edtPrice.getText().toString());
            String image = spinner.getSelectedItem().toString();

            Integer imageInt = -1;
            String type = null;

            if (image.equalsIgnoreCase("bed")){
                type =  "Bed";
                imageInt = R.drawable.bed;
            }
            else if (image.equalsIgnoreCase("chair")){
                type = "Chair";
                imageInt = R.drawable.chair;
            }
            else if (image.equalsIgnoreCase("clock")){
                type = "Clock";
                imageInt = R.drawable.clock;
            }
            else if (image.equalsIgnoreCase("desk")){
                type = "Desk";
                imageInt = R.drawable.desk;
            }
            else if (image.equalsIgnoreCase("furniture")){
                type = "Furniture";
                imageInt = R.drawable.furniture;
            }

            Product prod = new Product();
            prod.setTitle(title);
            prod.setImage(imageInt);
            prod.setPrice(price);
            prod.setType(type);

            database.insertProduct(prod);

            smsManager.sendTextMessage("+1-555-123-4567", null, "Success Insert " + prod.getTitle(),
                    null, null );


            Intent intent = new Intent(this, ProductActivity.class);
            startActivity(intent);
        });
    }

    private void init(){
        database = Database.getInstance(this);
        edtTitle = findViewById(R.id.insertProductName);
        edtPrice = findViewById(R.id.insertProductPrice);
        btnInsert = findViewById(R.id.insertProdBtn);

        smsManager = SmsManager.getDefault();
        sendSmsPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

        if (sendSmsPermission != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
        }

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.my_menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        Intent intent = new Intent(this, HomeActivity.class);
//        startActivity(intent);
//        return super.onOptionsItemSelected(item);
//    }
}