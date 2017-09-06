package com.metacube.ds5.sortedlinkedlist.implementation;

import java.util.LinkedList;
import java.util.List;

import com.metacube.ds5.enums.Status;

/**
 * Class is used to implement the sorted linked list 
 * 
 * @author Prateek Jain
 *
 */
public class SortedLinkedListImplementation {

	List<Integer> sortedLinkedList = new LinkedList<Integer>();
	/**
	 * Method is used to add the number to linked list
	 * @param number
	 */
	public void add(int number) {
		int location = getLocation(number, 0);
		sortedLinkedList.add(location, number);
	}
	/**
	 * Method is used to get the location where number should be added in sorted linked list
	 * 
	 * @param number
	 * @param index
	 * @return
	 */
	private int getLocation(int number, int index) {
		int location = index;
		/*
		 * if location is less than list size then find the location 
		 */
		if(location < sortedLinkedList.size()) {
			// if number is greater than the number present at that location in list then call function again  
			if(sortedLinkedList.get(location).compareTo(number) <= 0) {
				location++;
				location = getLocation(number, location);
			}
		}
		return location;
	}
	/**
	 * Method is used to check whether list is empty or not
	 * @return
	 */
	public Status isEmpty() {
		Status status = Status.NOT_EMPTY;
		if(sortedLinkedList.isEmpty()) {
			status = Status.EMPTY;
		}
		return status;
	}
	/**
	 * Method is used to get the linked list
	 * @return
	 */
	public String getAll() {
		String linkedList = "List is Empty";
		// if list is not empty then continue
		if(!sortedLinkedList.isEmpty()) {
			linkedList = "";
			// loop until end of list is reached
			for (Integer number : sortedLinkedList) {
				linkedList += number+" ";
			}
		}
		return linkedList;
	}
}
