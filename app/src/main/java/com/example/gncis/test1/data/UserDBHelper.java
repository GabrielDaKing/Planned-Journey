package com.example.gncis.test1.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Anant on 3/29/2018.
 */

public class UserDBHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME ="trip.db";
    private static final int DATABASE_VERSION=1;
    public UserDBHelper(Context context){super(context,DATABASE_NAME,null,DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_USER_TABLE = "CREATE TABLE "+ UserContract.UserEntry.TABLE_NAME + "("
                + UserContract.UserEntry.USER + "TEXT , "
                + UserContract.UserEntry.USER_ID + "INTEGER PRIMARY KEY AUTOINCREMENT )";
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
