package socialNetwork.index.menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import socialNetwork.index.menuItem.MenuItem;
/**
 *  This class takes choice input from user and contains list of menuItems object
 *  which can be accessed whenever any menuItem choice is selected
 *  
 *  @author Prateek Jain
 */
public class Menu extends MenuItem{
	private List<MenuItem> subMenu = new ArrayList<>();
	private static Scanner scan = new Scanner(System.in);
	
	/**
	 * Takes Input from console
	 * @return
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public int getInput() throws ArrayIndexOutOfBoundsException {
		int choice = (subMenu.size()+1);
		try{
			choice = scan.nextInt();
		}catch(InputMismatchException e){
			scan.next();
		}
		return choice;
	}
	public List<MenuItem> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<MenuItem> subMenu) {
		this.subMenu = subMenu;
	}
	
	/**
	 * Return MenuItem object whenever any valid choice is made
	 * @param choice
	 * @return
	 */
	public MenuItem getSelection(int choice){
		MenuItem menuItem = null;
		/*
		 * if choice is greater than menuItem list size then return null
		 * else return menuItem object
		 */
		if(choice <= subMenu.size()){
			menuItem = subMenu.get(choice-1);
			System.out.println("The Selected Option is : "+menuItem.getDisplayName());
		}
		return menuItem;
	}
}