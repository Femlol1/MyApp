package com.example.androidlogin;

import static com.example.androidlogin.AddScenarioDetails.scenario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPastDiagnosisPopUp extends AppCompatActivity implements View.OnClickListener{

    EditText inputDiagnosisDate, inputDiagnosis;
    Button btnAddDiagnosis;
    Diagnosis diagnosisObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pastdiagnosiswindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .6));

        inputDiagnosisDate = findViewById(R.id.editTextPDDate);
        inputDiagnosis = findViewById(R.id.editTextPDDiagnosis);

        btnAddDiagnosis = findViewById(R.id.btnAddDiagnosis);
        btnAddDiagnosis.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAddDiagnosis:
                validate();
                break;
        }
    }

    private void validate() {
        String diagnosisDate = inputDiagnosisDate.getText().toString().trim();
        String diagnosis = inputDiagnosis.getText().toString().trim();

        //diagnosisObj.setDate(diagnosisDate);
        //diagnosisObj.setName(diagnosis);

        //scenario.setDiagnoses(diagnosisObj);
        Toast.makeText(AddPastDiagnosisPopUp.this, "Diagnosis added!", Toast.LENGTH_LONG).show();


    }
}
