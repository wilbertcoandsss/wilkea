package com.example.androidproject_lc077;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class AboutUsActivity extends AppCompatActivity {
    private final double LATITUDE = -6.2197;
    private final double LONGITUDE = 106.6632;

    private MapView mapView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);

        mapView = findViewById(R.id.mapViewOSM);

        Marker marker = new Marker(mapView);
        marker.setPosition(new GeoPoint(LATITUDE, LONGITUDE));
        marker.setTitle("WILKea");

        IMapController controller = mapView.getController();
        controller.setZoom(17.0);

        GeoPoint geoPoint = new GeoPoint(LATITUDE, LONGITUDE);

        controller.setCenter(geoPoint);

        mapView.getOverlays().add(marker);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}