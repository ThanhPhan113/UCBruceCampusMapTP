package com.example.u3175008.ucbrucecampusmaptp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;


import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.StreetViewPanorama;



public class Google_Street_View2 extends AppCompatActivity implements OnStreetViewPanoramaReadyCallback {


    static final LatLng Streetview2 = new LatLng(-35.238375, 149.089377);
    private static final float ZOOM_BY = -1.0f;
    long duration = 5000;float tilt = 0;
    private static final int PAN_BY = 180;


    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama panorama) {


// Animate over a duration of 5000 milliseconds.
        StreetViewPanoramaCamera camera = new StreetViewPanoramaCamera.Builder()
                .zoom(panorama.getPanoramaCamera().zoom + ZOOM_BY)
                .bearing(panorama.getPanoramaCamera().bearing - PAN_BY)
                .tilt(tilt)            .build();
        panorama.animateTo(camera, duration);
        panorama.setPosition(Streetview2);


    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google__street__view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        StreetViewPanoramaFragment streetViewPanoramaFragment =
                (StreetViewPanoramaFragment) getFragmentManager()
                        .findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);
    }

}
