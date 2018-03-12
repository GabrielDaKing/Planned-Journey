package com.example.gncis.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;


public class Main2Activity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn1 =(Button)findViewById(R.id.button_send1);
        btn2 =(Button)findViewById(R.id.button_send2);
        btn3 =(Button)findViewById(R.id.button_send3);


        // Choose authentication providers
        onButtonListener();

    }

    public void onButtonListener(){

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "View Current trip", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Main2Activity.this , ViewCurrent.class));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "Create a new trip", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Main2Activity.this , CreateNew.class));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "View Old Trips", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Main2Activity.this , ViewOld.class));
            }
        });

    }
}
