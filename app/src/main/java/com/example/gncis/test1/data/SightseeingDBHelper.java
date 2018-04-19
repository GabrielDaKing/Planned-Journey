package com.example.gncis.test1.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Anant on 3/29/2018.
 */

public class SightseeingDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "trip.db";

    private static final int DATABASE_VERSION = 1;

    public SightseeingDBHelper(Context context){super(context,DATABASE_NAME,null,DATABASE_VERSION);}


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_SIGHTSEEING_TABLE = "CREATE TABLE " + SightseeingContract.SightseeingEntry.TABLE_NAME + " ( "
                + SightseeingContract.SightseeingEntry.SIGHTSEEING_USER_ID + " INTEGER, "
                + SightseeingContract.SightseeingEntry.SIGHTSEEING_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + SightseeingContract.SightseeingEntry.SIGHTSEEING_NAME + "TEXT, "
                + SightseeingContract.SightseeingEntry.LOCATION + "TEXT, "
                + SightseeingContract.SightseeingEntry.SIGHTSEEING_Date + "TEXT, "
                + SightseeingContract.SightseeingEntry.TICKET + "TEXT, "
                + SightseeingContract.SightseeingEntry.TIME + "TEXT, "
                + SightseeingContract.SightseeingEntry.DURATION + "TEXT,"
                +"FOREIGN KEY ("+ SightseeingContract.SightseeingEntry.SIGHTSEEING_USER_ID + ") REFERENCES "
                + UserContract.UserEntry._ID + ")";

        sqLiteDatabase.execSQL(SQL_CREATE_SIGHTSEEING_TABLE );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
