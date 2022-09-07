package com.UlBululStudios.mad_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class SignUpActivity extends AppCompatActivity {

    //Variables
    private EditText etUserName, etPassword;
    private RadioButton rbMale, rbFemale;
    private Button btnSignUp, btnCancle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = findViewById(R.id.et_Username);
        etPassword = findViewById(R.id.et_Password);
        btnSignUp = findViewById(R.id.btn_SignUp);
        btnCancle = findViewById(R.id.btn_Cancle);

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

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
}