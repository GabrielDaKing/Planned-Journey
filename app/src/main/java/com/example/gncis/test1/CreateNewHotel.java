package com.example.gncis.test1;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
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

import com.example.gncis.test1.data.HotelDBHelper;
import com.example.gncis.test1.data.UserDBHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CreateNewHotel extends AppCompatActivity {

    TextView head;
    ImageButton cncl,cnfrm;
    EditText StartDate, EndDate,Name,Loc,Dur,Typ;
    Calendar myCalendar;
    int id;
    UserDBHelper userDBHelper;
    HotelDBHelper hotelDBHelper;
    Hotel hotel;

    Date d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_hotel);

        Loc= findViewById(R.id.Location);
        Dur= findViewById(R.id.Duration);
        Typ=findViewById(R.id.roomtype);
        Name=findViewById(R.id.name);
        myCalendar = Calendar.getInstance();

        Bundle bun = getIntent().getExtras();

        head=findViewById(R.id.head);
        cncl=findViewById(R.id.ccl);
        cnfrm=findViewById(R.id.crm);
        
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

        StartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                new DatePickerDialog(CreateNewHotel.this, stdate, myCalendar.
                        get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        EndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(CreateNewHotel.this, eddate, myCalendar.
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

                AlertDialog.Builder builder=new AlertDialog.Builder(CreateNewHotel.this);
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
                    AlertDialog.Builder builder=new AlertDialog.Builder(CreateNewHotel.this);
                    builder.setMessage("Are you want to create this Hotel Entry ?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            try {

                                hotel = new Hotel();

                                hotelDBHelper = new HotelDBHelper(getApplicationContext());

                                hotel.sethCheckinDate(StartDate.toString());
                                hotel.sethCheckoutDate(EndDate.toString());
                                hotel.sethDuration(Dur.toString());
                                hotel.sethName(Name.toString());
                                hotel.sethLoctaion(Loc.toString());
                                hotel.sethRoomType(Typ.toString());

                                Bundle bun = getIntent().getBundleExtra("TRIP");
                                id = bun.getInt("id");
                                userDBHelper = new UserDBHelper(getApplicationContext());
                                userDBHelper.updateStartDate(hotel.gethCheckinDate(), id);
                                userDBHelper.updateEndDate(hotel.gethCheckoutDate(), id);

                                finish();
                                Toast.makeText(CreateNewHotel.this, "YAY!", Toast.LENGTH_SHORT).show();
                            }
                            catch(Exception e){
                                Toast.makeText(CreateNewHotel.this, "Please enter all details", Toast.LENGTH_SHORT).show();
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
}

