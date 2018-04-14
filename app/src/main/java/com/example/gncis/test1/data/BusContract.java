package com.example.gncis.test1.data;

import android.provider.BaseColumns;

/**
 * Created by Anant on 3/29/2018.
 */

public class BusContract {
    private BusContract() {}

    public static final class BusEntry implements BaseColumns {

        public static final String TABLE_NAME = "BUS";
        public static final String BUS_USER_Id = "User_Id";
        public static final String BUS_ID= BaseColumns._ID;
        public static final String BUS_NO = "Number";
        public static final String BUS_SEAT_NO = "Seat_Number";
        public static final String ORIGIN = "Origin";
        public static final String DESTINATION = "Destination";
        public static final String DEPARTURE_DATE = "Departure_Date";
        public static final String DEPARTURE_TIME = "Departure_Time";
        public static final String ARRIVAL_DATE = "Arrival_Date";
        public static final String ARRIVAL_TIME = "Arrival_Time";
        public static final String CLASS = "Class";

    }
}

