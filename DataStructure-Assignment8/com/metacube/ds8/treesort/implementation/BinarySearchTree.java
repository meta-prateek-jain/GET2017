package com.metacube.ds8.treesort.implementation;

import java.util.ArrayList;
import java.util.List;

import com.metacube.ds8.treesort.model.Student;
import com.metacube.ds8.treesort.node.Node;
/**
 * This class is used to create the binary search tree and traversing it in InOrder
 * 
 * @author Prateek Jain
 *
 */
public class BinarySearchTree {
	private Node root;
	private List<Student> inOrderTraversingList;
	/**
	 * constructor is used to initialize the property
	 */
	public BinarySearchTree() {
		this.root = null;
		inOrderTraversingList = new ArrayList<Student>(); 
	}
	/**
	 * Method is used to insert the node in binary search tree
	 * 
	 * @param node
	 * 		It is the root of the tree
	 * @param student
	 * 		Student class object which is inserted in tree
	 * @return
	 * 		starting node
	 */
	public Node insert(Node node, Student student) {
		/*
		 * if node is null then add student to this node
		 * else if student object present at node has roll no greater than current student roll no then add this node on right side
		 * else add this node on left side
		 */
		if(node == null) {
			node = new Node(student);
		} else if(((Student) node.getData()).compareTo(student) < 0) {
			node.setRight(insert(node.getRight(), student));
		} else {
			node.setLeft(insert(node.getLeft(), student));
		}
	return node;
	}
	/**
	 * Method is used to check whether array is empty or not
	 * 
	 * @return
	 * 		If empty then return true else false
	 */
	public boolean isEmpty() {
		return this.root == null;
	}
	/**
	 * Method is used to return the list containing student class object sorted by their roll no
	 * 
	 * @param node
	 * 		starting node of tree
	 * @return
	 * 		list of stuents sorted by roll no
	 */
	public List<Student> inOrderTraversing(Node node) {
		// if node is not null then perform inOrder traversing
		if(node != null) {
			inOrderTraversing(node.getLeft());
			inOrderTraversingList.add((Student) node.getData());
			inOrderTraversing(node.getRight());
		}
		return inOrderTraversingList;
	}

	// getters and setters
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
}
