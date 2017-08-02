package socialNetwork.entity;
/**
 * Organization class extends Entity class containing Details of organization
 * 
 * @author Prateek Jain
 *
 */
public class Organization extends Entity{
	private String category;
	/**
	 * Initialize all variables including superClass
	 * @param id
	 * @param name
	 * @param password
	 * @param category
	 * @param type
	 */
	public Organization(String id, String name, String password, String category , String type) {
		super(id, name, password, type);
		this.category = category;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
