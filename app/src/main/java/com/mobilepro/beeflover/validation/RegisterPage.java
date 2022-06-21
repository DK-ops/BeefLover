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

public class RegisterPage extends AppCompatActivity {
    EditText username, Email, nomor, password1, password2;
    String nama, email, nohp, pass1, pass2;
    Button daftar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        mAuth = FirebaseAuth.getInstance();
        username = findViewById(R.id.EditTextRegistUsername);
        Email = findViewById(R.id.EditTextRegistEmail);
        nomor = findViewById(R.id.EditTextRegistPhone);
        password1 = findViewById(R.id.EditTextRegistPassword);
        password2 = findViewById(R.id.EditTextRegistConfirmPassword);
        daftar = findViewById(R.id.btnDaftar);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrasi();
            }
        });
    }

    private void registrasi() {
        nama = Email.getText().toString();
        pass1 = password2.getText().toString();
        pass2 = password2.getText().toString();

            mAuth.createUserWithEmailAndPassword(nama, pass2)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(RegisterPage.this, "Registrasi Berhasil", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(RegisterPage.this, LoginPage.class);
                                startActivity(intent);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(RegisterPage.this, "Registrasi Gagal", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
    }

    public void onClickRegistBackToLogin(View view) {
        Intent bckLogin = new Intent(RegisterPage.this, LoginPage.class );
        startActivity(bckLogin);
    }
}