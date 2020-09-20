package com.me.ui;

import com.me.models.AccessLevel;
import com.me.models.GlobalState;

import java.util.ArrayList;
import java.util.List;

public class MainView extends View {
    private final GlobalState globalState = GlobalState.getInstance();

    @Override
    public void display() {
        clearScreen();
        List<KeyPromptOption> options = getKeyPromptOptions();

        while (active) {
            print("Hello " + globalState.getLoggedInUser().getName());

            printOptions(options);
            prompt(options);
        }
    }

    private List<KeyPromptOption> getKeyPromptOptions() {
        List<KeyPromptOption> options = new ArrayList<KeyPromptOption>();
        AccessLevel accessLevel = globalState.getLoggedInUser().getAccessLevel();

        // Add options available to every access level
        options.add(new KeyPromptOption('S', "Display students") {
            @Override
            public void onKey() {
                showView(new StudentsListView());
            }
        });

        options.add(new KeyPromptOption('T', "Display Teachers") {
            @Override
            public void onKey() {
                showView(new TeachersListView());
            }
        });

        // Add options to editor access level
        if (accessLevel == AccessLevel.EDITOR) {
            options.add(new KeyPromptOption('A', "Add student") {
                @Override
                public void onKey() {
                    showView(new AddStudentPrompt());
                }
            });

            options.add(new KeyPromptOption('R', "Show reports") {
                @Override
                public void onKey() {
                    showView(new StudentsReportListView());
                }
            });
        }

        // Add final option to exit to login screen
        options.add(new KeyPromptOption('X', "Exit") {
            @Override
            public void onKey() {
                print("Exiting program...");
                System.exit(0);
            }
        });

        return options;
    }
}
