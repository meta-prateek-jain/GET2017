/**
 * Test class for pyramid pattern
 * 
 * @author Prateek Jain
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class pattern2Test {
	pattern2 patternobj = new pattern2();				//pattern class object
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
		assertEquals("Spaces are not Correct", spaceExpect, spaceReturnlength);
	}
	/*
	 * Test method to check numbers in a row
	 */
	@Test
	public void checkNumbers() {
		String numberExpect = "1 2 ";
		String numberReturn;
		numberReturn = patternobj.numbers(4, 5);
		assertEquals("Numbers are not Correct", numberExpect, numberReturn);
	}
	/*
	 * Test method to check whole pyramid
	 */
	@Test
	public void checkPyramid() {
		String[] pyramidExpect = { "1 2 3 4 5 ", "  1 2 3 4 ", "    1 2 3 ", "      1 2 ", "        1 " };
		String[] pyramidReturn;
		pyramidReturn = patternobj.wholePyramid(5);
		assertEquals("Pyramid is not Correct", pyramidExpect, pyramidReturn);
	}
	/*
	 * Test method to check wrong expected output
	 */
	@Test
	public void checkPyramidWrongOutput() {
		String[] pyramidExpect = { "1 2 3 4 5 6 ", "  1 2 3 4 ", "    1 2 3 ", "      1 2 ", "        1 " };
		String[] pyramidReturn;
		pyramidReturn = patternobj.wholePyramid(5);
		assertEquals("Expected Output is not Correct", pyramidExpect, pyramidReturn);
	}
}
