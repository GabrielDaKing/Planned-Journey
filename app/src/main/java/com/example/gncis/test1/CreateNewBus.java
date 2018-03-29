package com.example.gncis.test1;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreateNewBus extends AppCompatActivity {

  

        ImageView img1;
        TextView head,txt1;
        ImageButton cncl,cnfrm;
        EditText StartDate, EndDate,StartTime,EndTime;
        Calendar myCalendar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_create_new_bus);

            myCalendar = Calendar.getInstance();

            Bundle bun = getIntent().getExtras();

            int select;

            head=findViewById(R.id.head);
            cncl=findViewById(R.id.ccl);
            cnfrm=findViewById(R.id.crm);

            //img1=findViewById(R.id.image1);

            StartTime=findViewById(R.id.StartTime2);
            EndTime=findViewById(R.id.EndTime2);
            StartDate=findViewById(R.id.StartDate2);
            EndDate=findViewById(R.id.EndDate2);


            select = bun.getInt("selection");

            final DatePickerDialog.OnDateSetListener stdate = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    myCalendar.set(Calendar.YEAR, i);
                    myCalendar.set(Calendar.MONTH, i1);
                    myCalendar.set(Calendar.DAY_OF_MONTH, i2);
                    updateLabel1();
                }
            };

            final DatePickerDialog.OnDateSetListener eddate = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    myCalendar.set(Calendar.YEAR, i);
                    myCalendar.set(Calendar.MONTH, i1);
                    myCalendar.set(Calendar.DAY_OF_MONTH, i2);
                    updateLabel2();
                }
            };



            StartTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Calendar mcurrentTime=Calendar.getInstance();
                    int hour=mcurrentTime.get(Calendar.HOUR_OF_DAY);
                    int minute=mcurrentTime.get(Calendar.MINUTE);
                    TimePickerDialog mTimePicker=new TimePickerDialog(CreateNewBus.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int i, int i1) {
                            StartTime.setText(i+":"+i1);
                        }
                    },hour,minute,true);
                    mTimePicker.setTitle("Select Time");
                    mTimePicker.show();
                }
            });

            EndTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Calendar mcurrentTime=Calendar.getInstance();
                    int hour=mcurrentTime.get(Calendar.HOUR_OF_DAY);
                    int minute=mcurrentTime.get(Calendar.MINUTE);
                    TimePickerDialog mTimePicker=new TimePickerDialog(CreateNewBus.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int i, int i1) {
                            StartTime.setText(i+":"+i1);
                        }
                    },hour,minute,true);
                    mTimePicker.setTitle("Select Time");
                    mTimePicker.show();
                }
            });


            StartDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    new DatePickerDialog(CreateNewBus.this, stdate, myCalendar.
                            get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
            });
            EndDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new DatePickerDialog(CreateNewBus.this, eddate, myCalendar.
                            get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
            });

            onCancelClickListener();
            onConfirmClickListener();
        }

    public void onCancelClickListener(){
        cncl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder=new AlertDialog.Builder(CreateNewBus.this);
                builder.setMessage("Are you want to cancel creating this journey ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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

    public void onConfirmClickListener(){
        cnfrm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder=new AlertDialog.Builder(CreateNewBus.this);
                builder.setMessage("Are you want to create this trip ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(CreateNewBus.this,Main2Activity.class));
                        Toast.makeText(CreateNewBus.this, "YAY!", Toast.LENGTH_SHORT).show();
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

    private void updateLabel1() {
        String myFormat = "dd/MM/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.UK);

        StartDate.setText(sdf.format(myCalendar.getTime()));
    }

    private void updateLabel2() {
        String myFormat = "dd/MM/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.UK);

        EndDate.setText(sdf.format(myCalendar.getTime()));
    }
}

