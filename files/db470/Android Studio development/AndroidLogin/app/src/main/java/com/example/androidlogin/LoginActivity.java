package com.example.androidlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    //on click go to main page
    public void goToMainPage(View view) {
        Intent Intent = new Intent(this, MainActivity.class);
        startActivity(Intent);
    }
    public void goToRegisterPage(View view) {
        Intent Intent = new Intent(this, RegisterActivity.class);
        startActivity(Intent);
    }
}