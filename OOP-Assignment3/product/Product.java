package product;
/**
 * Class is used for product to store and access its properties 
 * @author Prateek Jain
 *
 */
public class Product {

	private String id;
	private String name;
	private double rate;

	public Product() {
	}

	/**
	 * Function to set id name and rate
	 * 
	 * @param productId
	 * @param productName
	 * @param productRate
	 */
	public Product(String productId, String productName, double productRate) {
		super();
		this.id = productId;
		this.name = productName;
		this.rate = productRate;
	}

	// getters and setters
	public String getProductId() {
		return id;
	}

	public void setProductId(String productId) {
		this.id = productId;
	}

	public String getProductName() {
		return name;
	}

	public void setProductName(String productName) {
		this.name = productName;
	}

	public double getProductRate() {
		return rate;
	}

	public void setProductRate(double productRate) {
		this.rate = productRate;
	}
}