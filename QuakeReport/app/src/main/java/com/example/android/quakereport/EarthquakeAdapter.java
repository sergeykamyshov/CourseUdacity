package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EarthquakeAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<Earthquake> mEarthquakes;

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        this.mContext = context;
        mInflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mEarthquakes = earthquakes;
    }

    @Override
    public int getCount() {
        return mEarthquakes.size();
    }

    @Override
    public Object getItem(int position) {
        return mEarthquakes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.earthquake_list_item, parent, false);
        }

        Earthquake earthquake = mEarthquakes.get(position);

        TextView magnitude = (TextView) convertView.findViewById(R.id.magnitude_text_view);
        magnitude.setText(getMagnitudeFormat(earthquake.getMagnitude()));
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();
        magnitudeCircle.setColor(getMagnitudeColor(earthquake.getMagnitude()));

        String place = earthquake.getPlace();
        String locationOffset = "";
        String primaryLocation = "";
        if (place.contains("of ")) {
            int index = place.indexOf("of ");
            int splitIndex = index + 3;
            locationOffset = place.substring(0, splitIndex);
            primaryLocation = place.substring(splitIndex, place.length() - 1);
        } else {
            locationOffset = "Near of ";
            primaryLocation = place;
        }
        TextView locationOffsetTextView = (TextView) convertView.findViewById(R.id.location_offset_text_view);
        locationOffsetTextView.setText(locationOffset);
        TextView primaryLocationTextView = (TextView) convertView.findViewById(R.id.primary_location_text_view);
        primaryLocationTextView.setText(primaryLocation);

        Date earthquakeDate = new Date(earthquake.getTimeInMilliseconds());
        TextView date = (TextView) convertView.findViewById(R.id.date_text_view);
        date.setText(getDateFormet(earthquakeDate));
        TextView time = (TextView) convertView.findViewById(R.id.time_text_view);
        time.setText(getTimeFormat(earthquakeDate));

        return convertView;
    }

    private int getMagnitudeColor(double magnitude) {
        int colorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                colorResourceId = R.color.magnitude1;
                break;
            case 2:
                colorResourceId = R.color.magnitude2;
                break;
            case 3:
                colorResourceId = R.color.magnitude3;
                break;
            case 4:
                colorResourceId = R.color.magnitude4;
                break;
            case 5:
                colorResourceId = R.color.magnitude5;
                break;
            case 6:
                colorResourceId = R.color.magnitude6;
                break;
            case 7:
                colorResourceId = R.color.magnitude7;
                break;
            case 8:
                colorResourceId = R.color.magnitude8;
                break;
            case 9:
                colorResourceId = R.color.magnitude9;
                break;
            default:
                colorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(mContext, colorResourceId);
    }

    private String getMagnitudeFormat(double magnitude) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        return decimalFormat.format(magnitude);
    }

    private String getTimeFormat(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a");
        return dateFormat.format(date);
    }

    private String getDateFormet(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(date);
    }
}
