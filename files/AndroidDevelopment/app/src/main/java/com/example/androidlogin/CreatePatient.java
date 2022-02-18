package com.example.androidlogin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class CreatePatient extends AppCompatActivity implements View.OnClickListener{

    private EditText inputName, inputDob, inputGender, inputMaritalStatus,  inputRegDate, inputIdAndNo, inputAddress, inputHospital, inputNextOfKin, inputNextOfKinAddress;
    private ImageButton btnCpBack;
    private Button btnCpNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_patient);

        btnCpBack = (ImageButton) findViewById(R.id.btnCpBack);
        btnCpBack.setOnClickListener(this);

        btnCpNext = findViewById(R.id.btnCpNext);
        btnCpNext.setOnClickListener(this);

        inputName = (EditText) findViewById(R.id.editTextName);
        inputDob = (EditText) findViewById(R.id.editTextDob);
        inputGender = (EditText) findViewById(R.id.editTextGender);
        inputMaritalStatus = (EditText) findViewById(R.id.editTextMaritalStatus);
        inputRegDate = (EditText) findViewById(R.id.editTextRegistrationDate);
        inputIdAndNo = (EditText) findViewById(R.id.editTextIdTypeAndNo);
        inputAddress = (EditText) findViewById(R.id.editTextAddress);
        inputHospital = (EditText) findViewById(R.id.editTextHospital);
        inputNextOfKin = (EditText) findViewById(R.id.editTextNextOfKin);
        inputNextOfKinAddress = (EditText) findViewById(R.id.editTextNextOfKinAddress);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCpBack:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.btnCpNext:
                //startActivity(new Intent(this, cp_ethnicity_information.class));
                validate();
                break;
        }
    }

    private void validate() {
        String name = inputName.getText().toString().trim();
        String dob = inputDob.getText().toString().trim();
        String gender = inputGender.getText().toString().trim();
        String maritalStatus = inputMaritalStatus.getText().toString().trim();
        String regDate = inputRegDate.getText().toString().trim();
        String idAndNo = inputIdAndNo.getText().toString().trim();
        String address = inputAddress.getText().toString().trim();
        String hospital = inputHospital.getText().toString().trim();
        String nextOfKin = inputNextOfKin.getText().toString().trim();
        String nextOfKinAddress = inputNextOfKinAddress.getText().toString().trim();



        if (name.isEmpty()) {
            inputName.setError("Full name is required!");
            inputName.requestFocus();
            return;
        }

        if (dob.isEmpty()) {
            inputDob.setError("DOB is required!");
            inputDob.requestFocus();
            return;
        }

        try {
            Date dateCheck = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
            System.out.println(dob + "\t" + dateCheck);
        } catch (Exception ex) {
            inputDob.setError("Enter correct date format");
            inputDob.requestFocus();
            System.out.println("Not in date format");
            return;
        }

        if (gender.isEmpty()) {
            inputGender.setError("Gender is required!");
            inputGender.requestFocus();
            return;
        }

        if (regDate.isEmpty()) {
            inputRegDate.setError("Reg. date is required!");
            inputRegDate.requestFocus();
            return;
        }

        try {
            Date regDateCheck = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
            System.out.println(regDate + "\t" + regDateCheck);
        } catch (Exception ex) {
            inputRegDate.setError("Enter correct date format");
            inputRegDate.requestFocus();
            System.out.println("Not in date format");
            return;
        }

        if (hospital.isEmpty()) {
            inputHospital.setError("Hospital details are required!");
            inputHospital.requestFocus();
            return;
        }

        startActivity(new Intent(this, cp_ethnicity_information.class));

    }
}