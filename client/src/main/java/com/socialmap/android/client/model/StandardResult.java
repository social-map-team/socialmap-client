package com.socialmap.android.client.model;

/**
 * Created by yy on 5/7/14.
 */
public class StandardResult implements Result{
    private int result;
    private String errorMessage;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
