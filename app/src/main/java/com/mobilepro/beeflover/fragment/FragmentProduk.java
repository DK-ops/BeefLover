package com.mobilepro.beeflover.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
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

import java.util.ArrayList;
import java.util.List;

public class FragmentProduk extends Fragment {

    GridView gridView;
    CustomAdapter customAdapter;
    List<ItemsModel> itemsList =new ArrayList<>();
    int gambar[] = {R.drawable.fiesta1, R.drawable.fiesta1, R.drawable.fiesta1
            ,R.drawable.fiesta1, R.drawable.fiesta1};
    String names[] = {"Fiesta wratswursi sausage", "Fiesta wratswursi sausage", "Fiesta wratswursi sausage"
            ,"Fiesta wratswursi sausage", "Fiesta wratswursi sausage"};
    String price [] = {"Rp35.500", "Rp35.500", "Rp35.500", "Rp35.500", "Rp35.500"};
    String toko [] = {"FIESTA OFFICIAL", "FIESTA OFFICIAL", "FIESTA OFFICIAL", "FIESTA OFFICIAL", "FIESTA OFFICIAL"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_produk, container, false);

        gridView = view.findViewById(R.id.gridView3);
        for(int i=0; i < names.length; i++){
            ItemsModel itemsModel = new ItemsModel(names[i],price[i],toko[i],gambar[i]);
            itemsList.add(itemsModel);

            customAdapter = new CustomAdapter(itemsList, this);

            gridView.setAdapter(customAdapter);
        }
        return view;
    }

    public class CustomAdapter extends BaseAdapter implements Filterable {
        private List<ItemsModel> itemsModelList;
        private  List<ItemsModel> itemsModelListFiltered;
        private Context context;

        public CustomAdapter(List<ItemsModel> itemsModelList, FragmentProduk fragmentProduk) {
            this.itemsModelList = itemsModelList;
            this.itemsModelListFiltered = itemsModelList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return itemsModelListFiltered.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.row_items, null);

            ImageView imageView = view.findViewById(R.id.imageView);
            TextView tvName = view.findViewById(R.id.tvName);
            TextView tvPrice = view.findViewById(R.id.tvPrice);
            TextView tvToko = view.findViewById(R.id.tvToko);

            imageView.setImageResource(itemsModelListFiltered.get(position).getImage());
            tvName.setText(itemsModelListFiltered.get(position).getName());
            tvPrice.setText(itemsModelListFiltered.get(position).getPrice());
            tvToko.setText(itemsModelListFiltered.get(position).getToko());

            return view;
        }

        @Override
        public Filter getFilter() {
            return null;
        }
    }
}