package com.example.androidlogin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.PatientViewHolder> {

    Context context;
    ArrayList<Patient> list;

    public PatientAdapter(Context context, ArrayList<Patient> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PatientAdapter.PatientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.patient_view_item,parent,false);
        return new PatientViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientAdapter.PatientViewHolder holder, int position) {
        Patient patient = list.get(position);
        holder.name.setText(patient.getName());
        holder.dob.setText(patient.getDob());
        holder.gender.setText(patient.getGender());
        holder.tv4.setText(patient.getAddress());
        holder.tv5.setText(patient.getRace());
        holder.tv6.setText(patient.getOccupationalHistory());
        holder.tv7.setText(patient.getHospital());
        holder.tv8.setText(patient.getIdAndNo());
        holder.tv9.setText(patient.getNextOfKin());
        holder.tv10.setText(patient.getNextOfKinAddress());
        holder.tv11.setText(patient.getProfessionalTraining());
        holder.tv12.setText(patient.getRecentSourceOfFood());
        holder.tv13.setText(patient.getRecentSourceOfWater());
        holder.tv14.setText(patient.getRecentSanitationSystem());
        holder.tv15.setText(patient.getRegDate());
        holder.tv16.setText(patient.getTrainingHistory());
        holder.tv17.setText(patient.getClan());
        holder.tv18.setText(patient.getTotem());
        holder.tv19.setText(patient.getTribe());
        holder.tv20.setText(patient.getMaritalStatus());
        holder.tv21.setText(patient.getWeatherTransition());
        holder.tv22.setText(patient.getLongTermEnvironmentExposure());
        holder.tv23.setText(patient.getEndemicDiseaseRegion());
        holder.tv24.setText(patient.getDiseaseVectors());
        holder.tv25.setText(patient.getCommunicableDiseaseContact());
        holder.tv26.setText(patient.getAmbientTemperature());
        holder.tv27.setText(patient.getRelativeHumidity());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class PatientViewHolder extends RecyclerView.ViewHolder{

        TextView name, dob, gender, tv4, tv5, tv6, tv7, tv8, tv9, tv10, tv11,
                tv12, tv13, tv14, tv15, tv16, tv17, tv18, tv19, tv20, tv21,
                tv22, tv23, tv24, tv25, tv26, tv27;

        public PatientViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textViewName);
            dob = itemView.findViewById(R.id.textViewDOB);
            gender = itemView.findViewById(R.id.textViewGender);
            tv4 = itemView.findViewById(R.id.textView4);
            tv5 = itemView.findViewById(R.id.textView5);
            tv6 = itemView.findViewById(R.id.textView6);
            tv7 = itemView.findViewById(R.id.textView7);
            tv8 = itemView.findViewById(R.id.textView8);
            tv9 = itemView.findViewById(R.id.textView9);
            tv10 = itemView.findViewById(R.id.textView10);
            tv11 = itemView.findViewById(R.id.textView11);
            tv12 = itemView.findViewById(R.id.textView12);
            tv13 = itemView.findViewById(R.id.textView13);
            tv14 = itemView.findViewById(R.id.textView14);
            tv15 = itemView.findViewById(R.id.textView15);
            tv16 = itemView.findViewById(R.id.textView16);
            tv17 = itemView.findViewById(R.id.textView17);
            tv18 = itemView.findViewById(R.id.textView18);
            tv19 = itemView.findViewById(R.id.textView19);
            tv20 = itemView.findViewById(R.id.textView20);
            tv21 = itemView.findViewById(R.id.textView21);
            tv22 = itemView.findViewById(R.id.textView22);
            tv23 = itemView.findViewById(R.id.textView23);
            tv24 = itemView.findViewById(R.id.textView24);
            tv25 = itemView.findViewById(R.id.textView25);
            tv26 = itemView.findViewById(R.id.textView26);
            tv27 = itemView.findViewById(R.id.textView27);
        }
    }
}
