package com.metacube.arrayList;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.metacube.arrayList.ArrayListImplementation;

/**
 * This class is the main class to controll the arrayListImplementation
 * 
 * @author Prateek Jain
 *
 */
public class Main {

	public static void main(String[] args) {
		ArrayListImplementation<String> arrayList = new ArrayListImplementation<String>();
		Scanner scan = new Scanner(System.in);
		String choice;
		int location = -1;
		String item;
		boolean flag = true;
		// loop continue till exit is not choose
		while (flag) {
			System.out
					.println("1.Adding an item into array list "
							+ "\n2.Adding an item into array list at the given particular location"
							+ " \n3.Retrieving the first occurrence of an item based on its given location"
							+ "\n4.Retrieving the first index of particular item in the arraylist"
							+ "\n5.Removing an item based on particular location"
							+ "\n6.Remove given particular item from the arraylist"
							+ "\n7.remove all the elements of the list"
							+ "\n8.Reverse the arraylist"
							+ "\n9.Sort the elements of arraylist"
							+ "\n10.Get all the elements of arrayList"
							+ "\n11.Exit");
			System.out.println("Enter your choice");
			choice = scan.next();
			// switch case perform action according to the choice
			switch (choice) {
			case "1":
				System.out.println("Enter the item");
				item = scan.next();
				arrayList.addItem(item);
				break;
			case "2":
				System.out.println("Enter the Item");
				item = scan.next();
				// loop continue till valid location is entered
				while (true) {
					System.out.println("Enter the location");
					try {
						location = scan.nextInt();
						/*
						 * if location is greater than zero means valid then
						 * break the loop else print the error message
						 */
						if (location >= 0) {
							break;
						} else {
							System.out
									.println("Input should be greater than zero.");
						}
					} catch (InputMismatchException e) {
						System.out.println("Invalid input. Try Again");
						scan.next();
					}
				}
				int temp = arrayList.addItemAtParticularLocation(item, location);
				// if temp is -1 then print the message
				if (temp == -1) {
					System.out.println("Item is unable to add to list at this location");
				}
				break;
			case "3":
				System.out.println("Enter the Item");
				item = scan.next();
				// loop continue till valid location is entered
				while (true) {
					System.out.println("Enter the location");
					try {
						location = scan.nextInt();
						/*
						 * if location is greater than zero means valid then
						 * break the loop else print the error message
						 */
						if (location >= 0) {
							break;
						} else {
							System.out.println("Input should be greater than zero.");
						}
					} catch (InputMismatchException e) {
						System.out.println("Invalid input. Try Again");
						scan.next();
					}
				}
				location = arrayList.getFirstOccurrenceAfterLocation(item,
						location);
				/*
				 * if location is -1 then item is not found else print the
				 * location of the item
				 */
				if (location == -1) {
					System.out.println("Item is not Found.");
				} else {
					System.out.println("First occurrence of " + item
							+ " after this location is at " + location);
				}
				break;
			case "4":
				System.out.println("Enter the Item");
				item = scan.next();
				location = arrayList.getFirstOccurrence(item);
				/*
				 * if location is -1 then item is not found 
				 * else print the location of the item
				 */
				if (location == -1) {
					System.out.println("Item is not Found.");
				} else {
					System.out.println("First occurrence of " + item+ " is at " + location);
				}
				break;
			case "5":
				int temp2;
				// loop continue till valid location is entered
				while (true) {
					System.out.println("Enter the location");
					try {
						location = scan.nextInt();
						/*
						 * if location is greater than zero means valid then
						 * break the loop else print the error message
						 */
						if (location >= 0) {
							break;
						} else {
							System.out.println("Input should be greater than zero.");
						}
					} catch (InputMismatchException e) {
						System.out.println("Invalid input. Try Again");
						scan.next();
					}
				}
				temp2 = arrayList.removeItemFromIndex(location);
				/*
				 * if temp2 is -1 then item is not found else print the location
				 * of the item
				 */
				if (temp2 == -1) {
					System.out.println("Item is not Found.");
				} else {
					System.out.println("item is removed from the list");
				}
				break;
			case "6":
				System.out.println("Enter the Item");
				item = scan.next();
				int temp1;
				temp1 = arrayList.removeParticularItem(item);
				/*
				 * if temp1 is -1 then item is not found else print the location
				 * of the item
				 */
				if (temp1 == -1) {
					System.out.println("Item is not Found.");
				} else {
					System.out.println("item is removed from the list");
				}
				break;
			case "7":
				arrayList.clearTheList();
				break;
			case "8":
				arrayList.reverse();
				break;
			case "9":
				arrayList.sort();
				break;
			case "10":
				/*
				 * if arrayList size is zero then print message else print the
				 * arrayList
				 */
				if (arrayList.getActualSize() == 0) {
					System.out.println("Array List is Empty");
				} else {
					// loop continue till end of arrayList
					for (int index = 0; index < arrayList.getActualSize(); index++) {
						System.out.println(arrayList.get(index) + " ");
					}
				}
				break;
			case "11":
				flag = false;
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}
		}
		scan.close();
	}
}
