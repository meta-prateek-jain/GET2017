package action;

import java.util.InputMismatchException;
import java.util.Scanner;
import util.RecursionOperations;

/**
 * This class implements action interface and find Largest Digit whenever its
 * performFunction called
 * 
 * @author Prateek Jain
 *
 */
public class LargestDigitImplementation implements Action {

	@Override
	public void performAction() {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		int number = 0;
		int largestDigit;

		// Loop continue until a valid Input is entered
		do {
			System.out.println("Enter the number to find the largest digit in it ");
			try {
				number = Integer.parseInt(scan.next());

				// Pass number to the function and get Largest Digit in the the number
				largestDigit = new RecursionOperations().largestDigit(number);
				/*
				 * if number is valid then largest digit will not be equal to zero 
				 * and it will print the largest digit in the number
				 */
				if (largestDigit != 0) {
					System.out.println("Largest digit in " + number + " is " + largestDigit + "\n");
				}
			} catch (InputMismatchException | NumberFormatException e) {
				System.out.println("Enter valid Numbers");
			}
		} while (flag);
		scan.close();
	}
}
