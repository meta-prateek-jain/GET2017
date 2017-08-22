package com.metacube.doublyLinkedList;

import com.metacube.doublyLinkedList.node.Node;

/**
 * This class is implementing all doublyLinkedList operations
 * 
 * @author Prateek Jain
 *
 * @param <T>
 */
public class DoublyLinkedList<T> {
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
		// if the location is less then the doubly linked list size then add it to list
		if (location <= size) {
			/*
			 * if location = 1 then add the new node at first location 
			 * else add it to that location
			 */
			if (location == 1) {
				newNode.next = currentNode;
				// if currentNode is present then set this new node at its previous pointer
				if (currentNode != null) {
					currentNode.previous = newNode;
				}
				this.head = newNode;
				size++;
				flag = 0;
			} else {
				// loop continue till end of singly linked list
				while (currentNode != null) {
					// if location is equal to index then add it to this position
					if (index == location) {
						newNode.previous = currentNode;
						newNode.next = currentNode.next();
						// if currentNode.next is present then set this new node at its previous pointer
						if (currentNode.next != null) {
							currentNode.next.previous = newNode;
						}
						currentNode.next = newNode;
						size++;
						flag = 0;
						break;
					}
					index++;
					currentNode = currentNode.next();
				}
			}
		}
		return flag;
	}

	/**
	 * Method is used to get the size of singly Linked list
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
		Node<T> newNode = node.getNode(data);
		/*
		 * if size is zero then add the node in starting else add it to end
		 */
		if (size == 0) {
			this.head = newNode;
		} else {
			Node<T> currentNode = this.head;
			// loop continue till end of list
			while (currentNode.next() != null) {
				currentNode = currentNode.next();
			}
			newNode.previous = currentNode;
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
			 * if data is at first node then change the head pointer to point next node 
			 * else search for the node having the data and then removing it
			 */
			if (head.data.equals(data)) {
				head = head.next();
				// if head is not null then set head previous pointer to null
				if (head != null) {
					head.previous = null;
				}
				size--;
				flag = 0;
			} else {
				// loop continue till end of List is reached
				while (currentNode != null) {
					// if current node has that data then remove this node
					if (currentNode.data.equals(data)) {
						currentNode.previous.next = currentNode.next();
						// if currentNode. next node is present then set its previous pointer
						if (currentNode.next != null) {
							currentNode.next.previous = currentNode.previous();
						}
						size--;
						flag = 0;
						break;
					}
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
		int flag = -1;
		int index = 1;
		// if linked list is not empty then continue
		if (this.head != null) {
			/*
			 * if location is equal to 1 then remove the node from the head else
			 * go to that location and remove the node
			 */
			if (location == 1) {
				this.head = this.head.next();
				// if head is not null then set head previous pointer to null
				if (head != null) {
					head.previous = null;
				}
				size--;
				flag = 0;
			} else {
				// loop continue till end of the list
				while (currentNode != null) {
					// if location is found then remove the node
					if (index == location) {
						currentNode.previous.next = currentNode.next();
						// if currentNode. next is not null then set its previous pointer to null
						if (currentNode.next != null) {
							currentNode.next.previous = currentNode.previous();
						}
						size--;
						flag = 0;
						break;
					}
					index++;
					currentNode = currentNode.next();
				}
			}
		}
		return flag;
	}

	/**
	 * Method is used to get the element by its position
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
		Node<T> tempNode = null;
		Node<T> currentNode = head;
		// loop continue till end of the list reached
		while (currentNode != null) {
			tempNode = currentNode.previous();
			currentNode.previous = currentNode.next;
			currentNode.next = tempNode;
			currentNode = currentNode.previous();
		}
		// if tempNode is not empty then set the head to point this node
		if (tempNode != null) {
			head = tempNode.previous();
		}
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