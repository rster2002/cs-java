package com.me.views;

import com.me.DAL.Database;
import com.me.models.Task;
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

import java.io.*;

public class MainView extends Stage {
    private final Database database = new Database();
    private final ObservableList<Task> observableTaskList = FXCollections.observableList(database.getTaskList());

    public MainView() {
        super();

        populateStage();
    }

    private void populateStage() {
        // Create the nodes
        MenuBar menuBar = new MenuBar();
        TableView<Task> taskTableView = new TableView<>();
        TextField taskDescriptionTextField = new TextField();
        Button addTaskButton = new Button("Add");

        // Add the buttons to the menuBar
        Menu fileMenu = new Menu("File");
        MenuItem loadItem = new MenuItem("Load...");
        MenuItem saveItem = new MenuItem("Save...");
        fileMenu.getItems().addAll(loadItem, saveItem);

        Menu aboutMenu = new Menu("About");
        MenuItem aboutItem = new MenuItem("About");
        aboutMenu.getItems().addAll(aboutItem);

        menuBar.getMenus().addAll(fileMenu, aboutMenu);

        // Configure the nodes
        taskDescriptionTextField.setPromptText("Task description");

        // Add logic to buttons
        addTaskButton.addEventHandler(ActionEvent.ACTION, event -> {
            String taskDescription = taskDescriptionTextField.getText();
            observableTaskList.add(new Task(taskDescription));
        });

        loadItem.addEventHandler(ActionEvent.ACTION, event -> {
            try (FileInputStream inputStream = new FileInputStream(new File("file.dat"))) {
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

                while (true) {
                    try {
                        Task task = (Task) objectInputStream.readObject();
                        observableTaskList.add(task);
                    } catch (EOFException eofException) {
                        break;
                    }
                }
            } catch (FileNotFoundException fnfe) {
                System.out.println("You stupid...");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        saveItem.addEventHandler(ActionEvent.ACTION, event -> {
            try (FileOutputStream outputStream = new FileOutputStream(new File("file.dat"))) {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                for (Task task : observableTaskList) {
                    objectOutputStream.writeObject(task);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Add columns to the tableView
        TableColumn<Task, String> taskDescriptionColumn = new TableColumn<>("Description");
        taskDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        TableColumn<Task, String> taskDoneColumn = new TableColumn<>("Complete");
        taskDoneColumn.setCellValueFactory(new PropertyValueFactory<>("done"));

        taskTableView.getColumns().add(taskDescriptionColumn);
        taskTableView.getColumns().add(taskDoneColumn);

        taskTableView.setItems(observableTaskList);

        // Create the layout nodes
        VBox verticalLayout = new VBox();
        HBox horizontalLayout = new HBox();

        // Set some properties of the layouts
        verticalLayout.setPadding(new Insets(10));
        horizontalLayout.setPadding(new Insets(10));
        horizontalLayout.setSpacing(10);

        // Add the nodes to the layout
        verticalLayout.getChildren().addAll(
                menuBar,
                taskTableView,
                horizontalLayout
        );

        horizontalLayout.getChildren().addAll(taskDescriptionTextField, addTaskButton);

        // Create and set the stage
        Scene scene = new Scene(verticalLayout);
        setScene(scene);
    }
}
