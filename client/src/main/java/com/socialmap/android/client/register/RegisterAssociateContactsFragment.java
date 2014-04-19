package com.socialmap.android.client.register;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.socialmap.android.client.R;

/**
 * Created by yy on 3/29/14.
 */
public class RegisterAssociateContactsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.register_associate_contacts, container, false);
        assert root != null;
        ImageButton btn = (ImageButton)root.findViewById(R.id.back_btn_associate);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v){
                ((RegisterActivity)getActivity()).goToStep2();
            }

        });
        Button btnYes = (Button) root.findViewById(R.id.register_btn_yes);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RegisterActivity)getActivity()).goToStep4();
            }
        });
        Button btnNo = (Button) root.findViewById(R.id.register_btn_no);
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RegisterActivity)getActivity()).goToStep4();
            }
        });
        return root;
    }
}
