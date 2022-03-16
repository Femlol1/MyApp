package com.example.androidlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Vector;

public class AddScenarioSearch extends AppCompatActivity {

    private EditText PatientSearch;
    private ImageButton SearchButton;

    //private RecyclerView ResultsList;
    private FirebaseRecyclerAdapter<Patient, PatientsViewHolder> patientRVAdapter;

    DatabaseReference PatientDatabase;
    private AutoCompleteTextView txtSearch;
    private RecyclerView listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assearch);

        PatientSearch = findViewById(R.id.editTextPatientName);
        //ResultsList = findViewById(R.id.results_list);

        PatientDatabase = FirebaseDatabase.getInstance().getReference("Patients");
        txtSearch = findViewById(R.id.editTextPatientName);
        listData = findViewById(R.id.listData);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        listData.setLayoutManager(layoutManager);


        populateSearch();

    }

    private void populateSearch() {
        ValueEventListener eventListener= new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {

                    ArrayList<String> names = new ArrayList<>();
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        String n = ds.child("name").getValue(String.class);
                        names.add(n);
                    }

                    ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, names);
                    txtSearch.setAdapter(adapter);
                    txtSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            String selection=adapterView.getItemAtPosition(i).toString();
                            getPatients(selection);
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        PatientDatabase.addListenerForSingleValueEvent(eventListener);
    }

    private void getPatients(String selection) {
        Query query = PatientDatabase.orderByChild("name").equalTo(selection);
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){

                    ArrayList<PatientInfo> patientInfos = new ArrayList<>();
                    for(DataSnapshot ds:snapshot.getChildren())
                    {
                        PatientInfo patientInfo = new PatientInfo(ds.child("name").getValue(String.class)
                        ,ds.child("dob").getValue(String.class),ds.getKey());
                        patientInfos.add(patientInfo);
                    }
                    CustomAdapter adapter = new CustomAdapter(patientInfos, AddScenarioSearch.this);
                    listData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        query.addListenerForSingleValueEvent(eventListener);
    }
    class PatientInfo
    {

        public String getName(){
            return name;
        }

        public String getDob(){
            return dob;
        }

        public String getKey(){
            return key;
        }

        public String name;
        public String dob;
        public String key;

        public PatientInfo(String name, String dob, String key) {
            this.name = name;
            this.dob = dob;
            this.key = key;
        }
    }

    //View holder class
    public class PatientsViewHolder extends RecyclerView.ViewHolder {

        View view;

        public PatientsViewHolder(@NonNull View itemView) {
            super(itemView);

            view = itemView;

        }

    }

    public static class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

        private ArrayList<PatientInfo> localDataSet;
        private Context context;

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView name;
            TextView dob;

            public ViewHolder(View view) {
                super(view);
                // Define click listener for the ViewHolder's View

                name = view.findViewById(R.id.Name);
                dob = view.findViewById(R.id.dob);
            }

        }

        /**
         * Initialize the dataset of the Adapter.
         *
         * @param dataSet String[] containing the data to populate views to be used
         * by RecyclerView.
         */
        public CustomAdapter(ArrayList<PatientInfo> dataSet, Context context) {
            this.localDataSet = dataSet;
            this.context = context;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
            View view = layoutInflater.inflate(R.layout.row_style,viewGroup,false);
            return new ViewHolder(view);
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            PatientInfo thisPatient = localDataSet.get(position);
            viewHolder.name.setText(thisPatient.getName());
            viewHolder.dob.setText(thisPatient.getDob());
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,AddScenarioDetails.class);
                    intent.putExtra("key", thisPatient.getKey());
                    context.startActivity(intent);
                }
            });
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return localDataSet.size();
        }
    }

}