package dao;

import java.util.StringTokenizer;

import product.Product;

/**
 * A DAO implementation class for product
 * 
 * @author Prateek Jain
 *
 */
public class ProductDaoImpliment extends Product {

	/**
	 * Function generate a product object for each product
	 */
	public static Product generateProductObject(String line) {
		Product product = new Product();
		StringTokenizer productToken = new StringTokenizer(line, ",");
		if (productToken.countTokens() == 3) {
			product.setProductId(productToken.nextToken());
			product.setProductName(productToken.nextToken());
			product.setProductRate(Double.parseDouble(productToken.nextToken()));
		}
		return product;
	}
}