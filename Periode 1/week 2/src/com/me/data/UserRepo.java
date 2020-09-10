package com.me.data;

import com.me.models.Student;
import com.me.models.Teacher;
import com.me.models.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Data repo, this would usually be a DAL with access to a database, but this will have to do for now.
public class UserRepo {
    private static UserRepo instance;

    private int currentId = 0;
    private final List<User> users = new ArrayList<User>();

    // Instance management
    private UserRepo() {
        populateStudents();
        populateTeachers();
    }

    public static UserRepo getInstance() {
        if (instance == null) instance = new UserRepo();
        return instance;
    }

    // Data population, this would usually be a database
    public int nextId() {
        currentId++;
        return currentId;
    }

    public void addUser(User user) {
        users.add(user);
    }

    private void populateStudents() {
        for (int i = 0; i < 20; i++) {
            addUser(createStudent());
        }
    }

    private void populateTeachers() {
        for (int i = 0; i < 20; i++) {
            addUser(createTeacher());
        }
    }

    private Student createStudent() {
        int id = nextId();

        String username = "student" + id;
        String password = "password" + id;
        String firstName = "Student " + id;
        String lastName = id + "ington";

        LocalDate birthDate = LocalDate.of(1997, 1, 1);
        String group = "INF2Sc";

        return new Student(id, username, password, firstName, lastName, birthDate, group);
    }

    private Teacher createTeacher() {
        int id = nextId();

        String username = "teacher" + id;
        String password = "password" + id;
        String firstName = "Teacher " + id;
        String lastName = id + "ling";

        LocalDate birthDate = LocalDate.of(1967, 1, 1);

        return new Teacher(id, username, password, firstName, lastName, birthDate);
    }

    // Getters
    public List<User> getUsers() {
        return users;
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<Student>();

        for (User user : users) {
            if (user instanceof Student) {
                students.add((Student) user);
            }
        }

        return students;
    }

    public List<Teacher> getTeachers() {
        List<Teacher> teachers = new ArrayList<Teacher>();

        for (User user : users) {
            if (user instanceof Teacher) {
                teachers.add((Teacher) user);
            }
        }

        return teachers;
    }

    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) return user;
        }

        return null;
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) return user;
        }

        return null;
    }
}
