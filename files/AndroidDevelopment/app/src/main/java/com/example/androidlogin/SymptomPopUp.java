package com.example.androidlogin;

import static com.example.androidlogin.AddScenarioDetails.scenario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SymptomPopUp extends AppCompatActivity implements View.OnClickListener{

    EditText inputSymptomType, inputSymptomDesc;
    Button btnAddSymptomInPopUp;
    Symptom s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_pop_up);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int) (height*.6));

        inputSymptomType = findViewById(R.id.editTextASSymptomType);
        inputSymptomDesc = findViewById(R.id.editTextASSymptomDesc);

        btnAddSymptomInPopUp = findViewById(R.id.btnAddSymptomInPopUp);
        btnAddSymptomInPopUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btnAddSymptomInPopUp:
                validate();
                break;
        }
    }

    private void validate() {
        String symptomType = inputSymptomType.getText().toString().trim();
        String symptomDesc = inputSymptomDesc.getText().toString().trim();

        //s.setSymptomType(symptomType);
        //s.setDesc(symptomDesc);

        //scenario.setSymptoms(s);
        Toast.makeText(SymptomPopUp.this, "Symptom added!", Toast.LENGTH_LONG).show();
    }
}