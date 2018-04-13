package com.example.gncis.test1.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Anant on 3/29/2018.
 */

public class BusDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "trip.db";

    private static final int DATABASE_VERSION = 1;

    public BusDBHelper(Context context) {super(context , DATABASE_NAME, null ,DATABASE_VERSION );}

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_BUS_TABLE = "CREATE TABLE " + BusContract.BusEntry.TABLE_NAME + "("
                + BusContract.BusEntry.BUS_USER_Id + "INTEGER"
                + BusContract.BusEntry.BUS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BusContract.BusEntry.BUS_NO + " TEXT, "
                + BusContract.BusEntry.BUS_SEAT_NO + " TEXT, "
                + BusContract.BusEntry.ORIGIN + " TEXT, "
                + BusContract.BusEntry.DESTINATION + " TEXT, "
                + BusContract.BusEntry.DEPARTURE_DATE + " TEXT, "
                + BusContract.BusEntry.DEPARTURE_TIME + " TEXT, "
                + BusContract.BusEntry.ARRIVAL_DATE + " TEXT, "
                + BusContract.BusEntry.ARRIVAL_TIME + " TEXT, "
                + BusContract.BusEntry.CLASS + " INTEGER, "
                + "FOREIGN KEY ("+ BusContract.BusEntry.BUS_USER_Id+") REFERENCES "+UserContract.UserEntry._ID+" ) ";

        db.execSQL(SQL_CREATE_BUS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
