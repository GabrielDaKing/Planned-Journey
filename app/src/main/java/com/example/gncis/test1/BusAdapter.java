package com.example.gncis.test1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Anant on 4/21/2018.
 */

public class BusAdapter extends ArrayAdapter<Bus>{

    private ArrayList<Bus> object;
    LinearLayout linearLayout;

    public BusAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Bus> objects) {
        super(context, resource, objects);
        this.object=objects;

    }
    @NonNull
    @Override
    public View getView(int Position, @NonNull View convertView, @NonNull ViewGroup parent){
        if(convertView== null)
            convertView = ((Activity)getContext()).getLayoutInflater().inflate(R.layout.bus_tile, parent, false);

        TextView Number=convertView.findViewById(R.id.number), StartDate = convertView.findViewById(R.id.sdate), EndDate=convertView.findViewById(R.id.edate);

        linearLayout = convertView.findViewById(R.id.Bus_Tile);
        final Bus bus=getItem(Position);

        Number.setText(bus.getbNumber());
        StartDate.setText(bus.getbDepartureDate());
        EndDate.setText(bus.getbArrivalDate());

        linearLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i;
            }
        });
        return convertView;
    }
}
