import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * This is test class for GeneratePermutations
 * 
 * @author Prateek Jain 
 * Dated 18/07/2017
 */
public class GeneratePermutationsTest {
	GeneratePermutations permutations = new GeneratePermutations();
	/*
	 * This test case tests for String ABC
	 */
	@Test
	public void listOfStringTestForThree() {
		List<String> letterCombination = permutations.generatePermutations("ABC");
		List<String> listOfString = new ArrayList<>(Arrays.asList("CBA","BCA","BAC","CAB","ACB","ABC"));
		// Displaying the listOfString steps
		System.out.println("\nList of string");
		for (String string : letterCombination) {
			System.out.println(string);
		}
		assertEquals(listOfString, letterCombination);
	}

	/*
	 * This test case tests for String ABC
	 */
	@Test
	public void listOfStringTestForFour() {
		List<String> letterCombination = permutations.generatePermutations("ABCD");
		List<String> listOfString = new ArrayList<>(Arrays.asList("DCBA",
				"CDBA", "CBDA", "CBAD", "DBCA", "BDCA", "BCDA", "BCAD", "DBAC",
				"BDAC", "BADC", "BACD", "DCAB", "CDAB", "CADB", "CABD", "DACB",
				"ADCB", "ACDB", "ACBD", "DABC", "ADBC", "ABDC", "ABCD"));

		// Displaying the listOfString steps
		System.out.println("\nList of string");
		for (String string : letterCombination) {
			System.out.println(string);
		}
		assertEquals(listOfString, letterCombination);
	}
}
