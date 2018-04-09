package com.example.gncis.test1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gncis on 09-Apr-18.
 */

public class TripAdapter extends ArrayAdapter<Trip> {

    LinearLayout linearLayout;

    public TripAdapter(@NonNull Context context, int resource,@NonNull ArrayList<Trip> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null)
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.user_tile, parent,false);

        TextView Number = convertView.findViewById(R.id.number);
        TextView StartDate = convertView.findViewById(R.id.sdate);
        TextView EndDate = convertView.findViewById(R.id.edate);

        linearLayout = convertView.findViewById(R.id.trip_tile);

        final Trip trip = getItem(position);

        assert trip != null;

        Number.setText(trip.getTripName());
        StartDate.setText(trip.gettSDate());
        EndDate.setText(trip.gettEDate());

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return convertView;
    }
}
