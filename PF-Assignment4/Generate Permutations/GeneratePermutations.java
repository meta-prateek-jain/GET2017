import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeneratePermutations {
	/**
	 * This function generate permutations of input string
	 * @param input The string of which permutation is to find
	 * @return the list of string 
	 */
	public List<String> generatePermutations(String input) {
		// Removing "," "-" and " " from string
		input = input.replace("-", "");
		input = input.replace(",", "");
		input = input.replace(" ", "");
		//The listOfString contains the final list
		List<String> listOfString = new ArrayList<String>();
		/*
		 * If input string's length is 1 then return it
		 * else if string length > 1  Then generate other combination of string
		 */
		if (input.length() == 1) {
			listOfString.add(input);
		} else if (input.length() > 1) {
			int lastIndex = input.length() - 1;
			// Find out the last character
			String lastCharacter = input.substring(lastIndex);
			// Rest of the string
			String restString = input.substring(0, lastIndex);
			// Perform permutation on the rest string and merge with the last
			// character
			listOfString = merge(generatePermutations(restString),lastCharacter);
		}
		return listOfString;
	}

	/**
	 * This function merge the string letters
	 * @param list  Permutation result
	 * @param letter the last character
	 * @return a merged new list
	 */
	public ArrayList<String> merge(List<String> list, String letter) {
		ArrayList<String> mergeArray = new ArrayList<String>();
		StringBuffer temp;
		//Loop through all the string in the list
		for (String string : list) {
			/*
			 * if list contains the letter then return the list
			 * else For each string, insert the last character to all possible
			 * positions and add them to the new list
			 */
			if (string.contains(letter)) {
				return (ArrayList<String>) list;
			} else {
				for (int loop = 0; loop <= string.length(); ++loop) {
					temp = new StringBuffer(string).insert(loop, letter);
					mergeArray.add(temp.toString());
				}
			}
		}
		return mergeArray;
	}

	public static void main(String[] args) {
		GeneratePermutations permutations = new GeneratePermutations();
		// letterCombination contains the list of string
		List<String> letterCombination = new ArrayList<String>();
		String input;										// Input is the string
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the String to Find the Permutations");
		input = scanner.nextLine();
		letterCombination = permutations.generatePermutations(input);
		// Displaying List of strings
		for (String string : letterCombination) {
			System.out.println(string + "\n");
		}
		scanner.close();
	}
}