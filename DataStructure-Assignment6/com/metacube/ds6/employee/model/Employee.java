package com.metacube.ds6.employee.model;

import java.util.Comparator;

/**
 * This class is a model class which contains the properties of an employee
 * 
 * @author Prateek Jain
 *
 */
public class Employee implements Comparable<Employee> {

	private int id;
	private String name;
	private String address;
	/**
	 * Constructor to initialize the Properties
	 * @param id
	 * 		set The id of employee
	 * @param name
	 * 		set the name of employee
	 * @param address
	 * 		set the address of employee
	 */
	public Employee(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/*
	 * method is override to sort according to their id
	 * 
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Employee employee) {
		return getId()-employee.getId();
	}
	/**
	 * method is used to sort according to their name
	 */
	public static Comparator<Employee> NameComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee employee1, Employee employee2) {
			return employee1.getName().compareTo(employee2.getName());
		}
    };

	/* 
	 * method is override to generate hash code according to their id
	 * 
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/*
	 * method is override to check equality only by id
	 * 
	 *  (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "\nId: "+this.getId() + " --> Name: " + this.getName() + " --> Address: "
				+ this.getAddress();
	}

}
