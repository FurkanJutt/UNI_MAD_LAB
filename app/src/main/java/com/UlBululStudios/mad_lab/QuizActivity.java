package com.UlBululStudios.mad_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Log;
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

    private TextView tvQuestion, tvQuestionHeading;
    private Button btnWrong, btnCorrect, btnPrev, btnNext;

    private int currentIndex = 0;
    boolean selectedAnswer = false;

    public static final String KEY = "Index_Key";

    int clickCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        if (savedInstanceState != null) {
            Log.d("QuizActivity:", "Saved Instance Called");
            currentIndex = savedInstanceState.getInt(KEY, 0);
        }

        // initializing variables with views

        tvQuestion = findViewById(R.id.tv_question);
        tvQuestionHeading = findViewById(R.id.tv_question_heading);
        btnWrong = findViewById(R.id.btn_wrong);
        btnCorrect = findViewById(R.id.btn_correct);
        btnPrev = findViewById(R.id.btn_prev);
        btnNext = findViewById(R.id.btn_next);

        // end of initializing

        int question = questions[currentIndex].getQuestionId();
        tvQuestion.setText(question);


        tvQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCount++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(clickCount == 2){
                            Intent cheatActivity = new Intent(QuizActivity.this, CheatActivity.class);
                            cheatActivity.putExtra("ansToQues", questions[currentIndex].getAnswer());
                            startActivity(cheatActivity);
                        }
                        clickCount = 0;
                    }
                }, 500);
            }
        });


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


                //currentIndex = (currentIndex+1) % questions.length;
                currentIndex = (currentIndex+1);
                if(currentIndex<questions.length){

                    ValidateAnswer(selectedAnswer);
                    int question = questions[currentIndex].getQuestionId();
                    tvQuestion.setText(question);
                }else{
                    tvQuestionHeading.setText("Quiz Completed!");
                }

            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //currentIndex = (currentIndex+4) % questions.length;

                if(currentIndex>0){
                    currentIndex = (currentIndex-1);
                    int question = questions[currentIndex].getQuestionId();
                    tvQuestion.setText(question);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("QuizActivity:", "Instance Saved");
        outState.putInt(KEY, currentIndex);
    }

    static boolean stdCheat;
    public static void DidStdCheat(boolean cheatResult){
        stdCheat = cheatResult;
    }

    private void ValidateAnswer(boolean ans){
        boolean answer = questions[currentIndex].getAnswer();

        String floatingAnswer;

        if(!stdCheat){
            if (ans == answer){
                floatingAnswer = "Answer is Correct!";
            }else{
                floatingAnswer = "Answer is InCorrect!";
            }
        }else{
            floatingAnswer = "Tsk! Tsk! Tsk! Shame on you for Cheating!!!";
        }

        Toast.makeText(this, floatingAnswer, Toast.LENGTH_SHORT).show();
    }
}