package com.mobilepro.beeflover.validation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.mobilepro.beeflover.R;


public class RegisterPage extends AppCompatActivity {
    EditText username, Email, phone, password1, password2;
    String nama, email, nomor, pass1, pass2;
    Button daftar;
    FirebaseAuth mAuth;
    FirebaseDatabase database;
    FirebaseStorage storage;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();

        username = findViewById(R.id.EditTextRegistUsername);
        Email = findViewById(R.id.EditTextRegistEmail);
        phone = findViewById(R.id.EditTextRegistPhone);
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
        nama = username.getText().toString();
        nomor = phone.getText().toString();
        email = Email.getText().toString();
        pass1 = password1.getText().toString();
        pass2 = password2.getText().toString();

        if(TextUtils.isEmpty(nama)||TextUtils.isEmpty(nomor)||TextUtils.isEmpty(email)||
                TextUtils.isEmpty(pass1)||TextUtils.isEmpty(pass2)){
            Toast.makeText(RegisterPage.this, "Masukan data diri anda dengan benar.", Toast.LENGTH_LONG).show();
        }else if (!email.matches(emailPattern)){
            Toast.makeText(RegisterPage.this, "Masukan Email dengan benar", Toast.LENGTH_LONG).show();
        }else if (!pass1.equals(pass2)){
            Toast.makeText(RegisterPage.this, "Password tidak sesuai", Toast.LENGTH_LONG).show();
        }else if (pass1.length()<6){
            Toast.makeText(RegisterPage.this, "Masukan password lebih dari 6 karakter", Toast.LENGTH_LONG).show();
        }else {
            mAuth.createUserWithEmailAndPassword(email, pass2)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(RegisterPage.this, "Registrasi Berhasil", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(RegisterPage.this, LoginPage.class);
                                intent.putExtra("nama", nama);
                                intent.putExtra("nomor", nomor);
                                intent.putExtra("email", email);
                                startActivity(intent);
                                finish();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(RegisterPage.this, "Registrasi Gagal", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }

    public void onClickRegistBackToLogin(View view) {
        Intent bckLogin = new Intent(RegisterPage.this, LoginPage.class );
        startActivity(bckLogin);
    }
}