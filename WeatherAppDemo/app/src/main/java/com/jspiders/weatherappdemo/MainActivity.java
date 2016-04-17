package com.jspiders.weatherappdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView citynameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        citynameTextView = (TextView) findViewById(R.id.cityname);

        NetworkTask networkTask = new NetworkTask(citynameTextView);
        networkTask.execute();



    }
}
