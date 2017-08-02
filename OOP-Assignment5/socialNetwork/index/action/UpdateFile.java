package socialNetwork.index.action;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import socialNetwork.connection.Connection;
import socialNetwork.entity.Entity;
import socialNetwork.entity.Organization;
import socialNetwork.entity.Person;
import socialNetwork.graph.Graph;
import socialNetwork.util.FileUtility;
/**
 * Class is used to update data files 
 * @author Prateek Jain
 *
 */
public class UpdateFile {
	public static void writeEntityDetailsToFile(Graph<Entity> graph, Connection connection) {
		String entityDetails = "";
		Set<String> entityId = graph.getNodesId();
		//loop continue till end of entity list
		for (String id : entityId) {
			/*
			 * if entity is of type person then add its details
			 * else add organization details
			 */
			if ("person".equalsIgnoreCase(graph.getNodeById(id).getType())) {
				Person person = (Person) graph.getNodeById(id);
				entityDetails += person.getId() + "," + person.getName() + ","
						+ person.getPassword() + "," + person.getAge() + "," + person.getType() + "\n";
			} else {
				Organization organisation = (Organization) graph.getNodeById(id);
				entityDetails += organisation.getId() + ","
						+ organisation.getName() + ","
						+ organisation.getPassword() + ","
						+ organisation.getCategory() + ","
						+ organisation.getType() + "\n";

			}
		}
		try {
			new FileUtility().write(entityDetails, "src/socialNetwork/fileStore/Users.txt");
		} catch (IOException e) {
			System.out.println("Error occured while updating database. Exiting the Application");
			System.exit(0);
		}
	}

	/**
	 * writes the update into Connection file
	 * 
	 * @param graph
	 * @param connection
	 */
	public static void writeConnectionDetailsToFile(Graph<Entity> graph, Connection connection) {
		String connectionDetails = "";
		Set<String> entityId = connection.getConnectionIdSet();
		//loop continue till end of entity list
		for (String id : entityId) {
			List<String> connectionIdList = connection.getConnectionList(id);
			connectionDetails += id + ",";
			//loop continue till end of connection list
			for (String connectionId : connectionIdList) {
				connectionDetails += connectionId + ";";
			}
			connectionDetails += "\n";
		}
		try {
			new FileUtility().write(connectionDetails,"src/socialNetwork/fileStore/Connections.txt");
		} catch (IOException e) {
			System.out.println("Error occured while updating database. Exiting the Application");
			System.exit(0);
		}
	}
}