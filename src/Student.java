/*
 * OOPDA Spring 2016, Myers
 * University Lab
 * @author Meriel Stein
 * @author Troy Rainboth
 * @version 2016.02.16
 */

import java.io.*;

public class Student extends Person {

	private String major;

	public Student(String firstName, String middleName, String lastName, String email, String ssn, Integer age,
			Integer id, String major) throws IOException {
		super(firstName, middleName, lastName, email, ssn, age, id);
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	// calls on the parent classes' display method and then prints out the
	// Student's major
	public void display() {
		super.display();
		System.out.println(major);

	}
}
