package com.socialmap.android.client.login;

import android.app.Activity;
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
import android.widget.Toast;

import com.socialmap.android.client.main.MainActivity;
import com.socialmap.android.client.R;
import com.socialmap.android.client.register.RegisterActivity;
import com.socialmap.android.client.util.HttpUtil;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yy on 4/19/14.
 */
public class LoginActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new LoginFragment(new LoginFragment.Callback() {
                    @Override
                    public void onLoggedIn(String username) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("username",username);
                        startActivity(intent);
                        LoginActivity.this.finish();
                    }
                }))
                .commit();
    }

    public static class LoginFragment extends Fragment {
        private static final String DEBUG_TAG = "Fragment Login";
        Callback callback;
        private EditText username;
        private EditText password;

        public LoginFragment(Callback callback) {
            this.callback = callback;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            Log.d(DEBUG_TAG, "on create view");
            View root = inflater.inflate(R.layout.login, container, false);
            assert root != null;
            username = (EditText) root.findViewById(R.id.login_username);
            password = (EditText) root.findViewById(R.id.login_password);
            Button signIn = (Button) root.findViewById(R.id.login_sign_in);
            signIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Editable name = username.getText();
                    Editable pass = password.getText();
                    if (name == null) {
                        username.setText("Username cannot be null");
                    } else if (pass == null) {
                        password.setText("Password cannot be null");
                    } else {
                        List<NameValuePair> params = new ArrayList<NameValuePair>();
                        params.add(new BasicNameValuePair("username", name.toString()));
                        params.add(new BasicNameValuePair("password", pass.toString()));
                        JSONObject result = HttpUtil.post(HttpUtil.SERVER_URL + "login", params);
                        try {
                            if (result == null) throw new JSONException("result json is null");
                            if (result.getString("result").equals("true")) {
                                callback.onLoggedIn(name.toString());
                            } else {
                                Toast.makeText(getActivity(), result.getString("msg"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            Button btnRegister = (Button) root.findViewById(R.id.login_register);
            btnRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), RegisterActivity.class);
                    startActivity(intent);
                }
            });
            return root;
        }

        public static interface Callback {
            public void onLoggedIn(String username);
        }
    }

}
