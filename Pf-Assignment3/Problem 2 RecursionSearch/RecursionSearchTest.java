/**
 * This is a test class of binary search and linear search
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class RecursionSearchTest {
	private int[] pInput;			
	private int pInput2;
	private int pReturn;
	RecursionSearch recursionSearchObject = new RecursionSearch();
	/*
	 * This function tests function when number not present in array
	 */
	@Test
	public void shouldNotFoundInLinearSearch(){
		pInput = new int[]{2,5,8,9,10, 77, 55};
		pInput2 = 88;
		pReturn = recursionSearchObject.linearSearch(pInput, 0, pInput2);
		assertNotEquals(0, pReturn);
	}
	/*
	 * This Function Tests function when number is present in array 
	 */
	@Test
	public void shouldFoundInLinearSearch(){
		pInput = new int[]{2,5,8,9,10, 77, 55, 11};
		pInput2 = 77;
		pReturn = recursionSearchObject.linearSearch(pInput, 0, pInput2);
		assertEquals(6, pReturn);
	}
	/*
	 * This function tests function when number not present in array
	 */
	@Test
	public void shouldNotFoundInBinarySearch(){
		pInput = new int[]{2,5,8,9,10, 55, 77};
		pInput2 = 88;
		pReturn = recursionSearchObject.binarySearch(pInput, 0, 6, pInput2);
		assertNotEquals(0, pReturn);
	}
	/*
	 * This Function Tests function when number is present in array 
	 */
	@Test
	public void shouldFoundInBinarySearch(){
		pInput = new int[]{2,5,8,9,10, 55, 77};
		pInput2 = 77;
		pReturn = recursionSearchObject.binarySearch(pInput, 0, 6, pInput2);
		assertEquals(7, pReturn);
	}
}
