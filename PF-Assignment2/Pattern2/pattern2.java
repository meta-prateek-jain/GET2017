import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 	Programming fundamental assignment 2
 * 
 * This class is used to print following pattern by modular approach 
 *         
 * 1 2 3 4 5
 *   1 2 3 4
 *     1 2 3
 *       1 2
 *         1 
 * 
 *  Dated 14/07/2017
 * @author Prateek Jain
 *	Assumption n is 1 greater than the size of pyramid need to print
 */
public class Pattern2 {
	/*
	 * This function calculates space for particular row 
	 */
	public String space(int row) {
		String space = "";										
		/*
		 * This block add spaces to string 'space'  
		 */
		for (int loop = 1; loop < row; loop++) {
				space = space + "  ";
		}
		return space;
	}
	/*
	 * This function add numbers for particular row into string and return the string 
	 */
	public String numbers(int row, int n) {
		
		String number = "";
		/*
		 * This block add numbers to string  
		 */
		for (int loop = 1; loop <= (n-row+1); loop++) {
				number = number + loop + " ";
			}
		return number;
	}
	/*
	 * This function return array of strings containing individual row as a single string element
	 */
	public String[] wholePyramid(int n) throws NegativeArraySizeException{
		Pattern2 patterObject = new Pattern2();
		try {
			String[] pyramidArray = new String[n];
			int count;
			/*
			 * This loop add value to pyramidArray by using two functions
			 */

			for (count = 1; count <= n; count++) {
				pyramidArray[count - 1] = patterObject.space(count) + patterObject.numbers(count, n);
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
		Pattern2 patternobj = new Pattern2();
		int rowSize;
		Scanner scanner = new Scanner(System.in);
		/*
		 * Taking input from user the number of rows to print
		 */
		System.out.println("Enter the Number of rows");
		try{
			rowSize = scanner.nextInt();
			String pyramid[] = patternobj.wholePyramid(rowSize);
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
