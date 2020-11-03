package com.me.models;

import java.time.LocalDate;

public class Student extends User {
    private final LocalDate birthDate;
    private final String group;

    public Student(int id, String username, String password, String firstName, String lastName, LocalDate birthDate, String group) {
        super(id, username, password, firstName, lastName);
        this.birthDate = birthDate;
        this.group = group;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getGroup() {
        return group;
    }
}
