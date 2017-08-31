package com.metacube.doublyLinkedList;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is the controller class of DoublyLinkedList
 * 
 * @author Prateek Jain
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int flag;
		DoublyLinkedList<String> linkedList = new DoublyLinkedList<String>();
		do {
			System.out.println("1. Add item to DoublyLinkedList"
					+ "\n2. Add item to DoublyLinkedList at a location"
					+ "\n3. Remove item from DoublyLinkedList"
					+ "\n4. Remove item from DoublyLinkedList by location"
					+ "\n5. Retreive item from DoublyLinkedList by location"
					+ "\n6. Reverse the DoublyLinkedList"
					+ "\n7. Print DoublyLinkedList"
					+ "\n8. Sort DoublyLinkedList" + "\n9. Exit\n");
			System.out.println("Enter your choice");
			String choice = scan.next();
			// switch case to perform operations according to choice entered
			switch (choice) {
			case "1":
				System.out.println("Enter element you want to add");
				String element = scan.next();
				linkedList.addNode(element);
				break;
			case "2":
				int location = 0;
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
				System.out.println("Enter element you want to add");
				element = scan.next();
				flag = linkedList.addNodeAtLocation(location, element);
				/*
				 * if flag is not equal to -1 then print message the element is added
				 * else print invalid location message
				 */
				if (flag != -1) {
					System.out.println("Element is added to list");
				} else {
					System.out.println("Invalid location");
				}
				break;

			case "3":
				System.out.println("Enter element you want to remove");
				element = scan.next();
				int flag1;
				flag1 = linkedList.removeNode(element);
				/*
				 * if flag is not equal to -1 then print message the element is removed 
				 * else print error message
				 */
				if (flag1 != 0) {
					System.out
							.println("Element is removed from the LinkedList");
				} else {
					System.out
							.println("Element is not present in the LinkedList");
				}
				break;
			case "4":
				// loop continue till valid location is entered
				while (true) {
					System.out.println("Enter the location");
					try {
						location = scan.nextInt();
						/*
						 * if location is greater than zero means valid then break the loop 
						 * else print the error message
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
				flag = linkedList.removeNodeFromLocation(location - 1);
				/*
				 * if flag is not equal to -1 then print message the element is removed 
				 * else print error message
				 */
				if (flag != -1) {
					System.out.println("Element is removed from the List");
				} else {
					System.out.println("Invalid Location");
				}
				break;
			case "5":
				// loop continue till valid location is entered
				while (true) {
					System.out.println("Enter the location");
					try {
						location = scan.nextInt();
						/*
						 * if location is greater than zero means valid then break the loop 
						 * else print the error message
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
				element = linkedList.getElementByLocation(location - 1);
				/*
				 * if flag is equal to -1 then print message that element is removed 
				 * else print error message
				 */
				if (element.equals("-1")) {
					System.out.println("Location Invalid");
				} else {
					System.out.println("Element present at this location is "+ element.toString());
				}
				break;
			case "6":
				linkedList.reverse();
				break;
			case "7":
				int size = linkedList.getActualSize();
				/*
				 * If linked list is empty then print message else display the
				 * list
				 */
				if (size == 0) {
					System.out.println("LinkedList is empty");
				} else {
					// loop continue till end of list
					for (int index = 0; index < size; index++) {
						System.out.print(linkedList.getElementByLocation(index)+ " ");
					}
				}
				break;
			case "8":
				linkedList.sort();
				break;
			case "9":
				scan.close();
				System.exit(0);
				break;
			}
		} while (true);
	}
}