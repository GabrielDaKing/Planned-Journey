package com.example.gncis.test1;

import java.text.DateFormat;

/**
 * Created by gncis on 09-Apr-18.
 */

public class Trip {
    public String TripName;
    public String tSDate;
    public String tEDate;

    public String getTripName() {
        return TripName;
    }

    public void setTripName(String tripName) {
        TripName = tripName;
    }

    public String gettSDate() {
        return tSDate;
    }

    public void settSDate(String tSDate) {
        this.tSDate = tSDate;
    }

    public String gettEDate() {
        return tEDate;
    }

    public void settEDate(String tEDate) {
        this.tEDate = tEDate;
    }
}
