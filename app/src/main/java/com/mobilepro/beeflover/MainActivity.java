package com.mobilepro.beeflover;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mobilepro.beeflover.fragment.FragmentAkun;
import com.mobilepro.beeflover.fragment.FragmentHome;
import com.mobilepro.beeflover.fragment.FragmentPromo;
import com.mobilepro.beeflover.fragment.FragmentTransaksi;
import com.mobilepro.beeflover.validation.LoginPage;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Button profile;

    private BottomNavigationView.OnNavigationItemSelectedListener navigation =new BottomNavigationView.OnNavigationItemSelectedListener(){

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment f= null;
            switch (item.getItemId()){
                case R.id.menu_home:
                    f = new FragmentHome();
                    break;
                case R.id.menu_notif:
                    f = new FragmentPromo();
                    break;
                case R.id.menu_transaksi:
                    f = new FragmentTransaksi();
                    break;
                case R.id.menu_akun:
                    f = new FragmentAkun();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, f).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.BotNavbar);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,new FragmentHome()).commit();
    }

    public void logout(View view){
        new AlertDialog.Builder(this).setMessage("Apakah anda yakin ingin Keluar ?").setPositiveButton("Keluar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        Toast.makeText(MainActivity.this, "Berhasil Keluar",Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("Tidak", null).show();

    }

    public void profile(View view){
        Intent intent = new Intent(this, AkunProfile.class);
        startActivity(intent);
    }

    public void ubahpwd(View view){
        Intent intent = new Intent(this, ChangePassword.class);
        startActivity(intent);
    }

    public void about(View view){
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void toko(View view){
        Intent intent = new Intent(this, MyToko.class);
        startActivity(intent);
    }
}