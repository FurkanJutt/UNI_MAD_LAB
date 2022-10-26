package com.UlBululStudios.mad_lab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View detailView = LayoutInflater.from(getContext()).inflate(R.layout.detail_fragment_design, container, false);

        TextView detailText = detailView.findViewById(R.id.tv_fragment_detail);

        if (getArguments() != null && getArguments().getString("ItemName") != null){
            detailText.setText(getArguments().getString("ItemName"));
        }

        return detailView;
    }

}
