package com.example.gncis.test1.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gncis.test1.R;
import com.example.gncis.test1.Trip;
import com.example.gncis.test1.TripAdapter;
import com.firebase.ui.auth.data.model.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Anant on 3/29/2018.
 */

public class UserDBHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME ="trip.db";
    private static final int DATABASE_VERSION=1;
    public UserDBHelper(Context context){super(context,DATABASE_NAME,null,DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_USER_TABLE = "CREATE TABLE "+ UserContract.UserEntry.TABLE_NAME + " ( "
                + UserContract.UserEntry.USER + " TEXT NOT NULL , "
                + UserContract.UserEntry.USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + UserContract.UserEntry.START_DATE + " TEXT , "
                + UserContract.UserEntry.END_DATE + " TEXT " + " ) ";

        sqLiteDatabase.execSQL(SQL_CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + UserContract.UserEntry.TABLE_NAME + ";");
        onCreate(sqLiteDatabase);
    }

    public void addUser(Trip trip){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract.UserEntry.USER, trip.getTripName());
        contentValues.put(UserContract.UserEntry.START_DATE, trip.gettSDate());
        contentValues.put(UserContract.UserEntry.END_DATE, trip.gettEDate());

        sqLiteDatabase.insert(UserContract.UserEntry.TABLE_NAME, null, contentValues);
    }

    public ArrayList<Trip> displayAllNewTrips(){

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        DateFormat df = new SimpleDateFormat("d MMM yyyy");
        String date = df.format(Calendar.getInstance().getTime());
        ArrayList<Trip> trips = new ArrayList<>();
        String query = "SELECT * FROM " + UserContract.UserEntry.TABLE_NAME + " WHERE " + UserContract.UserEntry.END_DATE  + " > " + "\"" + date + "\";";

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        cursor.moveToFirst();

        //int i=0;
        while (!cursor.isAfterLast()) {

            Trip trip = new Trip();
            trip.setTripName(cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.USER)));
            trip.settSDate(cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.START_DATE)));
            trip.settEDate(cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.END_DATE)));

            trips.add(trip);
            cursor.moveToNext();
        }

        cursor.close();
        return trips;
    }


    public ArrayList<Trip> displayAllOldTrips(){

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        DateFormat df = new SimpleDateFormat("d MMM yyyy");
        String date = df.format(Calendar.getInstance().getTime());
        ArrayList<Trip> trips = new ArrayList<>();
        String query = "SELECT * FROM " + UserContract.UserEntry.TABLE_NAME + " WHERE " + UserContract.UserEntry.END_DATE  + " < " + "\"" + date + "\";";

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            Trip trip = new Trip();
            trip.setTripName(cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.USER)));
            trip.settSDate(cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.START_DATE)));
            trip.settEDate(cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.END_DATE)));
            trip.setId(cursor.getInt(cursor.getColumnIndex(UserContract.UserEntry.USER_ID)));

            trips.add(trip);
            cursor.moveToNext();
        }


        cursor.close();
        return trips;
    }

    public void deleteAllTrips(){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String DELETE_QUERY = "DELETE FROM "+ UserContract.UserEntry.TABLE_NAME ;
        sqLiteDatabase.execSQL(DELETE_QUERY);
    }
}
