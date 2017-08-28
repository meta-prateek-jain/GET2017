package socialNetwork.index.action;

import java.util.Scanner;

import socialNetwork.connection.Connection;
import socialNetwork.entity.Entity;
import socialNetwork.graph.Graph;

/**
 * Class is used to sign in as Person or Organization
 * 
 * @author Prateek Jain
 *
 */
public class SignIn implements Action {
	private static int choice;
	private static boolean logout;
	private static Scanner scan = new Scanner(System.in);

	@Override
	/**
	 * Method checks id and password and call login function according to its
	 * type
	 */
	public void performAction(Graph<Entity> graph, Connection connection) {
		scan = new Scanner(System.in);
		System.out.println("Enter your id : ");
		String entityId = scan.nextLine();

		// loop checks validation of Id
		while (!graph.isValidNodeId(entityId)) {
			System.out.println("Enter correct Id : ");
			entityId = scan.nextLine();
		}

		System.out.println("Enter password");
		String password = scan.nextLine();

		// check validation of password
		while (!graph.getNodeById(entityId).getPassword().equals(password)) {
			System.out.println("Enter correct password ");
			password = scan.nextLine();
		}
		System.out.println("Welcome to the Social Network " + ((Entity) graph.getNodeById(entityId)).getName() + "\n");
		/*
		 * if entity type is person then call personLogin function else call
		 * organizationLogin function
		 */
		if (("Person").equalsIgnoreCase(((Entity) graph.getNodeById(entityId)).getType())) {
			personLogin(graph, connection, entityId);
		} else {
			organizationLogin(graph, connection, entityId);
		}
	}

	/**
	 * Display Option related to Organization entity and perform them by calling
	 * that operation function
	 * 
	 * @param graph
	 * @param connection
	 * @param entityId
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void organizationLogin(Graph graph, Connection connection, String entityId) {
		logout = false;
		//Loop continue till valid choice is entered
		do {
			System.out.println("1.Edit Profile\n2.Post\n3.Followers\n4.Logout");
			//loop continue till correct value is enter
			while (!scan.hasNextInt()) {
				System.out.println("Enter Integer Value:");
				scan.nextLine();
			}
			int choice = scan.nextInt();
		
			//if entered value is other then options then print message and try again
			if(choice > 4 || choice < 1){
				System.out.println("Enter Value in the range 1 to 4");
				continue;
			}
			//perform operation according to the choice
			switch (choice) {
			case 1:
				logout = new EditProfile().editOrganizationProfile(graph, entityId);
				break;
			case 2:
				new Post().posts(graph, entityId);
				break;
			case 3:
				new Friends().friends(graph, connection, entityId);
				break;
			case 4:
				System.out.println("Are you sure : Y/N");
				if (scan.next().equalsIgnoreCase("Y")) {
					logout = true;
				}
				break;
			}
		} while (!logout);
	}
	/**
	 * Display Option related to Organization entity and perform them by calling
	 * that operation function.
	 * 
	 * @param graph
	 * @param connection
	 * @param entityId
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void personLogin(Graph graph, Connection connection, String entityId) {
		logout = false;
		//Loop continue till valid choice is entered
		do {
			System.out.println("1.Edit Profile\n2.Post\n3.Friends\n4.Search\n5.Suggest Friends\n6.Logout");
			//loop continue till correct value is enter
			while (!scan.hasNextInt()) {
				System.out.println("Enter Integer Value:");
				scan.nextLine();
			}
			choice = scan.nextInt();
			
			//if entered value is other then options then print message and try again
			if(choice > 6 || choice < 1){
				System.out.println("Enter Value in the range 1 to 4");
				continue;
			}
			
			//perform operation according to the choice
			switch (choice) {
			case 1:
				logout = new EditProfile().editPersonProfile(graph, entityId);
				break;
			case 2:
				new Post().posts(graph, entityId);
				break;
			case 3:
				new Friends().friends(graph, connection, entityId);
				break;
			case 4:
				new Search().search(graph, entityId);
				break;
			case 5:
				new SuggestFriend().suggestFriend(graph, connection, entityId);
				break;
			case 6:
				System.out.println("Are you sure : Y/N");
				//if choice is y then logout
				if (scan.next().equalsIgnoreCase("Y")) {
					logout = true;
				}
				break;
			default:
				System.out.println("Enter Correct Choice : ");
			}
		} while (!logout);
	}
}
