package com.UlBululStudios.mad_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    //Variables
    private EditText etUserName, etPassword;
    private Button btnSignUp, btnCancle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = findViewById(R.id.et_Username);
        etPassword = findViewById(R.id.et_Password);
        btnSignUp = findViewById(R.id.btn_SignUp);
        btnCancle = findViewById(R.id.btn_Cancle);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUsername = etUserName.getText().toString();
                String strPassword = etPassword.getText().toString();
            }
        });
    }
}