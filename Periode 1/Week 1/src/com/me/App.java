package com.me;

import java.util.Scanner;
import com.me.models.*;

public class App {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    public void start() {
        System.out.println("How many students?");
        int numberOfStudents = promptInt();

        Student[] students = new Student[numberOfStudents];

        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();

            System.out.println("Please enter the name of student #" + (i + 1) + " and press [ENTER]:");
            inputStudentName(students[i]);
        }

        System.out.println();

        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            System.out.println("Student #" + (i + 1) + ": " + student.name);
        }

        System.out.println();

        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            System.out.println("Is student #" + (i + 1) + " (" + student.name + ") present? [Y/N + ENTER]: ");

            inputStudentPresence(students[i]);
        }

        System.out.println();

        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            boolean isPresent = student.present == PresentState.PRESENT;

            System.out.println("Student #" + (i + 1) + ": " + student.name + "\t\t|\t\tPresent: " + isPresent);
        }
    }

    private int promptInt() {
        int result = scanner.nextInt();
        scanner.nextLine();

        return result;
    }

    private boolean promptYesNo() {
        char result = ' ';
        boolean validInput = false;

        while (!validInput) {
            String stringResult = scanner.nextLine();
            result = stringResult.charAt(0);

            validInput = result == 'y' || result == 'n';
            if (!validInput) System.out.println("You can only type 'y' or 'n'");
        }

        return result == 'y';
    }

    private String promptString() {
        return scanner.nextLine();
    }

    private void inputStudentName(Student student) {
        student.name = promptString();
    }

    private void inputStudentPresence(Student student) {
        boolean isPresent = promptYesNo();
        student.present = isPresent ? PresentState.PRESENT : PresentState.ABSENT;
    }
}
