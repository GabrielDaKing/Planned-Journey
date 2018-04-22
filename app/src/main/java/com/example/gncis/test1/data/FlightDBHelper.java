package com.example.gncis.test1.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gncis.test1.Flight;
import com.example.gncis.test1.data.FlightContract.FlightEntry;

import java.util.ArrayList;

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

        String SQL_CREATE_FLIGHT_TABLE = "CREATE TABLE " + FlightEntry.TABLE_NAME + " ( "
                + FlightEntry.FLIGHT_USER_Id + " INTEGER ,"
                + FlightEntry.FLIGHT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FlightEntry.FLIGHT_NO + " TEXT, "
                + FlightEntry.FLIGHT_SEAT_NO + " TEXT, "
                + FlightEntry.ORIGIN + " TEXT, "
                + FlightEntry.DESTINATION + " TEXT, "
                + FlightEntry.DEPARTURE_DATE + " TEXT, "
                + FlightEntry.DEPARTURE_TIME + " TEXT, "
                + FlightEntry.ARRIVAL_DATE + " TEXT, "
                + FlightEntry.ARRIVAL_TIME + " TEXT, "
                + FlightEntry.CLASS + " TEXT ); ";

        db.execSQL(SQL_CREATE_FLIGHT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FlightEntry.TABLE_NAME + ";");
        onCreate(sqLiteDatabase);
    }

    public void addFlight(Flight flight, int id){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FlightEntry.FLIGHT_USER_Id, id);
        contentValues.put(FlightEntry.FLIGHT_NO, flight.getFnumber());
        contentValues.put(FlightEntry.FLIGHT_SEAT_NO, flight.getfSeat());
        contentValues.put(FlightEntry.ORIGIN, flight.getfOrigin());
        contentValues.put(FlightEntry.DESTINATION, flight.getfDestination());
        contentValues.put(FlightEntry.DEPARTURE_DATE, flight.getfDepartureDate());
        contentValues.put(FlightEntry.DEPARTURE_TIME, flight.getfDepartureTime());
        contentValues.put(FlightEntry.ARRIVAL_DATE, flight.getfArrivalDate());
        contentValues.put(FlightEntry.ARRIVAL_TIME, flight.getfArrivalTime());
        contentValues.put(FlightEntry.CLASS, flight.getfClass());


        sqLiteDatabase.insert(FlightEntry.TABLE_NAME, null, contentValues);
    }

    public ArrayList<Flight> displayFlights(int id){

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String query = "SELECT * FROM " + FlightEntry.TABLE_NAME + " WHERE " + FlightEntry.FLIGHT_USER_Id + " = " +id + ";";

        ArrayList<Flight> flights = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            Flight flight = new Flight();
            flight.setFnumber(cursor.getString(cursor.getColumnIndex(FlightEntry.FLIGHT_NO)));
            flight.setfSeat(cursor.getString(cursor.getColumnIndex(FlightEntry.FLIGHT_SEAT_NO)));
            flight.setfOrigin(cursor.getString(cursor.getColumnIndex(FlightEntry.ORIGIN)));
            flight.setfDestination(cursor.getString(cursor.getColumnIndex(FlightEntry.DESTINATION)));
            flight.setfDepartureDate(cursor.getString(cursor.getColumnIndex(FlightEntry.DEPARTURE_DATE)));
            flight.setfDepartureTime(cursor.getString(cursor.getColumnIndex(FlightEntry.DEPARTURE_TIME)));
            flight.setfArrivalDate(cursor.getString(cursor.getColumnIndex(FlightEntry.ARRIVAL_DATE)));
            flight.setfArrivalTime(cursor.getString(cursor.getColumnIndex(FlightEntry.ARRIVAL_TIME)));
            flight.setfClass(cursor.getString(cursor.getColumnIndex(FlightEntry.FLIGHT_NO)));
            flight.setFid(cursor.getInt(cursor.getColumnIndex(FlightEntry.FLIGHT_ID)));

            flights.add(flight);
            cursor.moveToNext();
        }

        cursor.close();
        return flights;
    }

    public Flight displayFlight(int id){

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String query = "SELECT * FROM " + FlightEntry.TABLE_NAME + " WHERE " + FlightEntry.FLIGHT_ID + " = " + id + " ; ";

        Flight flight= new Flight();

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        cursor.moveToFirst();

        flight.setFnumber(cursor.getString(cursor.getColumnIndex(FlightEntry.FLIGHT_NO)));
        flight.setfSeat(cursor.getString(cursor.getColumnIndex(FlightEntry.FLIGHT_SEAT_NO)));
        flight.setfOrigin(cursor.getString(cursor.getColumnIndex(FlightEntry.ORIGIN)));
        flight.setfDestination(cursor.getString(cursor.getColumnIndex(FlightEntry.DESTINATION)));
        flight.setfDepartureDate(cursor.getString(cursor.getColumnIndex(FlightEntry.DEPARTURE_DATE)));
        flight.setfDepartureTime(cursor.getString(cursor.getColumnIndex(FlightEntry.DEPARTURE_TIME)));
        flight.setfArrivalDate(cursor.getString(cursor.getColumnIndex(FlightEntry.ARRIVAL_DATE)));
        flight.setfArrivalTime(cursor.getString(cursor.getColumnIndex(FlightEntry.ARRIVAL_TIME)));
        flight.setfClass(cursor.getString(cursor.getColumnIndex(FlightEntry.FLIGHT_NO)));

        return flight;

    }

    public void deleteFlightOfTrip(int id){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String Query = "DELETE FROM "+ FlightEntry.TABLE_NAME + " WHERE " + FlightEntry.FLIGHT_USER_Id + " = " +id;
        sqLiteDatabase.execSQL(Query);
    }

    public void deleteFlightint(int id){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String Query = "DELETE FROM "+ FlightEntry.TABLE_NAME + " WHERE " + FlightEntry.FLIGHT_ID + " = " + id;
        sqLiteDatabase.execSQL(Query);
    }
}
