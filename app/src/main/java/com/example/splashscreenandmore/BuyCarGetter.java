package com.example.splashscreenandmore;

public class BuyCarGetter {

    String price, make, model, millage, engineCapacity, type, img;
    int year;

    BuyCarGetter(){

    }

    public BuyCarGetter(String price, String make, String model, String millage, String engineCapacity, String type, String img, int year) {
        this.price = price;
        this.make = make;
        this.model = model;
        this.millage = millage;
        this.engineCapacity = engineCapacity;
        this.type = type;
        this.img = img;
        this.year = year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMillage() {
        return millage;
    }

    public void setMillage(String millage) {
        this.millage = millage;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
