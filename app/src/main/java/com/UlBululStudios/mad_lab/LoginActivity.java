package com.UlBululStudios.mad_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*import com.UlBululStudios.mad_lab.DB_Utils.LocalDB;
import com.UlBululStudios.mad_lab.DB_Utils.User;*/

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin, btnCancle;
    private TextView btnSignUp;

    private final String CREDENTIAL_SHARED_PREF = "credential_shared_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_Username);
        etPassword = findViewById(R.id.et_Password);
        btnLogin = findViewById(R.id.btn_Login);
        btnCancle = findViewById(R.id.btn_Cancle);
        btnSignUp = findViewById(R.id.btn_signUp);

//        String strUsername = getIntent().getStringExtra("Username");
//
//        etUsername.setText(strUsername);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences credentials = getSharedPreferences(CREDENTIAL_SHARED_PREF, MODE_PRIVATE);
                String prefUsername = credentials.getString("Username", null);
                String prefPassword = credentials.getString("Password", null);

                String strUsername = etUsername.getText().toString();
                String strPassword = etPassword.getText().toString();

                /*new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LocalDB dbInstance = RoomImplementation.getRoomInstance().getDbInstance();
                        User user = dbInstance.userDao().getUserByUsername(strUsername);
*/
                        if (!strUsername.isEmpty() && strUsername.equalsIgnoreCase(prefUsername)) {
                            if(!strPassword.isEmpty() && strPassword.equalsIgnoreCase(prefPassword)){
                                /*runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {*/
                                        Intent navigationActivity = new Intent(LoginActivity.this, NavigationActivity.class);
                                        startActivity(navigationActivity);
                                    /*}
                                });*/
                            }else{
                                etPassword.setText("");
                                etPassword.setHintTextColor(Color.parseColor("red"));
                                etPassword.setHint("Incorrect Password!");
                            }
                        }
                        else{
                            etUsername.setHintTextColor(Color.parseColor("red"));
                            etUsername.setHint("Field Cannot be empty");
                            etPassword.setHintTextColor(Color.parseColor("red"));
                            etPassword.setHint("Field Cannot be empty");
                        }
                /*    }
                });*/
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
    }
}