package com.mobilepro.beeflover.validation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mobilepro.beeflover.R;

public class RegisterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
    }
    public void onClickRegistBackToLogin(View view) {
        Intent bckLogin = new Intent(RegisterPage.this, LoginPage.class );
        startActivity(bckLogin);
    }

    public void daftarakun(View view) {
//        Intent intent = new Intent(this, MainActivity.class);
//
//        EditText regpassword= (EditText) findViewById(R.id.EditTextRegistPassword);
//        EditText regConfirmPass = (EditText) findViewById(R.id.EditTextRegistConfirmPassword);
//
//        String pass = regpassword.getText().toString();
//        String conpass = regConfirmPass.getText().toString();
//
//        if (pass.equals("")) {
//            Toast.makeText(this, "Password cannot be null", Toast.LENGTH_SHORT).show();
//        } else {
//            if (!pass.equals(conpass)) {
//                Toast.makeText(this, "Password not same with confirm password", Toast.LENGTH_SHORT).show();
//            } else {
//                startActivity(intent);
//
//            }
//        }
    }
}