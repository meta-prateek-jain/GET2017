package com.metacube.singlyLinkedList;

import com.metacube.singlyLinkedList.node.Node;

/**
 * This class is implementing all singlyLinkedList operations
 * 
 * @author Prateek Jain
 *
 * @param <T>
 */
public class SinglyLinkedList<T> {

	Node<T> head = null;
	Node<T> node = new Node<T>();
	private int size = 0;

	/**
	 * Method is used to add the node at particular location
	 * 
	 * @param location
	 * @param data
	 * @return
	 */
	public int addNodeAtLocation(int location, T data) {
		Node<T> newNode = node.getNode(data);
		Node<T> currentNode = this.head;
		int flag = -1;
		int index = 2;
		// if the location is less then the singly linked list size then add it to list
		if (location <= size) {
			/*
			 * if location = 1 then add the new node at first location 
			 * else add it to that location
			 */
			if (location == 1) {
				newNode.next = currentNode;
				this.head = newNode;
				size++;
				flag = 0;
			} else {
				Node<T> previousNode = this.head;
				// loop continue till end of singly linked list
				while (currentNode != null) {
					// if location is equal to index then add it to this position
					if (location == index) {
						newNode.next = currentNode.next();
						previousNode.next = newNode;
						size++;
						flag = 0;
						break;
					}
					index++;
					previousNode = currentNode;
					currentNode = currentNode.next();
				}
			}
		}
		return flag;
	}

	/**
	 * Method is used to get the actual size of singly Linked list
	 * 
	 * @return
	 */
	public int getActualSize() {
		return size;
	}

	/**
	 * Method is used to add the node to singly Linked list
	 * 
	 * @param data
	 */
	public void addNode(T data) {
		/*
		 * if size is zero then add the node in starting else add it to end
		 */
		if (size == 0) {
			Node<T> newNode = node.getNode(data);
			this.head = newNode;
		} else {
			Node<T> newNode = node.getNode(data);
			Node<T> currentNode = this.head;
			// loop continue till end of list
			while (currentNode.next() != null) {
				currentNode = currentNode.next();
			}
			currentNode.next = newNode;
		}
		size++;
	}

	/**
	 * Method is used to remove the Node
	 * 
	 * @param data
	 * @return
	 */
	public int removeNode(T data) {
		Node<T> currentNode = this.head;
		int flag = -1;
		// if Linked list is not empty then remove the node
		if (this.head != null) {
			/*
			 * if data is at first node then change the head pointer to point
			 * next node else search for the node having the data and then
			 * removing it
			 */
			if (head.data.equals(data)) {
				head = head.next();
				size--;
				flag = 0;
			} else {
				Node<T> previousNode = null;
				// loop continue till end of List is reached
				while (currentNode != null) {
					// if current node has that data then remove this node
					if (currentNode.data.equals(data)) {
						previousNode.next = currentNode.next();
						size--;
						flag = 0;
						break;
					}
					previousNode = currentNode;
					currentNode = currentNode.next();
				}
			}
		}
		return flag;
	}

	/**
	 * Method to remove node by its location
	 * 
	 * @param location
	 * @return boolean
	 */
	public int removeNodeFromLocation(int location) {
		Node<T> currentNode = this.head;
		Node<T> previousNode = null;
		int flag = -1;
		int index = 1;
		// if linked list is not empty then continue
		if (this.head != null) {
			/*
			 * if location is equal to 1 then remove the node from the head 
			 * else go to that location and remove the node
			 */
			if (location == 1) {
				this.head = this.head.next();
				size--;
				flag = 0;
			} else {
				// loop continue till end of the list
				while (currentNode != null) {
					// if location is found then remove the node
					if (index == location) {
						previousNode.next = currentNode.next();
						size--;
						flag = 0;
						break;
					}
					index++;
					previousNode = currentNode;
					currentNode = currentNode.next();
				}
			}
		}
		return flag;
	}

	/**
	 * Method is used to get the element by its location
	 * 
	 * @param location
	 * @return
	 */
	public T getElementByLocation(int location) {
		Node<T> currentNode = this.head;
		T element = null;
		int index = 0;
		// loop continue till end of list is reached
		while (currentNode != null) {
			// if location is reached then return the node data
			if (index == location) {
				element = currentNode.data;
			}
			currentNode = currentNode.next();
			index++;
		}
		return element;
	}

	/**
	 * Method is used to reverse the List
	 */
	public void reverse() {
		Node<T> currentNode = this.head;
		Node<T> previousNode = null;
		Node<T> nextNode = null;
		// loop continue till end of the list reached
		while (currentNode != null) {
			nextNode = currentNode.next();
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}
		this.head = previousNode;
	}

	/**
	 * Method is used to sort the linked list
	 */
	public void sort() {
		Node<T> currentNode = this.head;
		Node<T> tempNode = null;
		// loop continue till end of the list
		while (currentNode != null) {
			tempNode = currentNode.next();
			// loop continue till end of list
			while (tempNode != null) {
				// if previous node has data value greater than next node then swap the node the data
				if (currentNode.data.toString().compareTo(tempNode.data.toString()) > 0) {
					T temp = currentNode.data;
					currentNode.data = tempNode.data;
					tempNode.data = temp;
				}
				tempNode = tempNode.next();
			}
			currentNode = currentNode.next();
		}
	}
}