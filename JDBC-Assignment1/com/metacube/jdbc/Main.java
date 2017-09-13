package com.metacube.jdbc;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.metacube.jdbc.model.Title;
import com.metacube.jdbc.util.Helper;

/**
 * Main class to start the application
 * 
 * @author Prateek Jain
 * Dated: 12/09/2017
 *
 */
public class Main {
	private static Scanner scan = new Scanner(System.in);
	private static String name;
	/**
	 * Method is used to take Integer input from user
	 * @return
	 * 		the integer input got from user
	 */
	private static int takeIntegerInput() {
		int input;
		// loop continue till valid input is entered
		while (true) {
			try {
				input = scan.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input. Only Integers are allowed. Try Again");
				scan.next();
			}
		}
		return input;
	}
	
	/**
	 * main method to run the application
	 *  
	 * @param args
	 * 		arguments taken through console
	 */
	public static void main(String[] args) {
		try {
			Helper helper = Helper.getInstance();
			int choice;
			// loop continue till exit choice is selected
			while(true) {
				System.out.println("\n1) Fetch all the books published by author"
						+ "\n2) Check the book issued or not"
						+ "\n3) Delete all those books which were not issued in last 1 year"
						+ "\n4) Exit"
						+ "\n Enter your choice :");
				choice = takeIntegerInput();
				// switch case to perform operation according to the choice
				switch (choice) {
				/*
				 * case 1: Fetch all the books published by author
				 * case 2: Check the book issued or not
				 * case 3: Delete all those books which were not issued in last 1 year.
				 * case 4: Exit from the application
				 * default : display error message
				 */
				case 1:
					scan.nextLine();
					System.out.println("Enter the name of author :");
					name = scan.nextLine();
					name = name.trim();
					List<Title> titlesList = helper.fetchBooksWrittenByAuthor(name);
					/*
					 * if list size is greater than zero then display the titles 
					 * else display no book written message
					 */
					if(titlesList.size() > 0){
						System.out.println("Books Written by "+name+" are:");
						// loop continue till end of list is reached
						for (Title title : titlesList) {
							System.out.println(title.getName());
						}
					} else {
						System.out.println("There is no book available which is written by "+name);
					}
					break;

				case 2:
					scan.nextLine();
					System.out.println("Enter the name of book :");
					name = scan.nextLine();
					name = name.trim();
					int flag = helper.isBookIssued(name);
					/*
					 * if flag is -1 then display book is not in library
					 * else if flag is 1 then display book can't be issued 
					 * else display book can be issued
					 */
					if(flag == -1) {
						System.out.println("Book is not available in library");
					}
					else if(flag == 1) {
						System.out.println("Book can't be issued");
					} else {
						System.out.println("Book can be issued");
					}
					break;
					
				case 3:
					System.out.println("Number of Books removed is : "+helper.deleteBooksNotIssuedSinceLastYear());
					break;
					
				case 4:
					System.exit(0);
					break;
					
				default:
					System.out.println("Invalid choice. Try again");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}
