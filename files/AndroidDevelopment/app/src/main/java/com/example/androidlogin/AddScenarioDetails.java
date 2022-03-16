package com.example.androidlogin;

import static com.example.androidlogin.CreatePatient.patient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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
    private ProgressBar progressBar;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_scenario_details);

        scenario = new Scenario();

        btnAddSymptom = (Button) findViewById(R.id.addSymptonBttn);
        btnAddSymptom.setOnClickListener(this);

        btnCreateScenario = (Button) findViewById(R.id.createScenarioBttn);
        btnCreateScenario.setOnClickListener(this);

        progressBar = findViewById(R.id.ASProgressBar);

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
        scenario.setPatient(key);
        //System.out.println(key);
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

        scenario.setSmokingHabit(smokingHabit);
        scenario.setConsumptionHabit(consumptionHabit);


        //System.out.println(scenario.getPatient()+", "+scenario.getSymptoms()+", "+scenario.getTreatments()+", "+scenario.getDiagnoses()+", "+scenario.getAllergy());

        // When the patient object is being written to Firebase Real-time Database, make the progress bar visible to give UI responsiveness
        progressBar.setVisibility(View.VISIBLE);

        //Find the Patients node in the database, create auto-generated UID and write a patient object with all its attributes.
        //Implement an onCompleteListener to check if the data write is successful.
        FirebaseDatabase.getInstance().getReference().child("Scenarios").push().setValue(scenario).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                // If successful, tell the user the patient has been added
                if (task.isSuccessful()) {
                    Toast.makeText(AddScenarioDetails.this, "Scenario added successfully!", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                    startActivity(new Intent(AddScenarioDetails.this, MainActivity.class));

                    // Else, give them an error message
                } else {
                    Toast.makeText(AddScenarioDetails.this, "Scenario could not be added! Check internet and try again!", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

    }
}