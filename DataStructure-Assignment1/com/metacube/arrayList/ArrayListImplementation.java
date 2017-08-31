package com.metacube.arrayList;

import java.util.Arrays;

/**
 * This class contains all methods related to arraylist like add, remove, reverse , sort
 * 
 * @author Prateek Jain
 *
 */
public class ArrayListImplementation<T> {
	Object[] arrayList;
	private int numberOfItems = 0;
	private static final int FIXED_SIZE = 10;

	/**
	 * Constructor to initialize the properties
	 */
	public ArrayListImplementation() {
		arrayList = new Object[FIXED_SIZE];
	}

	/**
	 * Method is used to get the actual size i.e. number of items present in the list
	 * 
	 * @return
	 */
	public int getActualSize() {
		return numberOfItems;
	}

	/**
	 * Method is used to combine two list into single list
	 * 
	 * @param list
	 */
	public void addList(ArrayListImplementation<T> list) {
		// loop continue till all the items of list is added to arrayList
		for (int index = 0; index < list.getActualSize(); index++) {
			addItem(list.get(index));
		}
	}

	/**
	 * Method to add item to list and increasing array size if it is full
	 */
	public void addItem(T item) {
		/*
		 * if list is full then increase the size else add the item
		 */
		if (numberOfItems == arrayList.length - 2) {
			ensureCapacity();
		} else {
			arrayList[numberOfItems] = item;
			numberOfItems++;
		}
	}

	/**
	 * Method to resize the arrayList
	 */
	private void ensureCapacity() {
		arrayList = Arrays.copyOf(arrayList, arrayList.length * 2);
	}

	/**
	 * Method to Add an item into array list at the given particular location
	 */
	public int addItemAtParticularLocation(T item, int location) {
		int index;
		int temp = -1;
		// If location is less than arrayList Size and greater than zero then add it
		if (location <= numberOfItems && location >= 0) {
			// if in arraylist number of items is greater than or equal to arraylist.length then increase the size of array
			if (numberOfItems >= arrayList.length - 1) {
				ensureCapacity();
			}
			index = numberOfItems;
			// loop continue till index is greater than location
			while (index >= location) {
				arrayList[index] = arrayList[index - 1];
				index--;
			}
			arrayList[index] = item;
			this.numberOfItems++;
			temp = 0;
		}
		return temp;
	}

	/**
	 * Method to get the item at location
	 * 
	 * @param location
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T get(int location) {
		T item = null;
		// If location is greater than zero and less than number of items of array then return the item
		if (location <= (numberOfItems) && location >= 0) {
			item = (T) arrayList[location];
		}
		return item;
	}

	/**
	 * Method to get the first occurrence of an item based on its given location
	 * 
	 * @param item
	 * @param location
	 * @return
	 */
	public int getFirstOccurrenceAfterLocation(T item, int location) {
		int index = -1;
		// if location is less than arraySize then search for item
		if (location < (numberOfItems) && location >= 0) {
			// while location is not reach at end
			while (location < numberOfItems) {
				// if item is found then return the location
				if (arrayList[location].equals(item)) {
					index = location + 1;
					break;
				}
				location++;
			}
		}
		return index;
	}

	/**
	 * Method is used to get the first index of particular item in the arraylist
	 * 
	 * @param item
	 * @return
	 */
	public int getFirstOccurrence(T item) {
		int index = -1;
		int count = 0;
		// loop continue till end of arrayList reached
		while (count <= (numberOfItems)) {
			// if item found then return its location
			if (arrayList[count].equals(item)) {
				index = count + 1;
				break;
			}
			count++;
		}
		return index;
	}

	/**
	 * Method remove the item based on particular location
	 */
	public int removeItemFromIndex(int index) {
		int flag = -1;
		/*
		 * if index is less than array size and greater than zero then remove the item at index 
		 * else if index ==0 then clear the list
		 */
		if (index < numberOfItems && index > 1) {
			index--;
			// loop till end of list
			while (index < numberOfItems) {
				arrayList[index] = arrayList[index + 1];
				index++;
			}
			numberOfItems--;
			flag = 0;
		} else if (index == 1) {
			clearTheList();
			flag = 0;
		}
		return flag;
	}

	/**
	 * Method to remove given particular item from the arraylist
	 * 
	 * @param item
	 */
	public int removeParticularItem(T item) {
		int flag;
		flag = getFirstOccurrence(item);
		// if flag is not equal to -1 then remove the item
		if (flag != -1) {
			removeItemFromIndex(getFirstOccurrence(item));
			numberOfItems--;
		}
		return flag;
	}

	/**
	 * Method is used to remove all the elements of the list
	 */
	public void clearTheList() {
		arrayList = new Object[FIXED_SIZE];
		numberOfItems = 0;
	}

	/**
	 * Method is used Reverse the arraylist
	 */
	public void reverse() {
		Object[] tempArrayList = new Object[getActualSize() + 1];
		int index = 0;
		// loop continue till end of the list
		while (index < getActualSize()) {
			tempArrayList[index] = arrayList[getActualSize() - index - 1];
			index++;
		}
		arrayList = tempArrayList;
	}

	/**
	 * Method is used to sort the arrayList
	 */
	public void sort() {
		Object[] sortedSubarray = (Object[]) Arrays.copyOfRange(arrayList, 0,numberOfItems);
		Arrays.sort(sortedSubarray);
		for (int index = 0; index < numberOfItems; index++) {
			this.arrayList[index] = sortedSubarray[index];
		}
	}
}
