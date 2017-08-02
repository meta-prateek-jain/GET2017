package socialNetwork.index.menuItem;

import socialNetwork.connection.Connection;
import socialNetwork.entity.Entity;
import socialNetwork.graph.Graph;
import socialNetwork.index.action.Action;

/**
 * This class is used to trigger the menuItem object action whenever that menuItem choice is made
 * 
 * @author Prateek Jain
 *
 */
public class ActionableMenuItem extends MenuItem{
	private Action action;
	
	public ActionableMenuItem(Action action){
		this.action = action;
	}
	
	/**
	 * Trigger the MenuItem object action
	 */
	public void triggerAction(Graph<Entity> graph, Connection connection) {
		this.action.performAction(graph, connection);
	}
}
