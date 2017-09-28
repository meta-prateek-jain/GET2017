package com.metacube.ds4.guesthouse.enums;

/**
 * Enum  is used to in guest house application to save the status
 * 
 * @author Prateek Jain
 *
 */
public enum Status {
	ROOM_NOT_AVAILABLE("No room is available in guest house"),
	ROOM_ALLOTED("Room is alloted to the Guest"), 
	PRIME("Number is Prime"),
	NOT_A_PRIME("Number is not a Prime");
	
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
