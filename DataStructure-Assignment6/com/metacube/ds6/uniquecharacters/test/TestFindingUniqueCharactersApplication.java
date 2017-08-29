package com.metacube.ds6.uniquecharacters.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.metacube.ds6.employee.util.EmployeeCollection;
import com.metacube.ds6.uniquecharacters.implementation.UniqueCharactersInString;

/**
 * Test class is used to check find unique characters application
 * @author Prateek Jain
 *
 */
public class TestFindingUniqueCharactersApplication {

	UniqueCharactersInString uniqueCharacters;
	EmployeeCollection  collections;
	/**
	 * Method is used to set up the objects of class before start testing
	 */
	@Before
	public void setUp() {
		collections = new EmployeeCollection();
		uniqueCharacters = new UniqueCharactersInString();
	}

	/**
	 * Method is used to test when input contains only integers
	 */
	@Test
	public void testUniqueCharactersApplicationWhenInputContainsIntegers() {
		assertEquals(5, uniqueCharacters.find("1555200011333"));
	}
	/**
	 * Method is used to test when input contains only characters
	 */
	@Test
	public void testUniqueCharactersApplicationWhenInputContainsCharacters() {
		assertEquals(6, uniqueCharacters.find("abbbacdbbbecssd"));
	}
	/**
	 * Method is used to test when input contains characters and integers both
	 */
	@Test
	public void testUniqueCharactersApplicationWhenInputContainsCharactersAndIntegersBoth() {
		assertEquals(9, uniqueCharacters.find("abbbacdbbbec2223055"));
	}
}
