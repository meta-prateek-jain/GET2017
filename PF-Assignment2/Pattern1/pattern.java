import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 	Programming fundamental assignment 2
 * 
 * This class is used to print following pattern by modular approach 
 *         1
 *       1 2 1
 *     1 2 3 2 1
 *   1 2 3 4 3 2 1
 * 1 2 3 4 5 4 3 2 1
 *   1 2 3 4 3 2 1
 *     1 2 3 2 1
 *       1 2 1
 *         1 
 * 
 *  Dated 14/07/2017
 * @author Prateek Jain
 *	Assumption n is 1 greater than the size of pyramid need to print
 */
public class Pattern {
	/*
	 * This function calculates space for particular row 
	 */
	public String space(int row, int n) {
		String space = "";										
		/*
		 * This block add spaces to string 'space' if row is less than half of pyramidsize 
		 */
		if (row < (n / 2)) {
			for (int loop = (n / 2); loop > row; loop--) {
				space = space + "  ";
			}
		} 
		/*
		 * This block add spaces to string 'space' if row is greater than half of pyramide size
		 */
		else {
			if( n%2 !=0)
			{
				++n;
			}
			for (int loop1 = 0; loop1 < (row - (n / 2)); loop1++) {
				space = space + "  ";
			}
		}
		return space;
	}
	/*
	 * This function add numbers for particular row into string and return the string 
	 */
	public String numbers(int row, int n) {
		String number = "";
		/*
		 * This block add numbers if row is less than half of pyramidsize and add them to string 
		 */
		if (row <= (n / 2)) {
			/*
			 * this loop add starting number to string 
			 */
			for (int loop = 1; loop <= row; loop++) {
				number = number + loop + " ";
			}
			/*
			 * this loop add last numbers to string
			 */
			for (int loop1 = (row - 1); loop1 >= 1; loop1--) {
				number = number + loop1 + " ";
			}
		}

		/*
		 * This block find numbers if row is greater than or equal to half of pyramid size and add them to string 
		 */
		else {
			/*
			 * this loop add initial numbers of row to string
			 */
			for (int loop2 = 1; loop2 <= (n - row); loop2++) {
				number = number + loop2 + " ";
			}
			/*
			 * this loop add last numbers to string
			 */
			for (int loop3 = (n - row - 1); loop3 >= 1; loop3--) {
				number = number + loop3 + " ";
			}
		}
		return number;
	}
	/*
	 * This function return array of strings containing individual row as a single string element
	 */
	public String[] wholePyramid(int n) throws NegativeArraySizeException{
		Pattern patterObject = new Pattern();
		try {
			String[] pyramidArray = new String[n - 1];
			int count;
			/*
			 * This loop add value to pyramidArray by using two functions
			 */
			for (count = 1; count < n; count++) {
				pyramidArray[count - 1] = patterObject.space(count, n) + patterObject.numbers(count, n);
			}
			return pyramidArray;
		} 
		/*
		 * Catching the Negative Array Size Exception
		 */
		catch (NegativeArraySizeException error) {
			System.out.println("Array Size Should be greater than zero");
			return null;
		}
	}
	public static void main(String[] args){
		/*
		 * Created an object of Pattern Class
		 */
		Pattern patternobj = new Pattern();
		int rowSize;
		Scanner scanner = new Scanner(System.in);
		/*
		 * Taking input from user the number of rows to print
		 */
		System.out.println("Enter the Number of rows");
		try{
			rowSize = scanner.nextInt();
			String pyramid[] = patternobj.wholePyramid(rowSize+1);
			/*
			 * Checking pyramid array for null value
			 */
			if (pyramid != null) {
				System.out.println("The Pyramid is :");
				for (String string : pyramid) {
					System.out.println(string);
				}
			}
		}
		/*
		 * Catching the Input mismatch exception
		 */
		catch(InputMismatchException error){
			System.out.println("Enter the correct Input");
		}
	}
}
