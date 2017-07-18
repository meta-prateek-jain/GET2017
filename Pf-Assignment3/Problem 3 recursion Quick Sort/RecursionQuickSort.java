import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Programming Fundamental assignment 3
 * 
 * This class is using recursive function to  sort the given array in ascending order using quicksort 
 * 
 * @author Prateek Jain Dated 17/07/2017
 *
 */
public class RecursionQuickSort {
	/*
	 * Instance variables
	 */
	private int[] arrayToSort;
	private int arrayLength;
	public void quickSort(int[] array){
		/*
		 * return from function for null array
		 */
		if(array.length == 0){
			return;
		}
		/*
		 * initializing instance variables
		 */
		this.arrayToSort = array;
		this.arrayLength = array.length;
		recursiveQuickSort( 0, arrayLength-1);
		
	}
	/**
	 * This function recursively quick sort the array using pivot element
	 * @param start	starting index
	 * @param last	last index
	 */
	public void recursiveQuickSort(int start, int last){
		int temp;								//temporary variable for swapping
		int startIndex = start;
		int lastIndex = last;
		int pivot = arrayToSort[start];
		/*
		 * This loop divides array into two arrays
		 */
		while(startIndex <= lastIndex){
			/*
			 * Increase the startIndex till array values is smaller than pivot element 
			 */
			while(pivot > arrayToSort[startIndex]){
				startIndex++;
			}

			/*
			 * Decrease the lastIndex till array values is greater than pivot  element
			 */
			while(pivot < arrayToSort[lastIndex]){
				lastIndex--;
			}
			/*
			 * Swapping the values
			 */
			if(startIndex <= lastIndex){
				temp = arrayToSort[lastIndex];
				arrayToSort[lastIndex] = arrayToSort[startIndex];
				arrayToSort[startIndex] = temp;
				startIndex++;
				lastIndex--;
			}
		}
		/*
		 * Recursively calls the recursiveQuickSort
		 */
		if(start < lastIndex){
			recursiveQuickSort(start, lastIndex);
		}
		if(last > startIndex){
			recursiveQuickSort(startIndex, last);
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		RecursionQuickSort recursionQuickSort = new RecursionQuickSort();
		int arraySize;
		int[] array;
		/*
		 * Enter the size of array
		 */
		System.out.println("Enter the size of array");
		arraySize=scan.nextInt();
		array = new int[arraySize];
		/*
		*Enter the array to sort using Quick Sort
		*/
		System.out.println("Enter the array to sort using Quick Sort ");
		try{
			for(int loop = 0; loop<arraySize;loop++){
				array[loop] = scan.nextInt();
		}
		}catch(InputMismatchException error){
			System.out.println("Enter correct input");
		}
		recursionQuickSort.quickSort(array);
		System.out.println("Array after sorting");
		/*
		 * Displaying array after sorting through quick sort
		 */
		for (int sortedArray : array) {
			System.out.print(sortedArray+" ");
		}
	}
}
