package com.mobilepro.beeflover;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mobilepro.beeflover.fragment.FragmentAkun;
import com.mobilepro.beeflover.fragment.FragmentHome;
import com.mobilepro.beeflover.fragment.FragmentPromo;
import com.mobilepro.beeflover.fragment.FragmentTransaksi;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener navigation =new BottomNavigationView.OnNavigationItemSelectedListener(){

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment f= null;
            switch (item.getItemId()){
                case R.id.menu_home:
                    f = new FragmentHome();
                    break;
                case R.id.menu_promo:
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
}