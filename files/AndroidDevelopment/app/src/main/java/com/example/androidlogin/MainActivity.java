package com.example.androidlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView createPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createPatient = (TextView) findViewById(R.id.addPatient);
        createPatient.setOnClickListener(this);
    }
    public void goToLoginPage(View view) {
        Intent Intent = new Intent(this, LoginActivity.class);
        startActivity(Intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addPatient:
                startActivity(new Intent(MainActivity.this, CreatePatient.class));
                break;

        }
    }
}