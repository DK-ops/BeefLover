package com.mobilepro.beeflover;

import java.io.Serializable;

public class ItemsModel implements Serializable {

    private String name, price, toko ;
    private int Image ;

    public ItemsModel(String name, String price, String toko, int image) {
        this.name = name;
        this.price = price;
        this.toko = toko;
        Image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getToko() {
        return toko;
    }

    public void setToko(String toko) {
        this.toko = toko;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
