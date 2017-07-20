import java.util.ArrayList;

/**
 * 
 * @author Preeti Kumawat
 * Date: 20-07-2017
 * Class Name: Calculator
 *
 */
public class Layout {
	// default size of calculator is 4 * 4
	private int numberOfRows = 4; 
	private int numberOfColumns = 4;
	private ArrayList<Button> buttonList;

	public Layout getLayout() {
		/*
		 * get layout of calculator in case of GUI This helps to know number of
		 * rows and columns in calculator along with buttons available at
		 * particular position
		 */
		return this;
	}

	public void setLayout(int numberOfRows, int numberOfColumns) {
		/*
		 * set a layout for calculator in case of GUI here buttons can be set
		 */
		Button button = new Button();
		button.setButtonPosition();
	}

	/**
	 * Function to get number of rows
	 * 
	 * @return number of rows
	 */
	public int getNumberOfRows() {

		return numberOfRows;
	}

	/**
	 * Function to get number of columns
	 * 
	 * @return number of columns
	 */
	public int getNumberOfColumns() {
		return numberOfColumns;
	}

	/**
	 * This methods helps to find button at a particular location
	 * 
	 * @param row
	 * @param column
	 * @return Button object
	 */
	public Button getButtonAt(int row, int column) {
		Button button = new Button();
		return button;
	}
}
