package com.UlBululStudios.mad_lab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.hardware.lights.LightState;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private RecyclerView rvAndroidVersions;
    private List<AndroidVersions> androidVersionsList = new ArrayList<>();
    private Button btnShowList, btnAddToList;
    private EditText etAndroidName;

    ///////////////////////////////////////////
    private int currentIndex = 0;
    AndroidVersions version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        rvAndroidVersions = findViewById(R.id.rv_android_versions);
        btnShowList = findViewById(R.id.btn_show_list);
        btnAddToList = findViewById(R.id.btn_add_to_list);
        etAndroidName = findViewById(R.id.et_version_name);

        btnAddToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                version = new AndroidVersions();
                version.setVerName(etAndroidName.getText().toString()+currentIndex);
                version.setVerNumber("4.1");
                //for(int i =0;i<=currentIndex;i++){


                    androidVersionsList.add(version);
                //}
                btnShowList.setText(String.valueOf(currentIndex));
                currentIndex++;

            }
        });

        rvAndroidVersions.setLayoutManager(new LinearLayoutManager(this));
        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rvAndroidVersions.setAdapter(new CustomAdapter(androidVersionsList));
            }
        });

    }

    private List<AndroidVersions> getAndroidVersion() {
        String[] verList = getResources().getStringArray(R.array.array_android_versions);
        AndroidVersions version = new AndroidVersions();
        version.setVerName(verList[0]);
        version.setVerNumber("4.1");
        AndroidVersions version1 = new AndroidVersions();
        version1.setVerName(verList[1]);
        version1.setVerNumber("4.2");

        AndroidVersions version2 = new AndroidVersions();
        version2.setVerName(verList[2]);
        version2.setVerNumber("4.4");

        AndroidVersions version3 = new AndroidVersions();
        version3.setVerName(verList[3]);
        version3.setVerNumber("5.0");

        AndroidVersions version4 = new AndroidVersions();
        version4.setVerName(verList[4]);
        version4.setVerNumber("6.0");

        AndroidVersions version5 = new AndroidVersions();
        version5.setVerName(verList[5]);
        version5.setVerNumber("7.0");

        AndroidVersions version6 = new AndroidVersions();
        version6.setVerName(verList[6]);
        version6.setVerNumber("7.1");

        AndroidVersions version7 = new AndroidVersions();
        version7.setVerName(verList[7]);
        version7.setVerNumber("8.0");

        AndroidVersions version8 = new AndroidVersions();
        version8.setVerName(verList[8]);
        version8.setVerNumber("8.0");

        AndroidVersions version9 = new AndroidVersions();
        version9.setVerName(verList[9]);
        version9.setVerNumber("9.0");

        AndroidVersions version10 = new AndroidVersions();
        version10.setVerName(verList[10]);
        version10.setVerNumber("10");

        AndroidVersions version11 = new AndroidVersions();
        version11.setVerName(verList[11]);
        version11.setVerNumber("11");

        //List<AndroidVersions> arrayList = new ArrayList<>();
        androidVersionsList.add(version);
        androidVersionsList.add(version1);
        androidVersionsList.add(version2);
        androidVersionsList.add(version3);
        androidVersionsList.add(version4);
        androidVersionsList.add(version5);
        androidVersionsList.add(version6);
        androidVersionsList.add(version7);
        androidVersionsList.add(version8);
        androidVersionsList.add(version9);
        androidVersionsList.add(version10);
        androidVersionsList.add(version11);
        androidVersionsList.add(version);
        androidVersionsList.add(version1);
        androidVersionsList.add(version2);
        androidVersionsList.add(version3);
        androidVersionsList.add(version4);
        androidVersionsList.add(version5);
        androidVersionsList.add(version6);
        androidVersionsList.add(version7);
        androidVersionsList.add(version8);
        androidVersionsList.add(version9);
        androidVersionsList.add(version10);
        androidVersionsList.add(version11);
        return androidVersionsList;
    }
}