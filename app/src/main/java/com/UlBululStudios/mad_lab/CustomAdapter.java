package com.UlBululStudios.mad_lab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomHolder> {

    private List<AndroidVersions> versionsList;

    public CustomAdapter(List<AndroidVersions> versionsList) {
        this.versionsList = versionsList;
    }

    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new CustomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int position) {
        AndroidVersions android = versionsList.get(position);
        holder.tvAndroidName.setText(android.getVerName());
        holder.tvAndroidVer.setText(android.getVerNumber());
    }

    @Override
    public int getItemCount() {
        return versionsList.size();
    }
}

class CustomHolder extends RecyclerView.ViewHolder {

    TextView tvAndroidName, tvAndroidVer;

    public CustomHolder(@NonNull View itemView) {
        super(itemView);

        tvAndroidName = itemView.findViewById(R.id.tv_version_name);
        tvAndroidVer = itemView.findViewById(R.id.tv_version_number);
    }
}
