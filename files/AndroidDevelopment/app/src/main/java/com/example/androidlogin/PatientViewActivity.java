package com.example.androidlogin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

// This class's purpose if to gather the list of patients and present them to the user in activity_patient_view
public class PatientViewActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    DatabaseReference database;
    PatientAdapter patientAdapter;
    ArrayList<Patient> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_view);

        TextView backBtn = findViewById(R.id.textViewBackFromPatientView);

        backBtn.setOnClickListener(this);

        recyclerView = findViewById(R.id.patientList);
        database = FirebaseDatabase.getInstance().getReference("Patients");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        patientAdapter = new PatientAdapter(this,list);
        recyclerView.setAdapter(patientAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            //Snap shot gets the instance of the Firebase Patients table
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //Gets a patients from the instance taken from Firebase and adds that Patient to a list

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    //This gets all the Patients in the Firebase and adds them to a list
                    Patient patient = dataSnapshot.getValue(Patient.class);
                    list.add(patient);

                }
                patientAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //This will take the user back to the main page when the back button is clicked
            case R.id.textViewBackFromPatientView:
                Toast.makeText(this,"Back button clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PatientViewActivity.this, MainActivity.class));
                break;
        }
    }
}
