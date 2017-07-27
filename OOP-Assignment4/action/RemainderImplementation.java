package action;

import java.util.InputMismatchException;
import java.util.Scanner;

import util.RecursionOperations;

/**
 * This class implements action interface and find Remainder of two numbers
 * whenever its performFunction called
 * 
 * @author Prateek Jain
 *
 */
public class RemainderImplementation implements Action {

	@Override
	public void performAction() {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		int number1 = 0;
		int number2 = 0;
		int remainder;

		// Loop continue until a valid Input is entered
		do {
			System.out.println("Enter the dividend and divisor to find the remainder ");
			try {
				number1 = Integer.parseInt(scan.next());
				number2 = Integer.parseInt(scan.next());

				// Pass two numbers to function and get their remainder
				remainder = new RecursionOperations().remainder(number1,
						number2);

				/*
				 *	 if numbers are  valid then remainder is not equal to -1
				 *  and it will print the remainder of the numbers and terminate the loop
				 */
				if (remainder != -1) {
					flag = false;
					System.out.println("Remainder of " + number1 + "& "
							+ number2 + " is " + remainder + "\n");
				}
			} catch (InputMismatchException | NumberFormatException e) {
				System.out.println("Enter valid Numbers");
			}
		} while (flag);
		scan.close();
	}
}
