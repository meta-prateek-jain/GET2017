import static org.junit.Assert.*;
import org.junit.Test;

public class arraychecktest {
	/*
	 * case 1 
	 */
	@Test
	public void checkArray() {
		ArraySort sortArray = new ArraySort();
		int[] a= new int[]{1,2,4,5};
		int b;
		b= sortArray.arrayCheck(a);
		assertEquals("Ascending array",1,b);
		
	}
	/*
	 * case 2
	 */
	@Test
	public void checkArrays() {
		ArraySort sortArray = new ArraySort();
		int[] a1= new int[]{5,4,3,2};
		int b2;
		b2= sortArray.arrayCheck(a1);
		assertEquals("descending array",2,b2);
		
	}
	/*
	 * case3
	 */
	@Test
	public void checksArray() {
		ArraySort sortArray = new ArraySort();
		int[] a11= new int[]{1,3,5,4,5};
		int b12;
		b12 = sortArray.arrayCheck(a11);
		assertEquals("not sorted",0,b12);
		
	}
}
