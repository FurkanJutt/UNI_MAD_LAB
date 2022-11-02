package com.UlBululStudios.mad_lab.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.UlBululStudios.mad_lab.R;

public class DetailFragment extends Fragment {

    private TextView tvBtnBackToCriminalList, detailText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View detailView = LayoutInflater.from(getContext()).inflate(R.layout.detail_fragment_design, container, false);

        detailText = detailView.findViewById(R.id.tv_fragment_detail);
        tvBtnBackToCriminalList = detailView.findViewById(R.id.tv_btn_back_to_criminal_list);

        if (getArguments() != null && getArguments().getString("ItemName") != null){
            detailText.setText(getArguments().getString("ItemName"));
        }

        tvBtnBackToCriminalList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fl_fragment_container, FragmentList.class, null)
                        .commit();
            }
        });

        return detailView;
    }
}
