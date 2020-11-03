package com.me.views;

import com.me.DAL.Database;
import com.me.models.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import javax.swing.*;
import java.time.LocalDate;

public class MainView extends Stage {
    private final Database database = new Database();
    private final ObservableList<Person> observablePeople = FXCollections.observableArrayList(database.getPeople());

    public MainView() {
        super();

        // Populate the stage
        populateStage();

        // Set stage values
        setTitle("People Manager");
        setMinWidth(250);
    }

    private void populateStage() {
        // Create nodes
        TableView<Person> tableView = new TableView<>();
        TextField firstNameInput = new TextField();
        TextField lastNameInput = new TextField();
        DatePicker birthDatePicker = new DatePicker();
        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");

        // Set the values of the nodes
        firstNameInput.setPromptText("First name");
        lastNameInput.setPromptText("Last name");
        birthDatePicker.setPromptText("Birth date");

        // Create and add the columns to the tableView
        TableColumn<Person, String> firstNameColumn = new TableColumn<>("First name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<Person, String> lastNameColumn = new TableColumn<>("Last name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        TableColumn<Person, String> birthDateColumn = new TableColumn<>("Birth date");
        birthDateColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));

        tableView.getColumns().add(firstNameColumn);
        tableView.getColumns().add(lastNameColumn);
        tableView.getColumns().add(birthDateColumn);
        tableView.setItems(observablePeople);

        // Add the functionality to the buttons
        addButton.addEventHandler(ActionEvent.ACTION, event -> {
            String firstName = firstNameInput.getText();
            String lastName = firstNameInput.getText();
            LocalDate dateOfBirth = birthDatePicker.getValue();

            observablePeople.add(new Person(firstName, lastName, dateOfBirth));
            birthDatePicker.setValue(null);
        });

        // Create layout nodes
        VBox verticalLayout = new VBox();
        verticalLayout.setPadding(new Insets(10));

        HBox newUserForm = new HBox();
        newUserForm.setPadding(new Insets(10));
        newUserForm.setSpacing(10);

        // Add the nodes to the layouts
        newUserForm.getChildren().addAll(firstNameInput, lastNameInput, birthDatePicker, addButton, deleteButton);
        verticalLayout.getChildren().addAll(
                tableView,
                newUserForm
        );

        // Create and set the scene
        Scene scene = new Scene(verticalLayout);
        scene.getStylesheets().add("com/me/resources/css/style.css");

        JMetro metro = new JMetro(Style.DARK);
        metro.setScene(scene);

        setScene(scene);
    }
}
