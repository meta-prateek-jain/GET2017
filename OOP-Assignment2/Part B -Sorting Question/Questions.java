import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class Questions has two methods read(read file & split text by ',' and return list ) 
 * and input(takes questions list as argument and answers from console and store answers to Report-B)
 * 
 * @author Prateek Jain
 *
 */
public class Questions implements Comparable<Questions>{
	static BufferedReader readAnswer = new BufferedReader(new InputStreamReader(System.in));
	String string;
	//Constructor;
	public Questions(String string) {
		this.string = string;
	}
	//Used to print questions in main()
	public String toString()
    {
        return this.string;
    }
	public Questions() {}
	/**
	 * Method read file is used to access file contents
	 * 
	 * @param filePath path of file
	 * @return array of string containing file contents split by ','
	 */
	public String[][] read(String filePath) {
		String text[][] = new String[5][];
		int index = 0;
		try {
			// Read the file from filePath
			FileInputStream fstream = new FileInputStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String str = "";
			// Read File Line By Line
			while ((str = br.readLine()) != null) {
				text[index++] = str.split(",");
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Error: file not found");
		}
		return text;
	}

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
				writeToFile("Participant" + " " + user + "," + answer, "src/Documents/Report-B.txt");
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
				writeToFile("," + answer, "src/Documents/Report-B.txt");
			} else if ("(Type)Text".equals(question[index][1])) {
				String answer = readAnswer.readLine();
				writeToFile("," + answer, "src/Documents/Report-B.txt");
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
				writeToFile("," + Long.toString(answer), "src/Documents/Report-B.txt");
			}
		}
		writeToFile("-1", "src/Documents/Report-B.txt");
	}

	/**
	 * Function is used to write the text into file at filePath
	 * 
	 * @param text
	 * @param filePath
	 */
	public void writeToFile(String text, String filePath) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath), true));
			if (text.equals("-1")) {
				bw.newLine();
			} else {
				bw.write(text);
			}
			bw.close();
		} catch (IOException ie) {
			System.out.println("Error: File not found");
		}
	}
	@Override
	public int compareTo(Questions questions) {
		return string.compareTo(questions.string);
	}
}
