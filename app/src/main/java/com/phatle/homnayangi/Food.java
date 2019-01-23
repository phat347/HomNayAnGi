package com.phatle.homnayangi;

public class Food {
    String name;
    String descrition;
    String price;
    int imgRes;

    public Food(String name, String descrition, String price, int imgRes) {
        this.name = name;
        this.descrition = descrition;
        this.price = price;
        this.imgRes = imgRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }
}
