package com.metacube.singlyLinkedList;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is the controller class of SinglyLinkedList
 * 
 * @author Prateek Jain
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int flag;
		SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();
		do {
			System.out.println("1. Add item to SinglyLinkedList"
					+ "\n2. Add item to SinglyLinkedList at a location"
					+ "\n3. Remove item from SinglyLinkedList"
					+ "\n4. Remove item from SinglyLinkedList by location"
					+ "\n5. Retreive item from SinglyLinkedList by location"
					+ "\n6. Reverse the SinglyLinkedList"
					+ "\n7. Print The List" + "\n8. Sort The List"
					+ "\n9. Exit\n");
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
				flag = linkedList.removeNode(element);
				/*
				 * if flag is not equal to -1 then print message the element is removed 
				 * else print error message
				 */
				if (flag != -1) {
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
				 * if flag is not equal to -1 then print message that element is removed 
				 * else print error message
				 */
				if (flag != -1) {
					System.out
							.println("Element is removed from the LinkedList");
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
							System.out
									.println("Input should be greater than zero.");
						}
					} catch (InputMismatchException e) {
						System.out.println("Invalid input. Try Again");
						scan.next();
					}
				}
				element = linkedList.getElementByLocation(location - 1);
				/*
				 * if flag is not equal to -1 then print message that element is removed 
				 * else print error message
				 */
				if (element == null) {
					System.out.println("Location Invalid");
				} else {
					System.out.println("Element present at this location is "
							+ element.toString());
				}
				break;
			case "6":
				linkedList.reverse();
				break;
			case "7":
				int size = linkedList.getActualSize();
				/*
				 * If linked list is empty then print message 
				 * else display the list
				 */
				if (size == 0) {
					System.out.println("LinkedList is empty");
				} else {
					// loop continue till end of list
					for (int index = 0; index < size; index++) {
						System.out.print(linkedList.getElementByLocation(index)
								+ " ");
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
			default:
				System.out.println("Invalid choice. Try Again");
				break;
			}
		} while (true);
	}
}