package com.me.models;

public class Subject {
    public String name;
    public double grade;

    public Subject(String name) {
        this(name, 0);
    }

    public Subject(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}
