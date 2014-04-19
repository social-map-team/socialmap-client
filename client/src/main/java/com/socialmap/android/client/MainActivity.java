package com.socialmap.android.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.socialmap.android.client.util.HttpUtil;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity{

    private User user;

    private String getUserLocation(String username){
        String str ="";
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("username", username));
        JSONObject result = HttpUtil.post(HttpUtil.SERVER_URL + "location", params);
        try {
            if (result == null) throw new JSONException("result json is null");
            str += result.getDouble("longitude") + " ";
            str += result.getDouble("latitude") + " ";
            str += result.getDouble("altitude") + " ";
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = new User();
        user.setName(getIntent().getStringExtra("username"));
        TextView tv = (TextView)findViewById(R.id.main_text);
        tv.setText("Welcome," + user.getName());
        ((App)getApplication()).setUser(user);

        String str ="";
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("bug", "This is a bug"));
        JSONObject result = HttpUtil.post(HttpUtil.SERVER_URL + "all-users", params);
        //TODO 不知道这里result为什么是空值，要改进Android的Http访问机制
       /*
        Toast.makeText(this,result.toString(),Toast.LENGTH_LONG).show();
        try {
            if (result == null) throw new JSONException("result json is null");
            JSONArray users = new JSONArray();
            users.put(result);
            for(int i=0;i<users.length();i++){
                JSONObject user = users.getJSONObject(i);
                str+="User:"+user.getString("username") + " Location:" + getUserLocation(user.getString("username"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        tv.setText(str);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this,SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
