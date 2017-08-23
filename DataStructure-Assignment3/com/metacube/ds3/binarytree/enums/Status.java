package com.metacube.ds3.binarytree.enums;

/**
 * Enum class used in checkMirrorSimilar as an status 
 * @author Prateek Jain
 *
 */
public enum Status {

	VALID("Given Trees are mirror similar"),
	INVALID("Given Trees are not mirror similar");
	
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
