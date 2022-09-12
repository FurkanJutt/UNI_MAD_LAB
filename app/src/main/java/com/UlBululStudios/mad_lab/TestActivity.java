package com.UlBululStudios.mad_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {

    private TextView tvRollNum;
    private Button btnButton6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRollNum = findViewById(R.id.tv_roll_num);
        btnButton6 = findViewById(R.id.btn_button6);

        btnButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TestActivity.this, tvRollNum.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}