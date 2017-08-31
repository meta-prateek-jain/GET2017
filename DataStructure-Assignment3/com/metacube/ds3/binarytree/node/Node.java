package com.metacube.ds3.binarytree.node;

/**
 * This class is used to store the data in node and its left and right node address
 * 
 * @author Prateek Jain
 *
 */
public class Node {

	public Object data;
	public Node left;
	public Node right;
	/**
	 * Method is used to get the node
	 * @param data
	 * @return 
	 */
	public Node getNode(Object data) {
		Node node = new Node();
		node.data = data;
		node.left = null;
		node.right = null;
		return node;
	}
}
