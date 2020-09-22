package com.me.ui;

import com.me.models.Student;
import com.me.models.Subject;

public class ChangeStudentGrades extends View {
    private final Student student;

    public ChangeStudentGrades(Student student) {
        this.student = student;
    }

    @Override
    public void display() {
        for (Subject subject : student.subjects) {
            System.out.printf("Current grade %s is: %s Enter (new) grade: ", subject.name, subject.grade);
            subject.grade = promptGrade();
        }
    }

    private double promptGrade() {
        while (true) {
            double grade = scanner.nextDouble();
            scanner.nextLine();

            if (grade < 1) System.out.println("Please enter a grade bigger than 1");
            else if (grade > 10) System.out.println("Please enter a grade smaller than 10");
            else return grade;
        }
    }
}
