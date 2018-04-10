package com.example.gncis.test1.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gncis.test1.Trip;

/**
 * Created by Anant on 3/29/2018.
 */

public class TrainDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "trip.db";

    private static final int DATABASE_VERSION = 1;

    public TrainDBHelper(Context context) {super(context , DATABASE_NAME, null ,DATABASE_VERSION );}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_CREATE_TRAINS_TABLE = "CREATE TABLE " + TrainContract.TrainEntry.TABLE_NAME + " ( "
                + TrainContract.TrainEntry.TRAIN_USER_ID + "INTEGER"
                + TrainContract.TrainEntry.TRAIN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TrainContract.TrainEntry.TRAIN_NO + " TEXT, "
                + TrainContract.TrainEntry.TRAIN_SEAT_NO + " TEXT, "
                + TrainContract.TrainEntry.ORIGIN + " TEXT, "
                + TrainContract.TrainEntry.DESTINATION + " TEXT, "
                + TrainContract.TrainEntry.DEPARTURE_DATE + " TEXT, "
                + TrainContract.TrainEntry.DEPARTURE_TIME + " TEXT, "
                + TrainContract.TrainEntry.ARRIVAL_DATE + " TEXT, "
                + TrainContract.TrainEntry.ARRIVAL_TIME + " TEXT, "
                + TrainContract.TrainEntry.CLASS + " INTEGER, "
                + "FOREIGN KEY ("+ TrainContract.TrainEntry.TRAIN_USER_ID+") REFERENCES "+UserContract.UserEntry._ID+" ( ";

        sqLiteDatabase.execSQL(SQL_CREATE_TRAINS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TrainContract.TrainEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addTrip(Trip trip){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

    }
}
