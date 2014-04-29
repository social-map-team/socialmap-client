package com.socialmap.android.client.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yy on 4/26/14.
 */
public class Box implements Parcelable {
    private long id;
    private String name;
    private String iconPath;
    private Intent intent;

    public Box(){

    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    //Parcelable implements
    public Box(Parcel in){
        this.id = in.readLong();
        this.name = in.readString();
        this.iconPath = in.readString();
        this.intent = (Intent) in.readValue(Intent.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(iconPath);
        dest.writeValue(intent);
    }

    public static final Parcelable.Creator<Box> CREATOR
            = new Parcelable.Creator<Box>() {
        public Box createFromParcel(Parcel in) {
            return new Box(in);
        }

        public Box[] newArray(int size) {
            return new Box[size];
        }
    };
}
