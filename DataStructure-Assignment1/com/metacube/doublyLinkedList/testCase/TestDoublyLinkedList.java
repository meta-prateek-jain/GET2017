package com.metacube.doublyLinkedList.testCase;

import static org.junit.Assert.*;

import org.junit.Test;

import com.metacube.doublyLinkedList.DoublyLinkedList;
/**
 * Test class to check various DoublyLinkedList functions
 * 
 * @author Prateek Jain
 *
 */
public class TestDoublyLinkedList {

	/**
	 * Test case to check add item at particular location
	 */
	@Test
	public void testAddingItemAtParticularLocation() {
		DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<String>();
		doublyLinkedList.addNode("abc");
		doublyLinkedList.addNodeAtLocation(1, "ac");
		String check = doublyLinkedList.getElementByLocation(0);
		assertEquals("ac", check);
	}

	/**
	 * Test case to check item is added or not 
	 */
	@Test
	public void testAddingItem() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.addNode("aab");
		int check = list.getActualSize();
		assertEquals(1, check);
	}
	/**
	 * Test case to check Node is removed or not
	 */
	@Test
	public void testRemovingNode() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.addNode("aab");
		list.addNode("ab");
		list.addNode("cab");
		int check = list.removeNode("cab");
		assertEquals(0, check);
	}
	/**
	 * Test case to check Node is removed from particular location or not
	 */
	@Test
	public void testRemovingNodefromLocation() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.addNode("aab");
		list.addNode("ab");
		list.addNode("cab");
		int check = list.removeNodeFromLocation(1);
		assertEquals(0, check);
	}
	/**
	 * Test case to check Node is retrieved from particular location or not
	 */
	@Test
	public void testRetrievingNodeElementByLocation() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.addNode("aab");
		list.addNode("ab");
		list.addNode("cab");
		String check = list.getElementByLocation(1);
		assertEquals("ab", check);
	}
	/**
	 * Test case to check list is reversed or not
	 */
	@Test
	public void reverseTheList(){
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.addNode("aab");
		list.addNode("ab");
		list.addNode("cab");
		list.reverse();
		String actual = "";
		for (int index = 0; index < list.getActualSize(); index++) {
			actual += list.getElementByLocation(index) + " ";
		}
		assertEquals("cab ab aab ", actual);
	}
	/**
	 * Test case to check Sorting of list
	 */
	@Test
	public void sortTheList(){
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.addNode("ab");
		list.addNode("aab");
		list.addNode("cab");
		list.sort();
		String actual = "";
		for (int index = 0; index < list.getActualSize(); index++) {
			actual += list.getElementByLocation(index) + " ";
		}
		assertEquals("aab ab cab ", actual);
	}
}
