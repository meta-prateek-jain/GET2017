package com.metacube.ds3.binarytree.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.metacube.ds3.binarytree.implementation.BinaryTreeImplementation;
import com.metacube.ds3.binarytree.node.Node;

/**
 * Test class to check Binary Tree traversal
 * @author Prateek Jain
 *
 */
public class TestBinaryTreeTraversal {
	BinaryTreeImplementation binaryTree;

	/**
	 * Method is used to set up the object of binaryTree
	 */
	@Before
	public void setUp() {
		Node node = new Node();
		binaryTree = new BinaryTreeImplementation();
		binaryTree.setRoot(node.getNode("3"));
		binaryTree.getRoot().left = node.getNode("6");
		binaryTree.getRoot().right = node.getNode("2");
		binaryTree.getRoot().left.left = node.getNode("9");
		binaryTree.getRoot().left.right = node.getNode("8");
	}

	/**
	 * Method is used to test the preOrderTraversal of tree (Positive test case)
	 */
	@Test
	public void testPreOrderTraversal_Valid() {
		String actual = binaryTree.preOrderTraversal(binaryTree.getRoot());
		assertEquals("3 6 9 8 2 ", actual);
	}

	/**
	 * Method is used to test the postOrderTraversal of tree (Positive test case)
	 */
	@Test
	public void testPostOrderTraversal_Valid() {
		String actual = binaryTree.postOrderTraversal(binaryTree.getRoot());
		assertEquals("9 8 6 2 3 ", actual);
	}
	
	/**
	 * Method is used to test the postOrderTraversal of tree (Negative test case)
	 */
	@Test
	public void testPostOrderTraversal_Invalid() {
		String actual = binaryTree.postOrderTraversal(binaryTree.getRoot());
		assertNotEquals("3 6 9 8 2 ", actual);
	}

	/**
	 * Method is used to test the preOrderTraversal of tree (Negative test case)
	 */
	@Test
	public void testPreOrderTraversal_Invalid() {
		String actual = binaryTree.preOrderTraversal(binaryTree.getRoot());
		assertNotEquals("9 8 6 2 3 ", actual);
	}

}
