package com.metacube.joinArraylist.testCase;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.metacube.arrayList.ArrayListImplementation;

public class TestArrayListImplementation {
	ArrayListImplementation<String> arrayList;
	/**
	 * Test case to check two list is added or not
	 */
	@Test
	public void testAddList() {
		arrayList = new ArrayListImplementation<String>();
		arrayList.addItem("1");
		arrayList.addItem("2");
		ArrayListImplementation<String> tempArrayList = new ArrayListImplementation<String>();
		tempArrayList.addItem("4");
		tempArrayList.addItem("5");
		tempArrayList.addItem("6");
		int sizeBeforeListAdded = arrayList.getActualSize();
		arrayList.addList(tempArrayList);
		int sizeAfterListAdded = arrayList.getActualSize();
		assertNotEquals(sizeBeforeListAdded, sizeAfterListAdded);
	}

}
