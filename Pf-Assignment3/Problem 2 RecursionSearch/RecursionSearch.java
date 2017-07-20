import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Programming Fundamental assignment 3
 * 
 * Write recursive functions for the following:
 *	
 *	a) to search for a given value x in an array using linear search strategy.
 *	Write JUnit Tests:
 *	take an array having {2,5,8,9,10, 77, 55}, and search 88
 *	take an array having {2,5,8,9,10, 77, 55, 11}, and search 77
 *	
 *	b) to search for a given value x in an array using binary search strategy.
 *	Write JUnit Tests for each function:
 *	take an array having {2,5,8,9,10, 55, 77}, and search 88
 *	take an array having {2,5,8,9,10, 55, 77}, and search 77
 * 
 * @author Prateek Jain 
 * Dated 17/07/2017
 *
 */
public class RecursionSearch {
	/**
	 * This recursive function Finds number in an array using linear search
	 * strategy and return -1 if number not found
	 * 
	 * @param array			
	 * @param numberToFind
	 * @return	location of number in array
	 */
	public int linearSearch(int[] array, int start_index, int numberToFind) {
		int position = -1;
		if (start_index < array.length) {
			/*
			 * This block checks the number is present at that position of array
			 * or not
			 */
			if (array[start_index] == numberToFind) {
				position = start_index + 1;
			}

			/*
			 * This is a recursive block which increment the array start_index to search that number on that location 
			 */
			else {
				position = linearSearch(array, ++start_index, numberToFind);
			}
		}
		
		return position;
	}

	/**
	 * This recursive function Finds number in an array using binary search
	 * strategy and return -1 if number not found
	 * 
	 * @param array
	 * @param start_index
	 * @param last_index
	 * @param numberToFind
	 * @return location of number in array
	 * 
	 * Assumptions passed array is sorted in ascending order
	 */
	public int binarySearch(int[] array, int start_index, int last_index, int numberToFind) {
		int middle = (start_index + last_index) / 2;		 
		int position = -1;
		int loop;
		
		/*
		 * This block runs only when starting index of array is greater than last index
		 */
		if (start_index <= last_index) {
			/*
			 * This block checks whether number is present at that location. 
			 * If yes then store the location into position variable 
			 */
			if (array[middle] == numberToFind) {
				position = middle + 1;
			}
			/*
			 * If number to find is less than array[middle] then search number in left side of it
			 */
			else if (array[middle] > numberToFind) {
				position = binarySearch(array, start_index, middle - 1,numberToFind);
			} 
			/*
			 * If number to find is greater than array[middle] then search in right side right side of it
			 */
			else {
				position = binarySearch(array, middle + 1, last_index,numberToFind);
			}
		}
		
		
		return position;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		RecursionSearch recursionSearch = new RecursionSearch();
		int arraySize;
		int[] array;
		int numberToFind;
		int foundAt;
		int choice;
		/*
		 * Enter the size of array
		 */
		System.out.println("Enter the size of array");
		arraySize=scan.nextInt();
		array = new int[arraySize];
		/*
		 * Enter 1 to search with binaray search 
		 * Enter 2 to search with linear search
		 */
		System.out.println("Enter 1 for binary search \n enter 2 for linear search");
		choice = scan.nextInt();
		switch(choice){
		case 1:/*
				*Enter the sorted array to search for the number
				*/
				System.out.println("Enter the array sorted in ascending order to search a number using binary search ");
				try{
					for(int loop = 0; loop<arraySize;loop++){
						array[loop] = scan.nextInt();
					}
				}catch(InputMismatchException error){
					System.out.println("Enter correct input");
				}
				/*
				 * Enter the number to search
				 */
				System.out.println("Enter the number to Search");
				numberToFind=scan.nextInt();
				foundAt = recursionSearch.binarySearch(array, 0,array.length-1, numberToFind);
				if (foundAt == -1) {
					System.out.println("Number is not found ");
				} else {
					System.out.println("The number is at "+ foundAt);
				}
				break;
		case 2:	/*
				*Enter the array to search for the number
				*/
				System.out.println("Enter the array to search a number using linear search ");
				try{
					for(int loop = 0; loop<arraySize;loop++){
						array[loop] = scan.nextInt();
					}
				}catch(InputMismatchException error){
					System.out.println("Enter correct input");
				}
				/*
				 * Enter the number to search
				 */
				System.out.println("Enter the number to Search");
				numberToFind=scan.nextInt();
				foundAt = recursionSearch.linearSearch(array, 0, numberToFind);
				if (foundAt == -1) {
					System.out.println("Number is not found ");
				} else {
					System.out.println("The number is at "+ foundAt);
				}
				break;
			default: System.out.println("Enter the correct choice");
		}
	}
}