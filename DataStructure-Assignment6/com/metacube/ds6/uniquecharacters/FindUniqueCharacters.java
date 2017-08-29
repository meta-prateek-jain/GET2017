package com.metacube.ds6.uniquecharacters;

import java.util.Scanner;

import com.metacube.ds6.uniquecharacters.implementation.UniqueCharactersInString;

/**
 * Write a method that takes a string and returns the number of unique
 * characters in the string. It is expected that a string with the same
 * character sequence may be passed several times to the method. Since the
 * counting operation can be time consuming, the methods should cache the
 * results, so that when the methods is given a string previously encountered,
 * it will simply retrieve the stored result. Use collection and maps where
 * appropriate.
 * 
 * @author Prateek Jain
 * Dated : 29/08/2017
 *
 */
public class FindUniqueCharacters {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		UniqueCharactersInString uniqueCharactersInString = new UniqueCharactersInString();
		String string;
		String choice;
		boolean flag = true;
		// loop continue till user do not want to enter any string
		while (flag) {
			System.out.println("Enter the String ");
			string = scan.nextLine();
			string = string.replace(" ", "");
			/*
			 * if string is entered then continue to find unique characters present in it
			 * else display the message to enter something
			 */
			if (string.length() != 0) {
				System.out.println("Unique characters in string is : "+ uniqueCharactersInString.find(string));
				System.out.println("To find unique characters present in another string : enter yes else enter anything to exit");
				choice = scan.next();
				choice = choice.toLowerCase();
				// switch case is continue the operation if yes entered by user else exit from the application
				switch (choice) {
				case "yes":
					scan.nextLine();
					break;

				default:
					flag = false;
					break;
				}
			} else {
				System.out.println("Please Enter something");
			}
		}
		scan.close();
	}

}
