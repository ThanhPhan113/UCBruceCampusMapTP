package com.example.u3175008.ucbrucecampusmaptp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_Normal) {
            //Display??????????????????????????????????????????????????????????????
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            return true;
        }

        //Set go to Hybrid
        if (id == R.id.action_Hybrid) {
            //Display??????????????????????????????????????????????????????????????
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            return true;
        }

        //Set go to Satellite
        if (id == R.id.action_Satellite) {
            //Display??????????????????????????????????????????????????????????????
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            return true;
        }

        //Set go to Terrain
        if (id == R.id.action_Terrain) {
            //Display??????????????????????????????????????????????????????????????
            mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            return true;
        }

        //Set go to None
        if (id == R.id.action_None) {
            //Display??????????????????????????????????????????????????????????????
            mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {


        mMap = googleMap;


        //Shape around UC
        Polygon polygon = mMap.addPolygon(new PolygonOptions().geodesic(true)
                .add(new LatLng(-35.231369, 149.080675))
                .add(new LatLng(-35.231869, 149.083518))
                .add(new LatLng(-35.232710, 149.085438))
                .add(new LatLng(-35.234778, 149.091339))
                .add(new LatLng(-35.235093, 149.091607))
                .add(new LatLng(-35.238861, 149.090223))
                .add(new LatLng(-35.241770, 149.090084))
                .add(new LatLng(-35.241980, 149.089880))
                .add(new LatLng(-35.242322, 149.079752))
                .add(new LatLng(-35.241025, 149.075407))
                .add(new LatLng(-35.240298, 149.075504))
                .add(new LatLng(-35.240298, 149.075504))
                .add(new LatLng(-35.235235, 149.078023))
                .add(new LatLng(-35.232720, 149.079611))
                .add(new LatLng(-35.231369, 149.080675))
                .strokeColor(Color.GRAY)
                .fillColor(0x70D3D3D3)

        );
        polygon.setClickable(true);

        mMap.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() {
            @Override
            public void onPolygonClick(Polygon polygon) {
                polygon.setStrokeColor(Color.BLACK);
                polygon.setFillColor(Color.WHITE);
                Toast.makeText(getApplicationContext(), "University of Canberra",
                        Toast.LENGTH_LONG).show();
            }
        });

        LatLng centre = new LatLng(-35.2367572,149.0809081);

        // Add a marker in Sydney and move the camera
        LatLng coffee = new LatLng(-35.239040, 149.082282);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        final Marker coffeeMarker = mMap.addMarker(new MarkerOptions()
                .position(coffee)
                .title("Coffee Grounds")
                .snippet("The Best Coffee on campus, underneath Cooper Lodge")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_coffee))

        );

        // Add a marker in Sydney and move the camera
        LatLng gym = new LatLng(-35.238369, 149.088280);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        final Marker gymMarker = mMap.addMarker(new MarkerOptions()
                .position(gym)
                .title("UC Gym")
                .snippet("Open to students, staff, and the general public.")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_gym))
        );


        // Add a marker in Sydney and move the camera
        LatLng studentcentre = new LatLng(-35.2388374, 149.0837368);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        final Marker studentcentreMarker = mMap.addMarker(new MarkerOptions()
                .position(studentcentre)
                .title("UC Student Centre")
                .snippet("Your gateway to access support and advise.")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_std_centre))
        );


        // Add a marker in Sydney and move the camera
        LatLng hub = new LatLng(-35.2386841, 149.0824977);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        final Marker hubMarker = mMap.addMarker(new MarkerOptions()
                .position(hub)
                .title("The Hub")
                .snippet("Below Concourse level between Building 1 and Building 8.")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_thehub))
        );

        // Add a marker in Sydney and move the camera
        LatLng parking = new LatLng(-35.241040, 149.084296);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        final Marker parkingMarker = mMap.addMarker(new MarkerOptions()
                .position(parking)
                .title("Main Parking Area")
                .snippet("Several hundred parks available.")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_parking))
        );


        // Add a marker in Sydney and move the camera
        LatLng natsemcentre = new LatLng(-35.240674, 149.086980);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        final Marker natsemcentreMarker = mMap.addMarker(new MarkerOptions()
                .position(natsemcentre)
                .title("NATSEM Centre")
                .snippet("The National Centre for Social and Economic Modelling.")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_natsemcentre))
        );


        // Add a marker in Sydney and move the camera
        LatLng uclibrary = new LatLng(-35.238117, 149.083384);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        final Marker uclibraryMarker = mMap.addMarker(new MarkerOptions()
                .position(uclibrary)
                .title("UC Library")
                .snippet("24/7 access for all students and staff.")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_library))
        );


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(-35.2381611, 149.0840864), 15));




        //Street VieW1
        LatLng Streetview1 = new LatLng(-35.2344325, 149.0868359);
        final Marker Streetview1Marker =  mMap.addMarker(new MarkerOptions().position(Streetview1).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_street_view_person))) ;


        //Street VieW2
        LatLng Streetview2 = new LatLng(-35.238375, 149.089377);
        final Marker Streetview2Marker =  mMap.addMarker(new MarkerOptions().position(Streetview2).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_street_view_person))) ;


