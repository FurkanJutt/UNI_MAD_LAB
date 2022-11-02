package com.UlBululStudios.mad_lab.Fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.UlBululStudios.mad_lab.R;

import java.util.List;

public class FragmentAdapter extends RecyclerView.Adapter<FragmentHolder> {

    List<Crimes> crimeList;

    public FragmentAdapter(List<Crimes> crimeList) {
        if(crimeList != null)
            this.crimeList = crimeList;
    }

    @NonNull
    @Override
    public FragmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crime_list_design, parent, false);
        return new FragmentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentHolder holder, int position) {
        if(crimeList != null){
            Crimes crime = crimeList.get(position);
            holder.tvCrime.setText(crime.getCrimeComited());
            holder.cbCrimeIsSolved.setChecked(crime.getIsSolved());
        }
    }

    @Override
    public int getItemCount() {
        return crimeList.size();
    }
}

class FragmentHolder extends RecyclerView.ViewHolder{

    protected TextView tvCrime;
    protected CheckBox cbCrimeIsSolved;

    public FragmentHolder(@NonNull View itemView) {
        super(itemView);

        tvCrime = itemView.findViewById(R.id.tv_crime);
        cbCrimeIsSolved = itemView.findViewById(R.id.cb_crime_is_solved);
    }
}