
/*
 * OOPDA Spring 2016, Myers
 * University Lab
 * @author Meriel Stein
 * @author Troy Rainboth
 * @version 2016.02.16
 */

import java.io.*;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class PersonApp {

	BufferedReader br;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Person> persons = new HashMap<Integer, Person>();
		boolean looping = true;
		int personCount = 0;
				
		/* person-making loop */
		while (looping){
			
			String firstName = Person.getString("Provide a first name: ");

			String middleName = Person.getString("Provide a middle name: ");

			String lastName = Person.getString("Provide a last name: ");
			
			String email = Person.getString("Provide an email: ");
			while(!Person.validateEmail(email)){
				System.out.print("Invalid input, provide a valid email: ");
				email = br.readLine();
			}

			String ssn = Person.getString("Provide ssn in ###-##-#### format: ");
			while(!Person.validateSsn(ssn)){
				System.out.print("Invalid input, provide a valid ssn in ###-##-#### format: ");
				ssn = br.readLine();
			}
			
			System.out.print("Provide an age: ");
			Integer age = Integer.parseInt(br.readLine());
			while(!Person.validateAge(age)){
				System.out.println("Invalid input, provide a valid age:");
				age = Integer.parseInt(br.readLine());
			}
			
			Person person = new Person(firstName, middleName, lastName, email, ssn, age, personCount);
			persons.put(personCount, person);
			personCount++;
			
			System.out.print("Would you like to make another Person? y/n ");
			if(br.readLine().toLowerCase().startsWith("n")){
				br.close();
				looping = false;
			}
		} // end while loop
		
		// add Student and Instructor instances
		Person i1 = new Instructor("Robert", "WineBeard", "Baratheon", "TheKing@KingsLanding.com", 
				"001-01-0001", 49, 123, "Athletics");
		Person s1 = new Student("Meriel", "Katarina", "Stein", "steinm6@students.rowan.edu", "123-45-6789", 20,
				234, "Computer Science");
		persons.put(i1.getID(), i1);
		persons.put(s1.getID(), s1);
		
		
		// display each person in HashMap
		Set<Integer> keySet = persons.keySet();
		Iterator<Integer> iter = keySet.iterator();
		while (iter.hasNext()){
			Person p = persons.get(iter.next());
			p.display();
			System.out.println();
		}
	} // end main

} // end PersonApp class
