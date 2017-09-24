package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>>{

    public static final String LOG_TAG = EarthquakeLoader.class.getSimpleName();

    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
        Log.i(LOG_TAG, "EarthquakeLoader constuctor");
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG, "onStartLoading");
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        Log.i(LOG_TAG, "loadInBackground");
        if (mUrl == null) {
            return null;
        }
        return QueryUtils.fetchEearthquakeData(mUrl);
    }
}
