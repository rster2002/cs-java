package com.me.ui;

import com.me.data.UserRepo;
import com.me.models.Student;
import com.me.models.Subject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentsReportListView extends View {
    private final UserRepo userRepo = UserRepo.getInstance();;

    @Override
    public void display() {
        clearScreen();

        // Get the students and print the overview
        List<Student> students = userRepo.getStudents();
        printOverview(students);
        Student selectedStudent = promptStudent();

        if (!active) return;
        changeView(new StudentDetailView(selectedStudent));
    }

    private void printOverview(List<Student> students) {
        // Get the headers for the table
        List<String> subjectHeaders = getSubjectNamesFromStudents(students);
        List<String> headers = new ArrayList<String>(Arrays.asList("Id", "FistName", "LastName", "Birth Date", "Age", "Group"));
        headers.addAll(subjectHeaders);

        // Create a table display, then set and print the headers
        TableDisplay tableDisplay = new TableDisplay(headers);
        tableDisplay.printHeader();

        // For each student, create a row
        for (Student student : students) {
            // Create a list with all the shared values of the students
            List<String> headerValues = new ArrayList<String>(Arrays.asList(
                    String.valueOf(student.getId()),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getBirthDateString(),
                    String.valueOf(student.getAge()),
                    student.getGroup())
            );

            // Loop over every subject found and if the student has that subject, display it
            for (String subjectName : subjectHeaders) {
                Subject studentSubject = student.getSubjectByName(subjectName);

                if (studentSubject == null) headerValues.add("--");
                else headerValues.add(String.valueOf(studentSubject.grade));
            }

            tableDisplay.printRow(headerValues);
        }
    }

    private List<String> getSubjectNamesFromStudents(List<Student> students) {
        // Get all the unique subjects among the users
        List<String> subjectNames = new ArrayList<>();
        for (Student student : students) {
            for (Subject subject : student.subjects) {
                String subjectName = subject.name;
                if (!subjectNames.contains(subjectName)) subjectNames.add(subjectName);
            }
        }

        return subjectNames;
    }

    private Student promptStudent() {
        List<Student> students = userRepo.getStudents();

        while (true) {
            System.out.print("Enter student id (Report Details) | Or 0 back to main menu: ");
            int studentNumber = scanner.nextInt();
            scanner.nextLine();

            if (studentNumber == 0) {
                active = false;
                return null;
            }

            for (Student student : students) {
                if (student.getId() == studentNumber) return student;
            }

            print("Cannot find a student with that student number");
        }
    }
}
