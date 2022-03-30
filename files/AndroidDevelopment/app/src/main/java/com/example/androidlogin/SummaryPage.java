package com.example.androidlogin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidlogin.R;

public class SummaryPage extends AppCompatActivity implements View.OnClickListener{
    //Define all text inputs and buttons in the front-end
    EditText patientId;
    EditText ScenarioId;
    Button viewScenario;

    //firebase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario_summary_page);

        //Connect UI elements to corresponding defined variables
        patientId = findViewById(R.id.editTextPatientId);
        ScenarioId = findViewById(R.id.editTextScenarioId);
        viewScenario = findViewById(R.id.viewScenarioBttn);
        viewScenario.setOnClickListener(this);



    }


    //When a button is pressed...
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.viewScenarioBttn:
                showinfo();
                break;
        }
    }

    // Shows the summary of the users page
    private void showinfo() {
    }

}


