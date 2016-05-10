package com.jspiders.omg.networkutils;

/*
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jspiders.omg.R;
import com.jspiders.omg.models.Result;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

*/
/**
 * Created by mhs on 4/17/2016.
 *//*

public class FetchPlaces extends AsyncTask<LatLng, String, Void> {

    private String apiURL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=$lat,$lng&radius=5000&type=hindu_temple&name=cruise&key=AIzaSyBD4Zet-h7nziG38zToYlEpJCg8vwsWSX4";
    List<Result> list;
    String jsondata;
    List<HashMap<String, String>> places = null;
    HashMap<String, String> hmPlace;
    GoogleMap mMap;

    public FetchPlaces(GoogleMap mMap) {
        this.mMap = mMap;
    }


    @Override
    protected Void doInBackground(LatLng... params) {

        try {

           String lat = String.valueOf(params[0].latitude);
            String lng = String.valueOf(params[0].longitude);
            apiURL = apiURL.replace("$lat", lat);
            apiURL = apiURL.replace("$lng", lng);
            Log.d("THIS IS URL>>>>>", apiURL);
            HttpURLConnection connection = (HttpURLConnection) new URL(apiURL).openConnection();
            InputStream ins = connection.getInputStream();
            InputStreamReader inr = new InputStreamReader(ins);
            BufferedReader bufferedReader = new BufferedReader(inr);
            StringBuffer buffer = new StringBuffer();
            String data = "";

            while ((data = bufferedReader.readLine()) != null) {
                buffer.append(data);
            }

            jsondata = buffer.toString();
            Log.d("DEBUG", jsondata);
            PlaceJSONParser placeJsonParser = new PlaceJSONParser();
            JSONObject jObject = new JSONObject(jsondata);
            places = placeJsonParser.parse(jObject);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d("DEBUG",""+places.size());

        for (int i = 0; i < places.size(); i++) {

            // Getting a place from the places list
            hmPlace = places.get(i);

            // Getting latitude of the place
            double lato = Double.parseDouble(hmPlace.get("lat"));

            // Getting longitude of the place
            double lngo = Double.parseDouble(hmPlace.get("lng"));

            LatLng latLng = new LatLng(Double.parseDouble(hmPlace.get("lat")), Double.parseDouble(hmPlace.get("lng")));
            // Getting name
            String name = hmPlace.get("place_name");

            Log.d("", "latitude>>>> " + lato + "longitude>>>> " + lngo);

            mMap.addMarker(new MarkerOptions()
                    .position(latLng).snippet("temple").title(name)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.templemarker)));
        }
    }
}

*/
