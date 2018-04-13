package com.example.gncis.test1.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Anant on 3/28/2018.
 */

public class HotelDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME ="trip.db";
    private static final int DATABASE_VERSION=1;
    public HotelDBHelper(Context context){super(context,DATABASE_NAME,null,DATABASE_VERSION);}
    @Override
    public void onCreate(SQLiteDatabase db){
        String SQL_CREATE_HOTELS_TABLE = "CREATE TABLE"+ HotelContract.HotelEntry.TABLE_NAME +"("
                + HotelContract.HotelEntry.HOTEL_USER_ID + "INTEGER, "
                + HotelContract.HotelEntry.HOTEL_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HotelContract.HotelEntry.LOCATION + "TEXT, "
                + HotelContract.HotelEntry.DURATION + "TEXT, "
                + HotelContract.HotelEntry.CHECKIN_DATE + "TEXT, "
                + HotelContract.HotelEntry.CHECKOUT_DATE + "TEXT, "
                + HotelContract.HotelEntry.ROOM_TYPE + "INTEGER, "
                +"FORIEGN KEY (" + HotelContract.HotelEntry.HOTEL_USER_ID + ") REFERENCES " +UserContract.UserEntry._ID + ")";

        db.execSQL(SQL_CREATE_HOTELS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
