/**
 * Test class for pyramid pattern
 * 
 * @author Prateek Jain
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class Pattern2Test {
	Pattern2 patternobj = new Pattern2();				//pattern class object
	/*
	 * first test method to check spaces in a row
	 */
	@Test
	public void checkSpaces() {
		int spaceExpect = 3;
		int spaceReturnlength;
		String spaceReturn;
		spaceReturn = patternobj.space(4);
		spaceReturnlength = (spaceReturn.length() / 2);
		assertEquals(spaceExpect, spaceReturnlength);
	}
	/*
	 * Test method to check numbers in a row
	 */
	@Test
	public void checkNumbers() {
		String numberExpect = "1 2 ";
		String numberReturn;
		numberReturn = patternobj.numbers(4, 5);
		assertEquals(numberExpect, numberReturn);
	}
	/*
	 * Test method to check whole pyramid
	 */
	@Test
	public void checkPyramid() {
		String[] pyramidExpect = { "1 2 3 4 5 ", "  1 2 3 4 ", "    1 2 3 ", "      1 2 ", "        1 " };
		String[] pyramidReturn;
		pyramidReturn = patternobj.wholePyramid(5);
		/*
		 * Printing the pattern
		 */
		if (pyramidReturn != null) {
			System.out.println("The Pyramid is :");
			for (String string : pyramidReturn) {
				System.out.println(string);
			}
		}
		assertEquals(pyramidExpect, pyramidReturn);
		
	}
	/*
	 * Test method to check wrong expected output
	 */
	@Test
	public void checkPyramidWrongOutput() {
		String[] pyramidExpect = { "1 2 3 4 5 6 ", "  1 2 3 4 ", "    1 2 3 ", "      1 2 ", "        1 " };
		String[] pyramidReturn;
		pyramidReturn = patternobj.wholePyramid(5);
		assertNotEquals(pyramidExpect, pyramidReturn);
	}
}
