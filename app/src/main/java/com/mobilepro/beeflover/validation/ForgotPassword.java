package com.mobilepro.beeflover.validation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.mobilepro.beeflover.R;

import java.util.regex.Pattern;

public class ForgotPassword extends AppCompatActivity {

    private EditText emailEditText;
    private Button resetbtn;
    private ProgressBar progressBar;

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailEditText = (EditText) findViewById(R.id.EditTextForgetEmail);
        resetbtn = (Button) findViewById(R.id.resetBtn);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        auth = FirebaseAuth.getInstance();

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();

            }
        });
    }

    private void resetPassword(){
        String email = emailEditText.getText().toString().trim();

        if (email.isEmpty()){
            emailEditText.setError("Email Dibutuhkan!!!");
            emailEditText.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Masukkan Email yang Valid");
            emailEditText.requestFocus();
        }

        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful()){
                    Toast.makeText(ForgotPassword.this, "Cek Email anda untuk mereset Password", Toast.LENGTH_LONG).show();
                    Intent backtoLogin = new Intent(ForgotPassword.this, LoginPage.class);
                    startActivity(backtoLogin);
                }else{
                    Toast.makeText(ForgotPassword.this, "Coba lagi, ada yang salah ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void onClickForgetBackToLogin(View view) {
        Intent bckLogin = new Intent(ForgotPassword.this, LoginPage.class );
        startActivity(bckLogin);
    }
}