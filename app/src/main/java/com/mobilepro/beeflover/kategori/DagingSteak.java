package com.mobilepro.beeflover.kategori;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobilepro.beeflover.ItemsModel;
import com.mobilepro.beeflover.R;
import com.mobilepro.beeflover.etc.MyAdapter;
import com.mobilepro.beeflover.fragment.FragmentHome;

import java.util.ArrayList;
import java.util.List;

public class DagingSteak extends AppCompatActivity {

    RecyclerView recyclerView1;

    String namaProd[], hargaProd[], tokoProd[];
    int gambaritem1[] = {R.drawable.sirloin,R.drawable.sandunglumpur,R.drawable.tenderloin,R.drawable.shortplate,
            R.drawable.iga,R.drawable.dagingsapipahadpan};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kat_daging_steak);

        recyclerView1 = findViewById(R.id.recyclerview1);

        namaProd = getResources().getStringArray(R.array.namaProduk1);
        hargaProd = getResources().getStringArray(R.array.hargaProd1);
        tokoProd = getResources().getStringArray(R.array.tokoProduk1);

        MyAdapter myAdapter = new MyAdapter(this, namaProd,hargaProd,tokoProd,gambaritem1);
        recyclerView1.setAdapter(myAdapter);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getParent(), 2);
        recyclerView1.setLayoutManager(layoutManager);

        }
}


