package com.metacube.ds6.employee.util;

import com.metacube.ds6.employee.model.Employee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class is used as utility to create array list and set class objects and sort them
 * 
 * @author Prateek Jain
 *
 */
public class EmployeeCollection {

	/**
	 * Method is used to sort the list according to natural order
	 */
	public void sort(List<Employee> arrayList) {
		Collections.sort(arrayList);
	}
	/**
	 * Method is used to sort the list according to their name
	 */
	public void sort(List<Employee> arrayList, Comparator<Employee> comparator){
		Collections.sort(arrayList, comparator);
	}

	// getters
	public List<Employee> getArrayList() {
		return new ArrayList<Employee>();
	}

	public Set<Employee> getSet() {
		return new HashSet<Employee>();
	}
}
