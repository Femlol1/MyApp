package com.example.androidlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class cp_ethnicity_information extends AppCompatActivity implements View.OnClickListener{

    private EditText inputRace, inputClan, inputTotem, inputTribe;
    private ImageButton btnCpEiBack;
    private Button btnCpEiNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp_ethnicity_information);



        btnCpEiBack = (ImageButton) findViewById(R.id.btnCpBack2);
        btnCpEiBack.setOnClickListener(this);

        btnCpEiNext = (Button) findViewById(R.id.btnCpNext2);
        btnCpEiNext.setOnClickListener(this);

        inputRace = (EditText) findViewById(R.id.editTextRace);
        inputClan = (EditText) findViewById(R.id.editTextClan);
        inputTribe = (EditText) findViewById(R.id.editTextTribe);
        inputTotem = (EditText) findViewById(R.id.editTextTotem);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCpBack2:
                startActivity(new Intent(this, CreatePatient.class));
                break;
            case R.id.btnCpNext2:
                validate();
        }
    }

    public void validate(){

        String race = inputRace.getText().toString().trim();
        String clan = inputClan.getText().toString().trim();
        String tribe = inputTribe.getText().toString().trim();
        String totem = inputTotem.getText().toString().trim();

        if (race.isEmpty()) {
            inputRace.setError("Patient's race is required!");
            inputRace.requestFocus();
            return;
        }

    }
}