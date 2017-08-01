import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class for part B problem in which we have to sort the given questions in the file
 * 
 * @author Prateek Jain
 *
 */
public class SortQuestions {
	public static void main(String[] args) {
		Questions question = new Questions();
		String questionList[][] = question.read("src/Documents/Questions.txt");
		int loop;
		// Create a list of Questions
		List<Questions> list = new ArrayList<Questions>();
		for (loop = 0; loop < questionList.length; loop++) {
			list.add(new Questions(questionList[loop][0]));
		}
		System.out.println("Questions list Unsorted");
		for (loop = 0; loop < list.size(); loop++) {
			System.out.println(list.get(loop));
		}
		// Collections.sort method is sorting the elements of List in ascending order.
		Collections.sort(list);
		System.out.println("\n\nQuestions list sorted");
		for (loop = 0; loop < list.size(); loop++) {
			System.out.println(list.get(loop));
		}
	}
}
