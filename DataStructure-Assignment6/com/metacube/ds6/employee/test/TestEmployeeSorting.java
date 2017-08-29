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
		employeesList = collections.getArrayList();
		employeeSet = collections.getSet();
	}
	/**
	 * Method is used to test the employees entry sorted in natural order or not
	 */
	@Test
	public void testEmployeesSortingInNaturalOrder() {
		employeesList.add(new Employee(23, "mahesh", "kumbhamarg"));
		employeesList.add(new Employee(20, "manish", "sitapura"));
		employeesList.add(new Employee(15, "mukesh", "haldighati"));
		employeesList.add(new Employee(30, "ramesh", "durgapura"));
		collections.sort(employeesList);
		String actual = "";
		// loop continue till end of employees list is reached
		for (Employee employee : employeesList) {
			actual += "Id: " + employee.getId()+ " Name: " + employee.getName() + " address: "+ employee.getAddress()+"\n";
		}
		String expected = "Id: 15 Name: mukesh address: haldighati"
				+ "\nId: 20 Name: manish address: sitapura"
				+ "\nId: 23 Name: mahesh address: kumbhamarg"
				+ "\nId: 30 Name: ramesh address: durgapura\n";
		assertEquals(expected, actual);
	}

	/**
	 * Method is used to test the employees entry sorted by name or not
	 */
	@Test
	public void testEmployeesSortingByName(){
		employeesList.add(new Employee(23, "mahesh", "kumbhamarg"));
		employeesList.add(new Employee(20, "manish", "sitapura"));
		employeesList.add(new Employee(15, "mukesh", "haldighati"));
		employeesList.add(new Employee(30, "ramesh", "durgapura"));
		collections.sort(employeesList, Employee.NameComparator);
		String actual = "";
		// loop continue till end of employees list is reached
		for (Employee employee : employeesList) {
			actual += "Id: " + employee.getId()+ " Name: " + employee.getName() + " address: "+ employee.getAddress()+"\n";
		}
		String expected = "Id: 23 Name: mahesh address: kumbhamarg"
				+ "\nId: 20 Name: manish address: sitapura"
				+ "\nId: 15 Name: mukesh address: haldighati"
				+ "\nId: 30 Name: ramesh address: durgapura\n";
		assertEquals(expected, actual);
	}
	
	/**
	 * Method is used to test only unique employees are added to employees list or not
	 */
	@Test
	public void testEmployeesEntryUniqueOrNot(){
		employeeSet.add(new Employee(23, "mahesh", "kumbhamarg"));
		employeeSet.add(new Employee(15, "mukesh", "haldighati"));
		employeeSet.add(new Employee(23, "mahesh", "kumbhamarg"));
		employeeSet.add(new Employee(30, "ramesh", "durgapura"));
		String actual = employeeSet.toString();
		String expected = "[\nId: 23 --> Name: mahesh --> Address: kumbhamarg, "
				+ "\nId: 30 --> Name: ramesh --> Address: durgapura, "
				+ "\nId: 15 --> Name: mukesh --> Address: haldighati]";
		assertEquals(expected, actual);
	}
}
