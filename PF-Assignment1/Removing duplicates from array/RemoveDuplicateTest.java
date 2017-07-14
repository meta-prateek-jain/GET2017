import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class RemoveDuplicateTest {
	RemoveDuplicate rd = new RemoveDuplicate();
	@Test
	public void evaluatesArray() {										// Case 1 to test code
		int[] num ;
		int[] num1 = {2,5,4,6,3,8,9,0};
		int[] num2 = {2,5,4,6,3,8,5,9,3,3,6,3,9,0};
		num = rd.removeDuplicate(num2);
		assertArrayEquals("array are not same in case 1",num1, num);
	}

	@Test
	public void evaluatesArrays() {										// Case 2 to test code
		int[] n ;
		int[] n1 = {2};
		int[] n2 = {2,2,2,2,2,2,2};
		n = rd.removeDuplicate(n2);
		assertArrayEquals("array are not same in case 2", n1, n);
	}

	@Test
	public void evaluateArrays() {										// Case 3 to test code
		int[] n11 ;
		int[] n12 = {2,3,4,5,6,7,8,9};
		int[] n13 = {2,3,4,5,6,7,8,9};
		n11 = rd.removeDuplicate(n13);
		assertArrayEquals("array are not same in case 3", n12, n11);
	}

	@Test
	public void evaluatArrays() {										// Case 4 to test code
		int[] n21 ;
		int[] n22 = {2,3,4,5,-1,6,7};
		int[] n23 = {2,3,4,5,-1,6,7,-1};
		n21 = rd.removeDuplicate(n23);
		assertArrayEquals("array are not same in case 4", n22, n21);
	}

}
