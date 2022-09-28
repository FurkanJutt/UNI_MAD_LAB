package com.UlBululStudios.mad_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class SignUpActivity extends AppCompatActivity {

    //Variables
    private EditText etUserName, etPassword;
    private RadioButton rbMale, rbFemale;
    private Button btnIdCamera, btnSignUp, btnBackToLogin;

    private final int CAPTURE_IMAGE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnBackToLogin = findViewById(R.id.btn_back_to_login);
        etUserName = findViewById(R.id.et_Username);
        etPassword = findViewById(R.id.et_Password);
        btnSignUp = findViewById(R.id.btn_SignUp);
        btnIdCamera = findViewById(R.id.btn_IDcamera);

        btnBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUpActivity.this.finish();
            }
        });

        etUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etUserName.setText("");
            }
        });

        etPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etPassword.setText("");
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUsername = etUserName.getText().toString();
                String strPassword = etPassword.getText().toString();

                if (!strUsername.isEmpty() && !strPassword.isEmpty()) {
                    Intent loginActivity = new Intent(SignUpActivity.this, LoginActivity.class);
                    loginActivity.putExtra("Username", strUsername);
                    startActivity(loginActivity);
                }
                else{
                    etUserName.setTextColor(Color.parseColor("red"));
                    etUserName.setText("Field Cannot be empty");
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
    }
}