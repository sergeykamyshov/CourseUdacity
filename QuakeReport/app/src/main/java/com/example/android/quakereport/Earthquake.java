package com.example.android.quakereport;

public class Earthquake {

    private String mMagnitude;
    private String mPlace;
    private long mTimeInMilliseconds;

    public Earthquake(String magnitude, String place, long timeInMilliseconds) {
        this.mMagnitude = magnitude;
        this.mPlace = place;
        this.mTimeInMilliseconds = timeInMilliseconds;
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

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public void setTimeInMilliseconds(long timeInMilliseconds) {
        mTimeInMilliseconds = timeInMilliseconds;
    }
}
