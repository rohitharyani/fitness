package com.example.rohit.wecare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    final Button signUpButton = (Button) findViewById(R.id.loginSignUpButton);
    signUpButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent signUpIntent  = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(signUpIntent);
        }
    });
    }
}
