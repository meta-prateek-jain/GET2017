package com.metacube.ds6.employee.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.metacube.ds6.employee.model.Employee;
import com.metacube.ds6.employee.util.EmployeeCollection;
/**
 * Test class to check the Employee sorting functionality
 * 
 * @author Prateek Jain
 *
 */
public class TestEmployeeSorting {

	EmployeeCollection  collections;
	List<Employee> employeesList;
	Set<Employee> employeeSet;
	/**
	 * method is used to set up the class object before performing testing
	 */
	@Before
	public void setUp() {
		collections = new EmployeeCollection();
	}
	/**
	 * Method is used to test the employees entry sorted in natural order or not
	 */
	@Test
	public void testEmployeesSortingInNaturalOrder() {
		employeesList = collections.getArrayList();
		employeesList.add(new Employee(23, "mahesh", "kumbhamarg"));
		employeesList.add(new Employee(20, "manish", "sitapura"));
		employeesList.add(new Employee(15, "mukesh", "haldighati"));
		employeesList.add(new Employee(30, "ramesh", "durgapura"));
		collections.sort(employeesList);
		String expected = "[\nId: 15 --> Name: mukesh --> Address: haldighati, "
				+ "\nId: 20 --> Name: manish --> Address: sitapura, "
				+ "\nId: 23 --> Name: mahesh --> Address: kumbhamarg, "
				+ "\nId: 30 --> Name: ramesh --> Address: durgapura]";
		assertEquals(expected, employeesList.toString());
	}

	/**
	 * Method is used to test the employees entry sorted by name or not
	 */
	@Test
	public void testEmployeesSortingByName(){
		employeesList = collections.getArrayList();
		employeesList.add(new Employee(23, "mahesh", "kumbhamarg"));
		employeesList.add(new Employee(20, "manish", "sitapura"));
		employeesList.add(new Employee(15, "mukesh", "haldighati"));
		employeesList.add(new Employee(30, "ramesh", "durgapura"));
		collections.sort(employeesList, Employee.NameComparator);
		String expected = "[\nId: 23 --> Name: mahesh --> Address: kumbhamarg, "
				+ "\nId: 20 --> Name: manish --> Address: sitapura, "
				+ "\nId: 15 --> Name: mukesh --> Address: haldighati, "
				+ "\nId: 30 --> Name: ramesh --> Address: durgapura]";
		assertEquals(expected, employeesList.toString());
	}
	
	/**
	 * Method is used to test only unique employees are added to employees list or not
	 */
	@Test
	public void testEmployeesEntryUniqueOrNot(){
		employeeSet = collections.getSet();
		employeeSet.add(new Employee(23, "mahesh", "kumbhamarg"));
		employeeSet.add(new Employee(15, "mukesh", "haldighati"));
		employeeSet.add(new Employee(23, "mahesh", "kumbhamarg"));
		employeeSet.add(new Employee(30, "ramesh", "durgapura"));
		String expected = "[\nId: 23 --> Name: mahesh --> Address: kumbhamarg, "
				+ "\nId: 30 --> Name: ramesh --> Address: durgapura, "
				+ "\nId: 15 --> Name: mukesh --> Address: haldighati]";
		assertEquals(expected, employeeSet.toString());
	}
}
