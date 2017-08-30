package com.metacube.ds7.binarysearch;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.metacube.ds7.binarysearch.implementation.BinarySearch;

/**
 * Write a program the binary search function and its loop invariants in a way
 * so that it will always find the leftmost occurrence of x in the array in case
 * the occurrences are not unique
 * 
 * @author Prateek Jain
 * Dated :- 29/08/2017
 *
 */
public class BinarySearchInArray {
	private static Scanner scan = new Scanner(System.in);
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
	 * Main method to run the Application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array;
		int sizeOfArray;
		int elementToFound;
		int index;
		BinarySearch binarySearch = new BinarySearch();
		System.out.println("Enter the size of array");
		sizeOfArray = takeIntegerInput();
		// loop continue till valid size is entered
		while (sizeOfArray <= 0) {
			System.out.println("Size should be greater than zero. Try Again");
			sizeOfArray = takeIntegerInput();
		}
		array = new int[sizeOfArray];
		System.out.println("Enter the elements to add in array. Only integers");
		// loop continue till all elements are added to array
		for (int count = 0; count < sizeOfArray; count++) {
			array[count] = takeIntegerInput();
		}
		Arrays.sort(array);
		System.out.print("Sorted Array is :- ");
		// loop continue till all elements are displayed on console
		for (int element : array) {
			System.out.print(element + " ");
		}
		System.out.println("\nEnter the element to search");
		elementToFound = takeIntegerInput();
		index = binarySearch.findLeftMostOccurrenceOfElementInArray(array, 0, sizeOfArray - 1,elementToFound);
		/*'
		 * if index is -1 then display Element not found
		 * else display the leftmost location of element
		 */
		if (index == -1) {
			System.out.println("Element not found");
		} else {
			System.out.print("Leftmost Occurrence of " + elementToFound+ " in array is at : " + (index + 1));
		}
	}
}
