
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import util.FileHandling;
/**
 * Class Questions has two methods read(read file & split text by ',' and return list ) 
 * and input(takes questions list as argument and answers from console and store answers to Report-B)
 * 
 * @author Prateek Jain
 *
 */
public class Questions {
	static BufferedReader readAnswer = new BufferedReader(new InputStreamReader(System.in));
	/**
	 * Method takes answer of question from user and store them in Report-B
	 * 
	 * @param user
	 * @param question
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void input(int user, String question[][]) throws NumberFormatException, IOException {
		for (int index = 0; index < question.length; index++) {
			for (int jindex = 0; jindex < question[index].length; jindex++) {
				System.out.println(question[index][jindex]);
			}
			/*
			 * If Question is of type Single select then take answer as input
			 * else if question is of type Multiple select then take answer as
			 * input else if question is of type text then take answer as input
			 * else if question of type number then take answer as input
			 */
			if ("(Type) Single Select".equals(question[index][1])) {
				int answer = Integer.parseInt(readAnswer.readLine());
				// Loop continues till answer is not in the range 1 to 5
				while (answer != 1 && answer != 2 && answer != 3 && answer != 4 && answer != 5) {
					System.out.print("Enter correct option from 1 to 5");
					answer = Integer.parseInt(readAnswer.readLine());
				}
				new FileHandling().writeToFile("Participant" + " " + user + "," + answer, "src/Documents/Report-B.txt");
			} else if ("(Type) Multi Select".equals(question[index][1])) {
				String answer = readAnswer.readLine();
				String options[] = answer.split("/");
				for (String string : options) {
					// Check answer is from the available options or not
					if (!"Service Quality".equalsIgnoreCase(string) && !"Communication".equalsIgnoreCase(string)
							&& !"Delivery Process".equalsIgnoreCase(string)) {
						System.out.println("Enter input from the given options and use / between two choices ");
						answer = readAnswer.readLine();
					}
				}
				new FileHandling().writeToFile("," + answer, "src/Documents/Report-B.txt");
			} else if ("(Type)Text".equals(question[index][1])) {
				String answer = readAnswer.readLine();
				new FileHandling().writeToFile("," + answer, "src/Documents/Report-B.txt");
			} else if ("(Type) Number".equals(question[index][1])) {
				long answer = Long.parseLong(readAnswer.readLine());
				if (String.valueOf(answer).contains("-")) {
					System.out.println("Enter the valid number");
					answer = Long.parseLong(readAnswer.readLine());
				}
				while (String.valueOf(answer).length() != 10) {
					System.out.print("Enter 10 digit number");
					answer = Long.parseLong(readAnswer.readLine());
				}
				new FileHandling().writeToFile("," + Long.toString(answer), "src/Documents/Report-B.txt");
			}
		}
		new FileHandling().writeToFile("-1", "src/Documents/Report-B.txt");
	}


}
