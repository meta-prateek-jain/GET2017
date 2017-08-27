package com.metacube.ds2.collegecounselling.model;

/**
 * This is a student entity clas containing required properties of student
 * 
 * @author Prateek Jain
 *
 */
public class Student extends BaseEntity{

	College college;

	/**
	 * Constructor to initialize the properties
	 * 
	 * @param id
	 * @param name
	 * @param rank
	 */
	public Student(int id, String name, int rank) {
		super(id, name, rank);
	}

	//getters and setters
	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	/**
	 * override toString method to return reqiured string
	 */
	@Override
	public String toString(){
		String collegeDetail;
		/*
		 * if college is not alloted then display this message
		 * else alloted college details
		 */
		if (this.college == null) {
			collegeDetail = "No college is alloted";
		} else {
			collegeDetail = getCollege().toString();
		}
		return "Id : "+getId()+" --> "+getName()+" --> "+getRank()+" --> College : "
				+ collegeDetail
				+"\n";
	}
}
