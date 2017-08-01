import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import util.FileHandling;
/**
 * Class takes feedback from user and store answers in Report-B and 
 * percentage distribution of participants’ choice for single select question only in Report-A
 * @author Prateek Jain
 *
 */
public class AddFeedback {
	/**
	 * Method is used to takes feedback
	 * 
	 * @throws InputMismatchException
	 * @throws IOException
	 */
	public void addFeedback() throws InputMismatchException, IOException {
		FileHandling fileHandling = new FileHandling();
		Survey survey = new Survey();
		Scanner scan = new Scanner(System.in);
		String questionList[][] = {};
		int noOfUsers;
		Report report = new Report();
		// Clear the Report-A and Report-B
		report.clearReport();
		System.out.println("Enter number of users to participate in survey :- ");
		try {
			noOfUsers = scan.nextInt();
			if (noOfUsers < 1) {
				System.out.println("Number of users should be greater than zero");
			}
			// Takes the list of questions from Questions.txt
			questionList = fileHandling.read("src/Documents/Questions.txt");
			// loop iterate noOfUsers times to take their feedback
			for (int index = 0; index < noOfUsers; index++) {
				new Questions().input(index + 1, questionList);
			}
			questionList = fileHandling.read("src/Documents/Report-B.txt");
			int percentage[] = new int[6];
			for (int index = 0; index < noOfUsers; index++) {
				percentage[Integer.parseInt(questionList[index][1])] += 1;
			}
			// Calculates percentage distribution of choices and store result in Report-A
			for (int index = 1; index < 6; index++) {
				if (percentage[index] != 0) {
					percentage[index] = (int) ((percentage[index] / (float) noOfUsers) * 100);
					fileHandling.writeToFile(index + " - " + percentage[index] + "%", "src/Documents/Report-A.txt");
					fileHandling.writeToFile("-1", "src/Documents/Report-A.txt");
				} else {
					fileHandling.writeToFile(index + " - " + percentage[index] + "%", "src/Documents/Report-A.txt");
					fileHandling.writeToFile("-1", "src/Documents/Report-A.txt");
				}
			}
			survey.showMenu();
			scan.close();
		} catch (NumberFormatException nf) {
			System.out.println("Invalid input");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
