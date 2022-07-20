package com.mobilepro.beeflover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemView extends AppCompatActivity {

    ImageView imageView;
    TextView NameItem, NameToko;
    ItemsModel itemsModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);

        imageView = findViewById(R.id.imageViewItem);
        NameItem = findViewById(R.id.tvNameItem);
        NameToko = findViewById(R.id.tvNameToko);

        Intent intent  = getIntent();

        if(intent.getExtras() != null){
            itemsModel = (ItemsModel) intent.getSerializableExtra("item");
            imageView.setImageResource(itemsModel.getImage());
            NameItem.setText(itemsModel.getName());
            NameToko.setText(itemsModel.getToko());
        }
    }
}