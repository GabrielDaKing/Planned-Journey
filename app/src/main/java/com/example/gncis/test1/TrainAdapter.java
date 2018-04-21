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

public class TrainAdapter extends ArrayAdapter<Train>{
    private ArrayList<Train> object;
    LinearLayout linearLayout;
    public TrainAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Train> objets){
        super(context, resource, objets);
        this.object=objets;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){

        if(convertView== null)
            convertView=((Activity)getContext()).getLayoutInflater().inflate(R.layout.train_tile,parent,false);
        TextView Number=convertView.findViewById(R.id.number), StartDate = convertView.findViewById(R.id.sdate), EndDate=convertView.findViewById(R.id.edate);

        linearLayout = convertView.findViewById(R.id.Train_Tile);
        final Train train=getItem(position);

        Number.setText(train.getTnumber());
        StartDate.setText(train.gettDepartureDate());
        EndDate.setText(train.gettArrivalDate());

        linearLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i;
            }
        });
        return convertView;

    }
}
