package com.me.models;

import java.time.LocalDate;

public class Student extends User {
    private final String group;

    public Student(int id, String username, String password, String firstName, String lastName, LocalDate birthDate, String group) {
        super(id, username, password, firstName, lastName, birthDate, AccessLevel.BASIC);

        this.group = group;
    }

    public String getGroup() {
        return group;
    }
}
