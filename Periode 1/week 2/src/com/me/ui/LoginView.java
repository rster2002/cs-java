package com.me.ui;

import com.me.logic.LoginLogic;
import com.me.logic.LoginSuccessState;

public class LoginView extends View {
    private final LoginLogic loginLogic = new LoginLogic();

    @Override
    public void display() {
        while (active) {
            clearScreen();

            print("Enter username: ");
            String username = scanner.nextLine();

            print("Enter password: ");
            String password = scanner.nextLine();

            LoginSuccessState loginResponse = loginLogic.login(username, password);

            if (loginResponse == LoginSuccessState.NO_USER) {
                print("Could not find a user with that username");
            } else if (loginResponse == LoginSuccessState.WRONG_PASSWORD) {
                print("Invalid password");
            } else {
                changeView(new MainView());
                break;
            }
        }
    }
}
