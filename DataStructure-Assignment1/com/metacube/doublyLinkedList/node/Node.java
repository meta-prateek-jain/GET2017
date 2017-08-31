package com.metacube.doublyLinkedList.node;
/**
 *This class is used in linkedlist to store the data and next node address 
 * 
 * @author Prateek Jain
 *
 * @param <T>
 */
public class Node<T> {
	public T data;
	public Node<T> next;
	public Node<T> previous;
	/**
	 * Method is used to get the next node address
	 * @return next
	 */
	public Node<T> next() {
		return this.next;
	}
	/**
	 * Method is used to get the previous node address
	 * @return next
	 */
	public Node<T> previous() {
		return this.previous;
	}
	/**
	 * Method is used to get the node
	 * @param data
	 * @return 
	 */
	public Node<T> getNode(T data) {
		Node<T> node = new Node<T>();
		node.data = data;
		node.next = null;
		node.previous = null;
		return node;
	}

}