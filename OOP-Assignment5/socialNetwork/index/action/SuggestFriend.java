package socialNetwork.index.action;

import java.util.List;
import java.util.Scanner;

import socialNetwork.connection.Connection;
import socialNetwork.entity.Entity;
import socialNetwork.graph.Graph;
/**
 * Class is used to suggest friend to entity
 * 
 * @author Prateek Jain
 *
 */
public class SuggestFriend {
	private static Scanner scan;

	/**
	 * Suggest friends to the connection
	 * 
	 * @param graph
	 * @param connection
	 * @param personId
	 */
	public void suggestFriend(Graph<Entity> graph, Connection connection, String personId) {
		scan = new Scanner(System.in);
		System.out.println("Enter friend Id  who do you want to suggest friends");
		String friendId = scan.nextLine();
		
		/*
		 * if  Person entered his own Id then print message
		 * else if id is valid then suggest friend
		 * else error message
		 */
		if (graph.getNodeById(personId).equals(graph.getNodeById(friendId))) {
			System.out.println("Its your Id");
		}else if (graph.isValidNodeId(friendId)) {
			List<String> friendsConnection = connection.getConnectionList(friendId);
			/*
			 * if person is not a connection with friend whom he is suggesting then print message
			 * else suggest friend
			 */
			if (friendsConnection == null || !friendsConnection.contains(personId)) {
				System.out.println("--You have to become "
						+ graph.getNodeById(friendId).getName()
						+ "'s friend to suggest friend----------\n");
			} else {
				for (String id : connection.getConnectionList(personId)) {
					if (!friendsConnection.contains(id) && !friendId.equals(id)) {
						System.out.println("Person id- " + id + "\t Name: "+ graph.getNodeById(id).getName());
					}
				}
			}
		} else {
			System.out.println("------Enter valid Node Id------\n");
		}
	}
}
