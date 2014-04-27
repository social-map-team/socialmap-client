package com.socialmap.android.client.box;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.socialmap.android.client.R;
import com.socialmap.android.client.model.Box;
import com.socialmap.android.client.model.Friend;

import java.util.ArrayList;
import java.util.List;

/**
 * 副本，类似于桌面，列出副本图标
 * Created by Administrator on 2014/4/21 0021.
 */
public class BoxActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box);
        GridView grid = (GridView)findViewById(R.id.box_grid);
        final List<Box> boxes = new ArrayList<Box>();
        Box a = new Box();
        a.setName("上海大学");
        Box b = new Box();
        b.setName("超级鸡车");
        Box c = new Box();
        c.setName("上海市政府");
        Box d = new Box();
        d.setName("旅行社");
        boxes.add(a);
        boxes.add(b);
        boxes.add(c);
        boxes.add(d);
        boxes.add(a);
        boxes.add(b);
        boxes.add(c);
        boxes.add(d);
        boxes.add(a);
        boxes.add(b);
        boxes.add(c);
        boxes.add(d);
        MyAdapter adapter = new MyAdapter(this,boxes);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(),position+" clicked",Toast.LENGTH_LONG).show();
            }
        });
    }
    private static class MyAdapter extends BaseAdapter {

        private Context context;
        private LayoutInflater inflater = null;
        private List<Box> boxes;

        public MyAdapter(Context context, List<Box> boxes) {
            this.context = context;
            this.boxes = boxes;
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return boxes.size();
        }

        @Override
        public Object getItem(int position) {
            return boxes.get(position);
        }

        @Override
        public long getItemId(int position) {
            return boxes.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.box_grid_item, null);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.name = (TextView) convertView.findViewById(R.id.box_grid_name);
                viewHolder.icon = (ImageView) convertView.findViewById(R.id.box_grid_icon);
                convertView.setTag(viewHolder);
            }
            ViewHolder holder = (ViewHolder) convertView.getTag();
            Box box = boxes.get(position);
            holder.icon.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher));
            holder.name.setText(box.getName());
            return convertView;
        }

        private static class ViewHolder {
            public TextView name;
            public ImageView icon;
        }
    }
}
