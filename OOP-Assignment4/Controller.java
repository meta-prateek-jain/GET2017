import java.util.Iterator;
import java.util.List;

import menu.Menu;
import menuItem.ActionableMenuItem;
import menuItem.MenuItem;
import action.GCDImplementation;
import action.ImplementExit;
import action.LargestDigitImplementation;
import action.RemainderImplementation;

/**
 * Apply the design of the menu discussed in the class in one of the previous
 * assignment. The aim of the exercise is to replace the SOPs in the main
 * program with the the Menu related classes discussed in the OOP Session 4
 * (Menu , MenuItem , Action , ActionableMenuItem etc. )
 * 
 * @author Prateek Jain
 *
 */
public class Controller {

	public static void main(String args[]) {
		// Create Menu.
		Menu menu = createMenu();
		// Display Menu items and Perform Action accordingly.
		displayAndPerformAction(menu);
	}

	/**
	 * Function is used to create Menu in which required menu items will be added
	 * 
	 * @return
	 */
	public static Menu createMenu() {
		Menu mainMenu = new Menu();
		List<MenuItem> parentMenuItem = mainMenu.getSubMenu();

		// Create Menu Object for Sub Menu
		MenuItem menuItem = new Menu();
		List<MenuItem> subMenuItem = ((Menu) menuItem).getSubMenu();
		menuItem.setDisplayName("1. Find Remainder");
		parentMenuItem.add(menuItem);

		/* Create Actionable Menu Item object for Sub Menu which takes input and
		 * display remainder 
		 */
		menuItem = new ActionableMenuItem(new RemainderImplementation());
		menuItem.setDisplayName("1. Give Input");
		subMenuItem.add(menuItem);

		// Create Menu Object to go back to Parent Menu
		menuItem = new Menu();
		menuItem.setParentMenu(mainMenu);
		menuItem.setDisplayName("2. Go Back to Previous Menu");
		subMenuItem.add(menuItem);

		// Create Menu Object for Sub Menu
		menuItem = new Menu();
		subMenuItem = ((Menu) menuItem).getSubMenu();
		menuItem.setDisplayName("2. Find GCD");
		parentMenuItem.add(menuItem);

		/* Create Actionable Menu Item object for Sub Menu which takes input 
		 * and display greatest common divisor
		 */
		menuItem = new ActionableMenuItem(new GCDImplementation());
		menuItem.setDisplayName("1. Give Input");
		subMenuItem.add(menuItem);

		// Create Menu Object to go back to Parent Menu
		menuItem = new Menu();
		menuItem.setParentMenu(mainMenu);
		menuItem.setDisplayName("2. Go Back to Previous Menu");
		subMenuItem.add(menuItem);

		// Create Menu Object for Sub Menu
		menuItem = new Menu();
		subMenuItem = ((Menu) menuItem).getSubMenu();
		menuItem.setDisplayName("3. Find Largest Digit");
		parentMenuItem.add(menuItem);

		/*  Create Actionable Menu Item object for Sub Menu which takes input
		 *  and display largest digit
		 */
		menuItem = new ActionableMenuItem(new LargestDigitImplementation());
		menuItem.setDisplayName("1. Give Input");
		subMenuItem.add(menuItem);

		// Create Menu Object to go back to Parent Menu
		menuItem = new Menu();
		menuItem.setParentMenu(mainMenu);
		menuItem.setDisplayName("2. Go Back to Previous Menu");
		subMenuItem.add(menuItem);

		// Create Actionable Menu Item object for Parent Menu which exit from application
		menuItem = new ActionableMenuItem(new ImplementExit());
		menuItem.setDisplayName("4. Exit");
		parentMenuItem.add(menuItem);
		return mainMenu;
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

	/**
	 * Function calls the display function to display menu items and perform
	 * action according to the choice entered
	 * 
	 * @param menu
	 */
	public static void displayAndPerformAction(Menu menu) {

		// Display the Menu items to console
		display(menu);
		System.out.print("Enter your Choice: ");
		try {
			// takes the input from console
			int choice = menu.getInput();

			// Gets the object of choice selected and return null if choice is invalid
			MenuItem menuItem = menu.getSelection(choice);
			/*
			 * if menuItem is null then print error message and ask to enter choice again 
			 * else if menuItem is an object of ActionableMenuItem then trigger its action 
			 * else if menuItem has parentMenu not equal to null then go back to previous menu 
			 * else display the menuItems of sub Menu
			 */
			if (menuItem == null) {
				System.out.println("Invalid choice. Please Try Again\n");
				displayAndPerformAction(menu);
			} else if (menuItem instanceof ActionableMenuItem) {
				((ActionableMenuItem) menuItem).triggerAction();
			} else if (menuItem.getParentMenu() != null) {
				displayAndPerformAction(menuItem.getParentMenu());
			} else {
				displayAndPerformAction((Menu) menuItem);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid choice. Please Try Again\n");
			displayAndPerformAction(menu);
		}
	}
}
