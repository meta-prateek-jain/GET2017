package socialNetwork.index.action;

import socialNetwork.connection.Connection;
import socialNetwork.entity.Entity;
import socialNetwork.graph.Graph;

/**
 * Class implements Action Interface and terminates the Application when its function called
 * after updating data files
 * 
 * @author Prateek Jain
 *
 */
public class ExitApplication implements Action{
	@Override
	public void performAction(Graph<Entity> graph, Connection connection) {
		UpdateFile.writeEntityDetailsToFile(graph, connection);
		UpdateFile.writeConnectionDetailsToFile(graph,connection);
		System.exit(0);
	}

}
