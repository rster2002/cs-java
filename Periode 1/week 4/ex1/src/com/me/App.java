package com.me;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {
    public static void Main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage window) throws Exception {
        populateStage(window);
    }

    private void populateStage(Stage window) {
        // Create a new grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);

        // Create the static label for the euroTextField
        Label euroAmountLabel = new Label("Amount €:");
        GridPane.setConstraints(euroAmountLabel, 0, 0);

        // Create the euro input textField
        TextField euroTextField = new TextField();
        GridPane.setConstraints(euroTextField, 1, 0);
        euroTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (!newValue.matches("\\d+(\\.(\\d+)?)?")) {
                    euroTextField.setText(oldValue);
                }
            }
        });

        // Create the output label
        Label outputLabel = new Label();
        GridPane.setConstraints(outputLabel, 1, 2);

        // Create the convert button
        Button convertButton = new Button("Convert Euro to Dollar");
        GridPane.setConstraints(convertButton, 1, 1);
        convertButton.addEventHandler(ActionEvent.ACTION, event -> {
            double euros = Double.parseDouble(euroTextField.getText());
            double dollars = convertEuroToDollar(euros);

            outputLabel.setText(String.valueOf(dollars));
        });

        // Create the static label
        Label dollarAmountLabel = new Label("Amount $:");
        GridPane.setConstraints(dollarAmountLabel, 0, 2);

        // Add all nodes to the grid
        grid.getChildren().addAll(
                euroAmountLabel,
                euroTextField,
                convertButton,
                dollarAmountLabel,
                outputLabel
        );

        // Create a scene and show the window
        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.show();
    }

    private double convertEuroToDollar(double euro) {
        return euro * 1.17;
    }
}
