package com.me.ui;

import com.me.models.GlobalState;

import java.util.List;
import java.util.Scanner;

public abstract class View {
    protected Scanner scanner = new Scanner(System.in);
    protected GlobalState globalState = GlobalState.getInstance();

    // Whether or not the view is active. Can be used in input loops to make then exit out of the loop when the view is changed
    protected boolean active = true;

    public abstract void display();

    // Shorthand for System.out.println making writing large outputs easier
    protected void print(String line) {
        System.out.println(line);
    }

    protected void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.print("\n");
        }
    }

    // Used for moving between views, rendering the current view inactive
    protected void changeView(View view) {
        active = false;
        showView(view);
    }

    // Only displays the view
    protected void showView(View view) {
        clearScreen();
        view.display();
    }

    // Standard method to print KeyPromptOptions
    protected void printOptions(List<KeyPromptOption> options) {
        for (KeyPromptOption option : options) {
            System.out.print(option.toString() + " | ");
        }

        System.out.print("\n");
    }

    // Standard method for asking for a users input
    protected void prompt(List<KeyPromptOption> options) {
        // Prompt user
        print("Please, enter a choice");
        char input = Character.toLowerCase(scanner.next().charAt(0));

        // Check for a prompt
        for (KeyPromptOption option : options) {
            if (Character.toLowerCase(option.key) == input) {
                // Run overridden method and exit out of loop/method
                option.onKey();
                return;
            }
        }

        print("Invalid input");
    }
}
