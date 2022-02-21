package com.example.androidlogin;

//This class will mimic the variable naming on the firebase data bases
public class Patient {

    public String Name, DOB, Gender;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public Patient(String Name, String DOB, String Gender) {
        this.Name = Name;
        this.DOB = DOB;
        this.Gender = Gender;
    }
}

