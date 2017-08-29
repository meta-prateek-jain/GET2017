package com.metacube.ds6.employee;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.metacube.ds6.employee.model.Employee;
import com.metacube.ds6.employee.util.EmployeeCollection;

/**
 * Create a custom class say Employee with fields as empId, name and address.
 * Create a collection of this employee class. EmpId of the class with be
 * unique. - Perform sorting on this collection i.e natural order.
 * 
 * @author Prateek Jain
 *
 */
public class SortingInNaturalOrder {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice;
		EmployeeCollection collection = new EmployeeCollection();
		List<Employee> employeesList = collection.getArrayList();
		boolean exit = false;
		// loop continue till exit choice is selected
		while (!exit) {
			try {
				System.out.println("\n1) Add employee in the employeesList"
						+ "\n2) Display all employees sorted in natural order"
						+ "\n3) Exit.");
				System.out.println("Enter your Choice.");
				choice = scan.nextInt();
				// switch case to perform operations according to choice selected
				switch (choice) {
				/*
				 * case 1: add employee in the employees list 
				 * case 2: display all employees sorted in natural order 
				 * case 3: exit from application
				 */
				case 1:
					int id;
					// loop continue till valid employee id is entered
					while (true) {
						try {
							System.out.println("Enter the employee id.");
							id = scan.nextInt();
							// if id is greater than 0 then break the loop 
							if(id > 0) {
								break;
							}
							System.out.println("Invalid Id. Try Again");
						} catch (InputMismatchException e) {
							System.out.println("Invalid Input. Only Integers are allowed");
							scan.next();
						}
					}
					scan.nextLine();
					System.out.println("Enter the name");
					String name = scan.nextLine();
					System.out.println("Enter the address");
					String address = scan.nextLine();
					employeesList.add(new Employee(id, name, address));
					System.out.println("Employee entry is added in employees list.");
					break;
				case 2:
					/*
					 * if no employee entry is present in list then display message no employe entry is present
					 * else display all entries present in employeeslist after sorting in natural order
					 */
					if(employeesList.isEmpty()) {
						System.out.println("No employee entry is present");
					} else {
						collection.sort(employeesList);
						System.out.println(employeesList);
					}
					break;
				case 3:
					System.out.println("Exiting from application");
					exit = true;
					break;

				default:
					System.out.println("Invalid Choice. Try Again");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input. Try Again");
				scan.next();
			}
		}
		scan.close();
	}
}
