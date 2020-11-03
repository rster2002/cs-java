package com.me;

import com.me.views.MainView;
import javafx.application.Application;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class App extends Application {
    public static void Main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        MainView mainView = new MainView();
        mainView.show();
    }
}
