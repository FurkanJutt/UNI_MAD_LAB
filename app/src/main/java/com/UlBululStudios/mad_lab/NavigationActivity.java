package com.UlBululStudios.mad_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.UlBululStudios.mad_lab.Fragments.FragmentActivity;

import java.util.Locale;

public class NavigationActivity extends AppCompatActivity {

    Button btnQuiz, btnTest, btnListView, btnFragmentListView;
    TextView tvLblUsername;

    private void InitializeViews() {
        btnQuiz = findViewById(R.id.btn_quiz);
        btnTest = findViewById(R.id.btn_test);
        btnListView = findViewById(R.id.btn_list_view);
        tvLblUsername = findViewById(R.id.tv_lbl_username);
        btnFragmentListView = findViewById(R.id.btn_fragment_list_view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        InitializeViews();

        String strUsername = getIntent().getStringExtra("lUsername");
        if(strUsername!=null) {
            tvLblUsername.append(strUsername.toUpperCase(Locale.ROOT));
        }

        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listViewActivity = new Intent(NavigationActivity.this, ListViewActivity.class);
                startActivity(listViewActivity);
            }
        });

        btnFragmentListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fragmentActivity = new Intent(NavigationActivity.this, FragmentActivity.class);
                startActivity(fragmentActivity);
            }
        });

        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent quizActivity = new Intent(NavigationActivity.this, QuizActivity.class);
                startActivity(quizActivity);
            }
        });

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent testActivity = new Intent(NavigationActivity.this, TestActivity.class);
                startActivity(testActivity);
            }
        });

    }


}