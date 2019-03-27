/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loopy;

import java.util.Scanner;

/**
 *
 * @author Neticius
 */
// Tutorial 1, 159272. Task 2.
public class Loopy {
	
	public static void main (String[] args) {
		// TODO: Use a loop to print every upper case letter
        for (int i = 65; i < 91; i++) {System.out.println((char)i);}
        
		// TODO: Get input from user. Print the same input back but with cases swapped. Use the helper functions below.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter some text: ");
        String input = scanner.nextLine();
        System.out.println(toggleStringCase(input));
	}
	
	// TODO: Implement this function to return the opposite case of the letter given. DO NOT USE any built in functions.
	// THINK! How will you handle the case where the char given is not a letter? (any sensible treatment of this edge case is okay - but you have to figure out which way you will choose)
	private static char toggleCase(char c) {
        if (java.lang.Character.isUpperCase(c)) {
            return java.lang.Character.toLowerCase(c);
        }
        if (java.lang.Character.isLowerCase(c)) {
            return java.lang.Character.toUpperCase(c);
        }
		return c;
	}
	
	// TODO: Implement this function to toggle the case each char in a string. Use toggleCase() to help you.
	private static String toggleStringCase(String str) {
        char[] in = str.toCharArray();
        char[] out = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            out[i] = toggleCase(in[i]);
        }
		return new String(out);
	}
}
