package util;

/**
 * This class contains three function :-
 * 1. remainder 	(to find Remainder)
 * 2. gcd			(to find Greatest Common divisor)
 * 3. largestDigit	(to find Largest digit)
 * 
 * @author Prateek Jain 
 * Dated 27/07/2017
 *
 */

public class RecursionOperations {
	/**
	 * This recursive function finds remainder and return -1 if divisor is zero
	 * 
	 * @param input1 >= 0 dividend
	 * @param input2 > 0 divisor
	 * @return remainder
	 */
	public int remainder(int input1, int input2) {
		int remainderResult = -1;
		try {
			/*
			 * if x < 0 and y<=0 then throw an arithmetic exception 
			 * else if x>=y then recursion calls
			 * else remainder is x
			 */
			if (input1 < 0 || input2 <= 0) {
				throw new ArithmeticException("\nDividend and divisor should be greater than zero");
			} else if (input1 >= input2) {
				remainderResult = remainder((input1 - input2), input2);
			} else {
				remainderResult = input1;
			}
		} catch (ArithmeticException ae) {
			System.out.println(ae.getMessage());
		}
		return remainderResult;
	}

	/**
	 * This recursive function compute the greatest common divisor
	 * 
	 * @param input1 > 0 number 1
	 * @param input2 > 0 number 2
	 * @return greatest common divisor of number 1 and number 2
	 */
	public int gcd(int input1, int input2) {
		int greatestCommonDivisor = 0;
		try {
			/*
			 * If y< 0 throw an stack over flow error 
			 * else if y==o then greatestCommonDivisor is equal to x 
			 * else recursion calls and store the final result in greatestCommonDivisor
			 */
			if (input2 < 0) {
				throw new Exception("Numbers should be greater than zero");
			} else if (input2 == 0) {
				greatestCommonDivisor = input1;
			} else {
				greatestCommonDivisor = gcd(input2, input1 % input2);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return greatestCommonDivisor;
	}

	/**
	 * This function finds the largest digit in the number
	 * 
	 * @param input is the input number
	 * @return largest digit in the number
	 */
	public int largestDigit(int input) {
		int largest = 0;
		int temp;
		try {
			/*
			 * If x < 0 then throw an exception 
			 * else if x == 0 then store x in temp 
			 * else calls the recursion and store final result in 'largest' variable
			 */
			if (input < 0) {
				throw new Exception("Enter number greater than zero");
			} else if (input == 0) {
				temp = input;
			} else {
				largest = input % 10;
				temp = largestDigit((input / 10));
				/*
				 * This block compares 'temp' and 'largest' variable and store
				 * the largest digit value in 'largest' variable
				 */
				if (temp > largest) {
					largest = temp;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return largest;
	}
}