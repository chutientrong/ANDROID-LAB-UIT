package com.example.lab2_5;


public class Dish {
    private String name;
    private Thumbnail thumbnail;
    private boolean promotion;

    public Dish(String name, Thumbnail thumbnail, boolean promotion){
        this.name = name;
        this.thumbnail = thumbnail;
        this.promotion = promotion;
    }

    public Dish(){}

    public String getName(){
        return name;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }
}

