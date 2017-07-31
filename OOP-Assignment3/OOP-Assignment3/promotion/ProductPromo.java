package promotion;

import java.util.Map;
import java.util.StringTokenizer;

import product.Product;

/**
 * Class is used for Product Promotions to store its properties and to check
 * which promotion can be applied to order
 * 
 * @author Prateek Jain
 *
 */
public class ProductPromo {

	private String promoType;
	private String applicableProducts[];
	private double promoDiscount;
	private String promotionString;

	public ProductPromo() {
		promoType = "";
		promotionString = "";
	}

	public String getPromoType() {
		return promoType;
	}

	public void setPromoType(String promoType) {
		this.promoType = promoType;
	}

	public String[] getApplicableProducts() {
		return applicableProducts;
	}

	public void setApplicableProducts(String[] applicableProducts) {
		this.applicableProducts = applicableProducts;
	}

	public double getPromoDiscount() {
		return promoDiscount;
	}

	public void setPromoDiscount(double promoAmount) {
		this.promoDiscount = promoAmount;
	}

	/**
	 * Function checks if the product promotion is applicable on a particular
	 * product or not
	 * 
	 * @param productId
	 * @return
	 */

	public Boolean isApplicable(String productId) {
		Boolean flag = false;
		//check any promotion is available or not
		if (applicableProducts != null) {
			//loop iterate over all promotion list
			for (int iterate = 0; iterate < applicableProducts.length; iterate++) {
				//check any promotion is applicable for product or not
				if (productId.equals(applicableProducts[iterate])) {
					flag = true;
					break;
				} else {
					flag = false;
				}
			}
		}
		return flag;
	}

	/**
	 * Function to generate a ProductPromo Object in response of a line
	 * 
	 * @param line
	 * @return
	 */

	public static ProductPromo generatePromoObject(String line) {
		ProductPromo productPromo = new ProductPromo();
		StringTokenizer promoToken = new StringTokenizer(line, ",");
		// if promotion has all information then set its type & discount and applicable products list
		if (promoToken.countTokens() == 3) {
			productPromo.setPromoType(promoToken.nextToken());
			productPromo.setPromoDiscount(Double.parseDouble(promoToken.nextToken()));
			String applicableProducts[] = promoToken.nextToken().split(";");
			productPromo.setApplicableProducts(applicableProducts);
		}
		return productPromo;
	}

	/**
	 * constructor to initialize variables
	 * 
	 * @param promoType
	 * @param applicableProducts
	 * @param promoDiscount
	 */
	public ProductPromo(String promoType, String[] applicableProducts,
			double promoDiscount) {
		this.promoType = promoType;
		this.applicableProducts = applicableProducts;
		this.promoDiscount = promoDiscount;
		this.promotionString = "";
	}

	/**
	 * Generate the promotion string to be displayed for a particular product
	 * promotion
	 * 
	 * @param productsMap
	 * @return
	 */
	public String generatePromotionString(Map<String, Product> productsMap,
			Product product) {
		/*
		 * if promotion is of type fixed then add this string
		 * else if promotion is of type percentage then add this string 
		 */
		if (promoType.equals("ProductFixedAmountPromotion")) {
			promotionString = "Rs." + promoDiscount + " off on";
			promotionString += "  " + product.getProductName()+" [Code:" + product.getProductId() + "]";
		} else if (promoType.equals("ProductFixedPercentPromotion")) {
			promotionString = promoDiscount + "% off on";
			promotionString += "  "+ product.getProductName()+" [Code:"+ product.getProductId() + "]";
		}
		return (promotionString);
	}

}