

/**
 * This is a test class 
 */
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RecursionTestRemainder {
	/**
	 * This parameters values is used to initialize the local variables 
	 */
	 @Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {     
	                 { 2, 1, 0 }, { 2, 0, -1 }, { 100, 3, 1 }});
	    }

	    private int pInput1;
	    
	    private int pInput2;

	    private int pExpected;
	    /**
	     * This is a constructor which initialize the variables
	     * @param input1
	     * @param input2
	     * @param expected
	     */
	    public RecursionTestRemainder(int input1, int input2, int expected) {
	        pInput1= input1;
	        pInput2= input2;
	        pExpected= expected;
	    }
	    /**
	     * This test case checks the function for each values of pInput1 and pInput2
	     */
	@Test
	public void checkRemainder(){
		Recursion recursionObject = new Recursion();
		assertEquals("Remainder is not correct", pExpected, recursionObject.rem(pInput1, pInput2));
	}
}
