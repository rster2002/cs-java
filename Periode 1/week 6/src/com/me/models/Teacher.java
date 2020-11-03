package com.me.models;

public class Teacher extends User {
    private double salary;

    public Teacher(int id, String username, String password, String firstName, String lastName, double salary) {
        super(id, username, password, firstName, lastName);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
