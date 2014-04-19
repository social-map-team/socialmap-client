package com.socialmap.android.client.help;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.socialmap.android.client.R;
import com.socialmap.android.client.login.LoginActivity;


/**
 * Created by yy on 4/6/14. 4/12/2014 完善 LZY  4/13/2014 修改
 */
public class HelpActivity extends Activity {
    private static String TAG = "HelpActivity";

    private LinearLayout activity_help_captcha_1;
    private LinearLayout activity_help_captcha_2;
    private LinearLayout activity_help_server_1;
    private LinearLayout activity_help_server_2;
    private LinearLayout activity_help_server_3;



    private RelativeLayout box_captcha_1;
    private RelativeLayout box_captcha_2;
    private RelativeLayout box_server_1;
    private RelativeLayout box_server_2;
    private RelativeLayout box_server_3;

    private ImageView img_captcha_1;
    private ImageView img_captcha_2;
    private ImageView img_server_1;
    private ImageView img_server_2;
    private ImageView img_server_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        init();
        setAllOnclickListener();
        ImageButton back = (ImageButton)findViewById(R.id.back_btn_help);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 这里要返回跳转过来的Activity，而不是简单得返回LoginActivity
                Intent intent = new Intent(HelpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    private void init() {

        activity_help_captcha_1 = (LinearLayout) findViewById(R.id.activity_help_captcha_1);
        activity_help_captcha_2 = (LinearLayout) findViewById(R.id.activity_help_captcha_2);
        activity_help_server_1 = (LinearLayout) findViewById(R.id.activity_help_server_1);
        activity_help_server_2 = (LinearLayout) findViewById(R.id.activity_help_server_2);
        activity_help_server_3 = (LinearLayout) findViewById(R.id.activity_help_server_3);

        box_captcha_1 = (RelativeLayout) findViewById(R.id.box_captcha_1);
        box_captcha_2 = (RelativeLayout) findViewById(R.id.box_captcha_2);
        box_server_1 = (RelativeLayout) findViewById(R.id.box_server_1);
        box_server_2 = (RelativeLayout) findViewById(R.id.box_server_2);
        box_server_3 = (RelativeLayout) findViewById(R.id.box_server_3);

        img_captcha_1 = (ImageView) findViewById(R.id.help_a_1);
        img_captcha_2 = (ImageView) findViewById(R.id.help_a_2);
        img_server_1 = (ImageView) findViewById(R.id.help_a_3);
        img_server_2 = (ImageView) findViewById(R.id.help_a_4);
        img_server_3 = (ImageView) findViewById(R.id.help_a_5);

        clearAllBox();
    }

    private void setAllOnclickListener() {
        activity_help_captcha_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(box_captcha_1.getVisibility() == View.VISIBLE) {
                    clearAllBox();
                    img_captcha_1.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.ic_help_a));
                }
                else {
                    clearAllBox();
                    box_captcha_1.setVisibility(View.VISIBLE);
                    img_captcha_1.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.ic_help_a_press));
                }
            }
        });

        activity_help_captcha_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (box_captcha_2.getVisibility() == View.VISIBLE) {
                    clearAllBox();
                    img_captcha_2.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.ic_help_a));
                } else {
                    clearAllBox();
                    box_captcha_2.setVisibility(View.VISIBLE);
                    img_captcha_2.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.ic_help_a_press));
                }
            }
        });
        activity_help_server_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (box_server_1.getVisibility() == View.VISIBLE) {
                    clearAllBox();
                    img_server_1.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.ic_help_a));
                } else {
                    clearAllBox();
                    box_server_1.setVisibility(View.VISIBLE);
                    img_server_1.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.ic_help_a_press));
                }
            }
        });
        activity_help_server_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (box_server_2.getVisibility() == View.VISIBLE) {
                    clearAllBox();
                    img_server_2.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.ic_help_a));
                } else {
                    clearAllBox();
                    box_server_2.setVisibility(View.VISIBLE);
                    img_server_2.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.ic_help_a_press));
                }
            }
        });
        activity_help_server_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (box_server_3.getVisibility() == View.VISIBLE) {
                    clearAllBox();
                    img_server_3.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.ic_help_a));
                }
                else {
                    clearAllBox();
                    box_server_3.setVisibility(View.VISIBLE);
                    img_server_3.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.ic_help_a_press));
                }
            }
        });
    }

    private void clearAllBox() {
        box_captcha_1.setVisibility(View.GONE);
        box_captcha_2.setVisibility(View.GONE);
        box_server_1.setVisibility(View.GONE);
        box_server_2.setVisibility(View.GONE);
        box_server_3.setVisibility(View.GONE);
    }
}
