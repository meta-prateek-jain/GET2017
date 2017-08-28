package socialNetwork.graph;

import java.util.HashMap;
import java.util.Set;
/**
 * Interface for each entity implemented by graph
 * 
 * @author Prateek Jain
 *
 * @param <E>
 */
public interface Node<E> {
	/**
	 * Adding Node into Map
	 * @param id
	 * @param entity
	 */
	public void addNode(String id, E entity);
	/**
	 * Removing Node From Map
	 * @param id
	 */
	public void removeNodeById(String id);
	/**
	 * Get Node using id
	 * @param id
	 * @return
	 */
	public E getNodeById(String id);
	/**
	 * Get map of all Nodes
	 * @return
	 */
	public HashMap<String, E> getNodeHashMap();
	/**
	 * Check Node for Validation
	 * @param id
	 * @return
	 */
	public boolean isValidNodeId(String id);
	/**
	 * Get id of all nodes
	 * @return
	 */
	public Set<String> getNodesId();
}
