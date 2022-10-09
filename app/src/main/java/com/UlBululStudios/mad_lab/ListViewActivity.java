package com.UlBululStudios.mad_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.lights.LightState;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {

    private ListView lvAndroidVersions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lvAndroidVersions = findViewById(R.id.lv_android_versions);

        ArrayAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, getResources().getStringArray(R.array.array_android_versions));
        lvAndroidVersions.setAdapter(listAdapter);
    }
}