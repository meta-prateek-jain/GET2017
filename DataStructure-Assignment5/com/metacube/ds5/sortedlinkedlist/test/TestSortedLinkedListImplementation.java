package com.metacube.ds5.sortedlinkedlist.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.metacube.ds5.sortedlinkedlist.implementation.SortedLinkedListImplementation;

/**
 * Class is used to test the Sorted linked list functions
 * @author Prateek Jain
 *
 */
public class TestSortedLinkedListImplementation {

	SortedLinkedListImplementation sortedLinkedList;
	/**
	 * Method is used to set up the object of class
	 * @throws Exception
	 */
	@Before
	public void setUp() {
		sortedLinkedList = new SortedLinkedListImplementation();
	}

	/**
	 * Method is used to test the element adding in Sorted Linked List (positive Test case)
	 */
	@Test
	public void testSortedLinkedListForValidInput() {
		sortedLinkedList.add(25);
		String actual = sortedLinkedList.getAll();
		assertEquals("25 ", actual);
	}
	/**
	 * Method is used to test the element adding in Sorted Linked List (Negative Test case)
	 */
	@Test
	public void testListForInValidOutput() {
		sortedLinkedList.add(25);
		String actual = sortedLinkedList.getAll();
		assertNotEquals("23 ", actual);
	}

	/**
	 * Method is used to test the empty checking function
	 */
	@Test
	public void testListEmptyfunction() {
		assertEquals("It is Empty", sortedLinkedList.isEmpty().getString());
	}
}
