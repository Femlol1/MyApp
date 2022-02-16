package com.example.androidlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SelectPatient extends AppCompatActivity {

    private EditText searchPatient, mSearchField;
    private Button searchButton, mSearchBtn;
    private RecyclerView resultList;

    private DatabaseReference mPatientsDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_patient);

        mPatientsDatabase = FirebaseDatabase.getInstance().getReference("Patients");

        searchPatient = (EditText) findViewById(R.id.editTextSearchPatient);
        searchButton = (Button) findViewById(R.id.buttonSearch);
        resultList = (RecyclerView) findViewById(R.id.recyclerViewResultList);

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
                mPatientsDatabase
        ) {
            @Override
            protected void pupulateViewHolder(PatientsViewHolder viewHolder, Patients model, int position){

                viewHolder.setDetails(model.getName(), model.getPicture());

            }
        };
    }


    // View Holder Class

    public class PatientsViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public PatientsViewHolder(@NonNull View itemView) {
            super(itemView);

            mView = itemView;
        }

        public void setDetails(String patientName, String patientPicture){
            TextView patient_name = (TextView) mView.findViewById(R.id.textViewName);
            ImageView patient_picture = (ImageView) mView.findViewById(R.id.imageViewPicture);

            patient_name.setText(patientName);

        }

    }
}