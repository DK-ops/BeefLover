package com.mobilepro.beeflover.validation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.mobilepro.beeflover.MainActivity;
import com.mobilepro.beeflover.R;

public class LoginPage extends AppCompatActivity {
    EditText inputEmail, inputPassword;
    Button btnLogin;
    String email, password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        mAuth = FirebaseAuth.getInstance();
        inputEmail = findViewById(R.id.EditTextLoginEmail);
        inputPassword = findViewById(R.id.EditTextLoginPassword);
        btnLogin = findViewById(R.id.btn_login_masuk);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cekLogin();
            }
        });
    }

    private void cekLogin() {
        email = inputEmail.getText().toString();
        password = inputPassword.getText().toString();

        mAuth.signInWithEmailAndPassword(email,password )
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(LoginPage.this, "Login Berhasil", Toast.LENGTH_LONG).show();
                            Intent masuk = new Intent( LoginPage.this, MainActivity.class);
                            startActivity(masuk);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginPage.this, "Login Gagal, Email atau Password anda salah", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    public void onClickGoToDaftar(View view) {
        Intent daftar = new Intent(LoginPage.this, RegisterPage.class );
        startActivity(daftar);
    }

    public void onClickGoToLupaPassword(View view) {
        Intent lupapw = new Intent(LoginPage.this, ForgotPassword.class );
        startActivity(lupapw);
    }
}