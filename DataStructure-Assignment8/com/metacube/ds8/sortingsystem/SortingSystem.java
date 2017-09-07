package com.metacube.ds8.sortingsystem;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.metacube.ds8.sortingsystem.implementation.SortingTechniques;

/**
 * Write a sorting system, which takes input from user and provide a sorted
 * list. Here User could choose if he want to go with Comparison Sorting Or
 * Linear Sorting. Given Conditions: 1 - For comparison sorting system will use
 * Bubble Sort or Quick Sort techniques (When less number of inputs (input
 * elements <= 10) use Bubble Sort else Quicksort) 2 - For linear sorting system
 * will use Counting Sort or Radix Sort techniques (When large inputs(more than
 * 2 digit) use Radix Sort else Counting Sort)
 * 
 * (System should be intelligent to pick suitable techniques for sort as per
 * provided input )
 * 
 * @author Prateek Jain 
 * Dated :- 30/08/2017
 */
public class SortingSystem {

	private static Scanner scan = new Scanner(System.in);

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
	 * Method is used to take Integer Array input from user
	 * 
	 * @return
	 * 		The integer array
	 */
	private static int[] takeIntegerArrayInput() {
		int[] array;
		int size;
		System.out.println("Enter the size of array to sort :");
		size = takeIntegerInput();
		// loop continue till valid size is entered
		while (size < 1) {
			System.out.println("Size should be greater than zero. Try Again");
			size = takeIntegerInput();
		}
		array = new int[size];
		System.out.println("Enter the array elements. Only Integers are allowed.");
		// loop continue till all array elements are not entered by user
		for (int count = 0; count < size; count++) {
			array[count] = takeIntegerInput();
		}
		return array;
	}

	/**
	 * Main method to start the Application
	 * 
	 * @param args
	 * 		arguments passed at console
	 */
	public static void main(String[] args) {
		int choice;
		boolean flag = true;
		int[] array = takeIntegerArrayInput();
		System.out.println("Unsorted array is :");
		printArray(array);
		System.out.println("\n\n1) Comparison Sorting\n2) Linear Sorting");
		// loop continue till a valid choice is entered
		while (flag) {
			System.out.println("Enter your choice: ");
			choice = takeIntegerInput();
			// switch case is used to perform the operation according to the choice selected
			switch (choice) {
			/*
			 * case 1: perform comparisonSorting
			 * case 2: perform linearSorting
			 * default : display Invalid choice message.
			 */
			case 1:
				comparisonSorting(array);
				flag = false;
				break;

			case 2:
				linearSorting(array);
				flag = false;
				break;

			default:
				System.out.println("Invalid Choice. Try Again");
				break;
			}

		}
	}

	/**
	 * Method is used to perform the linear sorting on array 
	 */
	private static void linearSorting(int[] array) {
		/*
		 *  if input having more than 2 digit then perform radix sort on array
		 *  else perform counting sort on array
		 */
		if(SortingTechniques.findMaxInArray(array) / 100 >= 1) {
			array = SortingTechniques.radixSort(array, array.length);
			System.out.println("\nUsing Radix Sort");
		} else {
			array = SortingTechniques.countingSort(array, array.length, 0);
			System.out.println("\nUsing Counting Sort");
		}
		System.out.println("Sorted array is :");
		printArray(array);
	}
	
	/**
	 * Method is used to perform the comparison sorting on array 
	 */
	private static void comparisonSorting(int[] array) {
		/*
		 * if number of inputs is less than or equal to 10 then perform bubble sort on array
		 * else perform quick sort on array
		 */
		if(array.length <= 10) {
			array = SortingTechniques.bubbleSort(array);
			System.out.println("\nUsing Bubble Sort");
		} else {
			array = SortingTechniques.quickSort(array);
			System.out.println("\nUsing Quick Sort");
		}
		System.out.println("Sorted array is :");
		printArray(array);
	}
	/**
	 * Method is used to print the array to console
	 * @param array
	 */
	private static void printArray(int[] array) {
		// loop continue till end of array is reached
		for (int loop = 0; loop < array.length; loop++) {
			System.out.print(array[loop] + " ");
		}
	}
}