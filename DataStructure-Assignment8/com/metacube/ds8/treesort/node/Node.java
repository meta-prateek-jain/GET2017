package com.metacube.ds8.treesort.node;
/**
 * This is a node class which has all properties of node
 * 
 * @author Prateek Jain
 *
 */
public class Node {

	private Object data;
	private Node left;
	private Node right;
	/**
	 * Constructor to initialize the properties
	 * @param data
	 * 		data to be set
	 */
	public Node(Object data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	// getters and setters
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
}
