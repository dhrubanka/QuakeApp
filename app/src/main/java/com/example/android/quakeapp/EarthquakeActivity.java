package com.example.android.quakeapp;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.EventLog;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


/**
 * Helper methods related to requesting and receiving earthquake data from USGS.
 */
public class EarthquakeActivity extends AppCompatActivity {
    public static final String LOG_TAG = EarthquakeActivity.class.getSimpleName();
    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2017-01-01&limit=30";

    public ArrayList<Earthquake> earthquakes;
    public CustomAdapter mEarthquakeAdapter;
    public ListView listView;


    public EarthquakeActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);
        earthquakes = new ArrayList<>();
        listView = (ListView) findViewById(R.id.list);
        mEarthquakeAdapter = new CustomAdapter(this, earthquakes);


        network();


    }

    public static boolean isEmpty(@Nullable CharSequence str) {
        if ((str == null) || (str.length() == 0)) {
            return true;
        } else
            return false;
    }






    void network() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();


        StringRequest stringRequest = new StringRequest(Request.Method.GET, USGS_REQUEST_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Date dateObject;
                        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy\n h:mm a", Locale.ENGLISH);
                        try {
                            //converting the string to json array object
                            JSONObject jsonObj = new JSONObject(response);
                            JSONArray array = jsonObj.getJSONArray("features");

                            //traversing through all the object
                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                final JSONObject currentEarthquake = array.getJSONObject(i);
                                JSONObject properties = currentEarthquake.getJSONObject("properties");
                                JSONObject geometry = currentEarthquake.getJSONObject("geometry");
                                JSONArray coordinates = geometry.getJSONArray("coordinates");

                                String magnitude = properties.getString("mag");
                                String location = properties.getString("place");
                                String date = properties.getString("time");
                                long time = Long.parseLong(date);
                                dateObject = new Date(time);
                                String dateToDisplay = dateFormat.format(dateObject);
                                String url = properties.getString("url");
                                String depth = String.valueOf(coordinates.getInt(2));
                                Double lat=coordinates.getDouble(1);
                                Double longi=coordinates.getDouble(0);
                                String felt = properties.getString("felt");
                                String detail=properties.getString("detail");
                                Earthquake earthquake = new Earthquake(magnitude, location,date,dateToDisplay,depth,felt,detail,lat,longi);
                                earthquakes.add(earthquake);

                                listView.setAdapter(mEarthquakeAdapter);
                                progressDialog.dismiss();
                                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                     public void  onItemClick (AdapterView<?> parent, View view, int position,
                                                            long id) {
                                        Earthquake currentQuake = (Earthquake) listView.getItemAtPosition(position);


                                        Intent i = new Intent(EarthquakeActivity.this, EarthquakeDetails.class);
                                        i.putExtra("current_url",currentQuake.getUrl());
                                        i.putExtra("mag",currentQuake.getMagnitude());
                                        i.putExtra("time",currentQuake.getTime());
                                        i.putExtra("place",currentQuake.getLocation());
                                        i.putExtra("depth",currentQuake.getDepth());
                                        i.putExtra("latitude",currentQuake.getLatitude());
                                        i.putExtra("longitude",currentQuake.getLongitude());
                                       


                                        startActivity(i);
                                    }
                                });
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(EarthquakeActivity.this, "Error", Toast.LENGTH_SHORT).show();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our string request to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }
}