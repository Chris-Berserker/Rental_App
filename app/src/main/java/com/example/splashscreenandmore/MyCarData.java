package com.example.splashscreenandmore;


public class MyCarData {

    private String movieName;
    private String movieDate;
    private Integer movieImage;
    private String listingPrice;

    public MyCarData(String movieName, String listingPrice, String movieDate, Integer movieImage) {
        this.movieName = movieName;
        this.listingPrice = listingPrice;
        this.movieDate = movieDate;
        this.movieImage = movieImage;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getListingPrice(){return listingPrice;}

    public void setListingPrice(String listingPrice){this.listingPrice = listingPrice;}

    public String getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    public Integer getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(Integer movieImage) {
        this.movieImage = movieImage;
    }
}

