package com.example.gncis.test1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.gncis.test1.data.FlightDBHelper;

public class DisplayPartsFlight extends AppCompatActivity {

    ImageButton delete;
    FlightDBHelper flightDBHelper;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_parts_flight);

        Bundle bundle = getIntent().getBundleExtra("FLIGHT");
        id = bundle.getInt("id");

        delete = findViewById(R.id.delete);

        Flight flight = new Flight();

        flight = flightDBHelper.displayFlight(id);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(DisplayPartsFlight.this);
                builder.setMessage("Are you want to cancel creating this journey ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        flightDBHelper.deleteFlightint(id);

                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });

    }
}
