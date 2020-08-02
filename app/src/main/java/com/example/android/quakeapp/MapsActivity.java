package com.example.android.quakeapp;


import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {



    Double lat, long1;
    String f;





      private GoogleMap mMap;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_maps);
      // Obtain the SupportMapFragment and get notified when the map is ready to be used.
      SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
         .findFragmentById(R.id.map);
      mapFragment.getMapAsync(this);
      lat = getIntent().getExtras().getDouble("latitude");
        long1 = getIntent().getExtras().getDouble("longitude");
        f=getIntent().getExtras().getString("loc");

   }

   /**
      * Manipulates the map once available.
      * This callback is triggered when the map is ready to be used.
      * This is where we can add markers or lines, add listeners or move the camera.
      * In this case, we just add a marker near Sydney, Australia.
      * If Google Play services is not installed on the device.
      * This method will only be triggered once the user has installed
         Google Play services and returned to the app.
   */

   @Override
   public void onMapReady(GoogleMap googleMap) {


      mMap = googleMap;
      // Add a marker in Sydney and move the camera
      LatLng Point = new LatLng( lat,  long1);
      mMap.addMarker(new
         MarkerOptions().position(Point).title(f));
      mMap.moveCamera(CameraUpdateFactory.newLatLng(Point));
   }
}




