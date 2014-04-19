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

import com.socialmap.android.client.help.HelpActivity;
import com.socialmap.android.client.util.HttpUtil;
import com.socialmap.android.client.R;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yy on 3/29/14.
 */
public class RegisterCaptchaFragment extends Fragment {
    private static final String DEBUG_TAG = "Fragment: register captcha";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.register_captcha, container, false);
        assert root != null;
        final EditText etCaptcha = (EditText) root.findViewById(R.id.register_et_captcha);
        ImageButton btn = (ImageButton)root.findViewById(R.id.back_btn_captcha);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v){
                ((RegisterActivity)getActivity()).goToStep1();
            }

        });
        ImageButton help =(ImageButton)root.findViewById(R.id.help_captcha);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),HelpActivity.class));
            }
        });
        Button btnContinue = (Button) root.findViewById(R.id.register_btn_continue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO 直接跳转下一步
                ((RegisterActivity)getActivity()).goToStep3();
                /*
                Editable captcha = etCaptcha.getText();
                if (captcha == null) return;
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("captcha", captcha.toString()));
                JSONObject result = HttpUtil.post(HttpUtil.SERVER_URL + "check/captcha", params);
                try {
                    if (result == null) throw new JSONException("result json is null");
                    if (result.getBoolean("result")) {
                        ((RegisterActivity)getActivity()).goToStep3();
                    }else{
                        String msg = getResources().getString(R.string.error_register_captcha_wrong);
                        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    Log.d(DEBUG_TAG, "json parsing error", e);
                }*/
            }
        });
        return root;
    }
}
