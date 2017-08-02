package socialNetwork.connection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import socialNetwork.util.FileUtility;
/**
 * Class has connection details of an entity
 * 
 * @author Prateek Jain
 *
 */
public class Connection {
	private List<String> fileInformation;
	private List<String> list;
	private Map<String, List<String>> map = new HashMap<String, List<String>>();
	
	/**
	 * Initialize the connection and its variables 
	 * @throws IOException
	 */
	public Connection() throws IOException {
		initializeConnectionList();
	}
	/**
	 * Initialize the Connection
	 * @throws IOException 
	 */
	private void initializeConnectionList() throws IOException {
		fileInformation = new FileUtility().read("src/socialNetwork/fileStore/Connections.txt");
		//loop continue till end of file
		for (String string : fileInformation) {
			list = new ArrayList<String>();
			String[] details = string.split(",");
			//check if data is available proper not
			if (details.length > 1) {
				String[] connectionIds = details[1].split(";");
				for (int index = 0; index < connectionIds.length; index++) {
					list.add(connectionIds[index]);
				}
				map.put(details[0], list);
			}
		}
	}
	/**
	 * Remove connection from map
	 * @param Id
	 * @param connectionId
	 */
	public void removeConnection(String id, String connectionId) {
		map.get(id).remove(connectionId);
	}
	/**
	 * method add connection to map
	 * @param entityId
	 * @param connectionId
	 */
	public void addConnection(String entityId, String connectionId) {
		/*
		 * if id is not present in list then add into its connection list
		 * else id is present in list then add into its connection list
		 */
		if (!map.containsKey(entityId)) {
			list = new ArrayList<String>();
			list.add(connectionId);
			map.put(entityId, list);
		} else {
			list = getConnectionList(entityId);
			list.add(connectionId);
			map.put(entityId, list);
		}
	}
	/**
	 * Method is used to return all connection list of particular entity id
	 * @param entityId
	 * @return
	 */
	public List<String> getConnectionList(String entityId) {
		return map.get(entityId);
	}
	/**
	 * validate entity id is present or not
	 * @param id
	 * @param entityId
	 * @return
	 */
	public boolean isEntityIdPresent(String id, String entityId) {
		//if id has connection with that entity return true
		if (getConnectionList(id).contains(entityId)) {
			return true;
		}
		return false;
	}

	/**
	 * get all connection map
	 * @return the whole connection Map
	 */
	public Set<String> getConnectionIdSet() {
		return map.keySet();
	}
}
