package com.metacube.ds5.sortedlinkedlist;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.metacube.ds5.sortedlinkedlist.implementation.SortedLinkedListImplementation;

/**
 * Write a program to insert a number in sorted LinkList. Use recursive approach.
 * 
 * @author Prateek Jain 
 * Dated:- 28/08/2017
 *
 */
public class SortedLinkedList {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number;
		boolean exit = false;
		int choice;
		SortedLinkedListImplementation sortedLinkedList = new SortedLinkedListImplementation();
		// loop continue till exit choice is selected
		while (!exit) {
			try {
				System.out.println("\n1) Add element in SortedLinkedList"
						+ "\n2) Print the SortedLinkedList" 
						+ "\n3) Check Linkedlist empty or not"
						+ "\n4) Exit.");
				System.out.println("Enter your Choice.");
				choice = scan.nextInt();
				// switch case to perform operations according to choice selected
				switch (choice) {
				/*
				 * case 1 : Add element in linked list
				 * case 2 : Print the Linked List
				 * case 3 : Check Linked List is empty or not
				 * case 4 : Exit from aplication
				 * default: Display Invalid choice message
				 */
				case 1:
					while (true) {
						try {
							System.out.println("Enter the element");
							number = scan.nextInt();
							sortedLinkedList.add(number);
							System.out.println("Number is added.");
							break;
						} catch (InputMismatchException e) {
							System.out.println("Invalid input.Only Integers are allowed");
							scan.next();
						}
					}
					break;
				case 2:
					System.out.println(sortedLinkedList.getAll());
					break;
				case 3:
					System.out.println(sortedLinkedList.isEmpty().getString());
					break;
				case 4:
					System.out.println("Exiting from application");
					exit = true;
					break;

				default:
					System.out.println("Invalid Choice. Try Again");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. try Again");
				scan.next();
			}
		}
		scan.close();
	}
}
