package com.UlBululStudios.mad_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.lights.LightState;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    private ListView lvAndroidVersions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lvAndroidVersions = findViewById(R.id.lv_android_versions);

        CustomAdapter customAdapter = new CustomAdapter(this, getAndroidVersion());
        lvAndroidVersions.setAdapter(customAdapter);

        /*ArrayAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, getResources().getStringArray(R.array.array_android_versions));
        lvAndroidVersions.setAdapter(listAdapter);*/
    }

    private ArrayList<AndroidVersions> getAndroidVersion() {
        String[] verList = getResources().getStringArray(R.array.array_android_versions);
        AndroidVersions version = new AndroidVersions();
        version.setVerName(verList[0]);
        version.setVerNumber(4.1);
        AndroidVersions version1 = new AndroidVersions();
        version1.setVerName(verList[1]);
        version1.setVerNumber(4.2);

        AndroidVersions version2 = new AndroidVersions();
        version2.setVerName(verList[2]);
        version2.setVerNumber(4.4);

        AndroidVersions version3 = new AndroidVersions();
        version3.setVerName(verList[3]);
        version3.setVerNumber(5.0);

        AndroidVersions version4 = new AndroidVersions();
        version4.setVerName(verList[4]);
        version4.setVerNumber(6.0);

        AndroidVersions version5 = new AndroidVersions();
        version5.setVerName(verList[5]);
        version5.setVerNumber(7.0);

        AndroidVersions version6 = new AndroidVersions();
        version6.setVerName(verList[6]);
        version6.setVerNumber(7.1);

        AndroidVersions version7 = new AndroidVersions();
        version7.setVerName(verList[7]);
        version7.setVerNumber(8.0);

        AndroidVersions version8 = new AndroidVersions();
        version8.setVerName(verList[8]);
        version8.setVerNumber(8.0);

        AndroidVersions version9 = new AndroidVersions();
        version9.setVerName(verList[9]);
        version9.setVerNumber(9.0);

        AndroidVersions version10 = new AndroidVersions();
        version10.setVerName(verList[10]);
        version10.setVerNumber(10);

        AndroidVersions version11 = new AndroidVersions();
        version11.setVerName(verList[11]);
        version11.setVerNumber(11);

        ArrayList<AndroidVersions> arrayList = new ArrayList<>();
        arrayList.add(version);
        arrayList.add(version1);
        arrayList.add(version2);
        arrayList.add(version3);
        arrayList.add(version4);
        arrayList.add(version5);
        arrayList.add(version6);
        arrayList.add(version7);
        arrayList.add(version8);
        arrayList.add(version9);
        arrayList.add(version10);
        arrayList.add(version11);
        arrayList.add(version);
        arrayList.add(version1);
        arrayList.add(version2);
        arrayList.add(version3);
        arrayList.add(version4);
        arrayList.add(version5);
        arrayList.add(version6);
        arrayList.add(version7);
        arrayList.add(version8);
        arrayList.add(version9);
        arrayList.add(version10);
        arrayList.add(version11);
        return arrayList;
    }
}