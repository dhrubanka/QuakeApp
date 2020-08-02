package com.example.android.quakeapp;


import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class EarthquakeDetails extends EarthquakeActivity {

    GoogleMap mMap;
    String timeToDisplay, dt,f,  dateToDisplay,  effect,url1;
    int a;
    TextView timeView, dateView,textView,magView,locView,details,feltView,effectView,depthView,latView,long1View;
    SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy", Locale.ENGLISH);
    SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a", Locale.ENGLISH);
    Date dateObject;
    String mag,dep;
   Double lat,long1;
    public ListView listView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_details);

        try {

            final String current_url = getIntent().getExtras().getString("current_url");
            mag = getIntent().getExtras().getString("mag");
            dep = getIntent().getExtras().getString("depth");
            dt = getIntent().getExtras().getString("time");
            f = getIntent().getExtras().getString("place");
            lat = getIntent().getExtras().getDouble("latitude");
            long1 = getIntent().getExtras().getDouble("longitude");


        } catch (NullPointerException e) {

            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }


        textView = (TextView) findViewById(R.id.details);
        timeView = (TextView) findViewById(R.id.time);
        magView = (TextView) findViewById(R.id.magnitude);
        locView = (TextView) findViewById(R.id.location);
        dateView = (TextView) findViewById(R.id.date);
        feltView = (TextView) findViewById(R.id.felt);
        depthView = (TextView) findViewById(R.id.depth);
        latView = (TextView) findViewById(R.id.latitude);
        long1View = (TextView) findViewById(R.id.longitude);
        details=(TextView) findViewById(R.id.details);

        magView.setText(mag);
        locView.setText(f);
        details.setText(f);
        dateView.setText(dt);
        depthView.setText(dep);
        latView.setText(String.valueOf(lat));
        long1View.setText(String.valueOf(long1));
    }

    public void goToMap(View v){
    Intent i= new Intent(EarthquakeDetails.this, MapsActivity.class);
    i.putExtra("latitude",lat);
    i.putExtra("longitude",long1);
    i.putExtra("loc",f);
    startActivity(i);

    }





    }



