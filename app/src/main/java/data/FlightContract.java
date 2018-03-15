package data;

import android.provider.BaseColumns;

/**
 * Created by gncis on 14-Mar-18.*/

public class FlightContract {

    private FlightContract() {}

    public static final class FlightEntry implements BaseColumns{

        public static final String TABLE_NAME = "flights";
        public static final String FLIGHT_USER = "User";
        public static final String FLIGHT_ID= BaseColumns._ID;
        public static final String FLIGHT_NO = "Number";
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
