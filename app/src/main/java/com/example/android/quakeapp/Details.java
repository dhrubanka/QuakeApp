package com.example.android.quakeapp;

/**
 * Created by Creator on 5/14/2018.
 */
public class Details {

    String mag;
    String place;
    String time;
    String dateToDisplay;
    String depth;
    double latitude;
    double longitude;
    String felt;

    public Details(String mag,String place,String time, String dateToDisplay,String depth,double latitude,double longitude,String felt){
        this.mag=mag;
        this.place = place;
        this.time = time;
        this.dateToDisplay= dateToDisplay;
        this.depth = depth;
        this.latitude= latitude;
        this.longitude= longitude;
        this.felt = felt;
    }

    public String getMag() {
        return mag;
    }

    public String getPlace() {
        return place;
    }

    public String getTime() {
        return time;
    }

    public  String getDateToDisplay(){
        return dateToDisplay;
    }

    public String getDepth() {
        return depth;
    }

    public double getLatitude() { return latitude; }

    public double getLongitude() {
        return longitude;
    }

    public String getFelt() {
        return felt;
    }
}

