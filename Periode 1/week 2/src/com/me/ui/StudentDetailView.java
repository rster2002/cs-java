package com.me.ui;

import com.me.models.Student;
import com.me.models.Subject;

import java.util.ArrayList;
import java.util.List;

public class StudentDetailView extends View {
    private final int detailsWidth = 40;

    private final Student student;

    public StudentDetailView(Student student) {
        this.student = student;
    }

    @Override
    public void display() {
        printDetails();

        List<KeyPromptOption> options = getPromptOptions();

        while (active) {
            printOptions(options);
            prompt(options);
        }
    }

    private void printDetails() {
        printKeyValuePair("Student Id", String.valueOf(student.getId()));
        printKeyValuePair("First Name", student.getFirstName());
        printKeyValuePair("Last Name", student.getLastName());

        printHeader("Courses");

        boolean passed = true;
        int retakes = 0;
        for (Subject subject : student.subjects) {
            if (subject.grade < 5.5) {
                passed = false;
                retakes++;
            }

            printKeyValuePair(subject.name, String.valueOf(subject.grade));
        }

        printHeader("Results");

        printKeyValuePair("Result", passed ? "Passed" : "Not Passed");
        printKeyValuePair("Retakes", String.valueOf(retakes));
    }

    private void printKeyValuePair(String key, String value) {
        final int spacingSize = 2;
        final String repeatedPaddingString = ".";

        int paddingLength = detailsWidth - key.length() - value.length() - 2 * spacingSize;
        String paddingString = repeatedPaddingString.repeat(paddingLength);
        String spacingString = " ".repeat(spacingSize);

        // Format with fixed length: <key>  ............  <value>
        print(key + spacingString + paddingString + spacingString + value);
    }

    private void printHeader(String headerText) {
        int leadingSpaces = (detailsWidth - headerText.length()) / 2;
        String leadingSpacesString = " ".repeat(leadingSpaces);

        System.out.println();
        System.out.println(leadingSpacesString + headerText.toUpperCase());
        System.out.println();
    }

    private List<KeyPromptOption> getPromptOptions() {
        List<KeyPromptOption> options = new ArrayList<>();

        options.add(new KeyPromptOption('A', "Add (Update Report)") {
            @Override
            public void onKey() {
                changeView(new ChangeStudentGrades(student));
            }
        });

        options.add(new KeyPromptOption('R', "Display Reports") {
            @Override
            public void onKey() {
                active = false;
                changeView(new StudentsReportListView());
            }
        });

        options.add(new KeyPromptOption('B', "Back To Main") {
            @Override
            public void onKey() {
                active = false;
            }
        });

        options.add(new KeyPromptOption('X', "Exit") {
            @Override
            public void onKey() {
                print("Exiting application...");
                System.exit(0);
            }
        });

        return options;
    }
}
