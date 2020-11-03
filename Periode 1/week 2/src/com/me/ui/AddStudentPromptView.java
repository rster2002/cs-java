package com.me.ui;

import com.me.data.UserRepo;
import com.me.models.Student;
import com.me.models.Subject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AddStudentPromptView extends View {
    private final UserRepo userRepo = UserRepo.getInstance();

    @Override
    public void display() {
        String username = promptString("Choose a username");
        String password = promptString("Choose a password");
        String firstName = promptString("Enter first name");
        String lastName = promptString("Enter last name");
        LocalDate birthDate = promptLocalDate("Please enter a date of birth using format 'MM/DD/YYYY'");
        String group = promptString("Enter group");

        if (!active) return;

        int id = userRepo.nextId();

        Student student = new Student(id, username, password, firstName, lastName, birthDate, group);

        student.subjects.add(new Subject("Java"));
        student.subjects.add(new Subject("CSharp"));
        student.subjects.add(new Subject("Python"));
        student.subjects.add(new Subject("PHP"));

        userRepo.addUser(student);
    }

    private String promptString(String message) {
        // If the view is set to be inactive, the prompt will be skipped
        if (!active) return null;

        String promptTailString = ": ";
        System.out.print(message + promptTailString);

        while (true) {
            String outputString = scanner.nextLine();

            boolean validInput = outputString.length() > 0;
            String stopString = "stop";
            if (!validInput) {
                print("Please enter a value");
            } else if (outputString.equals(stopString)) {
                // If the given string is, "stop", set the view to inactive making it skip all next prompts
                active = false;
                return null;
            } else {
                return outputString;
            }
        }
    }

    private LocalDate promptLocalDate(String message) {
        if (!active) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        while (true) {
            try {
                String stringInput = promptString(message);

                if (stringInput == null) return null;
                return LocalDate.parse(stringInput, formatter);
            } catch(DateTimeParseException exception) {
                print("Invalid date");
            }
        }
    }
}
