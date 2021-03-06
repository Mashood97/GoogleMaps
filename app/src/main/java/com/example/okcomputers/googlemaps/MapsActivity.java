package com.example.okcomputers.googlemaps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker  and move the camera
        LatLng firstlocation = new LatLng(24.971520,   67.065902144444);
        mMap.addMarker(new MarkerOptions().position(firstlocation).title("Mashood's old  Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(firstlocation));

        LatLng SecondLocation = new LatLng(24.915710, 67.092807);
        mMap.addMarker(new MarkerOptions().position(SecondLocation).title("Mashood's new Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SecondLocation));

        //zoom into a particular position
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(11);
        mMap.moveCamera(zoom);
        mMap.animateCamera(zoom);

    }
}
