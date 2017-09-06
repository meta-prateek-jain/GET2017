package com.metacube.ds5.queue.implementation;

import java.util.LinkedList;
import java.util.Queue;

import com.metacube.ds5.enums.Status;

/**
 * This class is implementing the queue using collections
 * 
 * @author Prateek Jain
 *
 * @param <T>
 */
public class QueueImplementation<T> {

	private Queue<T> queue;

	/**
	 * Constructor to initialize the object
	 */
	public QueueImplementation() {
		queue = new LinkedList<T>();
	}

	/**
	 * Method is used to add the element to queue
	 * @param element
	 * @return
	 */
	public Status enqueue(T element) {
		Boolean flag = queue.add(element);
		Status status = Status.FAILED;
		// if flag is true then status equal to added
		if (flag) {
			status = Status.ADDED;
		}
		return status;
	}
	/**
	 * Method is used to retrieves and remove the element from head of queue 
	 * @return
	 */
	public T dequeue() {
		return queue.poll();
	}
	/**
	 * Method is used to get all elements of queue
	 * @return
	 */
	public String getAll() {
		String queueString = "Queue is empty.";
		// if queue is not empty then continue
		if(!queue.isEmpty()) {
			queueString = "";
			// loop continue end of queue is reached
			for(T element: queue) {
				queueString += element+ " ";
			}
		}
		return queueString;
	}
	/**
	 * Method is used to check that queue is empty or not
	 * @return
	 */
	public Status isEmpty() {
		Status status = Status.NOT_EMPTY;
		// if queue is empty then return status that queue is empty
		if(queue.isEmpty()) {
			status = Status.EMPTY;
		}
		return status;
	}
	/**
	 * Method is used to retrieve the element from head of queue
	 * @return
	 */
	public T peek() {
		return queue.peek();
	}
}
