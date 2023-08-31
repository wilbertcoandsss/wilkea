package com.example.androidproject_lc077;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidproject_lc077.model.User;

public class RegisterActivity extends AppCompatActivity {

    private EditText name, email, password, phone;
    private CheckBox chkBox;
    private RadioButton femaleBtn, maleBtn, chooseBtn;

    private RadioGroup genderBtn;
    private Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        registerBtn.setOnClickListener(e->{

            String nameField = name.getText().toString();
            String emailField = email.getText().toString();
            String passwordField = password.getText().toString();
            String phoneField = phone.getText().toString();

            int selectedId = genderBtn.getCheckedRadioButtonId();
            chooseBtn = (RadioButton) findViewById(selectedId);
            String genderField = null;
            if (nameField.isEmpty()){
                Toast.makeText(this, "Name cannot be empty!", Toast.LENGTH_SHORT).show();
            }
            else if (!nameField.contains(" ")){
                Toast.makeText(this, "Input your last name too (must be 2 words)", Toast.LENGTH_SHORT).show();
            }
            else if (emailField.isEmpty()){
                Toast.makeText(this, "Email cannot be empty!", Toast.LENGTH_SHORT).show();
            }
            else if (passwordField.isEmpty()){
                Toast.makeText(this, "Password cannot be empty!", Toast.LENGTH_SHORT).show();
            }
            else if (phoneField.isEmpty()){
                Toast.makeText(this, "Phone number cannot be empty!", Toast.LENGTH_SHORT).show();
            }
            else if (!phoneField.startsWith("+62")){
                Toast.makeText(this, "Phone number must starts with +62", Toast.LENGTH_SHORT).show();
            }
            else if (!femaleBtn.isChecked() && !maleBtn.isChecked()){
                Toast.makeText(this, "Gender must be selected!", Toast.LENGTH_SHORT).show();
            }
            else if (!chkBox.isChecked()){
                Toast.makeText(this, "Box must be checked!", Toast.LENGTH_SHORT).show();
            }
            else{
                genderField = chooseBtn.getText().toString();
                User u1 = new User(nameField, emailField, passwordField, phoneField, genderField);
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("nameRegister", nameField);
                intent.putExtra("emailRegister", emailField);
                intent.putExtra("passwordRegister", passwordField);
                intent.putExtra("phoneRegister", phoneField);
                intent.putExtra("genderRegister", genderField);
                startActivity(intent);
            }

        });
    }

    private void init(){
        name = findViewById(R.id.edtNameRegister);
        email = findViewById(R.id.edtEmailRegister);
        password = findViewById(R.id.edtPasswordRegister);
        phone = findViewById(R.id.editTextPhone);

        femaleBtn = findViewById(R.id.femaleRadioBtn);
        maleBtn = findViewById(R.id.maleRadioBtn);
        genderBtn = findViewById(R.id.genderBtn);
        chkBox = findViewById(R.id.chkBoxTerms);

        registerBtn = findViewById(R.id.registerBtn);
    }
}