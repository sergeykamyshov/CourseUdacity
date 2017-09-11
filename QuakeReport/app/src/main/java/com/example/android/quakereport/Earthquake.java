package com.example.android.quakereport;

public class Earthquake {

    private double mMagnitude;
    private String mPlace;
    private long mTimeInMilliseconds;
    private String mUrl;

    public Earthquake(double magnitude, String place, long timeInMilliseconds, String url) {
        this.mMagnitude = magnitude;
        this.mPlace = place;
        this.mTimeInMilliseconds = timeInMilliseconds;
        this.mUrl = url;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public void setMagnitude(double magnitude) {
        mMagnitude = magnitude;
    }

    public String getPlace() {
        return mPlace;
    }

    public void setPlace(String place) {
        mPlace = place;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public void setTimeInMilliseconds(long timeInMilliseconds) {
        mTimeInMilliseconds = timeInMilliseconds;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }
}
