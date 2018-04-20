package com.example.gncis.test1.data;

import android.provider.BaseColumns;

/**
 * Created by gncis on 16-Mar-18.
 */

public final class UserContract {
    //test

    private UserContract () {}

    public static final class UserEntry implements BaseColumns{

        public static final String TABLE_NAME = "users";
        public static final String USER = "User";
        public static final String START_DATE = "Start_date";
        public static final String END_DATE = "End";
        public static final String USER_ID = BaseColumns._ID;


    }
}
