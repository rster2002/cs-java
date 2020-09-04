package com.me;

import java.util.Scanner;
import com.me.models.*;

public class App {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Create a object of the app to allow access to non-static methods
        App app = new App();
        app.start();
    }

    public void start() {
        // Prompt the user for the number of students
        System.out.println("How many students?");
        int numberOfStudents = promptInt();

        // Create an array of students
        Student[] students = new Student[numberOfStudents];

        // For every student, ask for a name and add the student to the array
        for (int i = 0; i < students.length; i++) {
            Student student = new Student();

            System.out.println("Please enter the name of student #" + (i + 1) + " and press [ENTER]:");
            student.name = scanner.nextLine();

            students[i] = student;
        }

        System.out.println();

        // Print the students with their name
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            System.out.println("Student #" + (i + 1) + ": " + student.name);
        }

        System.out.println();

        // Prompt a yes/no question on whether or not the student is present for every student
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];

            System.out.println("Is student #" + (i + 1) + " (" + student.name + ") present? [y/n + ENTER]: ");
            student.present = promptYesNo() ? PresentState.PRESENT : PresentState.ABSENT;
        }

        System.out.println();

        // Print a overview of the students and whether or not they're present
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            boolean isPresent = student.present == PresentState.PRESENT;

            // Student #<i + 1>: <student.name>     |       Present: <isPresent>
            System.out.println("Student #" + (i + 1) + ": " + student.name + "\t\t|\t\tPresent: " + isPresent);
        }
    }

    // Used for prompting a int, because the enter key stays in the stream and needs to be cleared as wel
    private int promptInt() {
        int result = scanner.nextInt();
        scanner.nextLine();

        return result;
    }

    // Used for prompting yes/no questions
    private boolean promptYesNo() {
        // Declare variables for later use. `result` is assigned ' ' because it's an invalid input.
        char result = ' ';
        boolean validInput = false;

        // While the input is neither 'y' or 'n', keep repeating until it is
        while (!validInput) {
            // Get the next character of the stream
            String stringResult = scanner.next();
            result = stringResult.charAt(0);

            // Check whether or not the input is valid, and if not, print a message
            validInput = result == 'y' || result == 'n';
            if (!validInput) System.out.println("Invalid input, please type either 'y' or 'n'");
        }

        return result == 'y';
    }
}
