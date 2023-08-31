package com.example.androidproject_lc077;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject_lc077.model.User;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    private EditText edtEmail, edtPassword;
    private TextView goToRegister;
    private Button btnLogin;

    String currentUser;
    public Vector<User> userLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnLogin.setOnClickListener(v -> {

            String username = edtEmail.getText().toString();
            String password = edtPassword.getText().toString();

            Integer flag = 0;
            String currentUser = null;

            for(int i = 0; i < userLists.size(); i++){
                if(userLists.get(i).getEmail().equals(username)&&
                    userLists.get(i).getPassword().equals(password)){
                    currentUser = userLists.get(i).getName();
                    flag = 1;
                    break;
                }
                flag = 0;
            }

            if (flag != 1){
                Toast.makeText(this, "Invalid Account!", Toast.LENGTH_LONG).show();
                return;
            }

            Intent intent = new Intent(this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });

        goToRegister.setOnClickListener(e->{
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void init(){
        userLists = new Vector<>();
        // Default User
        userLists.add(new User("admin", "admin@gmail.com", "admin123", "+520865774634", "male"));
        userLists.add(new User("wilbert", "wilbert@gmail.com", "wilbert123", "+87633490343", "male"));

        // Register User
        if (getIntent().getStringExtra("nameRegister") != null){
            String nameIntent = getIntent().getStringExtra("nameRegister");
            String emailIntent = getIntent().getStringExtra("emailRegister");
            String passwordIntent = getIntent().getStringExtra("passwordRegister");
            String phoneIntent = getIntent().getStringExtra("phoneRegister");
            String genderIntent = getIntent().getStringExtra("genderRegister");
            userLists.add(new User(nameIntent, emailIntent, passwordIntent, phoneIntent, genderIntent));
        }

        edtEmail = findViewById(R.id.edtMainEmail);
        edtPassword = findViewById(R.id.edtMainPassword);
        btnLogin = findViewById(R.id.btnMainLogin);
        goToRegister = findViewById(R.id.goToRegister);
    }

}