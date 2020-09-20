package com.me.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private final String group;
    public final List<Subject> subjects = new ArrayList<>();

    public Student(int id, String username, String password, String firstName, String lastName, LocalDate birthDate, String group) {
        super(id, username, password, firstName, lastName, birthDate, AccessLevel.BASIC);

        this.group = group;
    }

    public Subject getSubjectByName(String name) {
        for (Subject subject : subjects) {
            if (subject.name.equals(name)) return subject;
        }

        return null;
    }

    public String getGroup() {
        return group;
    }
}
