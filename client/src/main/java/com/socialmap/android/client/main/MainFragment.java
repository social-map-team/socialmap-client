package com.socialmap.android.client.main;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.socialmap.android.client.R;

/**
 * Created by yy on 3/29/14.
 */
public class MainFragment extends Fragment {
    @Override
    public void onStart() {
        super.onStart();
        GoogleMap map = ((MapFragment) getFragmentManager()
                .findFragmentById(R.id.map)).getMap();

        LatLng beijing = new LatLng(39.9073, 116.3911);

        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(beijing, 16));

        map.addMarker(new MarkerOptions()
                .title("北京")
                .snippet("中华人民共和国的首都")
                .position(beijing));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.main, container, false);

        return root;
    }
}
