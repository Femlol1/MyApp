package com.example.androidlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StartScenario extends AppCompatActivity {

    TextView Allergies, SmokingHistory, AlxhoholConsunptionHistory, PostDiagnosis,PostTreatmment,Symptoms, symptomYetToReveal;
    Button btnRevealSymptom, btnTreatPatient;
    DatabaseReference scenarioRef;
    Integer totalSymptoms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_scenario);

        symptomYetToReveal = findViewById(R.id.symptomCount);

        Allergies = (TextView) findViewById(R.id.allergiesView);
        SmokingHistory = (TextView) findViewById(R.id.smokingHistoryView);
        AlxhoholConsunptionHistory = (TextView) findViewById(R.id.alchoholConsumptionHistoryView);
        PostDiagnosis = (TextView) findViewById(R.id.pDiagnosisView);
        PostTreatmment = (TextView) findViewById(R.id.pTreatmentView);
        //Symptoms = (TextView) findViewById(R.id.textsymptomexplanation);

        //Get the intent passed from StartScenarioSearch.java class
        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        System.out.println(key);

        btnRevealSymptom = (Button) findViewById(R.id.buttonstart);
        btnTreatPatient = (Button) findViewById(R.id.buttonnext2);


        scenarioRef = FirebaseDatabase.getInstance().getReference().child("Scenarios").child(key);

        btnTreatPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StartScenario.this, "we are going to go further in sprint 4", Toast.LENGTH_SHORT).show();
            }
        });

        //View a scenario. Shows one specific working example
        btnRevealSymptom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scenarioRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        totalSymptoms = (int) dataSnapshot.child("symptoms").getChildrenCount();
                        System.out.println("There are "+totalSymptoms+" symptoms");
                        String allergies = dataSnapshot.child("allergy").getValue().toString();
                        String smokingHistory = dataSnapshot.child("smokingHabit").getValue().toString();
                        String alcohol = dataSnapshot.child("consumptionHabit").getValue().toString();
                        String pdiagnosis = dataSnapshot.child("diagnoses").getValue().toString();
                        String ptreatments = dataSnapshot.child("treatments").getValue().toString();
                        //String symptoms = dataSnapshot.child("symptoms").getValue().toString();

                        Allergies.setText(allergies);
                        SmokingHistory.setText(smokingHistory);
                        AlxhoholConsunptionHistory.setText(alcohol);
                        PostDiagnosis.setText(pdiagnosis);
                        PostTreatmment.setText(ptreatments);
                        //Symptoms.setText(symptoms);

                        symptomYetToReveal.setText("* "+Integer.toString(totalSymptoms-1) + " symptom(s) yet to be revealed");


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

        System.out.println("Pre Scenario Ref");
        scenarioRef.child(key).orderByChild("symptoms")
                .startAt(key).endAt(key)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            totalSymptoms = (int) snapshot.getChildrenCount();
                            symptomYetToReveal.setText("*"+Integer.toString(totalSymptoms) + " symptoms yet to be revealed");
                            System.out.println(totalSymptoms);
                        }
                        else{

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
        System.out.println("Scenario Ref Skipped");

        /*
        //scenarioRef = FirebaseDatabase.getInstance().getReference().child("Scenarios");

        Allergies = (TextView) findViewById(R.id.allergiesView);
        SmokingHistory = (TextView) findViewById(R.id.smokingHistoryView);
        AlxhoholConsunptionHistory = (TextView) findViewById(R.id.alchoholConsumptionHistoryView);
        PostDiagnosis = (TextView) findViewById(R.id.pDiagnosisView);
        PostTreatmment = (TextView) findViewById(R.id.pTreatmentView);
        symptomYetToReveal = findViewById(R.id.symptomCount);
        //Symptoms = (TextView) findViewById(R.id.textsymptomexplanation);



        btnRevealSymptom = (Button) findViewById(R.id.buttonstart);
        btnTreatPatient = (Button) findViewById(R.id.buttonnext2);

        //Get the intent passed from StartScenarioSearch.java class
        Intent intent = getIntent();
        String key = intent.getStringExtra("key");


        btnTreatPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StartScenario.this, "we are going to go further in sprint 4", Toast.LENGTH_SHORT).show();
            }
        });


        //View a scenario. Shows one specific working example
        btnRevealSymptom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                scenarioRef = FirebaseDatabase.getInstance().getReference().child("Scenarios").child(key);
                scenarioRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        System.out.println(scenarioRef.child("allergy"));
                        String allergies = dataSnapshot.child("allergy").getValue().toString();
                        String smokingHistory = dataSnapshot.child("smokingHabit").getValue().toString();
                        String alcohol = dataSnapshot.child("consumptionHabit").getValue().toString();
                        String pdiagnosis = dataSnapshot.child("diagnoses").getValue().toString();
                        String ptreatments = dataSnapshot.child("treatments").getValue().toString();
                        String symptoms = dataSnapshot.child("symptoms").getValue().toString();

                        Allergies.setText(allergies);
                        SmokingHistory.setText(smokingHistory);
                        AlxhoholConsunptionHistory.setText(alcohol);
                        PostDiagnosis.setText(pdiagnosis);
                        PostTreatmment.setText(ptreatments);
                        Symptoms.setText(symptoms);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

        scenarioRef.child(key).orderByChild("symptoms")
                .startAt(key).endAt(key)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            totalSymptoms = (int) snapshot.getChildrenCount();
                            symptomYetToReveal.setText("*"+Integer.toString(totalSymptoms) + " symptoms yet to be revealed");
                        }
                        else{

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
        */


    }



}