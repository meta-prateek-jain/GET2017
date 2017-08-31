package com.metacube.ds3.binarytree.implementation;

import java.util.LinkedList;
import java.util.Queue;

import com.metacube.ds3.binarytree.node.Node;

/**
 * This class is used to create the binary tree and traverse it
 *
 * @author Prateek Jain 
 * Dated :- 22/08/2017
 */
public class BinaryTreeImplementation {
	Node root;
	Node node = new Node();

	/**
	 * Constructor to initialize the root
	 */
	public BinaryTreeImplementation() {
		root = null;
	}

	/**
	 * Create the binary tree of elements present in the queue 
	 * 
	 * @param data
	 */
	public void create(Queue<?> data) {
		Queue<Node> parentNodes = new LinkedList<Node>();
		//loop continue till all data list elements are added in binary tree 
		while (data.peek() != null) {
			/*
			 * if root is null then add data to first node
			 * else add data to left child or right child of the node
			 */
			if (root == null) {
				root = node.getNode(data.poll());
			} else {
				parentNodes.add(root);
				Node parent = parentNodes.poll();
				Node leftChild = null;
				Node rightChild = null;
				leftChild = node.getNode(data.poll());
				parentNodes.add(leftChild);
				//if list top element is not null then add the data
				if (data.peek() != null) {
					rightChild = node.getNode(data.poll());
					parentNodes.add(rightChild);
				}
				parent.left = leftChild;
				parent.right = rightChild;
			}
		}
	}

	/**
	 * Method is used to traverse the tree in preOrder
	 * @param node
	 * @return
	 */
	public String preOrderTraversal(Node node) {
		String preOrder = "";
		//if node is not null then continue traversing
		if (node != null) {
			preOrder += node.data + " ";
			preOrder += preOrderTraversal(node.left);
			preOrder += preOrderTraversal(node.right);
		}
		return preOrder;
	}

	/**
	 * Method is used to traverse the tree in postOrder
	 * @param node
	 * @return
	 */
	public String postOrderTraversal(Node node) {
		String postOrder = "";
		//if node is not null then continue traversing
		if (node != null) {
			postOrder += postOrderTraversal(node.left);
			postOrder += postOrderTraversal(node.right);
			postOrder += node.data + " ";
		}
		return postOrder;
	}
	//getters and setters
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
}
