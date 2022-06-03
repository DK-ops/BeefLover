package com.mobilepro.beeflover.fragment;

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
import android.widget.Button;
import android.widget.Toast;

import com.mobilepro.beeflover.R;
import com.mobilepro.beeflover.etc.SliderAdapter;
import com.mobilepro.beeflover.kategori.BumbuDapur;
import com.mobilepro.beeflover.kategori.DagingOlahan;
import com.mobilepro.beeflover.kategori.DagingSteak;
import com.mobilepro.beeflover.kategori.PaketDaging;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class FragmentHome extends Fragment implements View.OnClickListener {
    SliderView sliderView;
    int[] images = {R.drawable.carousel_1,
    R.drawable.carousel_2,
    R.drawable.carousel_3};
    CardView cvDS, cvDO, cvPD, cvBD;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view1 = inflater.inflate(R.layout.fragment_home,container,false);

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
}