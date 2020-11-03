package com.me.DAL;

import com.me.models.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private final List<Person> people = new ArrayList<>();

    public Database() {
        people.add(new Person("George", "Washington", LocalDate.of(1732, 2, 22)));
        people.add(new Person("John", "Adams", LocalDate.of(1735, 8, 30)));
    }

    public List<Person> getPeople() {
        return people;
    }
}
