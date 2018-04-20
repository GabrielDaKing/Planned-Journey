package com.example.gncis.test1;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.DateFormat;

/**
 * Created by gncis on 09-Apr-18.
 */

public class Trip  {

    public String TripName;
    public String tSDate;
    public String tEDate;
    public int id;

    public Trip() {
        this.TripName = "NULL";
        this.tSDate = "N/A";
        this.tEDate = "N/A";
    }

    public String getTripName() {
        return TripName;
    }

    public void setTripName(String tripName) {
        this.TripName = tripName;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
