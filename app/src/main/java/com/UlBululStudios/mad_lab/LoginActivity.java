package com.UlBululStudios.mad_lab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnIdCamera, btnLogin, btnCancle;

    private final int CAPTURE_IMAGE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_Username);
        etPassword = findViewById(R.id.et_Password);
        btnIdCamera = findViewById(R.id.btn_IDcamera);
        btnLogin = findViewById(R.id.btn_Login);
        btnCancle = findViewById(R.id.btn_Cancle);

        String strUsername = getIntent().getStringExtra("Username");

        etUsername.setText(strUsername);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

        btnIdCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent();
                cameraIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAPTURE_IMAGE);
            }
        });

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
}