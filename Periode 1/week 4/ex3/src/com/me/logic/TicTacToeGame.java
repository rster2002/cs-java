package com.me.logic;

import com.me.models.GameStatus;
import com.me.models.PlaySuccessStatus;
import com.me.models.GridValue;

public class TicTacToeGame {
    private final GridValue[][] playingGrid = new GridValue[3][3];
    private GridValue currentPlayer = GridValue.X;

    public TicTacToeGame() {
        resetGame();
    }

    public GridValue getCurrentPlayer() {
        return currentPlayer;
    }

    public PlaySuccessStatus makePlay(int x, int y) {
        // The the current value of the position and check whether or not it's empty
        GridValue currentGridValue = playingGrid[x][y];
        if (currentGridValue != GridValue.EMPTY) return PlaySuccessStatus.ALREADY_PLAYED;

        // Set the position to the gridValue as the current player
        playingGrid[x][y] = currentPlayer;

        // If the game is finished, return a end of game state. Else change the current player and return a success state.
        GameStatus gameStatus = getGameStatus();
        if (gameStatus == GameStatus.END_WITH_WINNER) {
            return PlaySuccessStatus.END_OF_GAME_WITH_WIN;
        } else if (gameStatus == GameStatus.END_WITH_DRAW) {
            return PlaySuccessStatus.END_OF_GAME_WITH_DRAW;
        } else {
            changeCurrentPlayer();
            return PlaySuccessStatus.SUCCESS;
        }
    }

    public void resetGame() {
        currentPlayer = GridValue.X;
        resetPlayingGrid();
    }

    private void resetPlayingGrid() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                playingGrid[x][y] = GridValue.EMPTY;
            }
        }
    }

    private void changeCurrentPlayer() {
        if (currentPlayer == GridValue.X) {
            currentPlayer = GridValue.O;
        } else {
            currentPlayer = GridValue.X;
        }
    }

    private GameStatus getGameStatus() {
        for (int i = 0; i < 3; i++) {
            // Check the horizontal lines
            GridValue topGridValue = getValueOf(i, 0);
            GridValue centerHorizontalGridValue = getValueOf(i, 1);
            GridValue bottomGridValue = getValueOf(i, 2);

            if (compareGridValues(topGridValue, centerHorizontalGridValue, bottomGridValue)) {
                return GameStatus.END_WITH_WINNER;
            }

            // Check the vertical lines
            GridValue leftGridValue = getValueOf(0, i);
            GridValue centerVerticalGridValue = getValueOf(1, i);
            GridValue rightGridValue = getValueOf(2, i);

            if (compareGridValues(leftGridValue, centerVerticalGridValue, rightGridValue)) {
                return GameStatus.END_WITH_WINNER;
            }

            // Check the diagonal top-left to bottom-right
            if (i == 1) {
                GridValue topLeftGridValue = getValueOf(0, 0);
                GridValue topRightGridValue = getValueOf(2, 0);
                GridValue bottomLeftGridValue = getValueOf(0, 2);
                GridValue bottomRightGridValue = getValueOf(2, 2);

                if (compareGridValues(topLeftGridValue, centerHorizontalGridValue, bottomRightGridValue)) return GameStatus.END_WITH_WINNER;
                if (compareGridValues(topRightGridValue, centerHorizontalGridValue, bottomLeftGridValue)) return GameStatus.END_WITH_WINNER;
            }
        }

        // If there is still a empty space, the game can still continue
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                GridValue positionValue = getValueOf(x, y);
                if (positionValue == GridValue.EMPTY) return GameStatus.NO_END;
            }
        }

        // If there is no winner and there are no empty spaces left, the game ends in a draw
        return GameStatus.END_WITH_DRAW;
    }

    private boolean compareGridValues(GridValue gridValue1, GridValue gridValue2, GridValue gridValue3) {
        // Checks if one of the values is empty, and if not, compares them all to each other
        if (gridValue1 == GridValue.EMPTY || gridValue2 == GridValue.EMPTY || gridValue3 == GridValue.EMPTY) return false;
        return gridValue1 == gridValue2 && gridValue2 == gridValue3;
    }

    public GridValue getValueOf(int x, int y) {
        return playingGrid[x][y];
    }
}
