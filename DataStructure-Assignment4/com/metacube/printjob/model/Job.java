package com.metacube.printjob.model;

import com.metacube.printjob.util.Priority;

/**
 * Class is used to store the details related to the job
 * 
 * @author Prateek Jain
 *
 */
public class Job implements Comparable<Job> {
	String department;
	String jobTitle;
	int priorityIndex = -1;

	// constructor to initialize the variables
	public Job(String department, String jobTitle) {
		if(!department.isEmpty() && !jobTitle.isEmpty()) {
			this.department = department;
			this.jobTitle = jobTitle;
			this.priorityIndex = Priority.get(department.toLowerCase());
		}
	}

	// getters and setters
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getPriorityIndex() {
		return priorityIndex;
	}

	public void setPriorityIndex(int priorityIndex) {
		this.priorityIndex = priorityIndex;
	}

	/**
	 * Override the compare to function for compairing two jobs on the basis of their priority index.
	 */
	@Override
	public int compareTo(Job job) {
		return this.getPriorityIndex() - job.getPriorityIndex();
	}
}
