package com.me.stages;

import com.me.models.LoginSuccessResult;
import com.me.models.EventExpression;
import com.me.models.UserSession;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginStage extends Stage {
    private final UserSession userSession = UserSession.getInstance();
    private EventExpression onLoginHandler;

    public LoginStage() {
        populate();
    }

    private void populate() {
        // Create the nodes
        Label usernameLabel = new Label("Username:");
        TextField usernameTextField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordPasswordField = new PasswordField();
        Label loginSuccessLabel = new Label();
        Button loginButton = new Button("Login");

        // Configure the nodes
        usernameTextField.setPromptText("Username");
        passwordPasswordField.setPromptText("Password");

        // Add logic to nodes
        loginButton.addEventHandler(ActionEvent.ACTION, event -> {
            String username = usernameTextField.getText();
            String password = passwordPasswordField.getText();

            LoginSuccessResult loginSuccessResult = userSession.login(username, password);

            if (loginSuccessResult == LoginSuccessResult.SUCCESS) triggerOnLoginHandler();
            else if (loginSuccessResult == LoginSuccessResult.WRONG_PASSWORD) loginSuccessLabel.setText("Wrong password");
            else if (loginSuccessResult == LoginSuccessResult.NO_USER) loginSuccessLabel.setText("No user with that username was found");
            else loginSuccessLabel.setText("Something went wrong");
        });

        // Create the layout
        GridPane grid = new GridPane();

        // Configure the layout
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);

        // Add the nodes to the layout
        GridPane.setConstraints(usernameLabel, 0, 0);
        GridPane.setConstraints(usernameTextField, 1, 0);
        GridPane.setConstraints(passwordLabel, 0, 1);
        GridPane.setConstraints(passwordPasswordField, 1, 1);
        GridPane.setConstraints(loginSuccessLabel, 0, 2);
        GridPane.setConstraints(loginButton, 1, 2);

        grid.getChildren().addAll(
                usernameLabel, usernameTextField,
                passwordLabel, passwordPasswordField,
                loginSuccessLabel, loginButton
        );

        // Set the scene
        setScene(new Scene(grid));
    }

    public void setOnLoginHandler(EventExpression expression) {
        onLoginHandler = expression;
    }

    private void triggerOnLoginHandler() {
        if (onLoginHandler != null) onLoginHandler.execute();
    }
}
