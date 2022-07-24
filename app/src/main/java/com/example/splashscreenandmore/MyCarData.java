package com.example.splashscreenandmore;


public class MyCarData {

    private String car_name;
    private String car_rent_price;
    private String car_type;
    private String img;

    public MyCarData(String car_name, String car_rent_price, String car_type, String img) {
        this.car_name = car_name;
        this.car_rent_price = car_rent_price;
        this.car_type = car_type;
        this.img = img;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getCar_rent_price() {
        return car_rent_price;
    }

    public void setCar_rent_price(String car_rent_price) {
        this.car_rent_price = car_rent_price;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "MyCarData{" +
                "car_name='" + car_name + '\'' +
                ", car_rent_price='" + car_rent_price + '\'' +
                ", car_type='" + car_type + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}


