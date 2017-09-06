package com.metacube.ds7.binarysearch.implementation;

/**
 * This class is used to perform the binary search operation on a sorted array
 * and find the leftmost occurrence of that element in the sorted array
 * 
 * @author Prateek Jain
 *
 */
public class BinarySearch {
	/**
	 * Method is used to find the LeftMost occurrence of that element in the array 
	 * 
	 * @param array 
	 * 		the array in which searching is done
	 * @param startIndex
	 * 		Starting index 
	 * @param endIndex
	 * 		Ending index
	 * @param numberToFind
	 * 		number to find 
	 * @return
	 * 		the location index
	 */
	public int findLeftMostOccurrenceOfElementInArray(int[] array, int startIndex, int endIndex, int numberToFind) {
		int middleIndex = (startIndex + endIndex) / 2;
		int index = -1;
		// if startIndex is not greater than end index then continue searching
		if (startIndex <= endIndex) {
			/*
			 * if number is at middle index of array then search in its left side again that number to get the leftmost index
			 * else if number is less then element present at middle index in array then continue searching on left side
			 * else search in right side of that element
			 */
			if (array[middleIndex] == numberToFind) {
				index = middleIndex;
				/* if middle index is greater than zero and the left element of array[middleIndex] 
				 * is same as element to find then again search for that number in this left side*/
				if (middleIndex > 0 && array[middleIndex - 1] == numberToFind) {
					int temporary = findLeftMostOccurrenceOfElementInArray(array, startIndex, middleIndex - 1, numberToFind);
					// if temporary variable is not equal to -1 then set index with this value  
					if (temporary != -1) {
						index = temporary;
					}
				}
			} else if (array[middleIndex] > numberToFind) {
				index = findLeftMostOccurrenceOfElementInArray(array, startIndex, middleIndex - 1, numberToFind);
			} else {
				index = findLeftMostOccurrenceOfElementInArray(array, middleIndex + 1, endIndex, numberToFind);
			}
		}
		return index;
	}
}
