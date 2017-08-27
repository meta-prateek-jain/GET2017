package com.metacube.ds2.collegecounselling.model;

/**
 * This is abstract base class which is extended by all other classes
 * 
 * @author Prateek Jain
 *
 */
public abstract class BaseEntity {

	int id;
	String name;
	int rank;

	//constructor to initialize the properties
	public BaseEntity(int id, String name, int rank){
		this.id = id;
		this.name = name;
		this.rank = rank;
	}
	//getters and setters
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
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
}
