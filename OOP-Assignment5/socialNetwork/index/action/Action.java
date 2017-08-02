package socialNetwork.index.action;

import socialNetwork.connection.Connection;
import socialNetwork.entity.Entity;
import socialNetwork.graph.Graph;
/**
 * Action interface is implemented by individual action classes to perform action whenever triggered
 * 
 * @author Prateek Jain
 *
 */
public interface Action {
	public void performAction(Graph<Entity> graph, Connection connection);
}
