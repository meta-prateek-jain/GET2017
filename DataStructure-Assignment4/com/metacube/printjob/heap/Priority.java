package com.metacube.printjob.heap;

/**
 * Class is used to get the priority index 
 * 
 * @author Prateek Jain
 *
 */
public class Priority {

	/**
	 * Method is returning the priority index according the department 
	 * @param department
	 * @return
	 */
	public static int get(String department){
		int priority;
		switch(department){
		case "chairman":
			priority = 4;
			break;
		case "professor":
			priority = 3;
			break;
		case "graduate":
			priority = 2;
			break;
		case "undergraduate":
			priority = 1;
			break;
		default:
			priority = 0;
		}
		return priority;
	}
}
