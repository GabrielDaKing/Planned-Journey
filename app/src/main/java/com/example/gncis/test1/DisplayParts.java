package com.example.gncis.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayParts extends AppCompatActivity {

    Trip trip;
    TextView NAME,sDATE,eDATE;
    FlightAdapter flightAdapter;
    ArrayList<Flight> flights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_parts);

        trip = new Trip();

        NAME=findViewById(R.id.name);
        sDATE=findViewById(R.id.sdate);
        eDATE=findViewById(R.id.edate);

        Bundle bundle = getIntent().getBundleExtra("TRIP");
        if(bundle != null){
            trip.setTripName(bundle.getString("name"));
            trip.settSDate(bundle.getString("sdate"));
            trip.settEDate(bundle.getString("edate"));

            NAME.setText(trip.getTripName());
            sDATE.setText(trip.gettSDate());
            eDATE.setText(trip.gettEDate());
        }

        //final ListView listView = findViewById(R.id.currentTripsList);
        //flightAdapter = new FlightAdapter(this, R.layout.flight_tile, flights);
        //listView.setAdapter(flightAdapter);

    }
}
