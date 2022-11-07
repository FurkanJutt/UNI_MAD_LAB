package com.UlBululStudios.mad_lab.Fragments;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.UlBululStudios.mad_lab.R;

import java.util.List;

public class FragmentAdapter extends RecyclerView.Adapter<FragmentHolder> {

    private FragmentInterface fragmentInterface;
    private List<Crimes> crimeList;
    private Crimes crime;

    public FragmentAdapter(List<Crimes> crimeList) {
        if(crimeList != null)
            this.crimeList = crimeList;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        try {
            fragmentInterface = (FragmentInterface) recyclerView.getContext();
        }catch (ClassCastException castException){
            Log.e("ClassCastException", castException.toString());
        }
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
            crime = crimeList.get(position);
            holder.tvCrime.setText(crime.getCrimeComited());
            holder.cbCrimeIsSolved.setChecked(Crimes._getInstance().getIsSolved());

            holder.crimeListMainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    holder.crimeListMainLayout.setBackgroundColor(Color.argb(81, 217, 217, 217));
                    fragmentInterface.OnFragmentItemClick(holder.tvCrime.getText().toString());
                }
            });
        }
    }

    /*public void SetCrimeIsSolved(Boolean isSolved){
        crime.setIsSolved(isSolved);
    }*/

    @Override
    public int getItemCount() {
        return crimeList.size();
    }
}

class FragmentHolder extends RecyclerView.ViewHolder{

    protected TextView tvCrime;
    protected CheckBox cbCrimeIsSolved;
    protected ConstraintLayout crimeListMainLayout;

    public FragmentHolder(@NonNull View itemView) {
        super(itemView);

        tvCrime = itemView.findViewById(R.id.tv_crime);
        cbCrimeIsSolved = itemView.findViewById(R.id.cb_crime_is_solved);
        crimeListMainLayout = itemView.findViewById(R.id.crime_list_main_layout);
    }
}