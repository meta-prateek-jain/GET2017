/**
 * This class is used to display on screen
 * 
 * @author Prateek Jain
 *
 */
public class Display {
	private String outputString = "";

	/**
	 * This Constructor is used to intialize outputString and display
	 * 
	 * @param value
	 */
	public Display(String value) {
		// check the value and append to previous value in outputString
		outputString += value;
		// until operator equals('=') is pressed
		outputString = value;
	}

	public Display(Double value) {
		outputString = value;
	}
}
