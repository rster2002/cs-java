package com.me.ui;

import com.me.data.UserRepo;
import com.me.models.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AddStudentPrompt extends View {
    private final UserRepo userRepo = UserRepo.getInstance();
    private final String promptTailString = ": ";

    @Override
    public void display() {
        String username = promptString("Choose a username");
        String password = promptString("Choose a password");
        String firstName = promptString("Enter first name");
        String lastName = promptString("Enter last name");
        LocalDate birthDate = promptLocalDate("Please enter a date of birth using format 'MM/DD/YYYY'");
        String group = promptString("Enter group");

        int id = userRepo.nextId();
        userRepo.addUser(new Student(id, username, password, firstName, lastName, birthDate, group));
    }

    private String promptString(String message) {
        System.out.print(message + promptTailString);

        while (true) {
            String outputString = scanner.nextLine();

            boolean validInput = outputString.length() > 0;
            if (!validInput) print("Please enter a value");
            else return outputString;
        }
    }

    private LocalDate promptLocalDate(String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        while (true) {
            try {
                String stringInput = promptString(message);
                return LocalDate.parse(stringInput, formatter);
            } catch(DateTimeParseException exception) {
                print("Invalid date");
            }
        }
    }
}
