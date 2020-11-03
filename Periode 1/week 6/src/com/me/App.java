package com.me;

import com.me.stages.LoginStage;
import com.me.stages.MainStage;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    public static void Main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        LoginStage loginStage = new LoginStage();
        loginStage.show();

        loginStage.setOnLoginHandler(() -> {
            loginStage.close();

            MainStage mainStage = new MainStage();
            mainStage.show();
        });
    }
}
