package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class EarthquakeAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<Earthquake> earthquakes;

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        this.context = context;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.earthquakes = earthquakes;
    }

    @Override
    public int getCount() {
        return earthquakes.size();
    }

    @Override
    public Object getItem(int position) {
        return earthquakes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.earthquake_list_item, parent, false);
        }

        Earthquake earthquake = earthquakes.get(position);

        TextView magnitude = (TextView) convertView.findViewById(R.id.magnitude_text_view);
        magnitude.setText(earthquake.getMagnitude());

        TextView place = (TextView) convertView.findViewById(R.id.place_text_view);
        place.setText(earthquake.getPlace());

        TextView date = (TextView) convertView.findViewById(R.id.date_text_view);
        date.setText(earthquake.getDate());

        return convertView;
    }
}
