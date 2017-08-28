package com.metacube.ds5.enums;

public enum Status {
	ADDED("It is Added"),
	REMOVED("It is Removed"),
	ClEAR("It is Cleared"), 
	FAILED("Operation Failed"), 
	NOT_EMPTY("It is Not Empty"),
	EMPTY("It is Empty");
	
	String string;
	//To get the string
	public String getString() {
		return string;
	}
	//constructor class
	Status(String string){
		this.string = string;
	}
}
