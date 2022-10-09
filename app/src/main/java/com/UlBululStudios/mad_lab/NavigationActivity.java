package com.UlBululStudios.mad_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NavigationActivity extends AppCompatActivity {

    Button btnQuiz, btnTest, btnListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        btnQuiz = findViewById(R.id.btn_quiz);
        btnTest = findViewById(R.id.btn_test);
        btnListView = findViewById(R.id.btn_list_view);

        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listViewActivity = new Intent(NavigationActivity.this, ListViewActivity.class);
                startActivity(listViewActivity);
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