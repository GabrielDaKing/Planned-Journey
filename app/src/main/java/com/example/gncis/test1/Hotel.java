package com.example.gncis.test1;

/**
 * Created by gncis on 04-Apr-18.
 */

public class Hotel {

    private String hName;
    private String hLoctaion;
    private String hDuration;
    private String hCheckinDate;
    private String hCheckoutDate;
    private String hRoomType;
    private int hid;

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public String gethLoctaion() {
        return hLoctaion;
    }

    public void sethLoctaion(String hLoctaion) {
        this.hLoctaion = hLoctaion;
    }

    public String gethDuration() {
        return hDuration;
    }

    public void sethDuration(String hDuration) {
        this.hDuration = hDuration;
    }

    public String gethCheckinDate() {
        return hCheckinDate;
    }

    public void sethCheckinDate(String hCheckinDate) {
        this.hCheckinDate = hCheckinDate;
    }

    public String gethCheckoutDate() {
        return hCheckoutDate;
    }

    public void sethCheckoutDate(String hCheckoutDate) {
        this.hCheckoutDate = hCheckoutDate;
    }

    public String gethRoomType() {
        return hRoomType;
    }

    public void sethRoomType(String hRoomType) {
        this.hRoomType = hRoomType;
    }
}
