import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JoinSortedArrayTest {
	@Test
	public void checkArray() {
		JoinSortedArray finalArray = new JoinSortedArray();
		int[] array = new int[8];
		int[] array1 = new int[]{1,2,3,4,6,7,8,9};
		int[] arr = new int[]{1, 2, 3, 6, 8};
		int[] arr1 = new int[]{4,7,9};
		array = finalArray.join(arr, 5, arr1, 3, array);
		assertArrayEquals(array1, array);
	}
	
	@Test
	public void checkArray1() {
		JoinSortedArray ffinalArray = new JoinSortedArray();
		int[] array = new int[5];
		int[] array1 = new int[]{2,4,6,8,9};
		int[] arr = new int[]{2,6,9};
		int[] arr1 = new int[]{4,8};
		array = ffinalArray.join(arr, 3, arr1, 2, array);
		assertArrayEquals(array1, array);
	}
	
	@Before
	public void checkArray2(){
		JoinSortedArray array1 = new JoinSortedArray();
		int[] a1 = new int[]{4,7,9};
		int[] a2 = new int[]{1, 2, 3};
		assertFalse("Arrays are not sorted", array1.isSorted(a1));
		assertFalse("Arrays are not sorted", array1.isSorted(a2));
	}
}
