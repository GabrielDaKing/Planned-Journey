package com.example.gncis.test1.data;

import android.provider.BaseColumns;

/**
 * Created by gncis on 14-Mar-18.*/

public final class FlightContract {

    private FlightContract() {}

    public static final class FlightEntry implements BaseColumns{

        public static final String TABLE_NAME = "flights";
        public static final String FLIGHT_USER_Id = "User_Id";
        public static final String FLIGHT_ID= BaseColumns._ID;
        public static final String FLIGHT_NO = "Number";
        public static final String FLIGHT_SEAT_NO = "SeatNumber";
        public static final String ORIGIN = "Origin";
        public static final String DESTINATION = "Destination";
        public static final String DEPARTURE_DATE = "Departure_Date";
        public static final String DEPARTURE_TIME = "Departure_Time";
        public static final String ARRIVAL_DATE = "Arrival_Date";
        public static final String ARRIVAL_TIME = "Arrival_Time";
        public static final String CLASS = "Class";
    }
}
