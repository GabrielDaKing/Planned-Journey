package com.example.gncis.test1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CreateNewActivity extends AppCompatActivity {

    ImageView img1;
    TextView head,txt1;
    ImageButton cncl,cnfrm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new2);

        Bundle bun = getIntent().getExtras();

        int select;

        head=findViewById(R.id.head);
        cncl=findViewById(R.id.ccl);
        cnfrm=findViewById(R.id.crm);

        img1=findViewById(R.id.image1);

        txt1=findViewById(R.id.text1);

        select = bun.getInt("selection");

        switch(select){

            case 1 : img1.setImageResource(R.drawable.ic_flight_takeoff_black_24dp);
                txt1.setText("Flight NO :");
                head.setText("PLANE");
                break;

            case 2 : img1.setImageResource(R.drawable.ic_directions_railway_black_36dp);
                txt1.setText("Train NO :");
                head.setText("TRAIN");
                break;

            case 3 : img1.setImageResource(R.drawable.ic_directions_boat_black_36dp);
                txt1.setText("Boat NO :");
                head.setText("BOAT");
                break;

            case 4 : img1.setImageResource(R.drawable.ic_directions_bus_black_36dp);
                txt1.setText("Bus NO :");
                head.setText("BUS");
                break;

            case 5 : img1.setImageResource(R.drawable.ic_directions_car_black_36dp);
                txt1.setText("Car NO :");
                head.setText("CAR");
                break;

            case 6 : img1.setImageResource(R.drawable.ic_directions_walk_black_36dp);
                txt1.setText(" NO :");
                head.setText("WALK");
                break;
        }

        onCancelClickListener();
        onConfirmClickListener();
    }

    public void onCancelClickListener(){
        cncl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder=new AlertDialog.Builder(CreateNewActivity.this);
                builder.setMessage("Are you want to cancel creating this journey ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(CreateNewActivity.this,Main2Activity.class));
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
    
    public void onConfirmClickListener(){
        cnfrm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder=new AlertDialog.Builder(CreateNewActivity.this);
                builder.setMessage("Are you want to create this trip ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(CreateNewActivity.this,Main2Activity.class));
                        Toast.makeText(CreateNewActivity.this, "YAY!", Toast.LENGTH_SHORT).show();
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
