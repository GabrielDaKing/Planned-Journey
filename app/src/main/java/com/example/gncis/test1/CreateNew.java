package com.example.gncis.test1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gncis.test1.data.UserDBHelper;

import static com.example.gncis.test1.R.anim.shake;

public class CreateNew extends AppCompatActivity {

    ActionBar bar;


    ImageButton btn1, btn2, btn3, btn4, can, cfrm;
    UserDBHelper userDBHelper;
    static EditText name;
    Trip trip;
    static int insert=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);
        //ANIMATIONS
        Animation AnimShake=AnimationUtils.loadAnimation(this, shake);
        userDBHelper = new UserDBHelper(getApplicationContext());

        bar = getSupportActionBar();


        btn1 = findViewById(R.id.plane);
        btn2 = findViewById(R.id.train);
        btn3 = findViewById(R.id.boat);
        btn4 = findViewById(R.id.bus);
        can = findViewById(R.id.cancel);
        cfrm = findViewById(R.id.confirm);

        name = findViewById(R.id.nameOfTrip);

        trip = new Trip();

        bar.setTitle("A New Trip");

        onButtonClickListener();


    }

    public void onButtonClickListener(){



        btn1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(insert==0) {
                    insert = 1;
                    trip = new Trip();
                    trip.setTripName(name.getText().toString());
                    userDBHelper = new UserDBHelper(getApplicationContext());
                    trip.setId(-1);
                    userDBHelper.addUser(trip);

                    Bundle bundle = new Bundle();
                    bundle.putInt("id", userDBHelper.returnID());

                    startActivity(new Intent(CreateNew.this,CreateNewActivity.class).putExtra("TRIP", bundle));
                }



            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(insert==0) {
                    insert = 1;
                    trip = new Trip();
                    trip.setTripName(name.getText().toString());
                    userDBHelper = new UserDBHelper(getApplicationContext());
                    trip.setId(-1);
                    userDBHelper.addUser(trip);
                }
                userDBHelper = new UserDBHelper(getApplicationContext());
                Bundle bundle = new Bundle();
                bundle.putInt("id", userDBHelper.returnID());

                startActivity(new Intent(CreateNew.this,CreateNewTrain.class).putExtra("TRIP", bundle));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(insert==0) {
                    insert = 1;
                    trip = new Trip();
                    trip.setTripName(name.getText().toString());
                    userDBHelper = new UserDBHelper(getApplicationContext());
                    trip.setId(-1);
                    userDBHelper.addUser(trip);
                }
                userDBHelper = new UserDBHelper(getApplicationContext());
                Bundle bundle = new Bundle();
                bundle.putInt("id", userDBHelper.returnID());

                startActivity(new Intent(CreateNew.this,CreateNewHotel.class).putExtra("TRIP", bundle));
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(insert==0) {
                    insert = 1;
                    trip = new Trip();
                    trip.setTripName(name.getText().toString());
                    userDBHelper = new UserDBHelper(getApplicationContext());
                    trip.setId(-1);
                    userDBHelper.addUser(trip);
                }
                userDBHelper = new UserDBHelper(getApplicationContext());
                Bundle bundle = new Bundle();
                bundle.putInt("id", userDBHelper.returnID());

                startActivity(new Intent(CreateNew.this,CreateNewBus.class).putExtra("TRIP", bundle));
            }
        });

        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        AlertDialog.Builder builder=new AlertDialog.Builder(CreateNew.this);
                        builder.setMessage("Are you want to cancel creating this journey ?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(insert==1){
                                    userDBHelper.deleteTripForID(userDBHelper.returnID());
                                }
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

        cfrm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(CreateNew.this);
                builder.setMessage("Are you want to create this trip ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if(insert==0) {
                            trip = new Trip();
                            trip.setTripName(name.getText().toString());
                            trip.settEDate("N/A");
                            trip.settSDate("N/A");
                            trip.setId(-1);

                            userDBHelper.addUser(trip);
                            insert=0;
                        }
                        Toast.makeText(CreateNew.this, "YAY!", Toast.LENGTH_SHORT).show();
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
