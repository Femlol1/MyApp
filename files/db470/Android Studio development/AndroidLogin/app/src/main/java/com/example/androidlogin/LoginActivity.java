package com.example.androidlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText inputEmail, inputPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = (EditText) findViewById(R.id.inputLoginEmail);
        inputPassword = (EditText) findViewById(R.id.inputPassword);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                if (login() == false) {
                    Intent Intent = new Intent(this, MainActivity.class);
                    startActivity(Intent);
                }
        }
    }
    private boolean login() {
        String inputemail = inputEmail.getText().toString().trim();
        String inputpassword = inputPassword.getText().toString().trim();

        if (inputemail.isEmpty()) {
            inputEmail.setError("Email is required");
            inputEmail.requestFocus();
            return true;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(inputemail).matches()){
            inputEmail.setError("please provide a valid email address");
            inputEmail.requestFocus();
            return true;
        }

        if (inputpassword.isEmpty()) {
            inputPassword.setError("Password is required");
            inputPassword.requestFocus();
            return true;
        }

        if (inputpassword.length() < 6) {
            inputPassword.setError("Password should be at least 6 characters");
            inputPassword.requestFocus();
            return true;
        }else{
            return false;
        }
    }

    /*//on click go to main page
    public void goToMainPage(View view) {
        Intent Intent = new Intent(this, MainActivity.class);
        startActivity(Intent);
    }
    public void goToRegisterPage(View view) {
        Intent Intent = new Intent(this, RegisterActivity.class);
        startActivity(Intent);
    }*/
}