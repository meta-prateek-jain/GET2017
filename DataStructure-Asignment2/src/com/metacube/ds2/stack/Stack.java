package com.metacube.ds2.stack;

import com.metacube.ds2.node.Node;

/**
 * This is a stack class which implement push and pop operation
 * 
 * @author Prateek Jain
 *
 */
public class Stack {

	Node head = null;
	Node node = new Node();
	private int size = 0;
	
	/**
	 * Method is used to push the data at last on stack
	 * 
	 * @param data
	 * @return
	 */
	public int push(Object data){
		int flag = -1;
		//if data is not null then add it to stack
		if(data != null){
			/*
			 * if size is zero then add node at start
			 * else add node at last
			 */
			if(size == 0){
				Node newNode = node.getNode(data);
				this.head = newNode;
			} else {
				Node newNode = node.getNode(data);
				Node currentNode = this.head;
				// loop continue till end of stack
				while (currentNode.next != null) {
					currentNode = currentNode.next;
				}
				currentNode.next = newNode;
			}
			flag = 0;
			size++;
		}
		return flag;
	}
	/**
	 * Method is used to pop the last element of stack
	 * @return
	 */
	public Object pop(){
		Object data = null;
		//if size is not equal to zero then delete the element
		if(size != 0){
			Node previousNode = this.head;
			Node currentNode = this.head;
			// loop continue till end of stack
			while (currentNode.next != null) {
				previousNode = currentNode;
				currentNode = currentNode.next;
			}
			data = currentNode.data;
			previousNode.next = null;
			size--;
		}
		return data;
	}
	/**
	 * method is used to get the size of stack
	 * @return 
	 */
	public int getSize() {
		return size;
	}
	/**
	 * Method is used to get the top most element of stack
	 * @return
	 */
	public Object peek(){
		Object data = null;
		//if stack is not empty then get the element
		if(size!=0){
			Node currentNode = this.head;
			// loop continue till end of stack
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			data = currentNode.data;
		}
		return data;
	}
	/**
	 * Method is used to get All elements present in stack
	 * @return
	 */
	public String getAll(){
		String string = "";
		/*
		 * if size is zero then return stack is empty
		 * else return all elements of stack
		 */
		if(size == 0){
			string = "Stack is empty";
		}else{
			Node currentNode = this.head;
			//loop continue till end of stack is reached
			while(currentNode != null){
				string += currentNode.data;
				currentNode = currentNode.next;
			}
		}
		return string;
	}
}
