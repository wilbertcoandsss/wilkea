package com.example.androidproject_lc077;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GMapsActivity extends AppCompatActivity {

    private GoogleMap map;
    private final double LATITUDE = -6.2197;
    private final double LONGITUDE = 106.6632;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmaps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.gMaps);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                map = googleMap;

                LatLng latlng = new LatLng(LATITUDE, LONGITUDE);
                map.addMarker(new MarkerOptions().position(latlng).title("WILkea"));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 14));

            }
        });

    }
}