package com.socialmap.android.client.util;

import android.location.Location;

/**
 * Created by yy on 4/19/14.
 */
public class LocationUtil {
    public static Location getCurrentLocation(){
        Location currentLocation = new Location("provider_string");
        currentLocation.setAltitude(100);
        currentLocation.setLongitude(200);
        currentLocation.setLatitude(300);
        return currentLocation;
    }
}
