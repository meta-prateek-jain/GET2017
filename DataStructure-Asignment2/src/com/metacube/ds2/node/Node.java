package com.metacube.ds2.node;
/**
 * This class is used to store the data and next node address
 * @author Prateek Jain
 *
 */
public class Node {

	public Object data;
	public Node next;
	/**
	 * Method is used to get the node
	 * @param data
	 * @return 
	 */
	public Node getNode(Object data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		return node;
	}
}