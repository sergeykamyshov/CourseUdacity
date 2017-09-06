package com.example.android.quakereport;

public class Earthquake {

    private String mMagnitude;
    private String mPlace;
    private String mDate;

    public Earthquake(String magnitude, String place, String date) {
        this.mMagnitude = magnitude;
        this.mPlace = place;
        this.mDate = date;
    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public void setMagnitude(String magnitude) {
        mMagnitude = magnitude;
    }

    public String getPlace() {
        return mPlace;
    }

    public void setPlace(String place) {
        mPlace = place;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }
}
