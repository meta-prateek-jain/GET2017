package com.metacube.shoppingCart.facade;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import com.metacube.shoppingCart.dao.DaoFactory;
import com.metacube.shoppingCart.enums.DBType;
import com.metacube.shoppingCart.enums.Entity;
import com.metacube.shoppingCart.model.BaseEntity;
import com.metacube.shoppingCart.model.Cart;
import com.metacube.shoppingCart.util.FileHandling;

/** Class is Responsible for Generating the Bill
 * 
 * @author Prateek Jain
 * 
 */
public class BillGeneratorFacade {
	private static BillGeneratorFacade billGeneratorFacade;
	private static Map<Integer, BaseEntity> cartList;
	private double totalAmount=0;
	/**
	 * Constructor Initializing the cartList Map
	 * @throws IOException 
	 */
	private BillGeneratorFacade() throws IOException {
		cartList = (Map<Integer, BaseEntity>) DaoFactory
				.getDaoForEntity(Entity.CART, DBType.IN_MEMORY).getList();
	}

	/**
	 * Making BillGeneratorFacade a singleton
	 * 
	 * @return 
	 * @throws IOException 
	 */
	public static BillGeneratorFacade getInstance() throws IOException {
		//if billGeneratorFacade is null then initialize it
		if (billGeneratorFacade == null) {
			//synchronized this and double check for null
			synchronized (BillGeneratorFacade.class) {
				if (billGeneratorFacade == null) {
					billGeneratorFacade = new BillGeneratorFacade();
				}
			}
		}
		return billGeneratorFacade;
	}

	/**
	 * Function is used to generate the purchase products list with their details 
	 * 
	 * @return
	 * @throws IOException 
	 */
	private String purchaseProductDetails() throws IOException {
		String purchasedProductsDetails = "";
		Cart order;
		Set<Integer> productId = cartList.keySet();
		for (int id : productId) {
			order = (Cart) DaoFactory.getDaoForEntity(Entity.CART, DBType.IN_MEMORY)
					.getList().get(id);
			purchasedProductsDetails += "\nProduct : " + order.getId() + " - "
					+ order.getProduct().getName() +"\n";
			purchasedProductsDetails += "Cost : Rs "
					+ (order.getProduct().getPrice() * order.getQuantity()) + "("
					+ order.getQuantity() + " X " + order.getProduct().getPrice()
					+ ")\n";
			totalAmount+=order.getProduct().getPrice()* order.getQuantity();
		}
		return purchasedProductsDetails;
	}

	/**
	 * Function is used Final sub total amount to bill string
	 *  
	 * @return
	 */
	private String subTotalValue() {
		String output = "";
		output += "\n\nSubTotal : " + totalAmount
				+ "\n";

		return output;
	}

	/**
	 * Function is used to display the final bill
	 * and also write the bill into file
	 * 
	 * @return 
	 * @throws IOException 
	 */

	public String display() throws IOException {
		if (cartList.size() == 0) {
			return "\n--------------Cart Is Empty-----------------\n";
		}
		String display = "";
		String hashtag = "\n##########################################################################################\n";
		display += hashtag + "\n  Your Order " + " \n" + hashtag;
		display += "\n PRODUCTS PURCHASED :\n";
		display += purchaseProductDetails();
		display += subTotalValue();
		display += hashtag + "  THANK YOU " + hashtag;
		FileHandling.getInstance().write(display);
		
		//reseting the cart
		CartFacade.resetCart();
		return display;
	}
}
