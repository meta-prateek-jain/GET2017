

/**
 *  This is a test class 
 */
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RecursionTestLargestNumber {
	/**
	 * This parameters values is used to initialize the local variables 
	 */
	 @Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {     
	                 { 2, 2 }, { 1257369, 9 }, { 444, 4 }});
	    }

	    private int pInput;
	    
	    private int pExpected;
	    /**
	     * This is a constructor which initialize the variables
	     * @param input
	     * @param expected
	     */
	    public RecursionTestLargestNumber(int input, int expected) {
	        pInput= input;
	        pExpected= expected;
	    }
	    /**
	     * This test case checks the function for each values of pInput
	     */
	@Test
	public void checkLargestNumber(){
		Recursion recusionObject = new Recursion();
		assertEquals("Result is not correct", pExpected, recusionObject.largestdigit(pInput));
	}
}
