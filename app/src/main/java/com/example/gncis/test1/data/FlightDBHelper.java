package com.example.gncis.test1.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gncis.test1.Flight;
import com.example.gncis.test1.data.FlightContract.FlightEntry;

/**
 * Created by gncis on 16-Mar-18.
 *
 * public static final String FLIGHT_USER = "User";
 public static final String FLIGHT_ID= BaseColumns._ID;
 public static final String FLIGHT_NO = "Number";
 public static final String ORIGIN = "Origin";
 public static final String DESTINATION = "Destination";
 public static final String DEPARTURE_DATE = "Departure Date";
 public static final String DEPARTURE_TIME = "Departure Time";
 public static final String ARRIVAL_DATE = "Arrival Date";
 public static final String ARRIVAL_TIME = "Arrival Time";
 public static final String CLASS = "Class";

 */

public class FlightDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "trip.db";

    private static final int DATABASE_VERSION = 1;

    public FlightDBHelper(Context context) {super(context , DATABASE_NAME, null ,DATABASE_VERSION );}

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_FLIGHT_TABLE = "CREATE TABLE " + FlightEntry.TABLE_NAME + "("
                + FlightEntry.FLIGHT_USER_Id + "INTEGER ,"
                + FlightEntry.FLIGHT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FlightEntry.FLIGHT_NO + " TEXT, "
                + FlightEntry.FLIGHT_SEAT_NO + " TEXT, "
                + FlightEntry.ORIGIN + " TEXT, "
                + FlightEntry.DESTINATION + " TEXT, "
                + FlightEntry.DEPARTURE_DATE + " TEXT, "
                + FlightEntry.DEPARTURE_TIME + " TEXT, "
                + FlightEntry.ARRIVAL_DATE + " TEXT, "
                + FlightEntry.ARRIVAL_TIME + " TEXT, "
                + FlightEntry.CLASS + " INTEGER, "
                + "FOREIGN KEY ("+FlightEntry.FLIGHT_USER_Id+") REFERENCES "+UserContract.UserEntry._ID+" ) ";

        db.execSQL(SQL_CREATE_FLIGHT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addFlight(Flight flight, int id){};

    public void deleteFlight(){};
}
