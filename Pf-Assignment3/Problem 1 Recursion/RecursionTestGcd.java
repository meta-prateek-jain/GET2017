

/**
 * This is a test class 
 */
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RecursionTestGcd {
	/**
	 * This parameters values is used to initialize the variables 
	 */
	 @Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {     
	                 { 2, 1, 1 }, { 12, 18, 6 }, { 100, 3, 1 }});
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
	    public RecursionTestGcd(int input1, int input2, int expected) {
	        pInput1= input1;
	        pInput2= input2;
	        pExpected= expected;
	    }
	    /**
	     * This test case checks the gcd function for each values of pInput1 and pInput2  
	     */
	@Test
	public void checkGcd(){
		Recursion recursionObject = new Recursion();
		assertEquals("GCD is not correct", pExpected, recursionObject.gcd(pInput1, pInput2));
	}
}
