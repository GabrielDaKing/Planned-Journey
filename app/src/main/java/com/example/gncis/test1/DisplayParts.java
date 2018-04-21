package com.example.gncis.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gncis.test1.data.BusDBHelper;
import com.example.gncis.test1.data.FlightDBHelper;
import com.example.gncis.test1.data.HotelDBHelper;
import com.example.gncis.test1.data.TrainDBHelper;
import com.example.gncis.test1.data.UserDBHelper;

import java.util.ArrayList;

public class DisplayParts extends AppCompatActivity {

    Trip trip;
    TextView NAME,sDATE,eDATE;
    UserDBHelper userDBHelper;
    FlightAdapter flightAdapter;
    TrainAdapter trainAdapter;
    HotelAdapter hotelAdapter;
    BusAdapter busAdapter;
    ArrayList<Flight> flights;
    ArrayList<Train> trains;
    ArrayList<Hotel> hotels;
    ArrayList<Bus> buses;
    FlightDBHelper flightDBHelper;
    HotelDBHelper hotelDBHelper;
    TrainDBHelper trainDBHelper;
    BusDBHelper busDBHelper;
    ImageButton delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_parts);

        userDBHelper = new UserDBHelper(getApplicationContext());
        flightDBHelper = new FlightDBHelper(getApplicationContext());
        hotelDBHelper = new HotelDBHelper(getApplicationContext());
        trainDBHelper = new TrainDBHelper(getApplicationContext());
        busDBHelper = new BusDBHelper(getApplicationContext());

        trip = new Trip();

        NAME=findViewById(R.id.name);
        sDATE=findViewById(R.id.sdate);
        eDATE=findViewById(R.id.edate);

        Bundle bundle = getIntent().getBundleExtra("TRIP");
        if(bundle != null){
            trip.setTripName(bundle.getString("name"));
            trip.settSDate(bundle.getString("sdate"));
            trip.settEDate(bundle.getString("edate"));
            trip.setId(bundle.getInt("id"));

            NAME.setText(trip.getTripName());
            sDATE.setText(trip.gettSDate());
            eDATE.setText(trip.gettEDate());
        }

        flights = flightDBHelper.displayFlights(trip.getId());

        ListView flightListView = findViewById(R.id.flightList);
        flightAdapter = new FlightAdapter(this, R.layout.flight_tile, flights);
        flightListView.setAdapter(flightAdapter);

        flightListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Flight flight = flightAdapter.getItem(position);
                Bundle bundle = new Bundle();
                bundle.putInt("id", flight.getFid());
                startActivity(new Intent(DisplayParts.this,DisplayPartsFlight.class).putExtra("FLIGHT", bundle));

            }
        });

        trains = trainDBHelper.displayTrains(trip.getId());

        ListView trainListView = findViewById(R.id.trainList);
        trainAdapter = new TrainAdapter(this, R.layout.train_tile, trains);
        trainListView.setAdapter(trainAdapter);

        hotels = hotelDBHelper.displayHotels(trip.getId());

        ListView hotelListView = findViewById(R.id.hotelList);
        hotelAdapter = new HotelAdapter(this, R.layout.hotel_tile, hotels);
        hotelListView.setAdapter(hotelAdapter);

        buses = busDBHelper.displayBuses(trip.getId());

        ListView busListView = findViewById(R.id.busList);
        busAdapter = new BusAdapter(this, R.layout.bus_tile, buses);
        busListView.setAdapter(busAdapter);

        deleteOnClickListener();

    }

    public void deleteOnClickListener(){

        delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userDBHelper.deleteTripForID(trip.getId());
            }
        });
    }
}
