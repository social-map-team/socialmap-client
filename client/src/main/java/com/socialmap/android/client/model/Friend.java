package com.socialmap.android.client.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yy on 4/26/14.
 */
public class Friend implements Parcelable{
    private long id;
    private String name;
    private String status;

    public Friend(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //Parcelable implements
    public Friend(Parcel in){
        this.id = in.readLong();
        this.name = in.readString();
        this.status = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(status);
    }

    public static final Parcelable.Creator<Friend> CREATOR
            = new Parcelable.Creator<Friend>() {
        public Friend createFromParcel(Parcel in) {
            return new Friend(in);
        }

        public Friend[] newArray(int size) {
            return new Friend[size];
        }
    };
}
