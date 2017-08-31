package com.metacube.ds2.queue;

import com.metacube.ds2.node.Node;

/**
 * This is a queue class which implement enqueue, dequeue, empty and get front operations
 * 
 * @author Prateek Jain
 *
 */
public class Queue {

	Node head = null;
	Node node = new Node();
	private int size = 0;
	
	/**
	 * Method is used to push the data at first in queue
	 * 
	 * @param data
	 * @return
	 */
	public int enque(Object data){
		int flag = -1;
		//if data is not null then add it to stack
		if(data != null){
			Node newNode = node.getNode(data);
			/*
			 * if head is null then add node at start
			 * else add node at end
			 */
			if(this.head == null){
				this.head = newNode; 
			}else{
				Node currentNode = this.head;
				// loop until end of queue is reached
				while(currentNode.next != null){
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
	 * Method is used to delete the first element of queue
	 * @return
	 */
	public Object deque(){
		Object data = null;
		//if size is greater than zero then delete the element
		if(size > 0){
			data = this.head.data;
			this.head = this.head.next;
			size--;
		}
		return data;
	}
	/**
	 * method is used to get the size of queue
	 * @return 
	 */
	public int getSize() {
		return size;
	}
	/**
	 * Method is used to get the front element of queue
	 * @return
	 */
	public Object peek(){
		Object data = null;
		//if stack is not empty then get the element
		if(size > 0){
			data = this.head.data;
		}
		return data;
	}
	/**
	 * Method is used to get All elements present in queue
	 * @return
	 */
	public String getAll(){
		String string = "";
		/*
		 * if size is zero then return stack is empty
		 * else return all elements of stack
		 */
		if(size == 0){
			string = "queue is empty";
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
	/**
	 * Method is used to remove all items of queue and make it empty
	 */
	public void makeEmpty(){
		this.head = null;
		size = 0;
	}
}