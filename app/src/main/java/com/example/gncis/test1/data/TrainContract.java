package com.example.gncis.test1.data;

import android.provider.BaseColumns;

/**
 * Created by Anant on 3/29/2018.
 */

public class TrainContract {
    private TrainContract(){}
    public static final class TrainEntry implements BaseColumns{
        public static final String TABLE_NAME = "TRAINS";
        public static final String TRAIN_USER_ID = "USER";
        public static final String TRAIN_ID = BaseColumns._ID;
        public static final String ORIGIN = "ORIGIN";
        public static final String TRAIN_NO = "Number";
        public static final String TRAIN_SEAT_NO = "SEAT Number";
        public static final String DESTINATION = "DESTINATION";
        public static final String DEPARTURE_TIME = "Departure Time";
        public static final String DEPARTURE_DATE = "DEPARTURE DATE";
        public static final String ARRIVAL_DATE = "Arrival Date";
        public static final String ARRIVAL_TIME = "Arrival Time";
        public static final String CLASS = "Class";

        public static final int CLASS_ECONOMY = 0;
        public static final int CLASS_BUSINESS = 1;
        public static final int CLASS_FIRST = 2;

    }
}
