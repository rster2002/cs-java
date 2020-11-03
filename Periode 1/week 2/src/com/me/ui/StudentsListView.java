package com.me.ui;

import com.me.data.UserRepo;
import com.me.models.Student;

import java.util.List;

public class StudentsListView extends View {
    @Override
    public void display() {
        clearScreen();

        // Get the user repo and request the students
        UserRepo userRepo = UserRepo.getInstance();
        List<Student> students = userRepo.getStudents();

        // Create a table display, then set and print the headers
        TableDisplay tableDisplay = new TableDisplay(new String[] {"Id", "FistName", "LastName", "Birth Date", "Age", "Group" });
        tableDisplay.printHeader();

        // For each student, print as a row (formatted)
        for (Student student : students) {
            tableDisplay.printRow(new String[] {
                    String.valueOf(student.getId()),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getBirthDateString(),
                    String.valueOf(student.getAge()),
                    student.getGroup(),
            });
        }
    }
}
