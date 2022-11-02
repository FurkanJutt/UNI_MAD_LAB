package com.UlBululStudios.mad_lab.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.UlBululStudios.mad_lab.AndroidVersions;
import com.UlBululStudios.mad_lab.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentList extends Fragment {

    FragmentInterface fragmentInterface;
    List<Crimes> crimeList = new ArrayList<>();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            fragmentInterface = (FragmentInterface) context;
        }catch (ClassCastException castException){
            Log.e("ClassCastException", castException.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_list_design, container, false);

        for(int i=0; i<=25; i++){
            String[] verList = getResources().getStringArray(R.array.array_android_versions);
            Crimes crime = new Crimes();
            crime.setCrimeComited(verList[i]);
            crime.setIsSolved(false);
            crimeList.add(crime);
        }

        RecyclerView rvCrimeListView = fragmentView.findViewById(R.id.rv_fragment_list_view);
        rvCrimeListView.setLayoutManager(new LinearLayoutManager(fragmentView.getContext()));
        rvCrimeListView.setAdapter(new FragmentAdapter(crimeList));

        rvCrimeListView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                Toast.makeText(getContext(), "Clicked 1", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        rvCrimeListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strItemName = ((TextView) view).getText().toString();
                fragmentInterface.OnFragmentItemClick(strItemName);
                Toast.makeText(getContext(), "Clicked ", Toast.LENGTH_SHORT).show();
            }
        });

        return fragmentView;
    }
}
