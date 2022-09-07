package com.UlBululStudios.mad_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Questions[] questions = new Questions[] {
            new Questions(R.string.q_1, false),
            new Questions(R.string.q_2, false),
            new Questions(R.string.q_3, true),
            new Questions(R.string.q_4, false),
            new Questions(R.string.q_5, true),
    };

    private TextView tvQuestion;
    private Button btnWrong, btnCorrect, btnPrev, btnNext;

    private int currentIndex = 0;
    boolean selectedAnswer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // initializing variables with views

        tvQuestion = findViewById(R.id.tv_question);
        btnWrong = findViewById(R.id.btn_wrong);
        btnCorrect = findViewById(R.id.btn_correct);
        btnPrev = findViewById(R.id.btn_prev);
        btnNext = findViewById(R.id.btn_next);

        // end of initializing

        int question = questions[currentIndex].getQuestionId();
        tvQuestion.setText(question);



        btnWrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = false;
            }
        });

        btnCorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = true;
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValidateAnswer(selectedAnswer);
                currentIndex = (currentIndex+1) % questions.length;
                int question = questions[currentIndex].getQuestionId();
                tvQuestion.setText(question);
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValidateAnswer(selectedAnswer);
                currentIndex = (currentIndex-1) % questions.length;
                int question = questions[currentIndex].getQuestionId();
                tvQuestion.setText(question);
            }
        });
    }

    private void ValidateAnswer(boolean ans){
        boolean answer = questions[currentIndex].getAnswer();

        String floatingAnswer;

        if (ans == answer){
            floatingAnswer = "Answer is Correct!";
        }else{
            floatingAnswer = "Answer is InCorrect!";
        }

        Toast.makeText(this, floatingAnswer, Toast.LENGTH_SHORT).show();
    }
}