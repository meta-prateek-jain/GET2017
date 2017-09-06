package com.metacube.ds5.queue.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.metacube.ds5.queue.implementation.QueueImplementation;

/**
 * Class is used to test the queue application
 * 
 * @author Prateek Jain
 *
 */
public class TestQueueImplementation {

	QueueImplementation<String> queue;
	/**
	 * Method is setting up the object of class
	 */
	@Before
	public void setUp() {
		queue = new QueueImplementation<String>();
	}
	/**
	 * method is testing the enqueue function of queue 
	 */
	@Test
	public void testEnqueue() {
		String actual = queue.enqueue("3").getString();
		assertEquals("It is Added", actual);
	}

	/**
	 * method is testing the enqueue function of queue (Negative Test Case) 
	 */
	@Test
	public void testEnqueueForInvalidOutput() {
		String actual = queue.enqueue("13").getString();
		assertNotEquals("It is Failed", actual);
	}

	/**
	 * method is used to test the dequeue operation of queue
	 */
	@Test
	public void testDequeue() {
		queue.enqueue("3");
		String actual = queue.dequeue();
		assertEquals("3", actual);
	}

	/**
	 * method is used to test the dequeue operation of queue (Negative Test Case)
	 */
	@Test
	public void testDequeueWhenQueueIsNull() {
		String actual = queue.dequeue();
		assertEquals(null, actual);
	}
	/**
	 * Method is used to test the isEmpty function of queue
	 */
	@Test
	public void testIsEmpty() {
		String actual = queue.isEmpty().getString();
		assertEquals("It is Empty", actual);
	}
	/**
	 * Method is used to test the isEmpty function of queue (Negative Test Case)
	 */
	@Test
	public void testIsEmptyWhenQueuseIsNot() {
		queue.enqueue("3");
		String actual = queue.isEmpty().getString();
		assertNotEquals("It is Empty", actual);
	}

	/**
	 * Method is used to test the peek function of queue
	 */
	@Test
	public void testPeek() {
		queue.enqueue("3");
		String actual = queue.peek();
		assertEquals("3", actual);
	}

	/**
	 * Method is used to test the peek function of queue (Negative Test Case)
	 */
	@Test
	public void testPeekWhenQueueIsEmpty() {
		String actual = queue.peek();
		assertEquals(null, actual);
	}
}
