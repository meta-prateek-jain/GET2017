package com.metacube.ds2.collegecounselling.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This is college entity class which has properties related to college
 * 
 * @author Prateek Jain
 *
 */
public class College extends BaseEntity{

	int seats;
	List<Student> listOfStudents = new ArrayList<Student>();
	/**
	 * Constructor to initialize the properties
	 * @param id
	 * @param name
	 * @param rank
	 * @param seats
	 */
	public College(int id, String name, int rank, int seats) {
		super(id, name, rank);
		this.seats = seats;
	}
	/**
	 * Method to add the student to list of students
	 * @param student
	 */
	public void admitStudent(Student student){
		this.listOfStudents.add(student);
	}
	//getters and setters
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public List<Student> getListOfStudents() {
		return listOfStudents;
	}
	public void setListOfStudents(List<Student> listOfStudents) {
		this.listOfStudents = listOfStudents;
	}

	/**
	 * override toString method to display required string
	 */
	@Override
	public String toString(){
		return "Id : "+getId()+" ---> "+getName();
	}
}
