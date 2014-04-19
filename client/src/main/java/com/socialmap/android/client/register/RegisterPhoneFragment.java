package com.socialmap.android.client.register;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.socialmap.android.client.R;
import com.socialmap.android.client.help.HelpActivity;
import com.socialmap.android.client.login.LoginActivity;
import com.socialmap.android.client.util.HttpUtil;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yy on 3/29/14.
 */
// 1.界面上面两个边角做出圆形  2.登陆界面后期需要美化 3.登陆界面2个按钮  4.需要添加help界面对应问号按钮     LZY  4/2/2014
// 当前全部界面按照480*800进行的设计  （3.7、4.0）
public class RegisterPhoneFragment extends Fragment {
    private static final String DEBUG_TAG = "Fragment: register phone";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.register_phone, container, false);
        assert root != null;
        final EditText etPhone = (EditText) root.findViewById(R.id.register_et_phone);
        ImageButton btn = (ImageButton)root.findViewById(R.id.back_btn_phone);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }

        });
        ImageButton help =(ImageButton)root.findViewById(R.id.help_phone);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),HelpActivity.class));
            }
        });
        Button btnVerify = (Button) root.findViewById(R.id.register_btn_verify);
        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO 省略联网验证，直接跳转下一步
                ((RegisterActivity)getActivity()).goToStep2();
                /*
                Editable phone = etPhone.getText();
                if (phone == null) return;
                //TODO send the verify code to user by

                // check if the phone number has been registered
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("username", phone.toString()));
                JSONObject result = HttpUtil.post(HttpUtil.SERVER_URL + "check/username", params);
                try {
                    if (result == null) throw new JSONException("result json is null");
                    if (result.getBoolean("result")) {
                        String msg = getResources().getString(R.string.error_register_phone_number_exists);
                        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                    } else {
                        ((RegisterActivity)getActivity()).goToStep2();
                    }
                } catch (JSONException e) {
                    Log.d(DEBUG_TAG, "json parsing error", e);
                }*/

            }
        });
        return root;
    }


}
