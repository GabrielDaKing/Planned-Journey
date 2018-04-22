package com.example.gncis.test1.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.gncis.test1.Hotel;
import com.example.gncis.test1.Train;


import java.util.ArrayList;

/**
 * Created by Apoorva on 4/21/18
 */

public class TrainDBHelper extends SQLiteOpenHelper {
    private static final String TAG = "DB TEST ";
    private static final String DATABASE_NAME = "trip2.db";

    private static final int DATABASE_VERSION = 3;

    public TrainDBHelper(Context context) {super(context , DATABASE_NAME, null ,DATABASE_VERSION );}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_CREATE_TRAINS_TABLE = "CREATE TABLE IF NOT EXIST " + TrainContract.TrainEntry.TABLE_NAME + " ( "
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
                + TrainContract.TrainEntry.CLASS + " TEXT ); ";

        sqLiteDatabase.execSQL(SQL_CREATE_TRAINS_TABLE);
        Log.v(TAG,"Created train Table");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TrainContract.TrainEntry.TABLE_NAME + " ; ");
        onCreate(sqLiteDatabase);
    }

    public void addTrain(Train train, int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TrainContract.TrainEntry.TRAIN_USER_ID,id);
        contentValues.put(TrainContract.TrainEntry.TRAIN_NO,train.getTnumber());
        contentValues.put(TrainContract.TrainEntry.TRAIN_SEAT_NO,train.gettSeat());
        contentValues.put(TrainContract.TrainEntry.ORIGIN,train.gettOrigin());
        contentValues.put(TrainContract.TrainEntry.DESTINATION,train.gettDestination());
        contentValues.put(TrainContract.TrainEntry.DEPARTURE_DATE,train.gettDepartureDate());
        contentValues.put(TrainContract.TrainEntry.DEPARTURE_TIME,train.gettDepartureTime());
        contentValues.put(TrainContract.TrainEntry.ARRIVAL_DATE,train.gettArrivalDate());
        contentValues.put(TrainContract.TrainEntry.ARRIVAL_TIME,train.gettArrivalTime());
        contentValues.put(TrainContract.TrainEntry.CLASS,train.gettClass());
        sqLiteDatabase.insert(TrainContract.TrainEntry.TABLE_NAME, null, contentValues);
    }

    public ArrayList<Train> displayTrains(int id){

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String query = "SELECT * FROM " + TrainContract.TrainEntry.TABLE_NAME + " ;";//+ " WHERE " + TrainContract.TrainEntry.TRAIN_USER_ID + " = " +id + ";";

        ArrayList<Train> trains = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            Train train = new Train();


            train.setTnumber(cursor.getString(cursor.getColumnIndex(TrainContract.TrainEntry.TRAIN_NO)));
            train.settSeat(cursor.getString(cursor.getColumnIndex(TrainContract.TrainEntry.TRAIN_SEAT_NO)));
            train.settOrigin(cursor.getString(cursor.getColumnIndex(TrainContract.TrainEntry.ORIGIN)));
            train.settDestination(cursor.getString(cursor.getColumnIndex(TrainContract.TrainEntry.DESTINATION)));
            train.settDepartureDate(cursor.getString(cursor.getColumnIndex(TrainContract.TrainEntry.DEPARTURE_DATE)));
            train.settDepartureTime(cursor.getString(cursor.getColumnIndex(TrainContract.TrainEntry.DEPARTURE_TIME)));
            train.settArrivalDate(cursor.getString(cursor.getColumnIndex(TrainContract.TrainEntry.ARRIVAL_DATE)));
            train.settArrivalTime(cursor.getString(cursor.getColumnIndex(TrainContract.TrainEntry.ARRIVAL_TIME)));
            train.setTid(cursor.getInt(cursor.getColumnIndex(TrainContract.TrainEntry.TRAIN_ID)));

            trains.add(train);
            cursor.moveToNext();
        }

        return trains;
    }
    public void deleteTrainofTrip(int id){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String Query = "SELECT * FROM " + TrainContract.TrainEntry.TABLE_NAME + " WHERE " + TrainContract.TrainEntry.TRAIN_USER_ID + " = " +id ;
        sqLiteDatabase.execSQL(Query);
    }
    public void deleteTrainint(int id){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String Query = "SELECT * FROM " + TrainContract.TrainEntry.TABLE_NAME + " WHERE " + TrainContract.TrainEntry.TRAIN_ID + " = " +id ;
        sqLiteDatabase.execSQL(Query);
    }
}