//Zoom of the map
        CameraPosition cameraPosition = CameraPosition.builder()
               .target(studentcentre)
                .zoom(15)
                .bearing(120)
                .build();

        // Animate the change in camera view over 2 seconds
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),
               2000, null);




        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

//Maker to show the tag
            @Override
            public View getInfoContents(Marker marker) {
                View infoWindow = getLayoutInflater().inflate(R.layout.infowindow_with_image, null);
                TextView title = (TextView) infoWindow.findViewById(R.id.textViewTitle);
                TextView snippet = (TextView) infoWindow.findViewById(R.id.textViewSnippet);
                ImageView image = (ImageView) infoWindow.findViewById(R.id.imageView);

                if (marker.getId().equals(coffeeMarker.getId())) {
                    title.setText(marker.getTitle());
                    snippet.setText(marker.getSnippet());
                    image.setImageDrawable(getResources()
                            .getDrawable(R.drawable.coffee_grounds, getTheme()));
                }



                if (marker.getId().equals(gymMarker.getId())) {
                    title.setText(marker.getTitle());
                    snippet.setText(marker.getSnippet());
                    image.setImageDrawable(getResources()
                            .getDrawable(R.drawable.gym, getTheme()));
                }


                if (marker.getId().equals(studentcentreMarker.getId())) {
                    title.setText(marker.getTitle());
                    snippet.setText(marker.getSnippet());
                    image.setImageDrawable(getResources()
                            .getDrawable(R.drawable.src, getTheme()));

                }



                if (marker.getId().equals(hubMarker.getId())) {
                    title.setText(marker.getTitle());
                    snippet.setText(marker.getSnippet());
                    image.setImageDrawable(getResources()
                            .getDrawable(R.drawable.the_hub, getTheme()));
                }



                if (marker.getId().equals(parkingMarker.getId())) {
                    title.setText(marker.getTitle());
                    snippet.setText(marker.getSnippet());
                    image.setImageDrawable(getResources()
                            .getDrawable(R.drawable.parking, getTheme()));
                }




                if (marker.getId().equals(natsemcentreMarker.getId())) {
                    title.setText(marker.getTitle());
                    snippet.setText(marker.getSnippet());
                    image.setImageDrawable(getResources()
                            .getDrawable(R.drawable.sc, getTheme()));
                }



                if (marker.getId().equals(uclibraryMarker.getId())) {
                    title.setText(marker.getTitle());
                    snippet.setText(marker.getSnippet());
                    image.setImageDrawable(getResources()
                            .getDrawable(R.drawable.library, getTheme()));
                }


                //For street view 1
                if (marker.getId().equals(Streetview1Marker.getId()))
                {
                    Intent intent = new Intent(getApplicationContext(), Google_Street_View.class);
                    startActivity(intent);
                    infoWindow = null;
                }


                //For street view 2
                if (marker.getId().equals(Streetview2Marker.getId())) {
                    Intent intent = new Intent(getApplicationContext(), Google_Street_View2.class);
                    startActivity(intent);
                    infoWindow = null;
                }



                return infoWindow;
            }
        });


        //Link to Web
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {

                if (marker.getId().equals(uclibraryMarker.getId()))
                    {
                        Intent intent = new Intent(getApplicationContext(), webview.class);
                        intent.putExtra("LinkWeb","http://www.canberra.edu.au/library");
                        startActivity(intent);
                    }

                if (marker.getId().equals(studentcentreMarker.getId()))
                {
                    Intent intent = new Intent(getApplicationContext(), webview.class);
                    intent.putExtra("LinkWeb","http://www.canberra.edu.au/current-students/canberra-students/student-centre");
                    startActivity(intent);
                }

                if (marker.getId().equals(natsemcentreMarker.getId()))
                {
                    Intent intent = new Intent(getApplicationContext(), webview.class);
                    intent.putExtra("LinkWeb","http://www.natsem.canberra.edu.au/");
                    startActivity(intent);
                }

                if (marker.getId().equals(parkingMarker.getId()))
                {
                    Intent intent = new Intent(getApplicationContext(), webview.class);
                    intent.putExtra("LinkWeb","http://www.canberra.edu.au/on-campus/parking");
                    startActivity(intent);
                }

                if (marker.getId().equals(hubMarker.getId()))
                {
                    Intent intent = new Intent(getApplicationContext(), webview.class);
                    intent.putExtra("LinkWeb","https://www.canberra.edu.au/maps/buildings-directory/the-hub");
                    startActivity(intent);
                }

                if (marker.getId().equals(gymMarker.getId()))
                {
                    Intent intent = new Intent(getApplicationContext(), webview.class);
                    intent.putExtra("LinkWeb","http://www.ucunion.com.au/fitness-centre/");
                    startActivity(intent);
                }

                if (marker.getId().equals(coffeeMarker.getId()))
                {
                    Intent intent = new Intent(getApplicationContext(), webview.class);
                    intent.putExtra("LinkWeb","http://www.canberra.edu.au/on-campus/shopping");
                    startActivity(intent);
                }



            }
        });
    }


    }

