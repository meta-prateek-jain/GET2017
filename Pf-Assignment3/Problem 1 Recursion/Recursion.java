import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Programming Fundamental assignment 3
 * 
 * Write recursive functions for the following:
 *
 * a) int rem(int x, int y) where x >=0 and y > 0, to compute the remainder of x
 * divided by y. b) int gcd(int x, int y) where x > 0 and y > 0, to compute the
 * greatest common divisor of x and y. c) int largestdigit(int x) where x >= 0,
 * to find out the largest digit in the number x.
 * 
 * @author Prateek Jain Dated 17/07/2017
 *
 */

public class Recursion {
	/**
	 * This recursive function finds remainder and return -1 if divisor is zero
	 * 
	 * @param x >= 0 dividend
	 * @param y > 0 divisor
	 * @return remainder
	 */
	public int rem(int x, int y) {
		int remainder = -1;
		try {
			/*
			 * if x < 0 and y<=0 then throw an arithmetic exception 
			 * else if x>=y then recursion calls
			 * else remainder is x
			 */
			if (x < 0 || y <= 0) {
				throw new ArithmeticException("Dividend and divisor should be greater than zero");
			} else if (x >= y) {
				remainder = rem((x - y), y);
			} else {
				remainder = x;
			}
		} catch (ArithmeticException ae) {
			System.out.println(ae.getMessage());
		}
		return remainder;
	}

	/**
	 * This recursive function compute the greatest common divisor
	 * 
	 * @param x > 0 number 1
	 * @param y > 0 number 2
	 * @return greatest common divisor of number 1 and number 2
	 */
	public int gcd(int x, int y) {
		int greatestCommonDivisor = 0;
		try {
			/*
			 * If y< 0 throw an stack over flow error 
			 * else if y==o then greatestCommonDivisor is equal to x 
			 * else if y > x then calls the recursion by changing x with y and vice versa
			 * else recursion calls and store the final result in greatestCommonDivisor
			 */
			if (y < 0) {
				throw new StackOverflowError("Enter number greater than zero");
			} else if (y == 0) {
				greatestCommonDivisor = x;
			} else if (y > x) {
				greatestCommonDivisor = gcd(y, x);
			} else {
				greatestCommonDivisor = gcd(y, x % y);
			}
		} catch (StackOverflowError error) {
			System.out.println(error.getMessage());
		}
		return greatestCommonDivisor;
	}

	/**
	 * This function finds the largest digit in the number
	 * 
	 * @param x is the input number
	 * @return largest digit in the number
	 */
	public int largestdigit(int x) {
		int largest = 0;
		int temp;
		try {
			/*
			 * If x < 0 then throw an exception 
			 * else if x == 0 then store x in temp 
			 * else calls the recursion and store final result in 'largest' variable
			 */
			if (x < 0) {
				throw new Exception("Enter number greater than zero");
			} else if (x == 0) {
				temp = x;
			} else {
				largest = x % 10;
				temp = largestdigit((x / 10));
				/*
				 * This block compares 'temp' and 'largest' variable and store
				 * the largest digit value in 'largest' variable
				 */
				if (temp > largest) {
					largest = temp;
				}
			}
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}
		return largest;
	}

	public static void main(String[] args) {
		Recursion recursion = new Recursion();
		int number1;
		int number2;
		int remainder;
		int gcd;
		int largestDigit;
		int choice;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 1 for finding remainder\nEnter 2 for finding gcd\nEnter 3 for finding largest digit");
		try {
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				// returns remainder of number1 and number2
				System.out.println("Enter the dividend and divisor to find the remainder ");
				number1 = scan.nextInt();
				number2 = scan.nextInt();
				remainder = recursion.rem(number1, number2);
				if (remainder != -1) {
					System.out.println("Remainder of " + number1 + "& " + number2 + " is " + remainder + "\n");
				}
				break;

			case 2:
				// Return greatest common divisor of number1 and number2
				System.out.println("Enter the two numbers to find the gcd ");
				number1 = scan.nextInt();
				number2 = scan.nextInt();
				gcd = recursion.gcd(number1, number2);
				if (gcd != 0) {
					System.out.println("Greatest Common Divisor of " + number1 + "& " + number2 + " is " + gcd + "\n");
				}
				break;

			case 3:
				// Return largest digit in number1
				System.out.println("Enter the number to find the largest digit in it ");
				number1 = scan.nextInt();
				largestDigit = recursion.largestdigit(number1);
				if (largestDigit != 0) {
					System.out.println("Largest digit in " + number1 + " is " + largestDigit + "\n");
				}
				break;
			default:
				System.out.println("Wrong input choice");
			}
		} catch (InputMismatchException error) {
			System.out.println("Enter the correct input");
		} finally {
			scan.close();
		}
	}
}