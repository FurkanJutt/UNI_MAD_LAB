package com.UlBululStudios.mad_lab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<AndroidVersions> versionsList;

    public CustomAdapter(Context context, ArrayList<AndroidVersions> versionsList){
        this.context = context;
        this.versionsList = versionsList;
    }

    @Override
    public int getCount() {
        if (versionsList != null && versionsList.size() > 0){
            return versionsList.size();
        }else{
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return versionsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_list, viewGroup, false);
        }

        ConstraintLayout itemListMainLayout = view.findViewById(R.id.item_list_main_layout);
        TextView tvVerName = view.findViewById(R.id.tv_version_name);
        TextView tvVerNumber = view.findViewById(R.id.tv_version_number);

        tvVerName.setText(versionsList.get(i).getVerName());
        tvVerNumber.setText("Version " + versionsList.get(i).getVerNumber());

        itemListMainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Clicked " + versionsList.get(i).getVerName(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
