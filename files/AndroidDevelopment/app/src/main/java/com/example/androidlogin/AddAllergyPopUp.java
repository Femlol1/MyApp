package com.example.androidlogin;

import static com.example.androidlogin.AddScenarioDetails.scenario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddAllergyPopUp extends AppCompatActivity implements View.OnClickListener{

    EditText inputAllergy;
    Button btnAddAllergy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addallergieswindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .6));

        inputAllergy = findViewById(R.id.editTextAllergy);

        btnAddAllergy = findViewById(R.id.btnAddAllergy);
        btnAddAllergy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnAddAllergy:
                validate();
                break;

        }
    }

    private void validate() {
        String allergy = inputAllergy.getText().toString().trim();
        scenario.getAllergy().add(allergy);
        System.out.println(scenario.getAllergy());
        //startActivity(new Intent(AddAllergyPopUp.this, AddScenarioDetails.class));

        finish();
        Toast.makeText(AddAllergyPopUp.this, "Allergy added!", Toast.LENGTH_LONG).show();
    }
}
