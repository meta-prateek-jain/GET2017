import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class BinaryToOctalTest {
	 BinaryToOctal b = new BinaryToOctal();
	 @Before
	  public void checkBinary() {							// checking for array
		 assertFalse("Not a binary", b.checkBinary(011));
	 }
	 
	 @Test
	  public void evaluatesConversion() {
		 	int num = b.convertBinaryToOctal(1101);			// Case 1 to test codes	
		 	assertEquals("wrong answer at case 1", 15, num);
	 }
	 
	 @Test
	  public void evaluateConversion() {
		 	int num1 = b.convertBinaryToOctal(110101);		// Case 2 to test codes
		 	assertEquals("wrong answer at case 2", 55, num1);
	 }
	 @Test
	  public void evaluatConversion() {
		 	int num2 = b.convertBinaryToOctal(11);			// Case 3 to test codes
		 	assertEquals("wrong answer at case 3", 3, num2);
	 }
	 
}
