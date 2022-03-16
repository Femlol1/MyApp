package com.example.androidlogin;

import java.util.ArrayList;

public class Scenario {

    private String patientUID;
    private String Allergy;
    private String smokingHabit;
    private String consumptionHabit;
    private Diagnosis Diagnoses;
    private Treatment Treatments;
    private Symptom Symptoms;

    public Scenario () {};

    public String getPatient() {
        return patientUID;
    }

    public void setPatient(String patient) {
        this.patientUID = patient;
    }

    public String getAllergy() {
        return Allergy;
    }

    public void setAllergy(String allergy) {
        Allergy = allergy;
    }

    public String getSmokingHabit() {
        return smokingHabit;
    }

    public void setSmokingHabit(String smokingHabit) {
        this.smokingHabit = smokingHabit;
    }

    public String getConsumptionHabit() {
        return consumptionHabit;
    }

    public void setConsumptionHabit(String consumptionHabit) {
        this.consumptionHabit = consumptionHabit;
    }

    public Diagnosis getDiagnoses() {
        return Diagnoses;
    }

    public void setDiagnoses(Diagnosis diagnoses) {
        Diagnoses = diagnoses;
    }

    public Treatment getTreatments() {
        return Treatments;
    }

    public void setTreatments(Treatment treatments) {
        Treatments = treatments;
    }

    public Symptom getSymptoms() {
        return Symptoms;
    }

    public void setSymptoms(Symptom symptoms) {
        Symptoms = symptoms;
    }
}
