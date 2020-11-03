package com.me;

import com.me.models.Employee;
import com.me.models.Freelancer;
import com.me.models.Payable;
import com.me.models.Student;
import com.me.models.Timer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main program = new Main();
        program.start();
    }

    public void start() {
        Timer timer = new Timer();
        timer.start();
        timer.stop();
    }

//    public void start() {
//        TreeSet<Student> students = new TreeSet<>();
//
//        Student a = new Student("A", "a");
//        Student b = new Student("A", "a");
//
//        // Add the students to the Set
//        students.add(new Student("David", "Dinner"));
//        students.add(new Student("Alice", "Arab"));
//        students.add(new Student("Eric", "Ember"));
//        students.add(new Student("Celine", "Castle"));
//        students.add(new Student("Bob", "Boris"));
//
//        // Print the students onto the screen
//        students.forEach(student -> {
//            System.out.println(student.toString());
//        });
//    }

//    public void start() {
//        List<String> words = new ArrayList<>();
//
//        // Add the words to a list
//        words.add("One");
//        words.add("Two");
//        words.add("Three");
//        words.add("Four");
//        words.add("Five");
//        words.add("Six");
//        words.add("Seven");
//        words.add("Eight");
//        words.add("Nine");
//        words.add("Ten");
//
//        // Create a map and add the words to the map
//        Map<Integer, String> map = new HashMap<>();
//        words.forEach(word -> {
//            map.put(word.length(), word);
//            System.out.println("Key: " + word.length() + ", Value: " + word);
//        });
//
//        System.out.println();
//
//        // Loop over the entries and display the key and value
//        map.forEach((key, value) -> {
//            System.out.println("Key: " + key + ", Value: " + value);
//        });
//    }
}
