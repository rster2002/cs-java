package com.me;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.w3c.dom.events.Event;

import java.awt.event.ActionEvent;

public class App extends Application {
    public static void Main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage window) throws Exception {
        // Create grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);

        // Create nodes
        Label usernameLabel = new Label("Username: ");
        GridPane.setConstraints(usernameLabel, 0, 0);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        GridPane.setConstraints(usernameField, 1, 0);

        Label passwordLabel = new Label("Password: ");
        GridPane.setConstraints(passwordLabel, 0, 1);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        GridPane.setConstraints(passwordField, 1, 1);
        StringProperty passwordFieldTextProperty = passwordField.textProperty();

        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);

        Label visiblePassword = new Label();
        GridPane.setConstraints(visiblePassword, 0, 2);
        visiblePassword.textProperty().bind(passwordFieldTextProperty);

        loginButton.setVisible(false);

        passwordFieldTextProperty.addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                loginButton.setVisible(isValidPassword(newValue));
            }
        });

        grid.getChildren().addAll(
                usernameLabel,
                usernameField,
                passwordLabel,
                passwordField,
                loginButton,
                visiblePassword
        );

        Scene scene = new Scene(grid);
        window.setScene(scene);

        window.show();
    }

    private boolean isValidPassword(String password) {
        if (password.length() < 8) return false;
        if (!password.matches(".*\\w.*")) return false;
        if (!password.matches(".*\\d.*")) return false;
        return password.matches(".*[$&+,:;=?@#|'<>.^*()%!-].*");
    }
}
