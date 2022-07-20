package com.mobilepro.beeflover.kategori;

import androidx.appcompat.app.AppCompatActivity;

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
import com.mobilepro.beeflover.fragment.FragmentHome;

import java.util.ArrayList;
import java.util.List;

public class DagingSteak extends AppCompatActivity {

    GridView gridView;
    FragmentHome.CustomAdapter customAdapter;
    List<ItemsModel> itemsList =new ArrayList<>();
    int gambar[] = {R.drawable.fiesta1, R.drawable.riverland1, R.drawable.pronas1
            ,R.drawable.sirloin, R.drawable.shortplate};
    String names[] = {"Fiesta wratswursi sausage", "Beef Nugget 500g", "Pronas Kornet 198g"
            ,"Daging Sirloin", "Daging Short plate"};
    String price [] = {"Rp35.500", "Rp50.500", "Rp21.000", "Rp50.000", "Rp35.000"};
    String toko [] = {"FIESTA OFFICIAL", "RIVERLAND", "PRONAS", "Daging Asep", "Daging Asep"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kat_daging_steak);

        gridView = findViewById(R.id.gridView2);
        for(int i=0; i < names.length; i++){
            ItemsModel itemsModel = new ItemsModel(names[i],price[i],toko[i],gambar[i]);
            itemsList.add(itemsModel);

            gridView.setAdapter(customAdapter);
        }
    }

    public class CustomAdapter extends BaseAdapter implements Filterable {

        private List<ItemsModel> itemsModelList;
        private  List<ItemsModel> itemsModelListFiltered;
        private Context context;

        public CustomAdapter(List<ItemsModel> itemsModelList, Context context) {
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