package com.example.android.quakeapp;

/**
 * Created by Creator on 3/24/2018.
 */


public class Earthquake {

    private String mMagnitude;

    private String mLocation;

    private String mDate;

    private String mTime;

    private String mDepth;

    private String mFelt;

    private String mUrl;
    private Double mLatitude;
    private Double mLongitude;

    public Earthquake(String magnitude,String location,String date,String time,String depth,String felt,String url, Double latitude, Double longitude){
        this.mMagnitude = magnitude;
        this.mLocation  = location;
        this.mDate      = date;
        this.mTime      = time;
        this.mDepth     = depth;
        this.mFelt      = felt;
        this.mUrl       = url;
        this.mLatitude  = latitude;
        this.mLongitude = longitude;

    }

    public String getMagnitude(){
        return mMagnitude;
    }


    public String getLocation(){
        return mLocation;
    }


    public String getDate(){ return mDate; }

    public String getTime() { return mTime; }


    public String getDepth() {
        return mDepth;
    }


    public String getUrl() { return mUrl; }

    public Double getLatitude() { return mLatitude; }

    public Double getLongitude() { return mLongitude; }


}