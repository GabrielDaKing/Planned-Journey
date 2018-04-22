package com.example.gncis.test1;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gncis.test1.data.BusDBHelper;
import com.example.gncis.test1.data.FlightDBHelper;
import com.example.gncis.test1.data.HotelDBHelper;
import com.example.gncis.test1.data.TrainDBHelper;
import com.example.gncis.test1.data.UserDBHelper;
import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private TextView iv;

    //private UserDBHelper userDBHelper;
    //private FlightDBHelper flightDBHelper;
    //private TrainDBHelper trainDBHelper;
    //private BusDBHelper busDBHelper;
   // private HotelDBHelper hotelDBHelper;

   // private SQLiteDatabase sqLiteDatabase;

   // private Animation.AnimationListener al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.txt);
        iv =findViewById(R.id.txthead);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv.startAnimation(myanim);
        iv.startAnimation(myanim);

        myanim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(MainActivity.this , Main2Activity.class));
            }



            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

}
