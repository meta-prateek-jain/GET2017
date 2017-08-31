package com.metacube.ds8.treesort.model;
/**
 * Class is used to store details of student
 * 
 * @author Prateek Jain
 *
 */
public class Student implements Comparable<Student>{
	private int rollNo;
	private String name;
	/**
	 * Constructor to initialize the properties
	 * 
	 * @param rollNo
	 * 		rollNo of the student
	 * @param name
	 * 		name of the student
	 */
	public Student(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}
	/*
	 * Method is override to compare the student on the basis of their roll no
	 * 
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Student student) {
		return this.getRollNo() - student.getRollNo();
	}
	/*
	 * Method is override to print the desired string whenever this method is called
	 * 
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Roll No.: " + this.getRollNo() + " --> Name: " + this.getName();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rollNo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (rollNo != other.rollNo)
			return false;
		return true;
	}
	// getters and setters
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
