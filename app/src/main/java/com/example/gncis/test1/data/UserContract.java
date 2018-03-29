package com.example.gncis.test1.data;

import android.provider.BaseColumns;

/**
 * Created by gncis on 16-Mar-18.
 */

public final class UserContract {

    private UserContract () {}

    public static final class UserEntry implements BaseColumns{

        public static final String TABLE_NAME = "flights";
        public static final String USER = "User";
        public static final String USER_ID= BaseColumns._ID;


    }
}
