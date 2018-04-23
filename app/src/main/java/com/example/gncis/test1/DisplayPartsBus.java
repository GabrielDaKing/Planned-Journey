package com.example.gncis.test1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.gncis.test1.data.BusDBHelper;
import com.example.gncis.test1.data.FlightDBHelper;

import java.util.ArrayList;

public class DisplayPartsBus extends AppCompatActivity {

    ImageButton delete;
    BusDBHelper busDBHelper;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_parts_bus);

        Bundle bundle = getIntent().getBundleExtra("BUS");
        id = bundle.getInt("id");

        delete = findViewById(R.id.delete);

        ArrayList<Bus> bus = new ArrayList<Bus>();

        bus = busDBHelper.displayBuses(id);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(DisplayPartsBus.this);
                builder.setMessage("Are you want to delete this Bus Entry ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        busDBHelper.deleteBusint(id);

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
    public void onBackPressed(){
        finish();
    }
}
