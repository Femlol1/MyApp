package com.example.androidlogin;

//This class will mimic the variable naming on the firebase data bases
public class Patients {

    public String Name, Picture;

    public Patients() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        this.Picture = picture;
    }

    public Patients(String Name, String Picture) {
        this.Name = Name;
        this.Picture = Picture;
    }
}

