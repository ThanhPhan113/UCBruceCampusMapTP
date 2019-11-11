package com.example.wear;

import android.os.Bundle;
import android.app.Activity;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class Google_Street_View extends Activity implements OnStreetViewPanoramaReadyCallback {




    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama panorama) {
        final LatLng UC = new LatLng(-35.2344325, 149.0868359);
        final float ZOOM_BY = 10.0f;
        long duration = 10000;
        float tilt = 0;
        final int PAN_BY = -179;

        StreetViewPanoramaCamera camera = new StreetViewPanoramaCamera.Builder()
                .zoom(panorama.getPanoramaCamera().zoom + ZOOM_BY)
                .bearing(panorama.getPanoramaCamera().bearing - PAN_BY)
                .tilt(tilt)
                .build();

        panorama.animateTo(camera, duration);
        panorama.setPosition(UC);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google__street__view);

        StreetViewPanoramaFragment streetViewPanoramaFragment =
                (StreetViewPanoramaFragment) getFragmentManager()
                        .findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);

    }

}
