package com.me.models;

public class Teacher extends Person {
    public double salary;

    public Teacher(String name, String email, double salary) {
        super(name, email);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary: " + salary;
    }
}
