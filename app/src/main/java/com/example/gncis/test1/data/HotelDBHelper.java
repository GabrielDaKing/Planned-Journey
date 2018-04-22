package com.example.gncis.test1.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;

import com.example.gncis.test1.Hotel;

/**
 * Created by Apoorva on 4/21/2018.
 */

public class HotelDBHelper extends SQLiteOpenHelper {

    private static final String TAG = "DB TEST ";
    private static final String DATABASE_NAME ="trip3.db";
    private static final int DATABASE_VERSION=3;

    public HotelDBHelper(Context context){super(context,DATABASE_NAME,null,DATABASE_VERSION);}
    @Override
    public void onCreate(SQLiteDatabase db){
        String SQL_CREATE_HOTELS_TABLE = "CREATE TABLE IF NOT EXIST "+ HotelContract.HotelEntry.TABLE_NAME +" ( "
                + HotelContract.HotelEntry.HOTEL_USER_ID + " INTEGER, "
                + HotelContract.HotelEntry.HOTEL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HotelContract.HotelEntry.HOTEL_NAME + " TEXT, "
                + HotelContract.HotelEntry.LOCATION + " TEXT, "
                + HotelContract.HotelEntry.DURATION + " TEXT, "
                + HotelContract.HotelEntry.CHECKIN_DATE + " TEXT, "
                + HotelContract.HotelEntry.CHECKOUT_DATE + " TEXT, "
                + HotelContract.HotelEntry.ROOM_TYPE + " TEXT )";

        db.execSQL(SQL_CREATE_HOTELS_TABLE);
        Log.v(TAG,"Createdhotel Table");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + HotelContract.HotelEntry.TABLE_NAME + ";");
        onCreate(sqLiteDatabase);
    }
    public void addHotel(Hotel hotel,int id)
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        //contentValues.put(HotelContract.HotelEntry.HOTEL_ID, id);
        contentValues.put(HotelContract.HotelEntry.HOTEL_NAME, hotel.gethName());
        contentValues.put(HotelContract.HotelEntry.LOCATION, hotel.gethLoctaion());
        contentValues.put(HotelContract.HotelEntry.DURATION, hotel.gethDuration());
        contentValues.put(HotelContract.HotelEntry.CHECKIN_DATE, hotel.gethCheckinDate());
        contentValues.put(HotelContract.HotelEntry.CHECKOUT_DATE, hotel.gethCheckoutDate());
        contentValues.put(HotelContract.HotelEntry.ROOM_TYPE, hotel.gethRoomType());

        sqLiteDatabase.insert(HotelContract.HotelEntry.TABLE_NAME, null, contentValues);
    }
    public ArrayList<Hotel> displayHotels(int id){

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String query = "SELECT * FROM " + HotelContract.HotelEntry.TABLE_NAME + ";";// WHERE " + HotelContract.HotelEntry.HOTEL_USER_ID + " = " +id + ";";

        ArrayList<Hotel> hotels = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            Hotel hotel = new Hotel();
            hotel.sethName(cursor.getString(cursor.getColumnIndex(HotelContract.HotelEntry.HOTEL_NAME)));
            hotel.sethDuration(cursor.getString(cursor.getColumnIndex(HotelContract.HotelEntry.DURATION)));
            hotel.sethLoctaion(cursor.getString(cursor.getColumnIndex(HotelContract.HotelEntry.LOCATION)));
            hotel.sethCheckinDate(cursor.getString(cursor.getColumnIndex(HotelContract.HotelEntry.CHECKIN_DATE)));
            hotel.sethCheckoutDate(cursor.getString(cursor.getColumnIndex(HotelContract.HotelEntry.CHECKOUT_DATE)));
            hotel.sethRoomType(cursor.getString(cursor.getColumnIndex(HotelContract.HotelEntry.ROOM_TYPE)));
            hotel.setHid(cursor.getInt(cursor.getColumnIndex(HotelContract.HotelEntry.HOTEL_ID)));
            hotels.add(hotel);
            cursor.moveToNext();
        }

        return hotels;
    }
    public void deleteHotelofTrip(int id){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String Query = "DELETE FROM "+ HotelContract.HotelEntry.TABLE_NAME + " WHERE " + HotelContract.HotelEntry.HOTEL_USER_ID+ " = " +id;
        sqLiteDatabase.execSQL(Query);
    }
    public void deleteHotelint(int id){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String Query = "DELETE FROM "+HotelContract.HotelEntry.TABLE_NAME + " WHERE " + HotelContract.HotelEntry.HOTEL_ID+ " = " + id;
        sqLiteDatabase.execSQL(Query);
    }

}















