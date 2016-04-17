package com.jspiders.weatherappdemo;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by mhs on 4/17/2016.
 */
public class NetworkTask extends AsyncTask {

    TextView citynameTextView;

    NetworkTask (TextView citynameTextView)
    {
        this.citynameTextView = citynameTextView;
    }

    String apiurl = "http://api.openweathermap.org/data/2.5/weather?q=Bangalore,India&appid=b1b15e88fa797225412429c1c50c122a";
    String jsonresponse;
    @Override
    protected Object doInBackground(Object[] params) {

        try
        {
            URL url = new URL(apiurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuffer buffer = new StringBuffer();
            String line ="";

            while ((line=bufferedReader.readLine())!=null)
            {
                buffer.append(line+"/n"+"/r");
            }

            jsonresponse = buffer.toString();

            Log.d("DEBUG",jsonresponse);

            String samplejson = "{\n" +
                    "  \"coord\": {\n" +
                    "    \"lon\": 77.6,\n" +
                    "    \"lat\": 12.98\n" +
                    "  }\n" +
                    "}";
            Gson gson = new Gson();
            gson.fromJson(samplejson,Cords.class);

            Cords.CoordBean coordBean = new Cords.CoordBean();
            Log.d("DEBUG",""+coordBean.getLat());




        }

        catch (MalformedURLException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        Response response = new Response();
        String cityname = response.getName();
        citynameTextView.setText(cityname);
    }
}
