package com.me.models;

public class Student implements Comparable<Student> {
    public String firstName;
    public String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Student otherStudent) {
        return lastName.compareTo(otherStudent.lastName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
