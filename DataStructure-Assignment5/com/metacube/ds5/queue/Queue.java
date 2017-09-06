package com.metacube.ds5.queue;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.metacube.ds5.queue.implementation.QueueImplementation;

/**
 * Write a program to implement the Queue functionality using the java
 * collections. Look for the best collection to meet this requirement. Provide
 * some points justifying your collection choice
 * 
 * @author Prateek Jain 
 * Dated :- 28/08/2017
 *
 */
public class Queue {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String element;
		boolean exit = false;
		QueueImplementation<String> queue = new QueueImplementation<String>();
		int choice;
		// loop continue till exit choice is selected
		while(!exit) {
			try{
				System.out.println("\n1) Add element in queue"
						+ "\n2) Remove element from head of queue"
						+ "\n3) Retrieve element from head of queue"
						+ "\n4) check queue empty or not"
						+ "\n5) Print the queue"
						+ "\n6) Exit.");
				System.out.println("Enter your Choice.");
				choice = scan.nextInt();
				// switch case to perform operations according to choice selected
				switch (choice) {
				/*
				 * case 1 : add element in queue
				 * case 2 : remove topmost element from queue and display the element
				 * case 3 : retrieve topmost element from queue
				 * case 4 : check queue empty or not
				 * case 5 : print the queue
				 * case 6 : exit from the application
				 * deafult: Display invalid choice message
				 */
				case 1:
					System.out.println("Enter the element");
					element = scan.next();
					System.out.println(queue.enqueue(element).getString());
					break;
				case 2:
					element = queue.dequeue();
					/*
					 * if element is null then display queue is empty
					 * else the removed element
					 */
					if(element == null) {
						System.out.println("Queue is empty");
					}else {
						System.out.println("Removed Element is : " + element);
					}
					break;
				case 3:
					element = queue.peek();
					/*
					 * if element is null then display queue is empty
					 * else the retrieved element
					 */
					if(element == null) {
						System.out.println("Queue is empty");
					}else {
						System.out.println("Retrieved Element is : " + element);
					}
					break;
				case 4:
					System.out.println(queue.isEmpty().getString());
					break;
				case 5:
					System.out.println(queue.getAll());
					break;
				case 6:
					System.out.println("Exiting from application");
					exit = true;
					break;

				default:
					System.out.println("Invalid Choice. Try Again");
					break;
				}
			} catch(InputMismatchException e) {
				System.out.println("Invalid input. try Again");
				scan.next();
			}
		}
		scan.close();
	}
}
