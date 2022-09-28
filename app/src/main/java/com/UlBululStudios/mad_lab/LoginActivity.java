package com.UlBululStudios.mad_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin, btnCancle, btnTestShow;
    private TextView btnSignUp;

    public static final String KEY = "key_index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_Username);
        etPassword = findViewById(R.id.et_Password);
        btnLogin = findViewById(R.id.btn_Login);
        btnCancle = findViewById(R.id.btn_Cancle);
        btnSignUp = findViewById(R.id.btn_signUp);
        btnTestShow = findViewById(R.id.btn_test_show);

//        String strUsername = getIntent().getStringExtra("Username");
//
//        etUsername.setText(strUsername);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUsername = etUsername.getText().toString();
                String strPassword = etPassword.getText().toString();

                if (!strUsername.isEmpty() && !strPassword.isEmpty()) {
                    Intent quizActivity = new Intent(LoginActivity.this, QuizActivity.class);
                    startActivity(quizActivity);
                }
                else{
                    etUsername.setTextColor(Color.parseColor("red"));
                    etUsername.setText("Field Cannot be empty");
                    etPassword.setTextColor(Color.parseColor("red"));
                    etPassword.setText("Field Cannot be empty");
                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpActivity = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(signUpActivity);
            }
        });

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        btnTestShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent testActivity = new Intent(LoginActivity.this, TestActivity.class);
                startActivity(testActivity);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }
}