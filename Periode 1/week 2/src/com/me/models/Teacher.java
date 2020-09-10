package com.me.models;

import com.me.AccessLevel;

import java.time.LocalDate;

public class Teacher extends User {
    public Teacher(int id, String username, String password, String firstName, String lastName, LocalDate birthDate) {
        super(id, username, password, firstName, lastName, birthDate, AccessLevel.EDITOR);
    }
}
