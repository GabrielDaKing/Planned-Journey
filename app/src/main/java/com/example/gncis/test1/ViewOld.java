package com.example.gncis.test1;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewOld extends AppCompatActivity {

    ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_old);

        bar = getSupportActionBar();

        bar.setTitle("Your Past Trips");
    }
}
