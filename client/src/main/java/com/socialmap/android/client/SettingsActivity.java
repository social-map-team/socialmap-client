package com.socialmap.android.client;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.socialmap.android.client.util.HttpUtil;
import com.socialmap.android.client.util.LocationUtil;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yy on 4/19/14.
 */
public class SettingsActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }

    public static class SettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preference);
            final Preference allowShareLocation = findPreference("allow_share_location");
            allowShareLocation.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    if (((Boolean) newValue) == true) {
                        Location currentLocation = LocationUtil.getCurrentLocation();
                        String msg = String.format("Share your current location(longitude=%.2f,latitude=%.2f,altitude=%.2f",
                                currentLocation.getLongitude(), currentLocation.getLatitude(), currentLocation.getAltitude());
                        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
                        List<NameValuePair> params = new ArrayList<NameValuePair>();
                        params.add(new BasicNameValuePair("username", ((App)(getActivity().getApplication())).getUser().getName()));
                        HttpUtil.post(HttpUtil.SERVER_URL + "share/location", params);
                        params.add(new BasicNameValuePair("longitude", currentLocation.getLongitude()+""));
                        params.add(new BasicNameValuePair("latitude", currentLocation.getLatitude()+""));
                        params.add(new BasicNameValuePair("altitude", currentLocation.getAltitude()+""));
                        JSONObject result = HttpUtil.post(HttpUtil.SERVER_URL + "submit/location", params);
                        try {
                            if (result == null) throw new JSONException("result json is null");
                            Toast.makeText(getActivity(), result.toString(), Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    return true;
                }
            });
        }
    }


}
