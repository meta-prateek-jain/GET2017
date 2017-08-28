package socialNetwork.index.action;

import java.util.Scanner;

import socialNetwork.connection.Connection;
import socialNetwork.entity.Entity;
import socialNetwork.graph.Graph;
/**
 * Class is used to add Connection to entity
 * 
 * @author Prateek Jain
 *
 */
public class Friends {
	private static Scanner scan = new Scanner(System.in);
	public void friends(Graph<Entity> graph, Connection connection, String userId) {
		boolean back = false;
		//loop continue till valid choice is entered 
		do {
			System.out.println("1.Add Connection\n2.Display Connections\n3.Remove Connection\n4.Back");
			//loop continue till valid input is entered
			while (!scan.hasNextInt()) {
				System.out.println("Enter Integer Value:");
				scan.nextLine();
			}
			int choice = scan.nextInt();
			
			//perform operations according to choice selected
			switch (choice) {
			case 1:
				addFriend(connection, graph, userId);
				break;
			case 2:
				display(connection, graph, userId);
				break;
			case 3:
				removeFriend(connection, graph, userId);
				break;
			case 4:
				back = true;
				break;
			default:
				System.out.println("Enter correct choice\n");
			}
		} while (!back);
	}
	/**
	 * Function to Remove friend from connection list
	 * @param connection
	 * @param graph
	 * @param id
	 */
	private void removeFriend(Connection connection, Graph<Entity> graph,String id) {
		System.out.println("Enter friend Id :");
		String entityId = scan.next();
		/*
		 *  if entity id is valid then remove friend
		 *  else error message
		 */
		if (graph.isValidNodeId(entityId)) {
			/*
			 * if connectionList of current person is not empty and connection id is present in list then remove
			 * else error message
			 */
			if (connection.getConnectionList(id) != null && connection.isEntityIdPresent(id, entityId)) {
				connection.removeConnection(id, entityId);
				System.out.println(graph.getNodeById(entityId).getName()+ " removed from your friend list\n");
			} else {
				System.out.println(graph.getNodeById(entityId).getName()+ " is not in your friend list\n");
			}
		} else {
			System.out.println("Incorrect Id\n");
		}
	}

	/**
	 * Display all the friends from connection list
	 * @param connection
	 * @param graph
	 * @param id
	 */
	private void display(Connection connection, Graph<Entity> graph,String id) {
		/*
		 * if connectionList of current entity is empty then print message
		 * else print connection id details
		 */
		if (connection.getConnectionList(id) == null || connection.getConnectionList(id).size() == 0) {
			System.out.println("You have no friends.");
		} else {
			for (String friends : connection.getConnectionList(id)) {
				System.out.println("\nFriends Id:" + friends + "  Name :"+ graph.getNodeById(friends).getName());
			}
		}
		System.out.println();
	}
	
	/**
	 * Add friend to connection list
	 * @param connection
	 * @param graph
	 * @param id
	 */
	private void addFriend(Connection connection, Graph<Entity> graph, String id) {
		System.out.println("Enter Entity Id ");
		String entityId = scan.next();
		// implementation of hash code and equals method
		/*
		 *  if current user enter his own Id then print message
		 *  else if validate that id then addConnection
		 *  else print error message
		 */
		if (graph.getNodeById(id).equals(graph.getNodeById(entityId))) {
			System.out.println("   Its your Id\n");
		}
		else if (graph.isValidNodeId(entityId)) {
			/*
			 *  if connectionList of current person  is null then add friend
			 *  else if ConnectionList  already contain that id then print message
			 */
			if (connection.getConnectionList(id) == null) {
				connection.addConnection(id, entityId);
				connection.addConnection(entityId, id);
				System.out.println("--You are now connect with "
						+ graph.getNodeById(entityId).getName()
						+ "--\n");
			}else if (connection.isEntityIdPresent(id, entityId)) {
				System.out.println("--You are already connected with "+ graph.getNodeById(entityId).getName()+ "--\n");
			}
		} else {
			System.out.println("--No person exist in social Network of id : "+ entityId + "--\n");
		}
	}
}

