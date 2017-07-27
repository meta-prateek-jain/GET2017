package action;

import java.util.InputMismatchException;
import java.util.Scanner;
import util.RecursionOperations;

/**
 * This class implements action interface and find Greatest Common Divisor
 * whenever its performFunction called
 *  
 * @author Prateek Jain
 *
 */
public class GCDImplementation implements Action{

	@Override
	public void performAction() {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		int number1 = 0;
		int number2 = 0;
		int gcd;

		// Loop continue until valid Input is not entered
		do {
			System.out.println("Enter two numbers to find the gcd ");
			try {
				number1 = Integer.parseInt(scan.next());
				number2 = Integer.parseInt(scan.next());

				// Pass the numbers to function and get their Greatest Common Divisor
				gcd = new RecursionOperations().gcd(number1, number2);

				/*
				 *	if numbers are valid then Greatest Common Divisor is not equal to 0 and 
				 *	and it will print the Greatest Common Divisor of the numbers and terminate the loop
				 */
				if (gcd != 0) {
					flag = false;
					System.out.println("Greatest Common Divisor of " + number1+ "& " + number2 + " is " + gcd + "\n");
				}
			} catch (InputMismatchException | NumberFormatException e) {
				System.out.println("Enter valid Numbers");
			}
		} while (flag);
		scan.close();
	}
}
