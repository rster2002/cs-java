package com.me.models;

import com.me.AccessLevel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public abstract class User {
    // User credentials
    protected int id;
    protected String username;
    private String password;

    // User info
    protected String firstName;
    protected String lastName;
    protected AccessLevel accessLevel;
    protected LocalDate birthDate;

    public User(int id, String username, String password, String firstName, String lastName, LocalDate birthDate, AccessLevel accessLevel) {
        this.id = id;
        this.username = username;
        this.password = password;

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.accessLevel = accessLevel;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getBirthDateString() {
        return birthDate.format(DateTimeFormatter.ofPattern("dd/MMM/yyyy"));
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        Period period = Period.between(birthDate, now);

        return period.getYears();
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public boolean checkPassword(String input) {
        return input.equals(password);
    }

    public boolean changePassword(String currentPassword, String newPassword) {
        if (!currentPassword.equals(password)) return false;

        password = newPassword;
        return true;
    }
}
