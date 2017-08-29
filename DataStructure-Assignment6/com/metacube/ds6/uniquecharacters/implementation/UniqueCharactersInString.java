package com.metacube.ds6.uniquecharacters.implementation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Class is used to find the unique characters present in string
 * 
 * @author Prateek Jain
 *
 */
public class UniqueCharactersInString {

	private Map<String, Integer> cacheMemory = new HashMap<String, Integer>();
	/**
	 * Method is used to find the unique characters and if same string is encountered before then cache the result from memory
	 * @param string 
	 * 			String of which unique characters need to find out
	 * @return
	 * 		no of unique characters present in passed string 
	 */
	public int find(String string) {
		int noOfUniqueCharacters = 0;
		/*
		 * if that string is already encountered then get the result from memory
		 * else calculate the unique characters present in string
		 */
		if(cacheMemory.containsKey(string)){
			noOfUniqueCharacters = cacheMemory.get(string);
			System.out.print("(Cached from memory)");
		} else {
			Set<Character> uniqueCharactersSet = new HashSet<Character>();
			// loop continue till string end is reached
			for(int count = 0; count < string.length(); count++) {
				uniqueCharactersSet.add(string.charAt(count));
			}
			noOfUniqueCharacters = uniqueCharactersSet.size();
			cacheMemory.put(string, noOfUniqueCharacters);
		}
		return noOfUniqueCharacters;
	}
}
