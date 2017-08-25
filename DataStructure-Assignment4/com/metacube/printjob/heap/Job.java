package com.metacube.printjob.heap;

public class Job implements Comparable<Job> {
	String department;
	String jobTitle;
	int priorityIndex;
	public Job(String department, String jobTitle){
		this.department = department;
		this.jobTitle = jobTitle;
		this.priorityIndex = Priority.get(department.toLowerCase());
	}
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
	@Override
	public int compareTo(Job job) {
		return this.getPriorityIndex() - job.getPriorityIndex();
	}

}
