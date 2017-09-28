package com.metacube.ds4.guesthouse.model;

/**
 * This class is used to store the property of a guest
 * 
 * @author Prateek Jain
 *
 */
public class Guest {

	private String name;
	private int age;

	/**
	 * Constructor to initialize the property
	 * 
	 * @param name
	 * @param age
	 */
	public Guest(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Method is used to print the details the guest 
	 */
	@Override
	public String toString(){
		return "Name : "+this.getName()+" ---> Age : "+this.getAge();
	}
}
