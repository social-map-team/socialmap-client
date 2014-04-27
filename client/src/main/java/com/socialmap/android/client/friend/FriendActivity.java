package com.socialmap.android.client.friend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.socialmap.android.client.R;
import com.socialmap.android.client.model.Friend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/4/21 0021.
 */
public class FriendActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        ListView list = (ListView) findViewById(R.id.friend_list);
        final List<Friend> friends = new ArrayList<Friend>();
        Friend a = new Friend();
        a.setId(1);
        a.setName("aaa");
        a.setStatus("This is a");
        Friend b = new Friend();
        b.setId(2);
        b.setName("bbb");
        b.setStatus("This is b");
        Friend c = new Friend();
        c.setId(3);
        c.setName("ccc");
        c.setStatus("This is c");
        Friend d = new Friend();
        d.setId(4);
        d.setName("ddd");
        d.setStatus("This is d");
        Friend e = new Friend();
        e.setId(5);
        e.setName("eee");
        e.setStatus("This is e");
        friends.add(a);
        friends.add(b);
        friends.add(c);
        friends.add(d);
        friends.add(e);
        MyAdapter adapter = new MyAdapter(this, friends);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FriendActivity.this, FriendDetailsActivity.class);
                intent.putExtra("friend",friends.get(position));
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.friend, menu);
        return true;
    }

    private static class MyAdapter extends BaseAdapter {

        private Context context;
        private LayoutInflater inflater = null;
        private List<Friend> friends;

        public MyAdapter(Context context, List<Friend> friends) {
            this.context = context;
            this.friends = friends;
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return friends.size();
        }

        @Override
        public Object getItem(int position) {
            return friends.get(position);
        }

        @Override
        public long getItemId(int position) {
            return friends.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.friend_list_item, null);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.name = (TextView) convertView.findViewById(R.id.friend_list_item_name);
                viewHolder.avatar = (ImageView) convertView.findViewById(R.id.friend_list_item_avatar);
                viewHolder.status = (TextView) convertView.findViewById(R.id.friend_list_item_status);
                convertView.setTag(viewHolder);
            }
            ViewHolder holder = (ViewHolder) convertView.getTag();
            Friend friend = friends.get(position);
            holder.avatar.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher));
            holder.name.setText(friend.getName());
            holder.status.setText(friend.getStatus());
            return convertView;
        }

        private static class ViewHolder {
            public TextView name;
            public TextView status;
            public ImageView avatar;
        }
    }
}
