package com.example.gncis.test1;

import android.content.Intent;
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

import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

<<<<<<< HEAD
    private TextView tv,iv;

=======
    private TextView tv;
    private TextView iv;
>>>>>>> 0a2ecfb6e311d674760ae9366756c134a5dc5594


   // private Animation.AnimationListener al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        tv = (TextView)findViewById(R.id.txt);
        iv =(TextView)findViewById(R.id.txthead);
=======
        tv = findViewById(R.id.txt);
        iv =findViewById(R.id.textView);
>>>>>>> 0a2ecfb6e311d674760ae9366756c134a5dc5594
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
