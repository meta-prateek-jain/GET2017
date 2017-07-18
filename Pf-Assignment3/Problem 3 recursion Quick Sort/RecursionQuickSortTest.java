/**
 * This is a test class of RecursionQuickSort 
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class RecursionQuickSortTest {
	/**
	 * This test check that the array is sorted or not after function called 
	 */
	@Test
	public void shouldSortArray(){
		RecursionQuickSort recursionQuickSort = new RecursionQuickSort();
		int[] arrayToSort = new int[]{2,5,8,9,10, 77, 55, 11};
		int[] arrayExpected = new int[]{2,5,8,9,10,11,55,77};
		recursionQuickSort.quickSort(arrayToSort);
		assertArrayEquals(arrayExpected, arrayToSort);
	}
	/**
	 * This test check the function for null input
	 */
	@Test
	public void shouldReturnNull(){
		RecursionQuickSort recursionQuickSort = new RecursionQuickSort();
		int[] arrayToSort = new int[]{};
		int[] arrayExpected = new int[]{};
		recursionQuickSort.quickSort(arrayToSort);
		assertArrayEquals(arrayExpected,arrayToSort);
	}
}
