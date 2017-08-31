package com.metacube.ds3.binarytree.checkMirroSimilar.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.metacube.ds3.binarytree.implementation.BinaryTreeImplementation;
import com.metacube.ds3.binarytree.checkMirroSimilar.implementation.MirrorSimilar;
import com.metacube.ds3.binarytree.enums.Status;
import com.metacube.ds3.binarytree.node.Node;

/**
 * @author Prateek Jain
 *
 */
public class TestMirrorSimilarTree {

	MirrorSimilar checkTrees;
	/**
	 * Method is used to Set up the object of CheckMirrorSimilar class
	 */
	@Before
	public void setUp() {
		checkTrees = new MirrorSimilar();
	}

	/**
	 * Method is used to test the mirror similar method for valid input
	 */
	@Test
	public void testBinaryTreesMirrorSimilarness_valid() {
		Node node = new Node();
		BinaryTreeImplementation firstBinaryTree = new BinaryTreeImplementation();
		firstBinaryTree.setRoot(node.getNode("3"));
		firstBinaryTree.getRoot().left = node.getNode("6");
		firstBinaryTree.getRoot().right = node.getNode("2");
		firstBinaryTree.getRoot().left.left = node.getNode("9");
		firstBinaryTree.getRoot().left.right = node.getNode("6");
		
		BinaryTreeImplementation secondBinaryTree = new BinaryTreeImplementation();
		secondBinaryTree.setRoot(node.getNode("3"));
		secondBinaryTree.getRoot().right = node.getNode("6");
		secondBinaryTree.getRoot().left = node.getNode("2");
		secondBinaryTree.getRoot().right.right = node.getNode("9");
		secondBinaryTree.getRoot().right.left = node.getNode("6");
		
		Status actual = MirrorSimilar.check(firstBinaryTree.getRoot(), secondBinaryTree.getRoot());
		assertEquals(Status.VALID, actual);
	}
	
	/**
	 * Method is used to test the mirror similar method for invalid input
	 */
	@Test
	public void testBinaryTreesMirrorSimilarness_Invalid() {
		Node node = new Node();
		BinaryTreeImplementation firstBinaryTree = new BinaryTreeImplementation();
		firstBinaryTree.setRoot(node.getNode("3"));
		firstBinaryTree.getRoot().left = node.getNode("6");
		firstBinaryTree.getRoot().right = node.getNode("2");
		firstBinaryTree.getRoot().left.left = node.getNode("9");
		firstBinaryTree.getRoot().left.right = node.getNode("6");
		
		BinaryTreeImplementation secondBinaryTree = new BinaryTreeImplementation();
		secondBinaryTree.setRoot(node.getNode("3"));
		secondBinaryTree.getRoot().right = node.getNode("2");
		secondBinaryTree.getRoot().left = node.getNode("6");
		secondBinaryTree.getRoot().right.right = node.getNode("9");
		secondBinaryTree.getRoot().right.left = node.getNode("6");
		
		Status actual = MirrorSimilar.check(firstBinaryTree.getRoot(), secondBinaryTree.getRoot());
		assertNotEquals(Status.VALID, actual);
	}

}
