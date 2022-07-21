package com.example.splashscreenandmore;

public class BuyCarGetter {

    String img, make, millage, model, price;

    BuyCarGetter() {

    }

    public BuyCarGetter(String img, String make, String millage, String model, String price) {
        this.img = img;
        this.make = make;
        this.millage = millage;
        this.model = model;
        this.price = price;

    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getMillage() {
        return millage;
    }

    public void setMillage(String millage) {
        this.millage = millage;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

