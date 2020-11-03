package com.me.ui;

import com.me.data.UserRepo;
import com.me.models.Student;
import com.me.models.Teacher;

import java.util.List;

public class TeachersListView extends View {
    @Override
    public void display() {
        clearScreen();

        // Get the user repo and request the students
        UserRepo userRepo = UserRepo.getInstance();
        List<Teacher> teachers = userRepo.getTeachers();

        // Create a table display, then set and print the headers
        TableDisplay tableDisplay = new TableDisplay(new String[] { "Id", "FistName", "LastName", "Birth Date", "Age" });
        tableDisplay.printHeader();

        // For each student, print as a row (formatted)
        for (Teacher teacher : teachers) {
            tableDisplay.printRow(new String[] {
                    String.valueOf(teacher.getId()),
                    teacher.getFirstName(),
                    teacher.getLastName(),
                    teacher.getBirthDateString(),
                    String.valueOf(teacher.getAge()),
            });
        }
    }
}
