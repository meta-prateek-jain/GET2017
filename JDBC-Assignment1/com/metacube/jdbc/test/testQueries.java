/**
 * 
 */
package com.metacube.jdbc.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.metacube.jdbc.model.Title;
import com.metacube.jdbc.util.Helper;
import com.metacube.jdbc.util.MySQlConnection;

/**
 * Test class to check queries are correct or not
 * 
 * @author Prateek Jain
 *
 */
public class testQueries {
	private Helper helper;
	/**
	 * Method is used to set up the class object before start testing
	 */
	@Before
	public void setUp() {
		helper = Helper.getInstance();
	}

	/**
	 * Test method to check connection established or not
	 */
	@Test
	public void testConnectionEstablish() {
		assertNotNull(MySQlConnection.establish());
	}
	/**
	 * Test method to check books fetch method for valid author name
	 * 
	 * @throws SQLException 
	 */
	@Test
	public void testFetchMethodWhenValid() throws SQLException {
		List<Title> titlesList = helper.fetchBooksWrittenByAuthor("henry");
		String actualResult = "";
		// loop continue till end of list
		for (Title title : titlesList) {
			actualResult += title.getName();
		}
		assertEquals("Physics", actualResult);
	}

	/**
	 * Test method to check books fetch method for wrong author name
	 * 
	 * @throws SQLException 
	 */
	@Test
	public void testFetchBooksMethodWhenInvalid() throws SQLException {
		List<Title> titlesList = helper.fetchBooksWrittenByAuthor("example");
		String actualResult = "";
		// loop continue till end of list
		for (Title title : titlesList) {
			actualResult += title.getName();
		}
		assertNotEquals("Physics", actualResult);
	}

	/**
	 * Test method to check book issued when book name is valid
	 *
	 * @throws SQLException 
	 */
	@Test
	public void testIsBookIssuedWhenValid() throws SQLException {
		assertEquals(0, helper.isBookIssued("Cooking With Computers"));
	}

	/**
	 * Test method to check book issued when book name is Invalid
	 *
	 * @throws SQLException 
	 */
	@Test
	public void testIsBookIssuedWhenInvalid() throws SQLException {
		assertEquals(-1, helper.isBookIssued("example"));
	}
	/**
	 * Test method to check book deleted or not which are not issued since last year
	 * 
	 * @throws SQLException 
	 */
	@Test
	public void testDeleteBooksNotIssuedSinceLastYear() throws SQLException {
		assertEquals(0, helper.deleteBooksNotIssuedSinceLastYear());
	}

}
