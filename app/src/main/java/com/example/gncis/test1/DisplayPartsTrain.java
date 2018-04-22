package com.example.gncis.test1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.gncis.test1.data.FlightDBHelper;
import com.example.gncis.test1.data.TrainDBHelper;

import java.util.ArrayList;

public class DisplayPartsTrain extends AppCompatActivity {

    ImageButton delete;
    TrainDBHelper trainDBHelper;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_parts_train);

        Bundle bundle = getIntent().getBundleExtra("TRAIN");
        id = bundle.getInt("id");

        delete = findViewById(R.id.delete);

        ArrayList<Train> train = new ArrayList<Train>();

        train= trainDBHelper.displayTrains(id);


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(DisplayPartsTrain.this);
                builder.setMessage("Are you want to delete this train entry?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        trainDBHelper.deleteTrainint(id);


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
