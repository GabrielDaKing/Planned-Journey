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

import com.example.gncis.test1.data.FlightDBHelper;
import com.example.gncis.test1.data.UserDBHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreateNewActivity extends AppCompatActivity {

    TextView head;
    ImageButton cncl,cnfrm;
    EditText StartDate, EndDate,StartTime,EndTime,FlightNumber,Seat,Origin,Destination,Cls;
    Calendar myCalendar;
    FlightDBHelper flightDBHelper;
    UserDBHelper userDBHelper;
    int id;
    Flight flight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new2);

        myCalendar = Calendar.getInstance();

        head=findViewById(R.id.head);
        cncl=findViewById(R.id.ccl);
        cnfrm=findViewById(R.id.crm);

        FlightNumber = findViewById(R.id.flightnumber);
        Seat = findViewById(R.id.seat);
        Origin = findViewById(R.id.origin);
        Destination = findViewById(R.id.destination);
        StartTime=findViewById(R.id.StartTime);
        EndTime=findViewById(R.id.EndTime);
        StartDate=findViewById(R.id.StartDate);
        EndDate=findViewById(R.id.EndDate);
        Cls = findViewById(R.id.CLS);

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
                TimePickerDialog mTimePicker=new TimePickerDialog(CreateNewActivity.this, new TimePickerDialog.OnTimeSetListener() {
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
                TimePickerDialog mTimePicker=new TimePickerDialog(CreateNewActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        EndTime.setText(i+":"+i1);
                    }
                },hour,minute,true);
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });

        StartDate = findViewById(R.id.StartDate);
        EndDate = findViewById(R.id.EndDate);
        StartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new DatePickerDialog(CreateNewActivity.this, stdate, myCalendar.
                        get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        EndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(CreateNewActivity.this, eddate, myCalendar.
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

                AlertDialog.Builder builder=new AlertDialog.Builder(CreateNewActivity.this);
                builder.setMessage("Are you sure want to cancel creating this journey ?");
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

                AlertDialog.Builder builder=new AlertDialog.Builder(CreateNewActivity.this);
                builder.setMessage("Are you sure want to create this Flight ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        try {
                            flight = new Flight();

                            flightDBHelper = new FlightDBHelper(getApplicationContext());

                            flight.setFnumber(FlightNumber.toString());
                            flight.setfSeat(Seat.toString());
                            flight.setfOrigin(Origin.toString());
                            flight.setfDestination(Destination.toString());
                            flight.setfDepartureDate(StartDate.toString());
                            flight.setfDepartureTime(StartTime.toString());
                            flight.setfArrivalDate(EndDate.toString());
                            flight.setfArrivalTime(EndTime.toString());
                            flight.setfClass(Cls.toString());

                            Bundle bun = getIntent().getExtras();
                            id = bun.getInt("id");

                            userDBHelper = new UserDBHelper(getApplicationContext());
                            userDBHelper.updateStartDate(flight.getfDepartureDate(), id);
                            userDBHelper.updateEndDate(flight.getfArrivalDate(), id);

                            flightDBHelper.addFlight(flight, id);
                            finish();
                            //Toast.makeText(CreateNewActivity.this, "YAY!", Toast.LENGTH_SHORT).show();
                        }
                        catch (Exception e){
                            Toast.makeText(CreateNewActivity.this, "Please enter all data", Toast.LENGTH_SHORT).show();
                            dialog.cancel();
                        }
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
    public void onBackPressed(){
        finish();
    }
}
