package com.me.logic;

import com.me.data.UserRepo;
import com.me.models.GlobalState;
import com.me.models.User;

public class LoginLogic {
    private final GlobalState globalState = GlobalState.getInstance();
    private final UserRepo userRepo = UserRepo.getInstance();

    public LoginSuccessState login(String username, String password) {
        // Search the user with the username
        User userFoundByUsername = userRepo.getUserByUsername(username);

        // Check for possible states
        if (userFoundByUsername == null) return LoginSuccessState.NO_USER;
        if (!userFoundByUsername.checkPassword(password)) return LoginSuccessState.WRONG_PASSWORD;

        // Set the global state to the current user
        globalState.setLoggedInUser(userFoundByUsername, password);
        return LoginSuccessState.SUCCESS;
    }
}
