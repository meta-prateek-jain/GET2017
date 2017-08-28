package socialNetwork.entity;

/**
 * Person class extends Entity class containing details of person
 * 
 * @author Prateek Jain
 *
 */
public class Person extends Entity {
	private int age;
	/**
	 * Initialize all variables including superclass 
	 * @param id
	 * @param name
	 * @param password
	 * @param age
	 * @param type
	 */
	public Person(String id, String name, String password, int age, String type) {
		super(id, name, password, type);
		this.age=age;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
