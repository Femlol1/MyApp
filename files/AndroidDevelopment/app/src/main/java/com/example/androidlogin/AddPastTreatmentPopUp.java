package com.example.androidlogin;

import static com.example.androidlogin.AddScenarioDetails.scenario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPastTreatmentPopUp extends AppCompatActivity implements View.OnClickListener{

    EditText inputTreatmentDate, inputTreatment;
    Button btnAddTreatment;
    Treatment t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pasttreatmentswindow);

        t = new Treatment();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .6));

        inputTreatmentDate = findViewById(R.id.editTextPTDate);
        inputTreatment = findViewById(R.id.editTextPTTreatment);

        btnAddTreatment = findViewById(R.id.btnAddTreatment);
        btnAddTreatment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnAddTreatment:
                validate();
                break;
        }
    }

    private void validate() {
        String TreatmentDate = inputTreatmentDate.getText().toString().trim();
        String Treatment = inputTreatment.getText().toString().trim();

        //Validation for dob to be of length - 10 characters of the format: DD/MM/YYYY
        if (TreatmentDate.length() != 10) {
            inputTreatmentDate.setError("Dob should be in the format DD/MM/YYYY");
            inputTreatmentDate.requestFocus();
            return;
        }

        t.setDate(TreatmentDate);
        t.setName(Treatment);

        scenario.getTreatments().add(t);

        finish();
        Toast.makeText(AddPastTreatmentPopUp.this, "Treatment added!", Toast.LENGTH_LONG).show();
    }
}