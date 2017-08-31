package com.metacube.ds8.sortingsystem.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.metacube.ds8.sortingsystem.implementation.SortingTechniques;

/**
 * This class is used to test the various sorting techniques
 * 
 * @author Prateek Jain
 *
 */
public class TestSortingSystem {
	SortingTechniques sortingTechniques;
	/**
	 * Method is used to setup the class object
	 */
	@Before
	public void setUp() {
		sortingTechniques = new SortingTechniques();
	}
	/**
	 * Test bubble sort when all values in array is positive
	 */
	@Test
	public void testBubbleSortWhenInputArrayIsPositive() {
		int[] actual = SortingTechniques.bubbleSort(new int[]{5,6,2,1,3,1});
		int[] expected = new int[]{1,1,2,3,5,6};
		assertArrayEquals(expected, actual);
	}
	/**
	 * Test bubble sort when all values in array is negative
	 */
	@Test
	public void testBubbleSortWhenInputArrayIsNegative() {
		int[] actual = SortingTechniques.bubbleSort(new int[]{-5,-6,-2,-1,0,-5});
		int[] expected = new int[]{-6,-5,-5,-2,-1,0};
		assertArrayEquals(expected, actual);
	}
	/**
	 * Test bubble sort when array is empty
	 */
	@Test
	public void testBubbleSortWhenInputArrayIsEmpty() {
		int[] actual = SortingTechniques.bubbleSort(new int[]{});
		int[] expected = new int[]{};
		assertArrayEquals(expected, actual);
	}
	/**
	 * Test bubble sort when array is null
	 */
	@Test(expected = NullPointerException.class)
	public void testBubbleSortWhenInputArrayIsNull() {
		int[] actual = SortingTechniques.bubbleSort(null);
		assertArrayEquals(null, actual);
	}

	/**
	 * Test Quick sort when all values in array is positive
	 */
	@Test
	public void testQuickSortWhenInputArrayIsPositive() {
		int[] actual = SortingTechniques.quickSort(new int[]{5,6,2,1,3,1});
		int[] expected = new int[]{1,1,2,3,5,6};
		assertArrayEquals(expected, actual);
	}
	/**
	 * Test Quick sort when all values in array is negative
	 */
	@Test
	public void testQuickSortWhenInputArrayIsNegative() {
		int[] actual = SortingTechniques.quickSort(new int[]{-5,-6,-2,-1,0,-5});
		int[] expected = new int[]{-6,-5,-5,-2,-1,0};
		assertArrayEquals(expected, actual);
	}
	/**
	 * Test Quick sort when array is empty
	 */
	@Test
	public void testQuickSortWhenInputArrayIsEmpty() {
		int[] actual = SortingTechniques.quickSort(new int[]{});
		int[] expected = new int[]{};
		assertArrayEquals(expected, actual);
	}
	/**
	 * Test Quick sort when array is null
	 */
	@Test(expected = NullPointerException.class)
	public void testQuickSortWhenInputArrayIsNull() {
		int[] actual = SortingTechniques.quickSort(null);
		assertArrayEquals(null, actual);
	}
	/**
	 * Test function is giving maximum element from array or not
	 */
	@Test
	public void testFindMaxInArray() {
		assertEquals(66, SortingTechniques.findMaxInArray(new int[]{2,4,0,-222,66,3}));
	}
	/**
	 * Test function is giving minimum element from array or not
	 */
	@Test
	public void testFindMinInArray() {
		assertEquals(-222, SortingTechniques.findMinInArray(new int[]{2,4,0,-222,66,3}));
	}
	/**
	 * Test Counting sort when array contains negative and positive values both
	 */
	@Test
	public void testCountingSort() {
		int[] actual = SortingTechniques.countingSort(new int[]{25,25,0,-22,-4,23,3,3,3}, 9, 0);
		assertArrayEquals(new int[]{-22,-4,0,3,3,3,23,25,25}, actual);
	}
	/**
	 * Test Radix Sort when array contains both positive and negative values both
	 */
	@Test
	public void testRadixSort() {
		int[] actual = SortingTechniques.countingSort(new int[]{225,225,10,-222,-4,223,31,31,223}, 9, 0);
		assertArrayEquals(new int[]{-222,-4,10,31,31,223,223,225,225}, actual);
	}
}
