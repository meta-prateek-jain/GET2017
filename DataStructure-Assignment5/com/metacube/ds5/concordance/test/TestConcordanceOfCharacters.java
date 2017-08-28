package com.metacube.ds5.concordance.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.metacube.ds5.concordance.implementation.ConcordanceOfCharacters;

/**
 * Test class to test the application of findind indices of characters in string
 * 
 * @author Prateek Jain
 *
 */
public class TestConcordanceOfCharacters {

	ConcordanceOfCharacters concordanceOfCharacters;

	/**
	 * Method is used to setup the class object
	 */
	@Before
	public void setUp() {
		concordanceOfCharacters = new ConcordanceOfCharacters();
	}

	/**
	 * Method is used to test the application (Positive Test case)
	 */
	@Test
	public void testFindingConcordanceApplicationWhenValidOutput() {
		String actual = concordanceOfCharacters.find("hello");
		String expected = "e = [1]h = [0]l = [2, 3]o = [4]";
		assertEquals(expected, actual);
	}

	/**
	 * Method is used to test the application (Negative Test case)
	 */
	@Test
	public void testFindingConcordanceApplicationWhenInValidOutput() {
		String actual = concordanceOfCharacters.find("JaipurIsMyCity");
		String expected = "C = [10]J = [0]M = [8]a = [1]i = [2, 11]p = [3]r = [5]s = [7]t = [12]u = [4]y = [9, 13]";
		assertNotEquals(expected, actual);
	}
}

