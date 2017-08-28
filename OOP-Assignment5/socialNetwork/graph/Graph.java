package socialNetwork.graph;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import socialNetwork.entity.Organization;
import socialNetwork.entity.Person;
import socialNetwork.util.FileUtility;

/**
 * Class implements Node Interface and has details of entity and its map
 * which can be used for validation of entity id
 * 
 * @author Prateek Jain
 *
 * @param <E>
 */
public class Graph<E> implements Node<E> {
	private List<String> entityList;
	private HashMap<String, E> nodesHashMap = new HashMap<String, E>();
	/**
	 * Initialize the entity Map
	 * 
	 * @throws IOException
	 */
	public Graph() throws IOException {
		initializeEntity();
	}
	
	/**
	 * Map of Entity is initialize which can be used to search an entity by its id 
	 * and validate entity id
	 *   
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	private void initializeEntity() throws IOException {
		entityList = new FileUtility().read("src/socialNetwork/fileStore/Users.txt");
		//loop continue till entityList end
		for (String str : entityList) {
			String details[] = str.split(",");
			/*
			 * if entity is of type Organization then addNode of organization in nodesHasMap
			 * else adddNode of entity in nodesHasMap
			 */
			if ("Organization".equalsIgnoreCase(details[4])) {
				Organization organization = new Organization(details[0], details[1], details[2], details[3], details[4]);
				addNode(details[0], (E) organization);
			} else {
				Person person = new Person(details[0], details[1], details[2], Integer.parseInt(details[3]), details[4]);
				nodesHashMap.put(details[0], (E) person);
			}
		}
	}

	@Override
	public void addNode(String id, E entity) {
		nodesHashMap.put(id, entity);
	}

	@Override
	public void removeNodeById(String id) {
		nodesHashMap.remove(id);
	}

	@Override
	public E getNodeById(String id) {
		return nodesHashMap.get(id);
	}

	@Override
	public HashMap<String, E> getNodeHashMap() {
		return nodesHashMap;
	}

	@Override
	public boolean isValidNodeId(String id) {
		return nodesHashMap.containsKey(id);
	}

	@Override
	public Set<String> getNodesId() {
		return nodesHashMap.keySet();
	}
}
