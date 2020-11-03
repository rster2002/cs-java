package com.me.DAL;

import com.me.models.Editor;
import com.me.models.Student;
import com.me.models.Teacher;
import com.me.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class UserRepo {
    private static UserRepo instance;

    private final List<User> userList = new ArrayList<>();
    private int currentId = 0;

    private UserRepo() {
        populate();
    }

    private void populate() {
        for (int i = 0; i < 20; i++) {
            add(createStudent());
            add(createTeacher());
            add(createEditor());
        }
    }

    private Student createStudent() {
        int id = nextId();

        return new Student(
                id,
                "student" + id,
                "password" + id,
                "Student" + id,
                id + "ington",
                LocalDate.of(1932, 1, 3),
                "ING1"
        );
    }

    private Teacher createTeacher() {
        int id = nextId();

        return new Teacher(
                id,
                "student" + id,
                "password" + id,
                "Student" + id,
                id + "son",
                1039
        );
    }

    private Editor createEditor() {
        int id = nextId();

        return new Editor(
                id,
                "student" + id,
                "password" + id,
                "Student" + id,
                id + "ling"
        );
    }

    private int nextId() {
        currentId++;
        return currentId;
    }

    public static UserRepo getInstance() {
        if (instance == null) instance = new UserRepo();
        return instance;
    }

    public void add(User user) {
        userList.add(user);
    }

    public User getUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }

    public List<User> getUsers() {
        return userList;
    }

    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();

        for (User user : userList) {
            if (user instanceof Student) {
                studentList.add((Student) user);
            }
        }

        return studentList;
    }

    public List<Teacher> getTeachers() {
        List<Teacher> teacherList = new ArrayList<>();

        for (User user : userList) {
            if (user instanceof Teacher) {
                teacherList.add((Teacher) user);
            }
        }

        return teacherList;
    }

    public List<Editor> getEditors() {
        List<Editor> editorList = new ArrayList<>();

        for (User user : userList) {
            if (user instanceof Editor) {
                editorList.add((Editor) user);
            }
        }

        return editorList;
    }
}
