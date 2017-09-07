package com.metacube.ds8.treesort;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.metacube.ds8.treesort.implementation.BinarySearchTree;
import com.metacube.ds8.treesort.model.Student;

/**
 * Write a program to print disorderly provided role numbers of n students in
 * ascending series using tree sort
 * 
 * @author Prateek Jain
 * Dated:- 31/08/2017
 */
public class TreeSort {
	private static Scanner scan = new Scanner(System.in);
	private static List<Student> studentList = new ArrayList<Student>();

	/**
	 * Method is used to take Integer input from user
	 * 
	 * @return the integer input got from user
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
	 * Main method to start the Application
	 * 
	 * @param args
	 * 		arguments passed at console
	 */
	public static void main(String[] args) {
		System.out.println("How many Entries of students to add in list");
		int noOfStudents = takeIntegerInput();
		// loop continue till valid input is entered
		while (noOfStudents < 1) {
			System.out.println("It shold be greater than zero. Try Again");
			noOfStudents = takeIntegerInput();
		}
		int rollNo;
		String name;
		boolean flag = true;
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		// loop continue till all students details is added to tree and perform tree sorting 
		for (int index = 0; index < noOfStudents; index++) {
			System.out.println("Enter the details of student "+(index+1));
			/*
			 * do-while loop is used to check roll no is valid should be unique
			 */
			do {
				System.out.println("Enter the roll No");
				rollNo = takeIntegerInput();
				// loop continue till valid roll no is entered
				while (rollNo < 1) {
					System.out.println("It shold be greater than zero. Try Again");
					rollNo = takeIntegerInput();
				}
				/*
				 * if studentList is not empty then continue
				 * else break the loop
				 */
				if(!studentList.isEmpty()) {
					// loop continue till end of list reached
					for(Student student : studentList) {
						// if roll no is same then diplay message to enter again and break the loop to again take the roll no value
						if(student.getRollNo() == rollNo) {
							System.out.println("Roll no already exist. Try Again");
							flag = true;
							break;
						}
						flag = false;
					}
				} else {
					flag = false;
				}
			}while(flag);
			scan.nextLine();
			System.out.println("Enter the name");
			name = scan.nextLine();
			Student student = new Student(rollNo, name);
			binarySearchTree.setRoot(binarySearchTree.insert(binarySearchTree.getRoot(), student));
			studentList.add(student);
		}
		studentList = binarySearchTree.inOrderTraversing(binarySearchTree.getRoot());
		for(Student student:studentList){
			System.out.println(student.toString());
		}
	}
}
