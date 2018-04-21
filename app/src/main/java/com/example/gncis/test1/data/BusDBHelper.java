package com.example.gncis.test1.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gncis.test1.Bus;

import java.util.ArrayList;

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
                + BusContract.BusEntry.CLASS + " INTEGER ) ";

        db.execSQL(SQL_CREATE_BUS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + BusContract.BusEntry.TABLE_NAME + ";");
        onCreate(sqLiteDatabase);
    }

    public void addBus(Bus bus, int id){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(BusContract.BusEntry.BUS_USER_Id, id);
        contentValues.put(BusContract.BusEntry.BUS_NO, bus.getbNumber());
        contentValues.put(BusContract.BusEntry.BUS_SEAT_NO, bus.getbSeat());
        contentValues.put(BusContract.BusEntry.ORIGIN, bus.getbOrigin());
        contentValues.put(BusContract.BusEntry.DESTINATION, bus.getbDestination());
        contentValues.put(BusContract.BusEntry.DEPARTURE_DATE, bus.getbDepartureDate());
        contentValues.put(BusContract.BusEntry.DEPARTURE_TIME, bus.getbDepartureTime());
        contentValues.put(BusContract.BusEntry.ARRIVAL_DATE,bus.getbArrivalDate());
        contentValues.put(BusContract.BusEntry.ARRIVAL_TIME, bus.getbArrivalTime());
        contentValues.put(BusContract.BusEntry.CLASS,bus.getbClass());
        sqLiteDatabase.insert(BusContract.BusEntry.TABLE_NAME, null, contentValues);
    }

    public ArrayList<Bus> displayBuses(int id){
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String query="SELECT * FROM " + BusContract.BusEntry.TABLE_NAME + " WHERE " + BusContract.BusEntry.BUS_USER_Id + " = " + id + ";";
        ArrayList<Bus> buses=new ArrayList<>();
        Cursor cursor =sqLiteDatabase.rawQuery(query,null);

        while(!cursor.isAfterLast()){
            Bus bus=new Bus();
            bus.setbNumber(cursor.getString(cursor.getColumnIndex(BusContract.BusEntry.BUS_NO)));
            bus.setbSeat(cursor.getString(cursor.getColumnIndex(BusContract.BusEntry.BUS_SEAT_NO)));
            bus.setbOrigin(cursor.getString(cursor.getColumnIndex(BusContract.BusEntry.ORIGIN)));
            bus.setbDestination(cursor.getString(cursor.getColumnIndex(BusContract.BusEntry.DESTINATION)));
            bus.setbDepartureDate(cursor.getString(cursor.getColumnIndex(BusContract.BusEntry.DEPARTURE_DATE)));
            bus.setbDepartureTime(cursor.getString(cursor.getColumnIndex(BusContract.BusEntry.DEPARTURE_TIME)));
            bus.setbArrivalDate(cursor.getString(cursor.getColumnIndex(BusContract.BusEntry.ARRIVAL_DATE)));
            bus.setbArrivalTime(cursor.getString(cursor.getColumnIndex(BusContract.BusEntry.ARRIVAL_TIME)));
            bus.setbClass(cursor.getColumnIndex(BusContract.BusEntry.CLASS));

            buses.add(bus);
            cursor.moveToNext();
        }
        return  buses;

    }

    public void deleteBusOfTrip(int id){
        SQLiteDatabase sqLiteDatabase =getWritableDatabase();
        String query = "DELETE FROM " + BusContract.BusEntry.TABLE_NAME +  " WHERE " + BusContract.BusEntry.BUS_ID + " = " + id + " ; ";
        sqLiteDatabase.execSQL(query);

    }
}
