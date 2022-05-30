package com.mobilepro.beeflover.validation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mobilepro.beeflover.MainActivity;
import com.mobilepro.beeflover.R;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
    }
    public void onClickGoToDaftar(View view) {
        Intent daftar = new Intent(LoginPage.this, RegisterPage.class );
        startActivity(daftar);
    }

    public void onClickGoToLupaPassword(View view) {
        Intent lupapw = new Intent(LoginPage.this, ForgotPassword.class );
        startActivity(lupapw);
    }

    public void onClickbtnLoginMasuk(View view) {
        Intent masuk = new Intent( LoginPage.this, MainActivity.class);
        startActivity(masuk);
    }
}