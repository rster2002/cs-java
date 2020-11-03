package com.me.models;

public class Person {
    public String name;
    public String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String toString() {
        return "Name: " + name + ", Email: " + email;
    }

    public void printInfo() {
        System.out.println(this.toString());
    }
}
