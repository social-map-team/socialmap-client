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
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.Toast;

import com.socialmap.android.client.MainActivity;
import com.socialmap.android.client.help.HelpActivity;
import com.socialmap.android.client.util.HttpUtil;
import com.socialmap.android.client.main.MainFragment;
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
public class RegisterPasswordFragment extends Fragment {
    private static final String DEBUG_TAG = "Fragment: register password";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.register_password, container, false);
        assert root != null;
        final EditText etPassword = (EditText) root.findViewById(R.id.register_et_password);
        final EditText etPasswordAgain = (EditText) root.findViewById(R.id.register_et_password_again);
        ImageButton btn = (ImageButton)root.findViewById(R.id.back_btn_password);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v){
                ((RegisterActivity)getActivity()).goToStep3();
            }
        });
        ImageButton help =(ImageButton)root.findViewById(R.id.help_password);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),HelpActivity.class));
            }
        });
        Button btnFinish = (Button) root.findViewById(R.id.register_btn_finish);
        Button btnDetails = (Button) root.findViewById(R.id.register_btn_details);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO 直接跳转主界面到主界面
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("username",((RegisterActivity)getActivity()).getPhone());
                startActivity(intent);
                getActivity().finish();

                /*
                Editable password = etPassword.getText();
                if (password == null) return;
                Editable passwordAgain = etPasswordAgain.getText();
                if (passwordAgain == null) return;

                String passwordStr = password.toString();
                String passwordAgainStr = passwordAgain.toString();

                if(passwordStr.equals(passwordAgainStr)){
                    List<NameValuePair> params = new ArrayList<NameValuePair>();
                    params.add(new BasicNameValuePair("username", ((RegisterActivity)getActivity()).getPhone()));
                    params.add(new BasicNameValuePair("password", passwordStr));
                    JSONObject result = HttpUtil.post(HttpUtil.SERVER_URL + "register", params);
                    try {
                        if (result == null) throw new JSONException("result json is null");
                        if (result.getString("result").equals("success")) {
                            getFragmentManager().beginTransaction().replace(R.id.main_container, new MainFragment()).commit();
                        }else{
                            //register failed
                        }
                    } catch (JSONException e) {
                        Log.d(DEBUG_TAG, "json parsing error", e);
                    }
                }else{
                    String msg = getResources().getString(R.string.error_register_password_not_equal);
                    Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
                }
                */
            }
        });

        return root;
    }
}
