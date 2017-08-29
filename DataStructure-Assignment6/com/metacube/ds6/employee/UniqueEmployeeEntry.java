package com.metacube.ds6.employee;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import com.metacube.ds6.employee.model.Employee;
import com.metacube.ds6.employee.util.EmployeeCollection;

/**
 * Create a collection for the employees to avoid any duplicate employee
 * entry. (Employee having same empId will consider as duplicate. If one try to
 * add the same employe again it should avoid that.)
 * 
 * @author Prateek Jain
 *
 */
public class UniqueEmployeeEntry {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		EmployeeCollection collection = new EmployeeCollection();
		int choice;
		Set<Employee> employeesList = collection.getSet();
		boolean exit = false;
		// loop continue till exit choice is selected
		while (!exit) {
			try {
				System.out.println("\n1) Add employee in the employeesList"+ "\n2) Display all employees" + "\n3) Exit.");
				System.out.println("Enter your Choice.");
				choice = scan.nextInt();
				// switch case to perform operations according to choice selected
				switch (choice) {
				/*
				 * case 1: add employee in the employees list
				 * case 2: display all employees
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
					boolean flag = employeesList.add(new Employee(id, name, address));
					/*
					 * if employee entry with this id is already present in list then display message already present
					 * else display employee entry is added   
					 */
					if(!flag) {
						System.out.println("Employee entry with this id is already present in employees list.");
					} else {
						System.out.println("Employee entry is added in employees list.");
					}
					break;
				case 2:
					/*
					 * if no employee entry is present in list then display message no employe entry is present
					 * else display all entries present in employeeslist
					 */
					if(employeesList.isEmpty()) {
						System.out.println("No employee entry is present");
					} else {
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
				System.out.println("Invalid input");
				scan.next();
			}
		}
		scan.close();
	}
}
