package com.metacube.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.metacube.jdbc.model.Title;

/**
 * Helper class contains all the queries, execute them and return the result of queries
 * 
 * @author Prateek Jain
 *
 */
public class Helper {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private static Helper helper = null;
	/**
	 * Constructor to initialize the variables
	 */
	private Helper() {
		connection = MySQlConnection.establish();
	}
	/**
	 * method is used to make the class singleton
	 * 
	 * @return
	 * 		object of this class
	 */
	public static Helper getInstance() {
		// if helper object is null then continue
		if(helper == null) {
			// synchronized the method block
			synchronized (Helper.class) {
				// double check the null condition
				if(helper == null) {
					helper = new Helper();
				}
			}
		}
		return helper;
	}
	/**
	 * Method is used to get the book titles written by author
	 * 
	 * @param name
	 * 		name of the author
	 * @return
	 * 		list of the titles
	 * @throws SQLException
	 */
	public List<Title> fetchBooksWrittenByAuthor(String name) throws SQLException {
		List<Title> titlesList = new ArrayList<Title>();
		String query = "SELECT titles.name AS 'Title'"
				+ " FROM authors"
				+ " JOIN titles ON titles.id = "
				+ " (SELECT ta.title_id FROM title_author ta  WHERE ta.author_id = authors.id) "
				+ "WHERE LOWER(authors.name) = LOWER(?);";
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, name);
			ResultSet resultSet = statement.executeQuery();
			// loop continue till end of the rows reached
			while (resultSet.next()) {
				Title title = new Title();
				title.setName(resultSet.getString(1));
				titlesList.add(title);
			}
		} catch (SQLException sqle) {
			System.err.print("Error in transaction");
		} finally {
			// if statement object is not null then close it
			if (statement != null) {
				statement.close();
			}
		}
		return titlesList;
	}

	/**
	 * Method is used to check whether book can be issued or not by existing member
	 * 
	 * @param name
	 * 		name of the book
	 * @return
	 * 		flag value if -1 then book is not available in library else if 0 then book can't be issued else book can be issued
	 * @throws SQLException
	 */
	public int isBookIssued(String name) throws SQLException {
		int flag = -1;
		String query = "SELECT titles.id"
				+ " FROM titles"
				+ " WHERE LOWER(titles.name) = LOWER(?);";
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, name);
			ResultSet resultSet = statement.executeQuery();
			// if result set has data then continue
			if (resultSet.next()) {
				flag = 0;
				query = "SELECT count(1)"
						+ " FROM titles"
						+ " JOIN book_issue bi ON bi.accession_no IN"
						+ " (SELECT books.accession_no FROM books  WHERE books.title_id = titles.id)"
						+ " WHERE LOWER(titles.name) = LOWER(?);";
				statement = connection.prepareStatement(query);
				statement.setString(1, name);
				resultSet = statement.executeQuery();
				resultSet.absolute(1);
				int issueCount = resultSet.getInt(1);
				// if Issue count is greater than zero then continue
				if(issueCount > 0) {
					String query1 = "SELECT count(1)"
							+ " FROM titles"
							+ " JOIN book_return br ON br.accession_no IN"
							+ " (SELECT books.accession_no FROM books  WHERE books.title_id = titles.id)"
							+ " WHERE LOWER(titles.name) = LOWER(?);";
					statement = connection.prepareStatement(query1);
					statement.setString(1, name);
					resultSet = statement.executeQuery();
					resultSet.absolute(1);
					// if issueCount is greater than returnCount then set flag equal to 1
					if (issueCount > resultSet.getInt(1)) {
						flag = 1;
					}
				}
			}
		} catch (SQLException sqle) {
			System.err.print("Error in transaction");
		} finally {
			// if statement object is not null then close it
			if (statement != null) {
				statement.close();
			}
		}
		return flag;
	}

	/**
	 * Method is used to delete the books which are not issued since last year
	 *
	 * @return
	 * 		number of rows deleted
	 * @throws SQLException
	 */
	public int deleteBooksNotIssuedSinceLastYear() throws SQLException {
		String query = "DELETE FROM books WHERE books.accession_no NOT IN "
				+ "(SELECT accession_no FROM book_issue WHERE TIMESTAMPDIFF(YEAR, issue_date, NOW()) < 1 );";
		int rowsAffected = 0;
		try {
			statement = connection.prepareStatement(query);
			rowsAffected = statement.executeUpdate();
		} catch (SQLException sqle) {
			System.err.println("Error in transaction");
		} finally {
			// if statement object is not null then close it
			if (statement != null) {
				statement.close();
			}
		}
		return rowsAffected;
	}
}
