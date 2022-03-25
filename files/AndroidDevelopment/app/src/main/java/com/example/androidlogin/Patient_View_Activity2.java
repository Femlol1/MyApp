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

public class Patient_View_Activity2 extends AppCompatActivity {
    TextView Race, Tribe,Clan, Totem,Professional_Training,Training_History,Occupational_History ;
    Button showbutton, nxtbutton, bckbutton;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientview_2);

        Race = (TextView) findViewById(R.id.raceView);
        Tribe = (TextView) findViewById(R.id.tribeView);
        Clan = (TextView) findViewById(R.id.clanView);
        Totem = (TextView) findViewById(R.id.totemView);
        Professional_Training = (TextView) findViewById(R.id.proffTrainingView);
        Training_History = (TextView) findViewById(R.id.trainingHistoryView);
        Occupational_History = (TextView) findViewById(R.id.occationalHistoryView);

        showbutton = (Button) findViewById(R.id.showbutton2);
        nxtbutton = (Button) findViewById(R.id.nxtbutton2);
        bckbutton = (Button) findViewById(R.id.bckbutton2);



        nxtbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Patient_View_Activity2.this, Patient_View_Activity3.class));;
                Toast.makeText(Patient_View_Activity2.this, "Next Page", Toast.LENGTH_SHORT).show();
            }
        });
        bckbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Patient_View_Activity2.this, Patient_View_Activity.class));;
                Toast.makeText(Patient_View_Activity2.this, "Previous Page", Toast.LENGTH_SHORT).show();

            }

        });

        showbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff = FirebaseDatabase.getInstance().getReference().child("Patients").child("-MwTire0DRc_MWeBWjXD");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String race = dataSnapshot.child("race").getValue().toString();
                        String tribe = dataSnapshot.child("tribe").getValue().toString();
                        String clan = dataSnapshot.child("clan").getValue().toString();
                        String totem = dataSnapshot.child("totem").getValue().toString();
                        String professional_Training = dataSnapshot.child("professionalTraining").getValue().toString();
                        String training_History = dataSnapshot.child("trainingHistory").getValue().toString();
                        String occupational_History = dataSnapshot.child("occupationalHistory").getValue().toString();

                        Race.setText(race);
                        Tribe.setText(tribe);
                        Clan.setText(clan);
                        Totem.setText(totem);
                        Professional_Training.setText(professional_Training);
                        Training_History.setText(training_History);
                        Occupational_History.setText(occupational_History);





                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });


    }


    }
