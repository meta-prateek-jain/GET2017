package com.metacube.singlyLinkedList.testCase;

import static org.junit.Assert.*;

import org.junit.Test;

import com.metacube.singlyLinkedList.SinglyLinkedList;
/**
 * Test class to check various SinglyLinkedList functions
 * 
 * @author Prateek Jain
 *
 */
public class TestSinglyLinkedList {

	/**
	 * Test case to check add item at particular location
	 */
	@Test
	public void testAddingItemAtParticularLocation() {
		SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<String>();
		singlyLinkedList.addNode("abc");
		singlyLinkedList.addNodeAtLocation(1, "ac");
		String check = singlyLinkedList.getElementByLocation(0);
		assertEquals("ac", check);
	}
	/**
	 * Test case to check item is added or not 
	 */
	@Test
	public void testAddingItem() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addNode("aab");
		int check = list.getActualSize();
		assertEquals(1, check);
	}
	/**
	 * Test case to check Node is removed or not
	 */
	@Test
	public void testRemovingNode() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
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
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
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
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
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
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
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
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
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
