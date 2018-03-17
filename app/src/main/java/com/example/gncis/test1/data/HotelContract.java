package com.example.gncis.test1.data;

import android.provider.BaseColumns;

/**
 * Created by gncis on 16-Mar-18.
 */

public class HotelContract {

        private HotelContract() {}

        public static final class HotelEntry implements BaseColumns {

            public static final String TABLE_NAME = "hotels";
            public static final String HOTEL_USER = "User";
            public static final String HOTEL_ID= BaseColumns._ID;
            public static final String LOCATION = "Origin";
            public static final String DURATION = "Duration";
            public static final String CHECKIN_DATE = "CheckIn Date";
            public static final String CHECKOUT_DATE = "CheckOut Date";
            public static final String ROOM_TYPE = "Room Type";

            public static final int ROOM_STANDARD = 0;
            public static final int ROOM_DELUXE = 1;
            public static final int ROOM_SUPER_DELUXE = 2;
            public static final int ROOM_SUITE = 3;

        }
}
