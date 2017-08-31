package com.metacube.ds8.sortingsystem.implementation;

/**
 * This class is contains all the required techniques of both sorting systems
 * 
 * @author Prateek Jain
 *
 */
public class SortingTechniques {
	/**
	 * Method is used to perform the bubble sort on array
	 * 
	 * @param array
	 * 		array to sort
	 * @return
	 * 		sorted array
	 */
	public static int[] bubbleSort(int[] array) {
		// loop continue till array is sorted
		 for(int loop = 0; loop < array.length - 1; loop++) {
			 // loop continue till largest element is placed in its right position
			 for(int count = 0; count < array.length - loop -1; count++) {
				 // if element at index equal to count is greater than its preceding element than swap them
				 if(array[count] > array[count + 1]) {
					 swapElements(array, count, count+1);
				 }
			 }
		 }
		return array;
	}
	/**
	 * Method is used to swap the elements
	 * 
	 * @param array
	 * 		array in which swapping to be done
	 * @param index1
	 * 		the index at which element is to replaced by element at index 2
	 * @param index2
	 * 		the index at which element is to replaced by element at index 1
	 */
	private static void swapElements(int[] array, int index1, int index2) {
		int temporaryElement = array[index1];
		array[index1] = array[index2];
		array[index2] = temporaryElement;
	}

	/**
	 * Method is used to perform the quick sort on array
	 * 
	 * @param array
	 * 		array to sort
	 * @return
	 * 		sorted array
	 */
	public static int[] quickSort(int[] array) {
		quickSortImplement(array, 0, array.length - 1);
		return array;
	}

	/**
	 * Method is used to find the maximum element in array
	 * 
	 * @param array
	 * 		array in which search is done
	 * @return
	 * 		maximum element present in array
	 */
	public static int findMaxInArray(int[] array) {
		int maxElement = array[0];
		// loop continue maximum element in array is found
		for(int loop = 1; loop < array.length; loop++) {
			// if element at index equal to loop is greater than maximum element than set maximum element to this element
			if(maxElement < array[loop]) {
				maxElement = array[loop];
			}
		}
		return maxElement;
	}
	/**
	 * Method is used to find the minimum element in array
	 * 
	 * @param array
	 * 		array in which search is done
	 * @return
	 * 		minimum element present in array
	 */
	public static int findMinInArray(int[] array) {
		int minElement = array[0];
		// loop continue minimum element in array is found
		for(int loop = 1; loop < array.length; loop++) {
			// if element at index equal to loop is less than minimum element than set minElement to this element
			if(minElement > array[loop]) {
				minElement = array[loop];
			}
		}
		return minElement;
	}

	/**
	 * Method is used to get the element depending on exponent value
	 * @param element
	 * 		original element
	 * @param exponent
	 * 		which decide which place value of element to send
	 * @return
	 * 		element or place value of element
	 */
	private static int getElement(int element, int exponent) {
		element = Math.abs(element);
		// if exponent is not zero then return the particular place value of that element 
		if(exponent != 0) {
			element = (element / exponent) % 10;
		}
		return element;
	}
	/**
	 * Method is used to perform the counting sort on array
	 * 
	 * @param array
	 * 		array to sort		
	 * @param length
	 * 		length of the array
	 * @param exponent
	 * 		exponent used to get the place value of particular number
	 * @return
	 * 		sorted array
	 */
	public static int[] countingSort(int[] array, int length, int exponent) {
		int[] positiveCountArray = new int[findMaxInArray(array) + 1];
		int[] negativeCountArray = null;
		int[] sortedArray;
		// if minimum element in array is less than zero then initialize the negative count array
		if(findMinInArray(array) < 0) {
			negativeCountArray = new int[Math.abs(findMinInArray(array)) + 1];
		}
		// loop continue till end of array reached
		for(int loop = 0; loop < length; loop++) {
			/*
			 * if element in array is greater than zero than add it countArray
			 * else add it to negativeCountArray
			 */
			if(array[loop] > 0) {
				positiveCountArray[getElement(array[loop], exponent)]++;
			} else {
				negativeCountArray[getElement(array[loop], exponent)]++;
			}
		}
		if(negativeCountArray != null) {
			// loop continue till negativeCountArray contains actual position of elements in output array
			for(int loop = negativeCountArray.length - 1; loop > 0; loop--) {
				negativeCountArray[loop-1] += negativeCountArray[loop];
			}
			positiveCountArray[0] += negativeCountArray[0];
		}
		// loop continue till countArray contains actual position of elements in output array
		for(int loop = 1; loop < positiveCountArray.length; loop++) {
			positiveCountArray[loop] += positiveCountArray[loop-1];
		}
		sortedArray = new int[length];
		// loop continue till all elements are stored in sorted array
		for(int loop = length-1; loop >= 0; loop--) {
			/*
			 * if element in array is greater than zero then add it to sortedArray at position get by countArray
			 * else add it to sortedArray at position get by negativeCountArray
			 */
			if(array[loop] > 0) {
				sortedArray[--positiveCountArray[getElement(array[loop], exponent)]] = array[loop];
			} else {
				sortedArray[--negativeCountArray[getElement(array[loop], exponent)]] = array[loop];
			}
		}
		return sortedArray;
	}

	/**
	 * Method is used to sort the array using radixSort
	 * 
	 * @param array
	 * 		array to sort
	 * @param length
	 * 		length of array
	 * @return
	 * 		sorted array
	 */
	public static int[] radixSort(int[] array, int length) {
		int maximumNumber = findMaxInArray(array);
		// loop continue till array is sorted completely
		for(int loop = 1; maximumNumber / loop > 0; loop *= 10) {
			array = countingSort(array, length, loop); 
		}
		return array;
	}

	/**
	 * This function recursively quick sort the array using pivot element
	 * 
	 * @param start
	 * 		starting index
	 * @param last
	 * 		last index
	 */
	private static void quickSortImplement(int[] array, int start, int last){
		// if array is not empty then continue
		if(array.length > 0) {
			int startIndex = start;
			int lastIndex = last;
			int middleIndex = (startIndex + lastIndex)/2;
			int pivot = array[middleIndex];
			// This loop divides array into two arrays
			while(startIndex <= lastIndex){
				// Increase the startIndex till array values is smaller than pivot element 
				while(pivot > array[startIndex]){
					startIndex++;
				}
				// Decrease the lastIndex till array values is greater than pivot  element
				while(pivot < array[lastIndex]){
					lastIndex--;
				}
				//if startIndex is less than or equal to lastIndex then Swap the values
				if(startIndex <= lastIndex){
					swapElements(array, startIndex, lastIndex);
					startIndex++;
					lastIndex--;
				}
			}
			// Recursively calls the quickSort for left partitioned array
			if(start < lastIndex){
				quickSortImplement(array, start, lastIndex);
			}
			// Recursively calls the quickSort for right partitioned array
			if(last > startIndex){
				quickSortImplement(array, startIndex, last);
			}
		}
	}
}
