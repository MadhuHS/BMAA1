package com.jspiders.omg.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Window;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.jspiders.omg.R;
import com.jspiders.omg.TempleDetails;
import com.jspiders.omg.TempleModel;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.HashMap;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import io.realm.Realm;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener, GoogleMap.OnMarkerClickListener {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private boolean mPermissionDenied = false;
    List<HashMap<String, String>> places = null;
    private String apiURL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=$lat,$lng&radius=5000&type=hindu_temple&name=cruise&key=AIzaSyBD4Zet-h7nziG38zToYlEpJCg8vwsWSX4";
    TempleModel modelobj;

    private GoogleMap mMap;
    protected LocationManager locationManager;
    //private FetchPlaces fetchPlaces;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_map);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        int hasmapsperms = checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION);

        if (hasmapsperms != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);

        } else {
            mMap.setMyLocationEnabled(true);
            mMap.setOnMarkerClickListener((GoogleMap.OnMarkerClickListener) this);
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 400, 100, this);
            //fetchPlaces=new FetchPlaces(mMap);



        }


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case LOCATION_PERMISSION_REQUEST_CODE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("PERM DEBUG", "GRANTED PERMISSION");

                } else {
                    Log.d("PERM DEBUG", "PERMISSION DENIED");

                }

                break;
        }
    }



    @Override
    public void onLocationChanged(Location location) {
        Log.d("LOCDEBUG", "inside onLocationChanged");
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        String lat = String.valueOf(location.getLatitude());
        String lng = String.valueOf(location.getLongitude());
        mMap.addMarker(new MarkerOptions()
                .position(latLng).snippet("You are here")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 15);
        mMap.animateCamera(cameraUpdate);
        //fetchPlaces.execute(latLng);

        AsyncHttpClient client = new AsyncHttpClient();
        apiURL = apiURL.replace("$lat", lat);
        apiURL = apiURL.replace("$lng", lng);
        client.get(apiURL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String json_str = new String(responseBody);
                Gson gson = new Gson();
                modelobj = gson.fromJson(json_str, TempleModel.class);
                Realm realm = Realm.getDefaultInstance();
                modelobj = realm.createObject(TempleModel.class);
                addmarkers(modelobj);
                int no_temples = modelobj.getResults().size();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });



        Log.d("LOCDEBUG", "finished onLocationChanged");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Log.d("[DEBUG]", "YOU CLI*KED ON MARKER");

        Intent intent = new Intent(getApplicationContext(), TempleDetails.class);
        intent.putExtra("Tobj",modelobj);
        startActivity(intent);

        return false;
    }

    public void addmarkers(TempleModel templeobj)
    {
       int no_temples = templeobj.getResults().size();

        for (int i = 0; i < no_temples; i++) {

            // Getting latitude of the place
            double lato = templeobj.getResults().get(i).getGeometry().getLocation().getLat();

            // Getting longitude of the place
            double lngo = templeobj.getResults().get(i).getGeometry().getLocation().getLng();

            LatLng latLng = new LatLng(lato,lngo);
            // Getting name
            String name = templeobj.getResults().get(i).getName();

            mMap.addMarker(new MarkerOptions()
                    .position(latLng).snippet("temple").title(name)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.templemarker)));
        }
    }
}
