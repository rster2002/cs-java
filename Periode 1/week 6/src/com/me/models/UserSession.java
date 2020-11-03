package com.me.models;

import com.me.DAL.UserRepo;

public class UserSession {
    private static UserSession instance;

    private final UserRepo userRepo = UserRepo.getInstance();
    private User loggedInUser;

    private UserSession() {}

    public static UserSession getInstance() {
        if (instance == null) instance = new UserSession();
        return instance;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public LoginSuccessResult setLoggedInUser(User loggedInUser, String password) {
        if (loggedInUser.checkPassword(password)) {
            this.loggedInUser = loggedInUser;
            return LoginSuccessResult.SUCCESS;
        } else {
            return LoginSuccessResult.WRONG_PASSWORD;
        }
    }

    public LoginSuccessResult login(String username, String password) {
        User user = userRepo.getUserByUsername(username);
        if (user == null) return LoginSuccessResult.NO_USER;

        return setLoggedInUser(user, password);
    }
}
