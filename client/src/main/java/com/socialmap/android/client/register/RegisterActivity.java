package com.socialmap.android.client.register;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.socialmap.android.client.R;

/**
 * Created by yy on 4/19/14.
 */
public class RegisterActivity extends Activity {
    private final RegisterPhoneFragment step1 = new RegisterPhoneFragment();
    private final RegisterCaptchaFragment step2 = new RegisterCaptchaFragment();
    private final RegisterAssociateContactsFragment step3 = new RegisterAssociateContactsFragment();
    private final RegisterPasswordFragment step4 = new RegisterPasswordFragment();
    private String phone;
    private Fragment currentStep;

    public void goToStep1() {
        getFragmentManager().beginTransaction().replace(android.R.id.content, step1).commit();
    }

    public void goToStep2() {
        getFragmentManager().beginTransaction().replace(android.R.id.content, step2).commit();
    }

    public void goToStep3() {
        getFragmentManager().beginTransaction().replace(android.R.id.content, step3).commit();
    }

    public void goToStep4() {
        getFragmentManager().beginTransaction().replace(android.R.id.content, step4).commit();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentStep = step1;
        getFragmentManager().beginTransaction().replace(android.R.id.content, currentStep).commit();
    }
}
