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

import com.example.gncis.test1.data.BusDBHelper;
import com.example.gncis.test1.data.TrainDBHelper;
import com.example.gncis.test1.data.UserDBHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreateNewTrain extends AppCompatActivity {

    TextView head;
    ImageButton cncl,cnfrm;
    EditText StartDate, EndDate,StartTime,EndTime,number,origin,destination,seat;
    Calendar myCalendar;
    int id;
    Train train;
    TrainDBHelper trainDBHelper;
    UserDBHelper userDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_train);

        myCalendar = Calendar.getInstance();

        head=findViewById(R.id.head);
        cncl=findViewById(R.id.ccl);
        cnfrm=findViewById(R.id.crm);

        number=findViewById(R.id.num);
        origin=findViewById(R.id.origin);
        destination=findViewById(R.id.destination);
        seat=findViewById(R.id.seat);

        StartTime=findViewById(R.id.StartTime2);
        EndTime=findViewById(R.id.EndTime2);
        StartDate=findViewById(R.id.StartDate2);
        EndDate=findViewById(R.id.EndDate2);

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
                TimePickerDialog mTimePicker=new TimePickerDialog(CreateNewTrain.this, new TimePickerDialog.OnTimeSetListener() {
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
                TimePickerDialog mTimePicker=new TimePickerDialog(CreateNewTrain.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        EndTime.setText(i+":"+i1);
                    }
                },hour,minute,true);
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });

        StartDate = (EditText) findViewById(R.id.StartDate2);
        EndDate = (EditText) findViewById(R.id.EndDate2);
        StartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new DatePickerDialog(CreateNewTrain.this, stdate, myCalendar.
                        get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        EndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(CreateNewTrain.this, eddate, myCalendar.
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

                AlertDialog.Builder builder=new AlertDialog.Builder(CreateNewTrain.this);
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


                AlertDialog.Builder builder=new AlertDialog.Builder(CreateNewTrain.this);
                builder.setMessage("Are you want to create this trip ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        train = new Train();
                        trainDBHelper = new TrainDBHelper(getApplicationContext());

                        train.setTnumber(number.toString());
                        train.settSeat(seat.toString());
                        train.settOrigin(origin.toString());
                        train.settDestination(destination.toString());
                        train.settDepartureDate(StartDate.toString());
                        train.settDepartureTime(StartTime.toString());
                        train.settArrivalDate(EndDate.toString());
                        train.settArrivalTime(EndTime.toString());

                        Bundle bun = getIntent().getBundleExtra("TRIP");
                        id = bun.getInt("id");

                        userDBHelper = new UserDBHelper(getApplicationContext());
                        userDBHelper.updateStartDate(train.gettDepartureDate(),id);
                        userDBHelper.updateEndDate(train.gettArrivalDate(),id);

                        trainDBHelper.addTrain(train,id);

                        finish();
                        Toast.makeText(CreateNewTrain.this, "YAY!", Toast.LENGTH_SHORT).show();
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

