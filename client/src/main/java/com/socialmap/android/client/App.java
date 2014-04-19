package com.socialmap.android.client;

import android.app.Application;

/**
 * Created by yy on 4/19/14.
 */
public class App extends Application {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
