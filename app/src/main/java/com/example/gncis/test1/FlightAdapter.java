package com.example.gncis.test1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gncis.test1.Flight;
import com.example.gncis.test1.R;

import java.util.ArrayList;

/**
 * Created by gncis on 09-Apr-18.
 */

public class FlightAdapter extends ArrayAdapter<Flight> {

    private ArrayList<Flight> flights;
    LinearLayout linearLayout;
    public FlightAdapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null)
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.flight_tile, parent,false);

        TextView Number = convertView.findViewById(R.id.number);
        TextView StartDate = convertView.findViewById(R.id.sdate);
        TextView EndDate = convertView.findViewById(R.id.edate);

        linearLayout = convertView.findViewById(R.id.Flight_Tile);

        final Flight flight = getItem(position);

        assert flight != null;

        Number.setText(flight.getFnumber());
        StartDate.setText(flight.getfDepartureDate());
        EndDate.setText(flight.getfArrivalDate());

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
            }
        });


        return convertView;
    }


}
