package socialNetwork.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import socialNetwork.entity.Entity;
import socialNetwork.graph.Graph;
import socialNetwork.util.FileUtility;
/**
 * A test class for Social Network
 * @author Prateek Jain
 *
 */
public class ApplicationTest {
	/**
	 * Test case to check file reading
	 * @throws IOException 
	 */
	@Test (expected = IOException.class)
	public void fileNotFoundTest() throws IOException{
		String line="src/Users.txt";
		new FileUtility().read(line);
	}
	/**
	 * Test case to check Entity id
	 * @throws IOException
	 */
	@Test
	public void checkEntityIdTest() throws IOException{
		assertFalse(new Graph<Object>().isValidNodeId("100")); 
	}
	@Test
	public void checkEntityPasswordTest() throws IOException{
		assertTrue(new Graph<Entity>().getNodeById("123").getPassword().equals("abc"));
	}
	
}
