package com.example.gncis.test1;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.gncis.test1.data.UserDBHelper;

import java.util.ArrayList;

public class ViewOld extends AppCompatActivity {

    ActionBar bar;
    static ArrayList<Trip> trips;
    private TripAdapter tripAdapter;

    UserDBHelper userDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_current);

        bar = getSupportActionBar();

        bar.setTitle("Your Current Trip");

        userDBHelper =new UserDBHelper(getApplicationContext());

        trips = userDBHelper.displayAllNewTrips();

        final ListView listView = findViewById(R.id.currentTripsList);
        tripAdapter = new TripAdapter(this, R.layout.user_tile, trips);
        listView.setAdapter(tripAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Trip trip = tripAdapter.getItem(position);
                Bundle bundle = new Bundle();
                bundle.putString("name", trip.getTripName());
                bundle.putString("sdate", trip.gettSDate());
                bundle.putString("edate", trip.gettEDate());
                startActivity(new Intent(ViewOld.this,DisplayParts.class).putExtra("trip", bundle));

            }
        });

    }
}
