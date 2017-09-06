package com.metacube.ds7.binarysearch.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.metacube.ds7.binarysearch.implementation.BinarySearch;

/**
 * Test class to test the BinarySearch application
 * 
 * @author Prateek Jain
 *
 */
public class TestBinarySearchApplication {
	BinarySearch  binarySearch ;
	/**
	 * Method is used to setup the object of class
	 */
	@Before
	public void setUp() {
		binarySearch = new BinarySearch();
	}

	/**
	 * Method is used to test the application when Sorted array is inserted 
	 */
	@Test
	public void testApplicationWhenSortedArrayIsInserted() {
		int[] array = {2,5,5,7,8,8,8,8,9};
		int actualIndex = binarySearch.findLeftMostOccurrenceOfElementInArray(array, 0, array.length - 1, 8) + 1;
		assertEquals(5, actualIndex);
	}
	/**
	 * Method is used to test the application when Sorted array is inserted 
	 */
	@Test
	public void testApplicationWhenInsertedArrayIsNotSorted() {
		int[] array = {2,7,8,8,8,5,5,1,9};
		int actualIndex = binarySearch.findLeftMostOccurrenceOfElementInArray(array, 0, array.length - 1, 8) + 1;
		assertNotEquals(5, actualIndex);
	}
	/**
	 * Method is used to test the application when Element is not present in array
	 */
	@Test
	public void testApplicationWhenElementNotPresentInArray() {
		int[] array = {2,7,8,8,8,5,5,1,9};
		int actualIndex = binarySearch.findLeftMostOccurrenceOfElementInArray(array, 0, array.length - 1, 12) + 1;
		assertEquals(0, actualIndex);
	}
	/**
	 * Method is used to test the application when array having same values
	 */
	@Test
	public void testApplicationWhenArrayHavingSameValues() {
		int[] array = {4,4,4,4};
		int actualIndex = binarySearch.findLeftMostOccurrenceOfElementInArray(array, 0, array.length - 1, 4) + 1 ;
		assertEquals(1, actualIndex);
	}
	/**
	 * Method is used to test the application when Empty array is inserted
	 */
	@Test
	public void testApplicationWhenEmptyArrayIsInserted() {
		int[] array = {};
		int actualIndex = binarySearch.findLeftMostOccurrenceOfElementInArray(array, 0, array.length - 1, 8) + 1;
		assertEquals(0, actualIndex);
	}
	/**
	 * Method is used to test the application when Inserted Array is null
	 */
	@SuppressWarnings("null")
	@Test(expected = NullPointerException.class)
	public void testApplicationWhenInsertedArrayIsNull() {
		int[] array = null;
		int actualIndex = binarySearch.findLeftMostOccurrenceOfElementInArray(array, 0, array.length - 1, 8) + 1;
		assertEquals(0, actualIndex);
	}
}
