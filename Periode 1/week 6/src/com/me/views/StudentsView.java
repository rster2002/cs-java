package com.me.views;

import com.me.models.Student;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StudentsView extends View {
    public StudentsView() {
        populate();
    }

    private void populate() {
        // Create nodes
        TableView<Student> studentTableView = new TableView<>();
        Button addStudentButton = new Button("Add student");
        Button editStudentButton = new Button("Edit student");
        Button deleteStudentButton = new Button("Delete student");

        // Create layout nodes
        VBox verticalLayout = new VBox();
        HBox buttonLayout = new HBox();

        // Configure the layout
        verticalLayout.setPadding(new Insets(10));
        verticalLayout.setSpacing(10);
        buttonLayout.setSpacing(10);

        // Add the nodes to the layout
        verticalLayout.getChildren().addAll(
                studentTableView,
                buttonLayout
        );
        buttonLayout.getChildren().addAll(addStudentButton, editStudentButton, deleteStudentButton);
    }
}
