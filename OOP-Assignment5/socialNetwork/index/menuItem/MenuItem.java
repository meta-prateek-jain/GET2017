package socialNetwork.index.menuItem;

import socialNetwork.index.menu.Menu;
/**
 * This is a MenuItem class which Holds the display value for an item of menu
 * and also an instance of parentMenu object
 *   
 * @author Prateek Jain
 *
 */
public abstract class MenuItem {
	private String dispayName;
	private Menu parentMenu;

	public Menu getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}

	public String getDisplayName() {
		return dispayName;
	}

	public void setDisplayName(String dispayName) {
		this.dispayName = dispayName;
	}
}
