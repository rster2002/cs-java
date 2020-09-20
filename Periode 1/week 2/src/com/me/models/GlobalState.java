package com.me.models;

import java.util.List;

public class GlobalState {
    private static GlobalState instance = null;

    // State
    private User loggedInUser = null;

    // Instance management
    private GlobalState() {}
    public static GlobalState getInstance() {
        if (instance == null) instance = new GlobalState();
        return instance;
    }

    // Gets the instance of the logged-in user
    public User getLoggedInUser() {
        return loggedInUser;
    }

    // Sets the logged in user if the password matches. This is not a check for the UI, but rather a safeguard making
    // sure the user can only be set if the password is valid. Password checking should still be handles by checking
    // in the service layer
    public void setLoggedInUser(User user, String password) {
        if (user.checkPassword(password)) loggedInUser = user;
    }
}
