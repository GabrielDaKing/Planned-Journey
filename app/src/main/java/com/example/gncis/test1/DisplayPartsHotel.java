package com.example.gncis.test1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.gncis.test1.data.HotelDBHelper;
import com.example.gncis.test1.data.TrainDBHelper;

import java.util.ArrayList;

public class DisplayPartsHotel extends AppCompatActivity {

    ImageButton delete;
    HotelDBHelper hotelDBHelper;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_parts_hotel);

        Bundle bundle = getIntent().getBundleExtra("HOTEL");
        id = bundle.getInt("id");

        delete = findViewById(R.id.delete);

        ArrayList<Hotel> hotel = new ArrayList<Hotel>();

        hotel= hotelDBHelper.displayHotels(id);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(DisplayPartsHotel.this);
                builder.setMessage("Are you want to delete this Hotel Entry ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        hotelDBHelper.deleteHotelint(id);


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
