package com.me;

import com.me.ui.LoginView;
import com.me.ui.View;

public class Main {

    public static void main(String[] args) {
        Main program = new Main();
        program.start();
    }

    public void start() {
        View loginView = new LoginView();
        loginView.display();
    }
}
