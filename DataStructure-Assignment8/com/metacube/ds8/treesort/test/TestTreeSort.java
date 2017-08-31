package com.metacube.ds8.treesort.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.metacube.ds8.treesort.implementation.BinarySearchTree;
import com.metacube.ds8.treesort.model.Student;

/**
 * This class is used to test the tree Sort functionality
 *
 * @author Prateek Jain
 *
 */
public class TestTreeSort {
	BinarySearchTree binarySearchTree;
	/**
	 * Method is used to setup the Class Object
	 * 
	 */
	@Before
	public void setUp() {
		binarySearchTree = new BinarySearchTree();
	}
	/**
	 * Method is used to check the insert method of binary search tree
	 */
	@Test
	public void testInsert() {
		binarySearchTree.setRoot(binarySearchTree.insert(binarySearchTree.getRoot(), new Student(23, "ramesh")));
		assertFalse(binarySearchTree.isEmpty());
	}
	/**
	 * Method is used to test the isEmpty method which checks binary search tree is empty or not
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(binarySearchTree.isEmpty());
	}
	/**
	 * Method is used to test the inorder traversing
	 */
	@Test
	public void testInOrderTraversing() {
		binarySearchTree.setRoot(binarySearchTree.insert(binarySearchTree.getRoot(), new Student(23, "ramesh")));
		binarySearchTree.setRoot(binarySearchTree.insert(binarySearchTree.getRoot(), new Student(12, "mahesh")));
		binarySearchTree.setRoot(binarySearchTree.insert(binarySearchTree.getRoot(), new Student(27, "suresh")));
		List<Student> actual = binarySearchTree.inOrderTraversing(binarySearchTree.getRoot());
		List<Student> expected = new ArrayList<Student>();
		expected.add(new Student(12, "mahesh"));
		expected.add(new Student(23, "ramesh"));
		expected.add(new Student(27, "suresh"));
		assertEquals(expected, actual);
	}
}
