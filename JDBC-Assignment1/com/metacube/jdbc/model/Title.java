package com.metacube.jdbc.model;

/**
 * Class contains properties of title
 * 
 * @author Prateek Jain
 *
 */
public class Title {
	private int id;
	private String name;
	private int subjectId;
	private int publisherId;
	
	/**
	 * Constructor to initialize the variables
	 * 
	 * @param id
	 *            id of the title
	 * @param name
	 *            name of the title
	 * @param subjectId
	 *            subject Id of the title
	 * @param publisherId
	 *            publisher ID of the title
	 */
	public Title(int id, String name, int subjectId, int publisherId) {
		this.id = id;
		this.name = name;
		this.subjectId = subjectId;
		this.publisherId = publisherId;
	}

	public Title() {
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
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
}
