package socialNetwork.index;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import socialNetwork.connection.Connection;
import socialNetwork.graph.Graph;
import socialNetwork.index.action.ExitApplication;
import socialNetwork.index.action.SignIn;
import socialNetwork.index.action.SignUp;
import socialNetwork.index.menu.Menu;
import socialNetwork.index.menuItem.ActionableMenuItem;
import socialNetwork.index.menuItem.MenuItem;
/**
 * This was an interactive session and the aim was to define , scope and design a solution for a Social Network. The Class Identified the key classes which are : 
 *
 *Graph 
 *Node
 *Connection
 *Social Network
 *Entity
 *Person/User
 *Organization/Collage
 *Record
 *
 * 
 * @author Prateek Jain
 *
 */
public class SocialNetwork {

	public static void main(String[] args) {
		// Create Menu.
		Menu menu = createMenu();
		// Display Menu items and Perform Action accordingly.
		displayAndPerformAction(menu);
	}

	public static Menu createMenu() {
		Menu mainMenu = new Menu();
		List<MenuItem> parentMenuItem = mainMenu.getSubMenu();

		// Create Actionable Menu Item object for Menu
		MenuItem menuItem = new ActionableMenuItem(new SignIn());
		menuItem.setDisplayName("1. SIGN IN");
		parentMenuItem.add(menuItem);

		// Create Actionable Menu Item object for Menu
		menuItem = new ActionableMenuItem(new SignUp());
		menuItem.setDisplayName("2. SIGN UP");
		parentMenuItem.add(menuItem);

		// Create Actionable Menu Item object for Menu
		menuItem = new ActionableMenuItem(new ExitApplication());
		menuItem.setDisplayName("3. Exit");
		parentMenuItem.add(menuItem);
		return mainMenu;
	}

	/**
	 * Function calls the display function to display menu items and perform
	 * action according to the choice entered
	 * 
	 * @param menu
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void displayAndPerformAction(Menu menu) {
		// Display the Menu items to console
		display(menu);
		System.out.println("Enter your Choice: ");
		try {
			Connection connection = new Connection();
			Graph graph = new Graph();
			
			// takes the input from console
			int choice = menu.getInput();

			// Gets the object of choice selected and return null if choice is
			// invalid
			MenuItem menuItem = menu.getSelection(choice);
			/*
			 * if menuItem is null then print error message and ask to enter choice again
			 *  else if menuItem is an object of ActionableMenuItem then trigger its action
			 */
			if (menuItem == null) {
				System.out.println("Invalid choice. Please Try Again\n");
				displayAndPerformAction(menu);
			} else if (menuItem instanceof ActionableMenuItem) {
				((ActionableMenuItem) menuItem).triggerAction(graph, connection);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid choice. Please Try Again\n");
			displayAndPerformAction(menu);
		} catch (IOException e) {
			System.out.println("Error Occured. Exiting from Application");
			System.exit(0);
		}
	}

	/**
	 * Function display the Menu items to console
	 * 
	 * @param menu
	 */
	public static void display(Menu menu) {
		Iterator<MenuItem> iterator = menu.getSubMenu().iterator();

		// loop continue until all menu Items displayed
		while (iterator.hasNext()) {
			System.out.println("\n" + iterator.next().getDisplayName());
		}
	}

}
