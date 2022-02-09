package com.example.androidlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText firstName, lastName, inputUniversity, inputYear, inputEmail,inputPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        firstName = (EditText) findViewById(R.id.inputFirstName);
        lastName = (EditText) findViewById(R.id.inputLastName);
        inputUniversity = (EditText) findViewById(R.id.inputUniversity);
        inputYear = (EditText) findViewById(R.id.inputYearInUniversity);
        inputEmail = (EditText) findViewById(R.id.inputEmail);
        inputPassword = (EditText) findViewById(R.id.inputPassword);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);

    }
    /*public void goToLoginPage(View view) {
        Intent Intent = new Intent(this, LoginActivity.class);
        startActivity(Intent);
    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegister:
                if (register() == false) {
                    Intent Intent = new Intent(this, LoginActivity.class);
                    startActivity(Intent);
                }
        }
    }

    private boolean register() {
        String firstname =  firstName.getText().toString().trim();
        String lastname =  lastName.getText().toString().trim();
        String universtity =  inputUniversity.getText().toString().trim();
        String year =  inputYear.getText().toString().trim();
        String  email =  inputEmail.getText().toString().trim();
        String password =  inputPassword.getText().toString().trim();


        if (firstname.isEmpty()) {
            firstName.setError("First name is required");
            firstName.requestFocus();
            return true;
        }

        if (lastname.isEmpty()) {
            lastName.setError("Last name is required");
            lastName.requestFocus();
            return true;
        }

        if (universtity.isEmpty()) {
            inputUniversity.setError("University name is required");
            inputUniversity.requestFocus();
            return true;


        }

        if (year.isEmpty()) {
            inputYear.setError("University year is required");
            inputYear.requestFocus();
            return true;


        }

        if (email.isEmpty()) {
            inputEmail.setError("Email is required");
            inputEmail.requestFocus();
            return true;

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
        inputEmail.setError("please provide a valid email address");
        inputEmail.requestFocus();
        return true;
        }

        if (password.isEmpty()) {
            inputPassword.setError("Password is required");
            inputPassword.requestFocus();
            return true;


        }
        if(password.length() < 6) {
            inputPassword.setError("Password should be at least 6 characters");
            inputPassword.requestFocus();
            return true;
        }else{
            return false;
        }

    }
}