/**
 * Created by gncis on 12-Mar-18.
 */

package com.example.gncis.test1;

import java.util.Date;

public class Trip {

    int type,party;
    String name,hotel;
    Date start,end;

    public void setType(int type){
        this.type = type;
    }

    public void setParty(int party){
        this.party = party;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setHotel(String hotel){
        this.hotel = hotel;
    }

    public void setStart(Date start){
        this.start = start;
    }

    public void setEnd(Date end){
        this.end = end;
    }

}
