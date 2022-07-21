package com.mobilepro.beeflover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.mobilepro.beeflover.etc.VPAdapter;
import com.mobilepro.beeflover.fragment.FragmentKategori;
import com.mobilepro.beeflover.fragment.FragmentProduk;

public class MyToko extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_toko);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        tabLayout.setupWithViewPager(viewPager);

        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new FragmentProduk(),"Produk");
        vpAdapter.addFragment(new FragmentKategori(),"Kategori");
        viewPager.setAdapter(vpAdapter);

    }
}