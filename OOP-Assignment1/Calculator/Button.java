/**
 * This class is used to set the button Position and button layout
 * 
 * @author Prateek Jain
 *
 */
public class Button {
	private String value;
	private String type;
	/**
	 * Function to get value of button
	 *  @return 
	 */
	public String getValue() {
		return value;
	}
	/**
	 * Function to set value on Button
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * Function to get type of button
	 * @return
	 */
	public String getType() {
		return type;
	}
	/**
	 * Function to set type of button
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * Function to set position such as row and column for a particular button
	 */
	public void setButtonPosition(){
		// to set button layout 
		this.setButtonLayout(2,2,2,2);
	}
	
	/**
	 * function set button layout
	 * 
	 * @param row_index
	 * @param column_index
	 * @param height
	 * @param width
	 */
	public void setButtonLayout(int row_index, int column_index, int height,int width) {

	}

	/**
	 * This will help to perform operations on buttons such as onclick event
	 */
	public void buttonEvents() {
		Calculator calculator = new Calculator();
		calculator.getInput(this.getValue());
	}
}
