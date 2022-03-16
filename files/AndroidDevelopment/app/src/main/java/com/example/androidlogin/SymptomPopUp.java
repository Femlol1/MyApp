package com.example.androidlogin;

import static com.example.androidlogin.AddScenarioDetails.scenario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SymptomPopUp extends AppCompatActivity implements View.OnClickListener{

    EditText inputSymptomDesc;
    Spinner inputSymptomType;
    String symptomTypeValue;
    Button btnAddSymptomInPopUp;
    Symptom s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_pop_up);

        s = new Symptom();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int) (height*.6));

        inputSymptomType = findViewById(R.id.spinnerASSymptomType);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(SymptomPopUp.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.symptomtypes));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputSymptomType.setAdapter(myAdapter);

        inputSymptomType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value = adapterView.getItemAtPosition(i).toString();
                symptomTypeValue = value;
                //s.setSymptomType(value);
                //Toast.makeText(SymptomPopUp.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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
        String symptomType;
        String symptomDesc = inputSymptomDesc.getText().toString().trim();

        if (symptomDesc.isEmpty()) {
            inputSymptomDesc.setError("Symptom description is required!");
            inputSymptomDesc.requestFocus();
            return;
        }

        s.setSymptomType(symptomTypeValue);
        s.setDesc(symptomDesc);

        scenario.getSymptoms().add(s);
        System.out.println(scenario.getSymptoms().toString());
        Toast.makeText(SymptomPopUp.this, "Symptom added!", Toast.LENGTH_LONG).show();
        finish();
    }
}