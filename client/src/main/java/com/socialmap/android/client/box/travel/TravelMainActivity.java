package com.socialmap.android.client.box.travel;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.socialmap.android.client.R;

/**
 * Created by yy on 4/27/14.
 */
public class TravelMainActivity extends Activity {
      public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_box_travel_main);
          LayoutInflater layoutInflater = LayoutInflater.from(this);
          final View SOS = layoutInflater.inflate(R.layout.dialog_travel_sos, null);
          Button btn = (Button)findViewById(R.id.box_travel_sos);
          btn.setOnClickListener(new View.OnClickListener() {
              @Override
              public  void onClick(View v) {
                  new AlertDialog.Builder(TravelMainActivity.this).setTitle("SOS").setIcon(R.drawable.ic_launcher)
                          .setView(SOS)
                          . setNegativeButton("取消",
                                  new DialogInterface.OnClickListener() {
                                      @Override
                                      public void onClick(DialogInterface dialog, int which) {

                                      }
                                  }
                          )
                  .setPositiveButton("确认",
                          new DialogInterface.OnClickListener() {
                              @Override
                              public void onClick(DialogInterface dialog, int which) {

                              }
                          }
                  ).show();

              }

              });

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
