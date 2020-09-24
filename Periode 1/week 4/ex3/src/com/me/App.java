package com.me;

import com.me.logic.TicTacToeGame;
import com.me.models.PlaySuccessStatus;
import com.me.models.GridValue;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    public static void Main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        TicTacToeGame game = new TicTacToeGame();

        populateStage(stage, game);

        stage.setTitle("Tic Tac Toe");
        stage.setResizable(false);
        stage.show();
    }

    private void populateStage(Stage stage, TicTacToeGame game) {
        // Create the grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        // Create a label for keeping track of the turn
        Label currentPlayerLabel = new Label("Current turn: X");
        GridPane.setConstraints(currentPlayerLabel, 0, 3);
        grid.getChildren().add(currentPlayerLabel);

        // Create the buttons and add them to the grid
        List<Button> buttons = new ArrayList<>();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                // Create the game button
                Button button = new Button("_");
                button.setFont(Font.font(40));

                // Set the position and size
                GridPane.setConstraints(button, x, y);
                button.setMinSize(100, 100);

                // Add a event handler to the button
                int finalX = x;
                int finalY = y;
                button.addEventHandler(ActionEvent.ACTION, event -> {
                    // Get some of the state from the game
                    PlaySuccessStatus playSuccess = game.makePlay(finalX, finalY);
                    GridValue currentValue = game.getValueOf(finalX, finalY);

                    // If the position wasn't played already, update the tex of the button
                    if (playSuccess != PlaySuccessStatus.ALREADY_PLAYED) {
                        button.setText(getGridValueString(currentValue));
                    }

                    // If the play made one player win, display the player who has won
                    if (playSuccess == PlaySuccessStatus.END_OF_GAME_WITH_WIN) {
                        currentPlayerLabel.setText(String.format("Player %s has won", getGridValueString(game.getCurrentPlayer())));
                    } else if (playSuccess == PlaySuccessStatus.END_OF_GAME_WITH_DRAW) {
                        currentPlayerLabel.setText("DRAW");
                    } else {
                        currentPlayerLabel.setText(String.format("Current turn: %s", getGridValueString(game.getCurrentPlayer())));
                    }
                });

                // Add the button to the grid and add it to the list for later reference
                grid.getChildren().add(button);
                buttons.add(button);
            }
        }

        // Create a reset button
        Button resetButton = new Button("Reset game");
        GridPane.setConstraints(resetButton, 2, 3);
        grid.getChildren().addAll(resetButton);
        resetButton.addEventHandler(ActionEvent.ACTION, event -> {
            game.resetGame();
            currentPlayerLabel.setText("Current turn: X");

            for (Button button : buttons) {
                button.setText("_");
            }
        });

        // Create the scene and set it
        Scene scene = new Scene(grid);
        stage.setScene(scene);
    }

    private String getGridValueString(GridValue gridValue) {
        if (gridValue == GridValue.X) return "X";
        if (gridValue == GridValue.O) return "O";
        return "_";
    }
}
