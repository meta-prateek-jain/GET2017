package socialNetwork.index.action;

import java.util.Scanner;
import java.util.Set;

import socialNetwork.entity.Entity;
import socialNetwork.graph.Graph;
/**
 * Class is used to search for an entity 
 * 
 * @author Prateek Jain
 *
 */
public class Search {
	private static Scanner scan;

	/**
	 * Search entity by using name
	 * 
	 * @param graph
	 * @param entityId
	 */
	public void search(Graph<Entity> graph, String entityId) {
		scan = new Scanner(System.in);
		boolean searchresult = false;
		System.out.println("Enter name : ");
		String name = scan.nextLine();
		Set<String> entityIds = graph.getNodesId();
		//loop continues for all nodes
		for (String id : entityIds) {
			//Checking input name is present in any other node
			if (!graph.getNodeById(id).equals(graph.getNodeById(entityId))&& graph.getNodeById(id).getName().contains(name)) {
				System.out.println("Person id - " + id + " \t Name : "+ graph.getNodeById(id).getName());
				searchresult = true;
			}
		}
		//if entity not found then print message
		if (!searchresult) {
			System.out.println("No result found..!!!");
		}
	}
}
