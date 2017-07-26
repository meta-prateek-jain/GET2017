package util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Class to write String to a file
 * @author Prateek Jain
 *
 */
public class WriteFile {
	
	/**
	 * Method to write a string to a file
	 * @param stringToWrite
	 * @param destinationFile
	 */
	
	public static void write(String stringToWrite,String destinationFile) {
		int fileCounter=0;
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(destinationFile)));
			writer.write(stringToWrite);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Billing File Not Found or UnAccesible:Printing to a different File: New"+(fileCounter++)+destinationFile);
			WriteFile.write(stringToWrite,"New"+(fileCounter++)+destinationFile);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}