package com.me.models;

public class User {
    private final int id;
    private final String username;
    private final String password;
    private final String firstName;
    private final String lastName;

    public User(int id, String username, String password, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Methods
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public UserType getUserType() {
        if (this instanceof Student) return UserType.STUDENT;
        if (this instanceof Teacher) return UserType.TEACHER;
        if (this instanceof Editor) return UserType.EDITOR;
        return UserType.USER;
    }
}
