package com.metacube.ds5.concordance;

import com.metacube.ds5.concordance.implementation.ConcordanceOfCharacters;

/**
 * Write a program which create a concordance of characters occurring in a
 * string (i.e which characters occur where in a string). Read the string from
 * the command line.
 * 
 * @author Prateek Jain
 * Dated :- 28/08/2017
 *
 */
public class FindConcordanceOfCharacters {

	public static void main(String[] args) {
		ConcordanceOfCharacters concordanceOfCharacters = new ConcordanceOfCharacters();
		String inputString = "";
		/*
		 * If string is passed from command line then display the concordance of characters occurring in a string 
		 * else display the message
		 */
		if (args.length > 0) {
			// loop continue till length of args array
			for (int index = 0; index < args.length; index++) {
				inputString += args[index];
			}
			String outputConcordantString = concordanceOfCharacters.find(inputString);
			System.out.println("Result --> " + outputConcordantString);
		} else {
			System.out.println("Nothing to display");
		}
	}
}
