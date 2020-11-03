package com.me.models;

public class Student extends Person {
    public String group;

    public Student(String name, String email, String group) {
        super(name, email);
        this.group = group;
    }

    @Override
    public String toString() {
        return super.toString() + ", Group: " + group;
    }
}
