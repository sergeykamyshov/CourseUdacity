package com.example.android.quakereport;

import android.content.Context;
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
