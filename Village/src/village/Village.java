/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package village;

/**
 *
 * @author Neticius
 */
// Tutorial 1, 159272. Task 3.
public class Village {
	
	public static void main(String[] args) {
		// Create several Person objects to create yourself a little Village. Store these so you can print them later.
		// You can either hardcode these in, or better yet, ask the user for information about them! If you do this, you might want to define a helper function.
		
		
		// One person just got married. They changed their surname!
		
		
		// Print out each Person in the Village (make sure you have implemented the Person.toString() method first)
		
	}
	
}

class Person {
	// Include at least four other 'traits' that a Person might have that usually differ from other People.
	private String surname;
	
	// Update this constructor to include the additional traits you made.
	public Person (String surname) {
		this.surname = surname;
	}
	
	// Implement
	public void changeSurname(String newSurname) {
	    
	}
	
	// Create a sensible toString implementation so each Person object can be printed out.
	public String toString() {
		return "";
	}
}
