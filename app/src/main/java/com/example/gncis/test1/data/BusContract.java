package com.example.gncis.test1.data;

import android.provider.BaseColumns;

/**
 * Created by Anant on 3/29/2018.
 */

public class BusContract {
    private BusContract() {}

    public static final class BusEntry implements BaseColumns {

        public static final String TABLE_NAME = "BUS";
        public static final String BUS_USER_Id = "User Id";
        public static final String BUS_ID= BaseColumns._ID;
        public static final String BUS_NO = "Number";
        public static final String BUS_SEAT_NO = "SEAT Number";
        public static final String ORIGIN = "Origin";
        public static final String DESTINATION = "Destination";
        public static final String DEPARTURE_DATE = "Departure Date";
        public static final String DEPARTURE_TIME = "Departure Time";
        public static final String ARRIVAL_DATE = "Arrival Date";
        public static final String ARRIVAL_TIME = "Arrival Time";
        public static final String CLASS = "Class";

        public static final int CLASS_ECONOMY = 0;
        public static final int CLASS_BUSINESS = 1;
        public static final int CLASS_FIRST = 2;

    }
}

