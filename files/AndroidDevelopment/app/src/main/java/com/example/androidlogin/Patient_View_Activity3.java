package com.example.androidlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Patient_View_Activity3 extends AppCompatActivity {

    TextView  Ambient_Temperature, Weather_Transition, Relative_Humidity,Endemic_Disease_Region,
            Disease_Vectors,Recent_Travel_Migration, Communicable_Disease_Contact, Recent_Source_food, Recent_Water_Water,
            Long_Term_Enviromental_Exposure, Natural_Catastrophe_Exposure, RecenT_Sanitation_System;
    Button showbutton, nxtbutton, bckbutton;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientview_3);
        Ambient_Temperature = (TextView) findViewById(R.id.aTempView);
        Weather_Transition = (TextView) findViewById(R.id.wTransView);
        Relative_Humidity = (TextView) findViewById(R.id.relativeHumView);
        Endemic_Disease_Region = (TextView) findViewById(R.id.EDRView);
        Disease_Vectors = (TextView) findViewById(R.id.DvectorView);
        Recent_Travel_Migration = (TextView) findViewById(R.id.recentTravelMigrationView);
        Communicable_Disease_Contact = (TextView) findViewById(R.id.comunicabledisieasecontactView);
        Recent_Source_food = (TextView) findViewById(R.id.RecentSourceOfFoodView);
        Recent_Water_Water = (TextView) findViewById(R.id.RecentSourceOfWaterView);
        Long_Term_Enviromental_Exposure = (TextView) findViewById(R.id.LongTermExposureView);
        Natural_Catastrophe_Exposure = (TextView) findViewById(R.id.NaturalCatastropheExposureView);
        RecenT_Sanitation_System = (TextView) findViewById(R.id.RecentSanitationSystemView);




        showbutton = (Button) findViewById(R.id.button3);
        nxtbutton = (Button) findViewById(R.id.nxtbutton3);
        bckbutton = (Button) findViewById(R.id.bckbutton3);

        nxtbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Patient_View_Activity3.this, "We have not added a functionality for the next page ", Toast.LENGTH_SHORT).show();
            }
        });
        bckbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Patient_View_Activity3.this, Patient_View_Activity2.class));
                ;
                Toast.makeText(Patient_View_Activity3.this, "Previous Page", Toast.LENGTH_SHORT).show();
            }

        });

        showbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff = FirebaseDatabase.getInstance().getReference().child("Patients").child("-MwTire0DRc_MWeBWjXD");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String ambient_Temperature = dataSnapshot.child("ambientTemperature").getValue().toString();
                        String weather_Transition = dataSnapshot.child("weatherTransition").getValue().toString();
                        String relative_Humidity = dataSnapshot.child("relativeHumidity").getValue().toString();
                        String endemic_Disease_Region = dataSnapshot.child("endemicDiseaseRegion").getValue().toString();
                        String disease_Vectors = dataSnapshot.child("diseaseVectors").getValue().toString();
                       // String recent_Travel = dataSnapshot.child("recentTravel").getValue().toString();
                        String communicable_Disease_Contact = dataSnapshot.child("communicableDiseaseContact").getValue().toString();
                        String recent_Source_Of_Food = dataSnapshot.child("recentSourceOfFood").getValue().toString();
                        String recent_Source_Of_Water = dataSnapshot.child("recentSourceOfWater").getValue().toString();
                        String long_Term_Environmen_tExposure = dataSnapshot.child("longTermEnvironmentExposure").getValue().toString();
                        String natural_Catastrophe_Exposure = dataSnapshot.child("naturalCatastropheExposure").getValue().toString();
                        String recent_Sanitation_System = dataSnapshot.child("recentSanitationSystem").getValue().toString();


                        Ambient_Temperature.setText(ambient_Temperature);
                        Weather_Transition.setText(weather_Transition);
                        Relative_Humidity.setText(relative_Humidity);
                        Endemic_Disease_Region.setText(endemic_Disease_Region);
                        Disease_Vectors.setText(disease_Vectors);
                       // Recent_Travel_Migration.setText(recent_Travel);
                        Communicable_Disease_Contact.setText(communicable_Disease_Contact);

                        Recent_Source_food.setText(recent_Source_Of_Food);
                        Recent_Water_Water.setText(recent_Source_Of_Water);
                        RecenT_Sanitation_System.setText(recent_Sanitation_System);
                        Long_Term_Enviromental_Exposure.setText(long_Term_Environmen_tExposure);
                        Natural_Catastrophe_Exposure.setText(natural_Catastrophe_Exposure);
                        Natural_Catastrophe_Exposure.setText(natural_Catastrophe_Exposure);










                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });


    }

}