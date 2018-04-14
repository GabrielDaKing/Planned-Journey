package com.example.gncis.test1.data;

import android.provider.BaseColumns;

/**
 * Created by gncis on 16-Mar-18.
 */

public class HotelContract {

        private HotelContract() {}

        public static final class HotelEntry implements BaseColumns {

            public static final String TABLE_NAME = "hotels";
            public static final String HOTEL_USER_ID = "User";
            public static final String HOTEL_ID= BaseColumns._ID;
            public static final String HOTEL_NAME= "Name";
            public static final String LOCATION = "Location";
            public static final String DURATION = "Duration";
            public static final String CHECKIN_DATE = "CheckIn_Date";
            public static final String CHECKOUT_DATE = "CheckOut_Date";
            public static final String ROOM_TYPE = "Room_Type";
        }
}
