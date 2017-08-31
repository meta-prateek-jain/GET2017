package com.metacube.arrayList.testCase;

import static org.junit.Assert.*;

import org.junit.Test;

import com.metacube.arrayList.ArrayListImplementation;

public class TestArrayListImplemenetation {
	ArrayListImplementation<String> arrayList;
	/**
	 * Test case to check item is added to list or not
	 */
	@Test
	public void testAddItem() {
		arrayList = new ArrayListImplementation<String>();
		arrayList.addItem("1");
		arrayList.addItem("2");
		arrayList.addItem("3");
		int check = arrayList.getFirstOccurrence("3");
		assertEquals(3, check);
	}

	/**
	 * Test case to check item is added at particular location or not
	 */
	@Test
	public void testAddingItemAtParticularLocation() {
		arrayList = new ArrayListImplementation<String>();
		arrayList.addItem("1");
		arrayList.addItem("2");
		arrayList.addItemAtParticularLocation("5", 2);
		String check = arrayList.get(2);
		assertNotEquals("0", check);
	}

	/**
	 * Test case to check retrieving first occurrence of item after this location 
	 */
	@Test
	public void testGetFirstOccurrenceAfterLocation() {
		arrayList = new ArrayListImplementation<String>();
		arrayList.addItem("1");
		arrayList.addItem("2");
		arrayList.addItem("3");
		arrayList.addItem("2");
		int check = arrayList.getFirstOccurrenceAfterLocation("2", 2);
		assertNotEquals(-1, check);
	}

	/**
	 * Test case to check Retrieving first occurrence of item
	 */
	@Test
	public void testGetFirstOccurrence() {
		arrayList = new ArrayListImplementation<String>();
		arrayList.addItem("1");
		arrayList.addItem("2");
		int check = arrayList.getFirstOccurrence("2");
		assertNotEquals(-1, check);
	}

	/**
	 * Test case to check item from index is removed or not
	 */
	@Test
	public void testRemovingItemFromIndex() {
		arrayList = new ArrayListImplementation<String>();
		arrayList.addItem("1");
		arrayList.addItem("2");
		int check = arrayList.removeItemFromIndex(1);
		assertNotEquals(-1, check);
	}

	/**
	 * Test case to check particular item is removed or not
	 */
	@Test
	public void testRemovingParticularItem() {
		arrayList = new ArrayListImplementation<String>();
		arrayList.addItem("1");
		arrayList.addItem("2");
		int check = arrayList.removeParticularItem("2");
		assertNotEquals(-1, check);
	}

	/**
	 * Test case to check array is reversed or not
	 */
	@Test
	public void testReversingTheList() {
		arrayList = new ArrayListImplementation<String>();
		arrayList.addItem("1");
		arrayList.addItem("2");
		arrayList.reverse();
		String actual = "";
		for (int index = 0; index < arrayList.getActualSize(); index++) {
			actual += arrayList.get(index) + " ";
		}
		assertEquals("2 1 ", actual);
	}

	/**
	 * Test case to check sorting of array
	 */
	@Test
	public void testSortingOfList() {
		arrayList = new ArrayListImplementation<String>();
		arrayList.addItem("3");
		arrayList.addItem("2");
		arrayList.addItem("6");
		arrayList.addItem("1");
		arrayList.sort();
		String actual = "";
		for (int index = 0; index < arrayList.getActualSize(); index++) {
			actual += arrayList.get(index) + " ";
		}
		assertEquals("1 2 3 6 ", actual);
	}

	/**
	 * Test case to check array list is cleared or not
	 */
	@Test
	public void testRemovingAllItemsFromList() {
		arrayList = new ArrayListImplementation<String>();
		arrayList.addItem("1");
		arrayList.addItem("2");
		arrayList.clearTheList();
		int check = arrayList.getActualSize();
		assertEquals(0, check);
	}
}
