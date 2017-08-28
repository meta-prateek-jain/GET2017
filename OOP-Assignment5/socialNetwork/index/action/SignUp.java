package socialNetwork.index.action;

import java.util.Scanner;

import socialNetwork.connection.Connection;
import socialNetwork.entity.Organization;
import socialNetwork.entity.Person;
import socialNetwork.graph.Graph;
/**
 * Class is used add new Entity
 * 
 * @author Prateek Jain
 *
 */
public class SignUp implements Action {
	private static Scanner scan = new Scanner(System.in);;

	/**
	 * Method Calls function according to the type Person or organization
	 * 
	 * @param graph
	 * @param connection
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void performAction(Graph graph, Connection connection) {
		System.out.println("Enter Account Type - Person/Organization");
		String type = scan.nextLine();
		//perform operation accordin to the choice
		switch (type) {
		case "person":
		case "Person":
			addPerson(type, graph, connection);
			break;
		case "organization":
		case "Organization":
			addOrganization(type, graph, connection);
			break;
		default:
			System.out.println("Invalid Option");
		}
	}

	/**
	 *Method Add organization into the graph
	 * 
	 * @param type
	 * @param graph
	 * @param connection
	 */
	private void addOrganization(String type, Graph<Organization> graph,
			Connection connection) {
		System.out.println("Enter Organization Id:");
		String id = scan.nextLine();
		//loop continue until new unique id is entered
		while (graph.isValidNodeId(id)) {
			System.out.println("This id is already exist in social network");
			id = scan.nextLine();
		}
		String name, password;
		String category;
		System.out.println("Enter your Name:");
		name = scan.nextLine();
		System.out.println("Password");
		password = scan.nextLine();
		System.out.println("Category");
		category = scan.nextLine();
		graph.addNode(id, new Organization(id, name, password, category, type));
		System.out.println("\n--Welcome to the Social Network " + name+ "--\n");
		new SignIn().organizationLogin(graph, connection, id);

	}

	/**
	 * Function Add Person into the graph
	 * 
	 * @param type
	 * @param graph
	 * @param connection
	 */
	protected void addPerson(String type, Graph<Person> graph, Connection connection) {
		System.out.println("Enter Person Id:");
		String id = scan.nextLine();
		// if node already exist in social network
		while (graph.isValidNodeId(id)) {
			System.out.println("This id is already exist in social network");
			id = scan.nextLine();
		}
		String name, password;
		int age;
		System.out.println("Enter your Name:");
		name = scan.nextLine();
		System.out.println("Password");
		password = scan.nextLine();
		age = getValidAge();
		graph.addNode(id, new Person(id, name, password, age, type));
		System.out.println("\n--Welcome to the Social Network " + name+ "--\n");
		new SignIn().personLogin(graph, connection, id);
	}

	/**
	 * method check for age is valid or not
	 * 
	 * @return valid age
	 */
	private int getValidAge() {
		System.out.println("Age");
		int age;
		//loop continue until valid age is entered
		while (!scan.hasNextInt() || (age = scan.nextInt()) > 150 || age < 1) {
			System.out.println("Enter Correct Age:");
			scan.nextLine();
		}
		return age;
	}
}

