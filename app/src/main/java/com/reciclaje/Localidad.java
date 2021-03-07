package com.reciclaje;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Localidad extends AppCompatActivity implements OnMapReadyCallback {

    MapView mapa;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localidad);

        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(4.71279059583009, -74.07128600147612)).title("Centro Comercial Bulevar Niza"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(4.59891879967459, -74.0794306168176)).title("Centro Comercial San Victorino"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(4.618847894562671, -74.08639524750052)).title("Centro Comercial Calima"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(4.579680417955662, -74.14025804565301)).title("Centro Comercial Plaza Mayor"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(4.762080667018361, -74.04632805914676)).title("Centro Comercial Santafé"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(4.60971, -74.08175), 10));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(4.71279059583009, -74.07128600147612)));
    }
}