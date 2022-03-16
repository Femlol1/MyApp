package com.example.androidlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class AddScenarioDetails extends AppCompatActivity implements View.OnClickListener{

    public static Scenario scenario;

    private FloatingActionButton addAllergy, addPastDiagnosis, addPastTreatments;
    private Button btnAddSymptom, btnCreateScenario;
    private EditText inputSmokingHabit, inputConsumptionHabit;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_scenario_details);

        btnAddSymptom = (Button) findViewById(R.id.addSymptonBttn);
        btnAddSymptom.setOnClickListener(this);

        btnCreateScenario = (Button) findViewById(R.id.createScenarioBttn);
        btnCreateScenario.setOnClickListener(this);

        addAllergy = findViewById(R.id.floatingActionAllergies);
        addAllergy.setOnClickListener(this);

        addPastDiagnosis = findViewById(R.id.floatingActionPastDiagnosis);
        addPastDiagnosis.setOnClickListener(this);

        addPastTreatments = findViewById(R.id.floatingActionPastTreatments);
        addPastTreatments.setOnClickListener(this);

        inputConsumptionHabit = findViewById(R.id.editTextConsumptionHabits);
        inputSmokingHabit = findViewById(R.id.editTextSmokingHabit);

        Intent intent = getIntent();
        String key = intent.getStringExtra("key");

        ref = FirebaseDatabase.getInstance().getReference("Patients");
        Query query = ref.orderByKey().equalTo(key);
        System.out.println(key);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.addSymptonBttn:
                startActivity(new Intent(AddScenarioDetails.this, SymptomPopUp.class));
                break;
            case R.id.floatingActionAllergies:
                startActivity(new Intent(AddScenarioDetails.this, AddAllergyPopUp.class));
                break;
            case R.id.floatingActionPastDiagnosis:
                startActivity(new Intent(AddScenarioDetails.this, AddPastDiagnosisPopUp.class));
                break;
            case R.id.floatingActionPastTreatments:
                startActivity(new Intent(AddScenarioDetails.this, AddPastTreatmentPopUp.class));
                break;
            case R.id.createScenarioBttn:
                validate();
                break;
        }
    }

    private void validate() {
        String smokingHabit = inputSmokingHabit.getText().toString().trim();
        String consumptionHabit = inputConsumptionHabit.getText().toString().trim();

        //scenario.setSmokingHabit(smokingHabit);
        //scenario.setConsumptionHabit(consumptionHabit);


        //System.out.println(scenario.getPatient()+", "+scenario.getSymptoms()+", "+scenario.getTreatments()+", "+scenario.getDiagnoses()+", "+scenario.getAllergy());
        Toast.makeText(AddScenarioDetails.this, "Scenario added!", Toast.LENGTH_LONG).show();
        startActivity(new Intent(AddScenarioDetails.this, MainActivity.class));
    }
}