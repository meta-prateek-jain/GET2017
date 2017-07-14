import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class LongestSequenceTest {
	
	
	@Test
	public void testCase(){
		LongestSequence obj=new LongestSequence();
		
		int[] input={1,2,3,2,3,4,5,3,4,2,2,3,4,5,6,7,8,1,2,4,5,6,7,8,9};
		int[] ans={1,2,4,5,6,7,8,9};
		
		assertArrayEquals(ans,obj.getLS(input));
	
		}

	
}
