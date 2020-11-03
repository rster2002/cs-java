package com.me;

import com.me.models.Person;
import com.me.models.Student;
import com.me.models.Teacher;

public class Main {

    public void main(String[] args) {
		Person[] persons = new Person[2];

		persons[0] = new Student("Student", "a@a", "INF");
		persons[1] = new Teacher("Teacher", "b@b", 100);

		for (Person person : persons) {
			person.printInfo();

			if (person instanceof Teacher) {
				Teacher teacher = (Teacher) person;
				System.out.println("Yearly salary of " + teacher.name + ": " + teacher.salary * 12);
			}
		}
    }
}
