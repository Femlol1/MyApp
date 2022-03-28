package com.example.androidlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.EventLogTags;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StartScenario extends AppCompatActivity {

    private TextView Allergies, SmokingHistory, AlxhoholConsunptionHistory, PostDiagnosis,PostTreatmment,Symptoms, symptomYetToReveal;
    private EditText diagnosisInput;
    private Button btnRevealSymptom, btnTreatPatient;
    private DatabaseReference scenarioRef;
    private Integer totalSymptoms;
    private Integer clickCount = 0;

    private RecyclerView symptomList;

    ArrayList<Symptom> scenarioSymptoms = new ArrayList<>();
    ArrayList<String> userDiagnosisInputs = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_scenario);

        symptomYetToReveal = findViewById(R.id.symptomCount);

        Allergies = findViewById(R.id.allergiesView);
        SmokingHistory = findViewById(R.id.smokingHistoryView);
        AlxhoholConsunptionHistory = findViewById(R.id.alchoholConsumptionHistoryView);
        PostDiagnosis = findViewById(R.id.pDiagnosisView);
        PostTreatmment = findViewById(R.id.pTreatmentView);
        diagnosisInput = findViewById(R.id.editTextEnterDiagnosis);
        //Symptoms = (TextView) findViewById(R.id.textsymptomexplanation);

        //Create a linear layout manager which can create multiple views/screens linearly.
        //The content of recycler view is set to the manager to allow multiple mini screens
        //in the form of search results to appear

        //Connect the RecyclerView element to the back-end
        symptomList = findViewById(R.id.recyclerViewSS);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        symptomList.setLayoutManager(layoutManager);

        //Get the intent passed from StartScenarioSearch.java class
        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        System.out.println(key);

        btnRevealSymptom = (Button) findViewById(R.id.buttonRevealSymptom);
        btnTreatPatient = (Button) findViewById(R.id.buttonTreatPatient);


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

                        String allergies="None", smokingHistory="None", alcohol="None", pdiagnosisDate="None", pdiagnosisName = "None", ptreatmentDate="None", ptreatmentName="None", symptom="None";

                        totalSymptoms = (int) dataSnapshot.child("symptoms").getChildrenCount();
                        System.out.println("There are "+totalSymptoms+" symptoms");

                        if (clickCount < totalSymptoms){
                            Symptom aSymptom;
                            aSymptom = new Symptom();

                            aSymptom.setSymptomType(dataSnapshot.child("symptoms").child(Integer.toString(clickCount)).child("symptomType").getValue().toString());
                            aSymptom.setDesc(dataSnapshot.child("symptoms").child(Integer.toString(clickCount)).child("desc").getValue().toString());
                            scenarioSymptoms.add(aSymptom);

                            System.out.println(scenarioSymptoms);
                        }
                        clickCount += 1;

                        if (!(dataSnapshot.child("allergy").getValue() == null)){
                            allergies = dataSnapshot.child("allergy").getValue().toString();
                        }

                        if (!(dataSnapshot.child("smokingHabit").getValue() == null)){
                            smokingHistory = dataSnapshot.child("smokingHabit").getValue().toString();
                        }

                        if (!(dataSnapshot.child("consumptionHabit").getValue() == null)){
                            alcohol = dataSnapshot.child("consumptionHabit").getValue().toString();
                        }

                        String diagnoses = "";
                        if (!(dataSnapshot.child("diagnoses").getValue() == null)){
                            int totalDiagnoses = (int) dataSnapshot.child("diagnoses").getChildrenCount();


                            for (int i=0; i<totalDiagnoses; i++) {
                                pdiagnosisDate = dataSnapshot.child("diagnoses").child(Integer.toString(i)).child("date").getValue().toString();
                                pdiagnosisName = dataSnapshot.child("diagnoses").child(Integer.toString(i)).child("name").getValue().toString();
                                System.out.println(pdiagnosisDate+"    "+pdiagnosisName);
                                diagnoses = diagnoses + "Diagnosis:- \nDate: " + pdiagnosisDate + "\nDiagnosis: " +pdiagnosisName+"\n\n";
                            }
                        }

                        String treatments = "";
                        if (!(dataSnapshot.child("treatments").getValue() == null)){

                            int totalTreatments = (int) dataSnapshot.child("treatments").getChildrenCount();


                            for (int i=0; i<totalTreatments; i++) {
                                ptreatmentDate = dataSnapshot.child("treatments").child(Integer.toString(i)).child("date").getValue().toString();
                                ptreatmentName = dataSnapshot.child("treatments").child(Integer.toString(i)).child("name").getValue().toString();
                                treatments = treatments + "Treatment:- \nDate: " + ptreatmentDate + "\n Description: " +ptreatmentName+"\n\n";
                            }
                        }

                        Allergies.setText(allergies);
                        SmokingHistory.setText(smokingHistory);
                        AlxhoholConsunptionHistory.setText(alcohol);
                        PostDiagnosis.setText(diagnoses);
                        PostTreatmment.setText(treatments);
                        String diagnosisAtAStep = diagnosisInput.getText().toString().trim();

                        userDiagnosisInputs.add(diagnosisAtAStep);
                        System.out.println(userDiagnosisInputs);



                        if (totalSymptoms == 0 || (totalSymptoms-clickCount <= 0)) {
                            symptomYetToReveal.setText("* No symptoms left to reveal, click on 'Treat Patient'");
                            btnRevealSymptom.setClickable(false);
                            btnRevealSymptom.setBackgroundColor(Color.parseColor("#939997"));
                        }
                        else {
                            symptomYetToReveal.setText("* " + Integer.toString(totalSymptoms - clickCount) + " symptom(s) yet to be revealed");
                        }
                        CustomAdapter adapter = new CustomAdapter(scenarioSymptoms, StartScenario.this);
                        symptomList.setAdapter(adapter);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });




    }

    //Create a patient info class to get attribute information from patient objects in the database
    class SymptomInfo
    {

        public String getType(){
            return type;
        }

        public String getDescription(){
            return description;
        }

        public String getKey(){
            return key;
        }

        public String type;
        public String description;
        public String key;

        public SymptomInfo(String type, String description, String key) {
            this.type = type;
            this.description = description;
            this.key = key;
        }
    }

    //Create adapter to display the search results of the clicked option in a row layout
    public static class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

        private ArrayList<Symptom> localDataSet;
        private Context context;

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView symptomNo, symptomType;
            TextView symptomDescription;

            public ViewHolder(View view) {
                super(view);
                // Define click listener for the ViewHolder's View

                symptomNo = view.findViewById(R.id.textViewStepNo);
                symptomType = view.findViewById(R.id.textViewSSTypeData);
                symptomDescription = view.findViewById(R.id.textViewSSDescData);

            }

        }

        /**
         * Initialize the dataset of the Adapter.
         *
         * @param dataSet String[] containing the data to populate views to be used
         * by RecyclerView.
         */
        public CustomAdapter(ArrayList<Symptom> dataSet, Context context) {
            this.localDataSet = dataSet;
            this.context = context;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
            View view = layoutInflater.inflate(R.layout.row_style_ss_symptom_info,viewGroup,false);
            return new CustomAdapter.ViewHolder(view);
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(CustomAdapter.ViewHolder viewHolder, final int position) {


            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            Symptom thisSymptom = localDataSet.get(position);
            viewHolder.symptomNo.setText("Symptom");
            viewHolder.symptomType.setText(thisSymptom.getSymptomType());
            viewHolder.symptomDescription.setText(thisSymptom.getDesc());

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return localDataSet.size();
        }
    }



}