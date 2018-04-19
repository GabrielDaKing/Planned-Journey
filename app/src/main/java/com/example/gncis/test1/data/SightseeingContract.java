package com.example.gncis.test1.data;

import android.provider.BaseColumns;

/**
 * Created by Anant on 3/29/2018.
 */

public class SightseeingContract {

    private  SightseeingContract(){}
    public static final class SightseeingEntry implements BaseColumns{
        public static final String TABLE_NAME = "SIGHTSEEING";
        public static final String SIGHTSEEING_USER_ID = "SIGHTSEEING_USER_ID";
        public static final String SIGHTSEEING_ID = BaseColumns._ID;
        public static final String SIGHTSEEING_NAME = "SIGHTSEEING_NAME";
        public static final String SIGHTSEEING_Date = "Date";
        public static final String LOCATION = "LOCATION";
        public static final String TICKET = "TICKET";
        public static final String TIME = "TIME";
        public static final String DURATION = "DURATION";
    }
}
