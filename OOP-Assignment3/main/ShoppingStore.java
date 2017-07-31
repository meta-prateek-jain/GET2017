package main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import billGenerator.BillGenerator;
import orderEntry.OrderEntry;
import product.Product;
import dao.ProductDaoImpliment;
import promotion.OrderPromo;
import promotion.ProductPromo;
import util.ReadFile;
/**
 *  This application will be a console based application enabling the salesperson
 * at the store to facilitate the billing and discount process for the customer.
 * 
 * System will take 3 files as input - ProductList.csv file containing the list
 * of products available in the store. ProductPromo.csv file containing list of
 * products level discounts available. OrderPromo.csv file containing list of
 * order level discounts available in the store.
 * 
 * List of all the products and available promotions should be displayed to the
 * user. System will ask User to enter number of products that customer has to
 * buy Based on above input, the user will be asked to enter product code and
 * quantity he has to buy. After all the products have been entered, system
 * should generate the bill and display to the user after applying all the
 * applicable discounts. The product bill should be generated in a text file as
 * well.
 *
 * This class is the main class that executes the billing terminal of shopping store
 *
 * @author Prateek Jain
 * Dated: 24/07/2017
 *
 */
public class ShoppingStore {

	public static void main(String args[]) {
		ReadFile fileReader = new ReadFile();
		List<Product> productList = new ArrayList<Product>();
		List<ProductPromo> productPromoList = new ArrayList<ProductPromo>();
		List<OrderPromo> orderPromoList = new ArrayList<OrderPromo>();

		// read productList file Line by Line
		List<String> productListString = fileReader.readLineByLine(".\\src\\storeFiles\\ProductList.csv");
		System.out.println(" --------------");
		System.out.println("| Product List |");
		System.out.println(" --------------");
		System.out.println("Code  Product name   Price");

		// Generate Product object for each product
		for (String product : productListString) {
			productList.add(ProductDaoImpliment.generateProductObject(product));
			System.out.println(product);
		}

		// Generate a map to associate the product(value) with productId(key)
		Map<String, Product> productMap = new HashMap<String, Product>();
		for (Product product : productList) {
			productMap.put(product.getProductId(), product);
		}

		System.out.println();
		System.out.println();

		// read producPromotionList file Line by Line
		List<String> productPromotionString = fileReader.readLineByLine(".\\src\\storeFiles\\ProductPromo.csv");
		System.out.println(" --------------------");
		System.out.println("| Product Promotions |");
		System.out.println(" --------------------");
		System.out.println("\tType \t\t   Discount   Code");

		// generate ProductPromo Object for each Product Level Promotion
		for (String promotion : productPromotionString) {
			productPromoList.add(ProductPromo.generatePromoObject(promotion));
			System.out.println(promotion);
		}

		System.out.println();
		System.out.println();

		// read orderPromotionList file Line by Line
		List<String> orderPromotionString = fileReader.readLineByLine(".\\src\\storeFiles\\OrderPromo.csv");
		System.out.println(" --------------------");
		System.out.println("| Order Promotions |");
		System.out.println(" --------------------");

		// generate orderPromo Object for each Order Level Promotion
		for (String promotion : orderPromotionString) {
			orderPromoList.add(OrderPromo.generatePromoObject(promotion));
			System.out.println(promotion);
		}
		System.out.println();
		System.out.println();
		Scanner scannerObject = new Scanner(System.in);
		int numberOfProducts = -1;

		// loop until valid input
		while (true) {
			System.out.print("Enter number of products you want to buy : \n");
			try {
				numberOfProducts = scannerObject.nextInt();
				/*
				 * if numberofProducts is less than or equal to zero then ask
				 * for enter again
				 */
				if (numberOfProducts <= 0) {
					System.out.println("Enter positive number of products");
				} else {
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Input mismatch:Enter a numeric value only ");
				scannerObject.next();
			}
		}

		// Creating Order Entry Objects with each iteration for an order
		OrderEntry[] orderEntry = new OrderEntry[numberOfProducts];
		String productId;
		int orderQuantity;
		for (int loop = 0; loop < numberOfProducts; loop++) {
			System.out.print("Enter the product id for Product to be bought : ");
			productId = scannerObject.next();

			// Loop is used to check validation of Product id
			while (!productMap.containsKey(productId)) {
				System.out.println("Enter a valid product id");
				productId = scannerObject.next();
			}

			// loop until valid input
			while (true) {
				System.out.print("Enter the quantity for product : ");
				try {
					orderQuantity = scannerObject.nextInt();

					// if order Quantity is less than or equal to Zero then ask to enter again
					if (orderQuantity <= 0) {
						System.out.println("Enter a valid quantity");
					} else {
						break;
					}
				} catch (InputMismatchException e) {
					System.out.println("Input mismatch:Enter a numeric value only ");
					scannerObject.next(); // to avoid infinite loop
				}
			}
			orderEntry[loop] = new OrderEntry(productId, orderQuantity);
		}
		scannerObject.close();
		// Generate Final bill
		System.out.println(BillGenerator.getBill(orderEntry, productMap, orderPromoList, productPromoList));
	}
}