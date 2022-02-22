package com.example.androidlogin;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreatePatient extends AppCompatActivity implements View.OnClickListener {

    // Declare all the input fields for the general info page
    private EditText inputName, inputDob, inputGender, inputMaritalStatus, inputRegDate, inputIdAndNo, inputAddress, inputHospital, inputNextOfKin, inputNextOfKinAddress;

    // Declare back button
    private ImageButton btnCpBack;

    // Declare next button
    private Button btnCpNext;

    // Declare patient object that can be modified in other classes too
    public static Patient patient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_patient);

        //Connect the input field variables to the Edit Text elements in the corresponding activity_create_patient.xml
        inputName = (EditText) findViewById(R.id.editTextName);
        inputDob = (EditText) findViewById(R.id.editTextDob);
        inputGender = (EditText) findViewById(R.id.editTextGender);
        inputMaritalStatus = (EditText) findViewById(R.id.editTextMaritalStatus);
        inputRegDate = (EditText) findViewById(R.id.editTextRegDate);
        inputIdAndNo = (EditText) findViewById(R.id.editTextIdTypeAndNo);
        inputAddress = (EditText) findViewById(R.id.editTextAddress);
        inputHospital = (EditText) findViewById(R.id.editTextHospital);
        inputNextOfKin = (EditText) findViewById(R.id.editTextNextOfKin);
        inputNextOfKinAddress = (EditText) findViewById(R.id.editTextNextOfKinAddress);

        // Instantiate a patient object whose attributes can be updated with user inputs
        patient = new Patient();

        // Connect back button variable to the Image Button in the corresponding XML file
        // and set an onclick listener to check for any click on the button
        btnCpBack = (ImageButton) findViewById(R.id.btnCpBack);
        btnCpBack.setOnClickListener(this);

        // Connect next button variable to Button element in the XML file
        // and set an onclick listener to check for any click on the button

        btnCpNext = findViewById(R.id.btnCpNext);
        btnCpNext.setOnClickListener(this);

    }

    // Define the actions for any button click
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCpBack:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.btnCpNext:
                validate();
                break;
        }
    }

    // Validate the required text fields on the XML page
    private void validate() {

        // Assign all the inputs (after some formatting) to variables that can be assigned to patient object's attributes
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

        //Validation for required field: name
        if (name.isEmpty()) {
            inputName.setError("Full name is required!");
            inputName.requestFocus();
            return;
        }

        //Validation for required field: dob
        if (dob.isEmpty()) {
            inputDob.setError("DOB is required!");
            inputDob.requestFocus();
            return;
        }

        //Validation for dob to be of length - 10 characters of the format: DD/MM/YYYY
        if (dob.length() != 10) {
            inputDob.setError("Dob should be in the format DD/MM/YYYY");
            inputDob.requestFocus();
            return;
        }

        // IMP: Not required conversion of date inputs from string to SimpleDateFormat
        /*
        try {
            Date dateCheck = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
            System.out.println(dob + "\t" + dateCheck);
        } catch (Exception ex) {
            inputDob.setError("Enter correct date format");
            inputDob.requestFocus();
            System.out.println("Not in date format");
            return;
        }*/

        //Validation for required field: gender
        if (gender.isEmpty()) {
            inputGender.setError("Gender is required!");
            inputGender.requestFocus();
            return;
        }

        //Validation for required field: regDate (Registration Date)
        if (regDate.isEmpty()) {
            inputRegDate.setError("Reg. date is required!");
            inputRegDate.requestFocus();
            return;
        }

        //Validation for regDate to be of length - 10 characters of the format: DD/MM/YYYY
        if (regDate.length() != 10) {
            inputRegDate.setError("Reg. date should be in the format DD/MM/YYYY");
            inputRegDate.requestFocus();
            return;
        }

        //Validation for required field: hospital
        if (hospital.isEmpty()) {
            inputHospital.setError("Hospital details are required!");
            inputHospital.requestFocus();
            return;
        }

        //Assign all the formatted user inputs to a Patient object's attributes
        patient.setName(name);
        patient.setDob(dob);
        patient.setGender(gender);
        patient.setMaritalStatus(maritalStatus);
        patient.setRegDate(regDate);
        patient.setIdAndNo(idAndNo);
        patient.setAddress(address);
        patient.setHospital(hospital);
        patient.setNextOfKin(nextOfKin);
        patient.setNextOfKinAddress(nextOfKinAddress);

        // Create an intent to map a navigation between General Info page and Ethnic Background page
        Intent intent = new Intent(this, cp_ethnicity_information.class);

        // Start the new activity: Ethnic Info, when all validation is done
        startActivity(intent);

    }
}