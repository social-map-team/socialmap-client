package com.socialmap.android.client;

import android.app.Application;

import com.socialmap.android.client.model.User;

/**
 * Created by yy on 4/19/14.
 */
public class App extends Application {
    private boolean loggedIn = true;

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
