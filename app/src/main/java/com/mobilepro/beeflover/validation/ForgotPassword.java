package com.mobilepro.beeflover.validation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mobilepro.beeflover.R;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }

    public void onClickForgetBackToLogin(View view) {
        Intent bckLogin = new Intent(ForgotPassword.this, LoginPage.class );
        startActivity(bckLogin);
    }
}