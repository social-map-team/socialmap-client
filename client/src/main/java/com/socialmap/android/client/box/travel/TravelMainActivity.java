package com.socialmap.android.client.box.travel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.socialmap.android.client.R;

/**
 * Created by yy on 4/27/14.
 */
public class TravelMainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box_travel_main);
    }
    public void btnScheduleClicked(View view){
        Intent intent = new Intent(this,TravelScheduleActivity.class);
        startActivity(intent);
    }
    public void btnInfoClicked(View view){
        Intent intent = new Intent(this,TravelInfoActivity.class);
        startActivity(intent);
    }
}
