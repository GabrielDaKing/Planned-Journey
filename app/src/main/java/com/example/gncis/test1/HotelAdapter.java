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

public class HotelAdapter extends ArrayAdapter<Hotel> {
    private ArrayList<Hotel> object;
    LinearLayout linearLayout;
    public HotelAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Hotel> objets){
        super(context, resource, objets);
        this.object=objets;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){

        if(convertView== null)
            convertView=((Activity)getContext()).getLayoutInflater().inflate(R.layout.hotel_tile,parent,false);
        TextView Name=convertView.findViewById(R.id.name), StartDate = convertView.findViewById(R.id.sdate), EndDate=convertView.findViewById(R.id.edate);

        linearLayout = convertView.findViewById(R.id.Hotel_Tile);
        final Hotel hotel=getItem(position);

        Name.setText(hotel.gethName());
        StartDate.setText(hotel.gethCheckinDate());
        EndDate.setText(hotel.gethCheckoutDate());

        linearLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            //h
            public void onClick(View v){
                Intent i;
            }
        });
        return convertView;

    }

}
