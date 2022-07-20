package com.mobilepro.beeflover.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mobilepro.beeflover.ItemsModel;
import com.mobilepro.beeflover.R;
import com.mobilepro.beeflover.etc.SliderAdapter;
import com.mobilepro.beeflover.kategori.BumbuDapur;
import com.mobilepro.beeflover.kategori.DagingOlahan;
import com.mobilepro.beeflover.kategori.DagingSteak;
import com.mobilepro.beeflover.kategori.PaketDaging;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends Fragment implements View.OnClickListener {
    SliderView sliderView;
    int[] images = {R.drawable.carousel_1,
    R.drawable.carousel_2,
    R.drawable.carousel_3};
    CardView cvDS, cvDO, cvPD, cvBD;

    GridView gridView;
    CustomAdapter customAdapter;
    List<ItemsModel> itemsList =new ArrayList<>();
    int gambar[] = {R.drawable.fiesta1, R.drawable.riverland1, R.drawable.pronas1
                    ,R.drawable.sirloin, R.drawable.shortplate};
    String names[] = {"Fiesta wratswursi sausage", "Beef Nugget 500g", "Pronas Kornet 198g"
                        ,"Daging Sirloin", "Daging Short plate"};
    String price [] = {"Rp35.500", "Rp50.500", "Rp21.000", "Rp50.000", "Rp35.000"};
    String toko [] = {"FIESTA OFFICIAL", "RIVERLAND", "PRONAS", "Daging Asep", "Daging Asep"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view1 = inflater.inflate(R.layout.fragment_home,container,false);

        gridView = view1.findViewById(R.id.gridView);
        for(int i=0; i < names.length; i++){
            ItemsModel itemsModel = new ItemsModel(names[i],price[i],toko[i],gambar[i]);
            itemsList.add(itemsModel);

            customAdapter = new CustomAdapter(itemsList, this);

            gridView.setAdapter(customAdapter);
        }

        sliderView = view1.findViewById(R.id.carouselH);
        cvDS = view1.findViewById(R.id.cvdagingsteak);
        cvDO = view1.findViewById(R.id.cvdagingolahan);
        cvPD = view1.findViewById(R.id.cvpaketdaging);
        cvBD = view1.findViewById(R.id.cvbumbudapur);
        cvDS.setOnClickListener(this::onClick);
        cvDO.setOnClickListener(this::onClick);
        cvPD.setOnClickListener(this::onClick);
        cvBD.setOnClickListener(this::onClick);

        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.startAutoCycle();


        SearchView searchView = view1.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getContext(), query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return view1;
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.cvdagingsteak:
                Intent intent = new Intent(getActivity(), DagingSteak.class);
                this.startActivity(intent);
                break;

            case R.id.cvdagingolahan:
                Intent intent1 = new Intent(getActivity(), DagingOlahan.class);
                this.startActivity(intent1);
                break;
            case R.id.cvpaketdaging:
                Intent intent2 = new Intent(getActivity(), PaketDaging.class);
                this.startActivity(intent2);
                break;
            case R.id.cvbumbudapur:
                Intent intent3 = new Intent(getActivity(), BumbuDapur.class);
                this.startActivity(intent3);
                break;

        }
    }

    public class CustomAdapter extends BaseAdapter implements Filterable{

        private List<ItemsModel> itemsModelList;
        private  List<ItemsModel> itemsModelListFiltered;
        private Context context;

        public CustomAdapter(List<ItemsModel> itemsModelList, FragmentHome fragmentHome) {
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