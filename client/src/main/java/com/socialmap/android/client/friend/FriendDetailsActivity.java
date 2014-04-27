package com.socialmap.android.client.friend;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.socialmap.android.client.R;
import com.socialmap.android.client.model.Friend;

/**
 * Created by yy on 4/26/14.
 */
public class FriendDetailsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_details);
        Friend friend = getIntent().getParcelableExtra("friend");
        ImageView avatar = (ImageView)findViewById(R.id.friend_details_avatar);
        TextView status = (TextView)findViewById(R.id.friend_details_status);
        avatar.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher));
        status.setText(friend.getStatus());
        getActionBar().setTitle(friend.getName());
    }
}
