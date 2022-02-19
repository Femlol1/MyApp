package com.example.androidlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;


public class SelectPatient extends AppCompatActivity {

    private EditText searchPatient, mSearchField;
    private Button searchButton, mSearchBtn;
    private RecyclerView mResultList;

    private DatabaseReference mPatientDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_patient);

        mPatientDatabase = FirebaseDatabase.getInstance().getReference("Patients");

        searchPatient = (EditText) findViewById(R.id.editTextSearchPatient);
        searchButton = (Button) findViewById(R.id.buttonSearch);
        mResultList= (RecyclerView) findViewById(R.id.recyclerViewResultList);
        mResultList.setHasFixedSize(true);
        mResultList.setLayoutManager(new LinearLayoutManager(this));

        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebasePatientSearch();
            }
        });
    }

    private void firebasePatientSearch() {
        FirebaseRecyclerAdapter<Patients, PatientsViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Patients, PatientsViewHolder>(
                Patients.class,
                R.layout.list_layout,
                PatientsViewHolder.class,
                mPatientDatabase
        ) {
            @Override
            protected void onBindViewHolder(@NonNull PatientsViewHolder holder, int position, @NonNull Patients model) {
                holder.setDetails(getApplicationContext(), model.getName(), model.getPicture());
            }

            @NonNull
            @Override
            public PatientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }
        };
        mResultList.setAdapter(firebaseRecyclerAdapter);
    }

    /*
    *     private void firebasePatientSearch() {
        FirebaseRecyclerAdapter<Patients, PatientsViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Patients, PatientsViewHolder>(
                Patients.class,
                R.layout.list_layout,
                PatientsViewHolder.class,
                mPatientDatabase
        ) {
            @Override
            protected void onBindViewHolder(@NonNull PatientsViewHolder holder, int position, @NonNull Patients model) {

                holder.setDetails(getApplicationContext(), model.getName(), model.getPicture());
            }

            @NonNull
            @Override
            public PatientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }
        };
        mResultList.setAdapter(firebaseRecyclerAdapter);
    }*/


    // View Holder Class

    public static class PatientsViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public PatientsViewHolder(@NonNull View itemView) {
            super(itemView);

            mView = itemView;
        }

        public void setDetails(Context ctx, String patientName, String patientPicture){
            TextView patient_name = (TextView) mView.findViewById(R.id.textViewName);
            ImageView patient_picture = (ImageView) mView.findViewById(R.id.imageViewPicture);

            patient_name.setText(patientName);

            Glide.with(ctx).load(patientPicture).into(patient_picture);

        }

    }
}