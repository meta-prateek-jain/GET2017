import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Setup Read around 5-7 Questions ( of type Single Select, Multiple Select,
 * Text, Number), available options from text file.
 *
 * User Input
 *
 * Ask Participant to fill the survey. Survey will have number of questions.
 * Participant will answer question one by one. Single, Multiple choice question
 * will have validation to choose answer from available options only. All
 * questions are mandatory to answer.
 *
 * Output Reports: System should be able to generate report that will display
 * percentage distribution of participants’ choice for single select question
 * only. System should be able to print all the questions and respective answer
 * given by Participants.
 *
 * @author Prateek Jain Dated:- 21/07/2017
 */
public class Survey {
	Scanner scan = new Scanner(System.in);

	/**
	 * Function displays the menu
	 * 
	 * @throws IOException
	 */
	public void showMenu() throws IOException {
		System.out.print("1 : Give Feedback\n2 : Display Report A\n3 : Display Report B\n4 : Exit\n\nYour Choice : ");
		AddFeedback feedback = new AddFeedback();
		Report report = new Report();
		try {
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				feedback.addFeedback(); // calls addFeedback function of Addfeedback
				break;
			case 2:
				System.out.println("Overall Rating of service ?,(Type) Single Select, Options - (1/2/3/4/5)");
				// calls displayReport function of Report
				report.displayReport("src/Documents/Report-A.txt");
				break;
			case 3:
				// calls displayReport function of Report
				report.displayReport("src/Documents/Report-B.txt");
				break;
			case 4:
				System.exit(1);
				break;
			default:
				System.out.println("\nInvalid Choice !");
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input");
		}
	}

	public static void main(String[] args) throws IOException {
		Survey survey = new Survey();
		survey.showMenu();
	}
}
