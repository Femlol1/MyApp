package com.example.androidlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView patients = findViewById(R.id.patients);
        TextView logout = findViewById(R.id.logout);

        patients.setOnClickListener(this);
        logout.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.patients:
                Toast.makeText(this,"Patients View clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, PatientViewActivity.class));
                break;
            case R.id.logout:
                Toast.makeText(this,"Logout clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
        }
    }
}