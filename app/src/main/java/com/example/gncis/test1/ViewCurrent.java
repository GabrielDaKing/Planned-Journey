package com.example.gncis.test1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gncis.test1.data.UserContract;
import com.example.gncis.test1.data.UserDBHelper;
import com.firebase.ui.auth.AuthUI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ViewCurrent extends AppCompatActivity {

    ActionBar bar;
    static ArrayList<Trip> trips;
    private TripAdapter tripAdapter;

    UserDBHelper userDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_current);

        bar = getSupportActionBar();

        bar.setTitle("Your Current Trips");

        userDBHelper =new UserDBHelper(getApplicationContext());

        trips = userDBHelper.displayAllNewTrips();

       ListView listView = findViewById(R.id.currentTripsList);
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
                bundle.putInt("id", trip.getId());
                Toast.makeText(ViewCurrent.this, "Details of trip "+ trip.getTripName(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ViewCurrent.this,DisplayParts.class).putExtra("TRIP", bundle));

            }
        });

    }

    public void onBackPressed(){
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.delete_all_trips, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_all:
                userDBHelper.deleteAllTrips();
                trips = userDBHelper.displayAllNewTrips();
                tripAdapter = new TripAdapter(this, R.layout.user_tile, trips);
                final ListView listView = findViewById(R.id.currentTripsList);
                listView.setAdapter(tripAdapter);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
