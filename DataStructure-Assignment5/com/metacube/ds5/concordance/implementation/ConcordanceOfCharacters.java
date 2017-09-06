package com.metacube.ds5.concordance.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * This class contains the logic of creating the Concordance of characters occurring in a string
 * 
 * @author Prateek Jain
 *
 */
public class ConcordanceOfCharacters {

	/**
	 * Method is used to get the position of characters in the string
	 * 
	 * @param inputString
	 * @return
	 */
	public String find(String inputString) {
		Map<Character, List<Integer>> concordanceOfCharacters = new TreeMap<Character, List<Integer>>();
		String indicesOfCharacters = "";
		List<Integer> characterIndices = new ArrayList<Integer>();
		// loop continue till end of input String reached
		for (int index = 0; index < inputString.length(); index++) {
			// if inputString do not contain space at location equal to index then continue  
			if (inputString.charAt(index) != ' ') {
				/*
				 * if character is not present in concordance of characters map then initialize the character indices list
				 * else get the list which is previously initialized 
				 */
				if (!concordanceOfCharacters.containsKey(inputString.charAt(index))) {
					characterIndices = new ArrayList<Integer>();
				} else {
					characterIndices = concordanceOfCharacters.get(inputString.charAt(index));
				}
				characterIndices.add(index);
				concordanceOfCharacters.put(inputString.charAt(index), characterIndices);
			}
		}
		Set<Character> key = concordanceOfCharacters.keySet();
		// loop continue till end of concordance of characters map reached
		for (Character character : key) {
			indicesOfCharacters += character + " = " + concordanceOfCharacters.get(character);
		}
		return indicesOfCharacters;
	}
}
