package com.example.gncis.test1;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CreateNew extends AppCompatActivity {

    ActionBar bar;
    ImageButton btn1, btn2, btn3, btn4, btn5, btn6;
    boolean flag;
    int selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);

        bar = getSupportActionBar();

        btn1 = findViewById(R.id.plane);
        btn2 = findViewById(R.id.train);
        btn3 = findViewById(R.id.boat);
        btn4 = findViewById(R.id.bus);


        bar.setTitle("A New Trip");

        onButtonClickListener();

    }

    public void onButtonClickListener(){

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection=1;
                flag=true;
                Intent i = new Intent(CreateNew.this,CreateNewActivity.class);
                i.putExtra("selection"  , selection);
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection=2;
                flag=true;
                Intent i = new Intent(CreateNew.this,CreateNewActivity.class);
                i.putExtra("selection"  , selection);
                startActivity(i);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection=3;
                flag=true;
                Intent i = new Intent(CreateNew.this,CreateNewActivity.class);
                i.putExtra("selection"  , selection);
                startActivity(i);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection=4;
                flag=true;
                Intent i = new Intent(CreateNew.this,CreateNewActivity.class);
                i.putExtra("selection"  , selection);
                startActivity(i);
            }
        });


    }
}
