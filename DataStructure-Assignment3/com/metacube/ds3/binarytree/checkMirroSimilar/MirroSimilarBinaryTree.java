package com.metacube.ds3.binarytree.checkMirroSimilar;

import com.metacube.ds3.binarytree.enums.Status;
import com.metacube.ds3.binarytree.implementation.BinaryTreeImplementation;
import com.metacube.ds3.binarytree.node.Node;
import com.metacube.ds3.binarytree.checkMirroSimilar.implementation.*;

/**
 * This class is the main class which is used to check 
 * that the two trees are mirror similar or not
 * 
 * @author Prateek Jain
 *
 */
public class MirroSimilarBinaryTree {

	public static void main(String[] args) {
		Node node = new Node();
		//Initializing first BinaryTree
		BinaryTreeImplementation firstBinaryTree = new BinaryTreeImplementation();
		firstBinaryTree.setRoot(node.getNode("3"));
		firstBinaryTree.getRoot().left = node.getNode("6");
		firstBinaryTree.getRoot().right = node.getNode("2");
		firstBinaryTree.getRoot().left.left = node.getNode("9");
		firstBinaryTree.getRoot().left.right = node.getNode("6");
		
		//Initializing Second Binary Tree
		BinaryTreeImplementation secondBinaryTree = new BinaryTreeImplementation();
		secondBinaryTree.setRoot(node.getNode("3"));
		secondBinaryTree.getRoot().right = node.getNode("6");
		secondBinaryTree.getRoot().left = node.getNode("2");
		secondBinaryTree.getRoot().right.right = node.getNode("9");
		secondBinaryTree.getRoot().right.left = node.getNode("6");
		
		//getting status after checking the two binary trees 
		Status status = MirrorSimilar.check(firstBinaryTree.getRoot(), secondBinaryTree.getRoot());
		System.out.println(status.getString());
	}
}
