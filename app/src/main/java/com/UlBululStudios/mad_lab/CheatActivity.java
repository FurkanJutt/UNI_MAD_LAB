package com.UlBululStudios.mad_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    Button btnCheatAnswer;
    TextView txtCheatText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        if (savedInstanceState != null) {
            return;
        }

        btnCheatAnswer = findViewById(R.id.btn_cheat_answer);
        txtCheatText = findViewById(R.id.tv_ans_cheat);

        btnCheatAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean ans = getIntent().getBooleanExtra("ansToQues", false);
                QuizActivity.DidStdCheat(true);
                if (ans)
                    txtCheatText.setText("Ans is Correct!");
                else
                    txtCheatText.setText("Ans is Wrong!");
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}