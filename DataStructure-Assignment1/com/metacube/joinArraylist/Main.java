package com.metacube.joinArraylist;

import com.metacube.arrayList.ArrayListImplementation;

/**
 * This class is the main class to control the arrayListImplementation
 * 
 * @author Prateek Jain
 *
 */
public class Main {

	public static void main(String[] args) {
		ArrayListImplementation<Integer> firstList = new ArrayListImplementation<Integer>();
		firstList.addItem(3);
		firstList.addItem(2);
		firstList.addItem(8);
		firstList.addItem(4);
		firstList.addItem(5);
		firstList.addItem(6);
		ArrayListImplementation<Integer> secondList = new ArrayListImplementation<Integer>();
		secondList.addItem(1);
		secondList.addItem(5);
		secondList.addItem(6);
		secondList.addItem(2);
		secondList.addItem(9);
		System.out.println("Size of First List is : "+ firstList.getActualSize());
		// add list2 to list1
		firstList.addList(secondList);
		/*
		 * if firstList size is zero then print message else print the arrayList
		 */
		if (firstList.getActualSize() == 0) {
			System.out.println("Array List is Empty");
		} else {
			// loop continue till end of arrayList
			for (int index = 0; index < firstList.getActualSize(); index++) {
				System.out.print(firstList.get(index) + " ");
			}
			System.out.println("\nNew Size of First List is : "+ firstList.getActualSize());
		}
	}
}
