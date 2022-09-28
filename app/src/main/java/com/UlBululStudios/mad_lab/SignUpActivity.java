package com.UlBululStudios.mad_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    //Variables
    private EditText etUserName, etPassword, etConfirmPassword;
    private RadioButton rbMale, rbFemale;
    private Button btnIdCamera, btnSignUp, btnBackToLogin;

    private final int CAPTURE_IMAGE = 101;
    private final String CREDENTIAL_SHARED_PREF = "credential_shared_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnBackToLogin = findViewById(R.id.btn_back_to_login);
        etUserName = findViewById(R.id.et_Username);
        etPassword = findViewById(R.id.et_Password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        btnSignUp = findViewById(R.id.btn_SignUp);
        btnIdCamera = findViewById(R.id.btn_IDcamera);

        btnBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUpActivity.this.finish();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUsername = etUserName.getText().toString();
                String strPassword = etPassword.getText().toString();
                String strConfirmPassword = etConfirmPassword.getText().toString();

                if (!strUsername.isEmpty() && !strPassword.isEmpty() && !strConfirmPassword.isEmpty()) {
                    if(!strConfirmPassword.equals(strPassword)){
                        Toast.makeText(SignUpActivity.this, "Password mismatched!", Toast.LENGTH_SHORT).show();
                    }else{
                        SharedPreferences credentials = getSharedPreferences(CREDENTIAL_SHARED_PREF, MODE_PRIVATE);
                        SharedPreferences.Editor editor = credentials.edit();
                        editor.putString("Username", strUsername);
                        editor.putString("Password", strPassword);
                        editor.commit();
                        Toast.makeText(SignUpActivity.this, "SignUp Successful, Go back to Login!", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    etUserName.setHintTextColor(Color.parseColor("red"));
                    etUserName.setHint("Field Cannot be empty");
                    etPassword.setHintTextColor(Color.parseColor("red"));
                    etPassword.setHint("Field Cannot be empty");
                    etConfirmPassword.setHintTextColor(Color.parseColor("red"));
                    etConfirmPassword.setHint("Field Cannot be empty");
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