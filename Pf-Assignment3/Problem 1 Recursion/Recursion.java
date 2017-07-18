import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Programming Fundamental assignment 3
 * 
 * Write recursive functions for the following:
 *
 *a) int rem(int x, int y) where x >=0 and y > 0, to compute the remainder of x divided by y.
 *b) int gcd(int x, int y) where x > 0 and y > 0, to compute the greatest common divisor of x and y. 
 *c) int largestdigit(int x) where x >= 0,  to find out the largest digit in the number x.
 * 
 * @author Prateek Jain 
 * Dated 17/07/2017
 *
 */

public class Recursion extends Exception{
	/**
	 * This recursive function finds remainder and return -1 if divisor is zero
	 * 
	 * @param x >= 0 dividend
	 * @param y > 0	divisor
	 * @return	remainder
	 */
	public int rem(int x, int y) {
		int remainder = -1 ;
		/*
		 * This block return -1 if divisor is zero
		 */
		try{
		if(x<0 || y <= 0){
			throw new ArithmeticException("Number should be greater than zero");
		}
		 
		/*
		 * This is a recursive block which calls itself unit x >= y
		 */
		else if (x >= y) {
			remainder = rem((x - y), y);
		}
		/*
		 * This is a base block which stop recursion and return the remainder
		 */
		 else {
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
	 * @param x > 0	number 1
	 * @param y > 0	number 2
	 * @return	greatest common divisor of number 1 and number 2
	 */
	public int gcd(int x, int y) {
		int greatestCommonDivisor = 0;
		/*
		 * This block compares input numbers and recursivily  calls
		 */
		try{
			if(y<0){
				throw new StackOverflowError("Enter number greater than zero");
			}
		else if( y==0){
				greatestCommonDivisor = x;
			}
		
		else if (y > x) {
			greatestCommonDivisor = gcd(y, x);
		}
		
		/*
		 * This is a recursive block which compares and assign value to greatest common divisor
		 */
		else {
			greatestCommonDivisor = gcd(y, x%y);
		}
			
		} catch (ArithmeticException ae) {
			System.out.println(ae.getMessage());
		}
		catch(StackOverflowError error){
			System.out.println(error.getMessage());
		}
		return greatestCommonDivisor;
	}

	/**
	 * This function finds the largest digit in the number
	 * 
	 * @param x is the input number
	 * @return	largest digit in the number
	 */
	public int largestdigit(int x) {
		int largest = 0;
		int temp;
		try{
		if(x<0){
			throw new Exception("Enter number greater than zero");
		}
		/*
		 * This is a base case which stops the recursion
		 */
		
		else if (x == 0) {
			temp = x;
		}
		/*
		 * This is a recursive case which compares each digit and assign final
		 * value to largest variable
		 */
		else {
			temp = x % 10;
			/*
			 * This block compares the digits and store the largest digit value in the variable 
			 */
			if (temp > largest) {
				largest = temp;
			}
			temp = largestdigit((x / 10));
		}
		
		/*
		 * This block comares the final digits value and store the largest digit value in variable
		 */
		if (temp > largest) {
			largest = temp;
		}
		}
		catch(Exception error){
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
		choice = scan.nextInt();
		try{
			switch(choice){
		case 1:
			/*
			 * returns remainder of number1 and number2
			 * 
			 * Return -1 as remainder and also an error message
			 */
			
			System.out.println("Enter the dividend and divisor to find the remainder ");
			number1 = scan.nextInt();
			number2 = scan.nextInt();
			remainder = recursion.rem(number1,number2);
			System.out.println("Remainder of "+number1+"& "+number2+" is " + remainder+"\n");
			break;
			
		case 2:
			/*
			 * Return gcd of number1 and number2
			 * and returns 0 if any number is less than 0
			 */
			System.out.println("Enter the two numbers to find the gcd ");
			number1 = scan.nextInt();
			number2 = scan.nextInt();
			gcd = recursion.gcd(number1,number2);
			System.out.println("Greatest Common Divisor of "+number1+"& "+number2+" is " +  gcd+"\n");
			break;
			
		case 3:

			/*
			 * Return largest digit in number1
			 */
			System.out.println("Enter the number to find the largest digit in it ");
			number1 = scan.nextInt();
			largestDigit = recursion.largestdigit(number1);
			System.out.println("Largest digit in "+number1+" is " +  largestDigit+"\n");
			break;
		default:
			System.out.println("Wrong input choice");
		}
		}catch(InputMismatchException error){
			System.out.println("Enter the correct input");
		}
	} 
}
