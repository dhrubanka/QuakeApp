package com.example.android.quakeapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.Math.floor;

/**
 * Created by Creator on 5/5/2018.
 */


public class CustomAdapter extends ArrayAdapter<Earthquake> {

    public CustomAdapter(Context context, ArrayList<Earthquake> earthquake) {
        super(context, 0, earthquake);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        assert currentEarthquake != null;
        magnitudeView.setText(currentEarthquake.getMagnitude());


        TextView locationView = (TextView) listItemView.findViewById(R.id.location);
        locationView.setText(currentEarthquake.getLocation());


        TextView dateView = listItemView.findViewById(R.id.date);
        dateView.setText(currentEarthquake.getDate());

        TextView dateText = (TextView) listItemView.findViewById(R.id.date);
        dateText.setText(currentEarthquake.getTime());

        return listItemView;
    }
}



