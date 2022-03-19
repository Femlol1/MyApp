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

public class Patient_View_Activity extends AppCompatActivity {
    TextView Name, Date_of_birth, Gender, Marital_status, Registration_date, Id_type_and_number, Address, Hospital, Next_of_kin, Next_of_kin_address;
    Button showbutton, nxtbutton, bckbutton;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientview);

        Name = (TextView) findViewById(R.id.nameview);
        Date_of_birth = (TextView) findViewById(R.id.dobview);
        Gender = (TextView) findViewById(R.id.genderview);
        Marital_status = (TextView) findViewById(R.id.mstatusview);
        Registration_date = (TextView) findViewById(R.id.rdateview);
        Id_type_and_number = (TextView) findViewById(R.id.idview);
        Address = (TextView) findViewById(R.id.addressview);
        Hospital = (TextView) findViewById(R.id.hospitalview);
        Next_of_kin = (TextView) findViewById(R.id.nokview);
        Next_of_kin_address = (TextView) findViewById(R.id.nokaview);
        showbutton = (Button) findViewById(R.id.button);
        nxtbutton = (Button) findViewById(R.id.nxtbutton);
        bckbutton = (Button) findViewById(R.id.bckbutton);

//        showbutton.setOnClickListener((View.OnClickListener) this);
//        nxtbutton.setOnClickListener((View.OnClickListener) this);
//        bckbutton.setOnClickListener((View.OnClickListener) this);



//            @Override
//            public void onClick(View view) {
//                switch (v.getId()) {
//                    case R.id.nxtbutton:
//                        nextButton();
//                        break;
               nxtbutton.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       startActivity(new Intent(Patient_View_Activity.this, Patient_View_Activity2.class));;
                       Toast.makeText(Patient_View_Activity.this, "Next Page", Toast.LENGTH_SHORT).show();
                   }
               });
               bckbutton.setOnClickListener(new View.OnClickListener() {
                   @Override
                    public void onClick(View view) {
                    startActivity(new Intent(Patient_View_Activity.this, MainActivity.class));;
                    Toast.makeText(Patient_View_Activity.this, "Main Page", Toast.LENGTH_SHORT).show();
                }
            });

                showbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        reff = FirebaseDatabase.getInstance().getReference().child("Patients").child("-MwRF1xWUMZgj0yfbmhX");
                        reff.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                String name = dataSnapshot.child("name").getValue().toString();
                                String gender = dataSnapshot.child("gender").getValue().toString();
                                String dob = dataSnapshot.child("dob").getValue().toString();
                                String marital_status = dataSnapshot.child("maritalStatus").getValue().toString();
                                String regDate = dataSnapshot.child("regDate").getValue().toString();
                                String idAndNo = dataSnapshot.child("idAndNo").getValue().toString();
                                String address = dataSnapshot.child("address").getValue().toString();
                                String hospital = dataSnapshot.child("hospital").getValue().toString();
                                String nextOfKin = dataSnapshot.child("nextOfKin").getValue().toString();
                                String nextOfKinAddress = dataSnapshot.child("nextOfKin").getValue().toString();
                                Name.setText(name);
                                Date_of_birth.setText(dob);
                                Gender.setText(gender);
                                Marital_status.setText(marital_status);
                                Registration_date.setText(regDate);
                                Id_type_and_number.setText(idAndNo);
                                Address.setText(address);
                                Hospital.setText(hospital);
                                Next_of_kin.setText(nextOfKin);
                                Next_of_kin_address.setText(nextOfKinAddress);

                            }





                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

                    }
                });


            }



}
