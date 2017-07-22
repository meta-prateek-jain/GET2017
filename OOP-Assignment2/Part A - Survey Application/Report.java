import java.io.BufferedReader;
import java.io.*;

/**
 * This class has two functions displayReport(to display the report) and clearReport(to clear the report)
 * @author Prateek Jain
 * Dated :- 21/07/2017
 *
 */
public class Report {
	Survey survey = new Survey();

	/**
	 * function Clear the Report-A and Report-B
	 * 
	 * @throws IOException
	 */
	public void clearReport() throws IOException {
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src/Documents/Report-A.txt")));
		PrintWriter pw1 = new PrintWriter(new BufferedWriter(new FileWriter("src/Documents/Report-B.txt")));
		pw.close();
		pw1.close();
		for (int i = 0; i < 999999999; i++); // Wait for some time
	}

	/**
	 * Function Display the report
	 * 
	 * @param filepath	Path of the file
	 * @throws FileNotFoundException
	 */
	public void displayReport(String filepath) throws FileNotFoundException {
		try {
			// Open the file
			BufferedReader file = new BufferedReader(new FileReader(filepath));
			String report;
			/*
			 * Loop continue till report is not equal to null
			 */
			while ((report = file.readLine()) != null) {
				System.out.println(report);
			}
			survey.showMenu();
			file.close();
		} catch (IOException e) {
			System.out.println("\nERROR : File not Found !!!");
		}
	}
}
