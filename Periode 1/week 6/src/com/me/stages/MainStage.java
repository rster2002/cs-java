package com.me.stages;

import com.me.views.StudentsView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainStage extends Stage {
    public MainStage() {
        populate();
    }

    private void populate() {
        // Create nodes
        MenuBar menuBar = new MenuBar();
        Pane mainContainer = new Pane();

        // Create the menu buttons and add them to the menu
        Menu mainMenu = new Menu("Menu");
        MenuItem dashboardMenuButton = new MenuItem("Dashboard");
        MenuItem studentsMenuButton = new MenuItem("Students");
        MenuItem teachersMenuButton = new MenuItem("Teachers");
        mainMenu.getItems().addAll(dashboardMenuButton, studentsMenuButton, teachersMenuButton);
        menuBar.getMenus().add(mainMenu);

        // Add logic to the menuButtons
        studentsMenuButton.addEventHandler(ActionEvent.ACTION, event ->  {
            mainContainer.getChildren().clear();
            mainContainer.getChildren().add(new StudentsView());
        });

        // Configure nodes
        mainContainer.setMinHeight(300);
        mainContainer.setMinWidth(600);

        // Create layout nodes
        VBox verticalLayout = new VBox();

        // Add the nodes to the layout
        verticalLayout.getChildren().addAll(
                menuBar,
                mainContainer
        );

        // Set the scene
        setScene(new Scene(verticalLayout));
    }
}
