package com.me;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;

public class App extends Application {
    public static void Main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        populateStage(stage);
        stage.show();
    }

    private void populateStage(Stage stage) {
        // Create the nodes
        Label numberOfDaysRentedLabel = new Label("Number of days rented:");
        TextField numberOfDaysRentedTextField = new TextField();
        Label numberOfKilometersDrivenLabel = new Label("Number of kilometers driven:");
        TextField numberOfKilometersDrivenTextField = new TextField();
        CheckBox notFullTankWhenReturnedCheckBox = new CheckBox("Fuel tank not full when returned");
        Label numberOfLitersLabel = new Label("Number of liters:");
        TextField numberOfLitersTextField = new TextField();
        Button calculateButton = new Button("Calculate payment");
        Label amountDueLabel = new Label("Amount due:");
        Label calculatedPriceLabel = new Label();

        // Set the grid locations of the nodes
        GridPane.setConstraints(numberOfDaysRentedLabel, 0, 0);
        GridPane.setConstraints(numberOfDaysRentedTextField, 1, 0);
        GridPane.setConstraints(numberOfKilometersDrivenLabel, 0, 1);
        GridPane.setConstraints(numberOfKilometersDrivenTextField, 1, 1);
        // notFullTankWhenReturnedCheckBox is part of the verticalLayout
        GridPane.setConstraints(numberOfLitersLabel, 0, 0);
        GridPane.setConstraints(numberOfLitersTextField, 1, 0);
        GridPane.setConstraints(calculateButton, 1, 1);
        GridPane.setConstraints(amountDueLabel, 0, 2);
        GridPane.setConstraints(calculatedPriceLabel, 1, 2);

        // Apply a number filter to all textFields
        applyNumberFilter(numberOfDaysRentedTextField);
        applyNumberFilter(numberOfKilometersDrivenTextField);
        applyNumberFilter(numberOfLitersTextField);

        // Add logic to the button
        calculateButton.addEventHandler(ActionEvent.ACTION, event -> {
            // Get the required values from the nodes
            int numberOfDaysRented = (int) Math.ceil(getDoubleValueFromTextField(numberOfDaysRentedTextField));
            double numberOfKilometersDriven = getDoubleValueFromTextField(numberOfKilometersDrivenTextField);
            double numberOfLiters = getDoubleValueFromTextField(numberOfLitersTextField);
            boolean tankNotFullWhenReturned = notFullTankWhenReturnedCheckBox.isSelected();

            // Start with some basic variables used when calculating
            double price = 0;
            double freeKilometers = numberOfDaysRented * 100;

            // Do the calculating
            price += numberOfDaysRented * 45;
            if (numberOfKilometersDriven > freeKilometers) price += (numberOfKilometersDriven - freeKilometers) * 0.25;
            if (tankNotFullWhenReturned) price += 2 * numberOfLiters;

            // Show the output to the user
            calculatedPriceLabel.setText(String.format("€ %s", price));
        });

        // Create layout nodes
        VBox verticalLayout = new VBox();
        GridPane topGrid = new GridPane();
        GridPane bottomGrid = new GridPane();

        // Apply spacing to the layout nodes
        verticalLayout.setPadding(new Insets(10));
        verticalLayout.setSpacing(10);
        applySpacingToGrid(topGrid);
        applySpacingToGrid(bottomGrid);

        // Add the grids and the checkbox to the verticalLayout
        verticalLayout.getChildren().addAll(
                topGrid,
                notFullTankWhenReturnedCheckBox,
                bottomGrid
        );

        // Add nodes to the topGrid
        topGrid.getChildren().addAll(
                numberOfDaysRentedLabel, numberOfDaysRentedTextField,
                numberOfKilometersDrivenLabel, numberOfKilometersDrivenTextField
        );

        // Add nodes to the bottomGrid
        bottomGrid.getChildren().addAll(
                numberOfLitersLabel, numberOfLitersTextField,
                /* ............ */  calculateButton,
                amountDueLabel, calculatedPriceLabel
        );

        // Create and set the scene
        Scene scene = new Scene(verticalLayout);
        stage.setScene(scene);
    }

    private void applySpacingToGrid(GridPane grid) {
        grid.setVgap(10);
        grid.setHgap(10);
    }

    private void applyNumberFilter(TextField textField) {
        // Add a listener to the textProperty that makes sure it has a number or nothing as input
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (!newValue.matches("^$|\\d+(\\.(\\d+)?)?")) {
                    textField.setText(oldValue);
                }
            }
        });
    }

    private double getDoubleValueFromTextField(TextField textField) {
        // Get the text value and if it's a valid string, parse it to a double
        // (no need for checking whether or not it's a number because of the number filter)
        String textValue = textField.getText();

        if (textValue.equals("")) return 0;
        return Double.parseDouble(textValue);
    }
}
