package com.metacube.shoppingCart.facade;

import java.io.IOException;
import java.util.Map;

import com.metacube.shoppingCart.dao.BaseDao;
import com.metacube.shoppingCart.dao.DaoFactory;
import com.metacube.shoppingCart.dao.InMemoryCartDao;
import com.metacube.shoppingCart.enums.DBType;
import com.metacube.shoppingCart.enums.Entity;
import com.metacube.shoppingCart.enums.Status;
import com.metacube.shoppingCart.model.BaseEntity;
import com.metacube.shoppingCart.model.Cart;
import com.metacube.shoppingCart.model.Product;

/**
 * This facade class performs all business logics on database and update it
 * 
 * @author Prateek Jain
 *
 */
public class CartFacade {
	private static BaseDao<?> cartItems;
	private BaseDao<?> productList;
	private Status status;
	private Cart order;
	private static CartFacade cartFacade;
	
	/**
	 * function is making class a singleton
	 * @return
	 * @throws IOException
	 */
	public static CartFacade getInstance() throws IOException {
		//if cartFacade is null then initialize it
		if (cartFacade == null) {
			//synchronized the function and double check the condition
			synchronized (CartFacade.class) {
				if (cartFacade == null) {
					cartFacade = new CartFacade();
				}
			}
		}
		return cartFacade;
	}
	
	/**
	 * Constructor initializes the cartItems and productList
	 * @throws IOException
	 */
	public CartFacade() throws IOException{
		cartItems = DaoFactory.getDaoForEntity(Entity.CART, DBType.IN_MEMORY);
		productList = DaoFactory.getDaoForEntity(Entity.PRODUCT, DBType.IN_MEMORY);
	}
	
	/**
	 * Checks is cart empty or not
	 * @return
	 */
	public Status isCartEmpty() {
		status = Status.EMPTY;
		//if cart size is greater than zero then return status Not empty
		if (cartItems.getList().size() > 0) {
			status = Status.NOT_EMPTY;
		}
		return status;
	}
	
	/**
	 * checks If product id is valid or not
	 * 
	 * @param productId
	 * @return
	 */
	public Status isProductIdValid(int productId){
		status = Status.INVALID;
		//if products list contains this product id then return status valid 
		if(productList.getList().containsKey(productId)){
			status = Status.VALID;
		}
		return status;
	}
	
	/**
	 * checks if product is present in cart or not 
	 * 
	 * @param productId
	 * @return
	 */
	public Status isProductPresentInCart(int productId) {
		status = Status.NOT_PRESENT;
		//if cart contains product with this id then return status present
		if (cartItems.getList().containsKey(productId)) {
			status = Status.PRESENT;
		}
		return status;
	}
	/**
	 * Function is used to add product to cart
	 * @param productId
	 * @param quantity
	 * @return
	 */
	public Status addProductToCart(int productId, int quantity) {
		status = Status.FAILED;
		//if product id is valid then continue
		if(isProductIdValid(productId)==Status.VALID){
			/*
			 * if product is already present then just increment its quantity
			 * else add the product to cart
			 */
			if (isProductPresentInCart(productId)==Status.PRESENT) {
				cartItems.edit(productId, ((Cart)cartItems.getList().get(productId)).getQuantity()+quantity);
				status = Status.UPDATED;
			} else {
				order = new Cart();
				order.setQuantity(quantity);
				order.setId(productId);
				order.setProduct((Product) productList.getList().get(productId));
				cartItems.add(order);
				status = Status.ADDED;
			}
		}
		return status;
	}
	/**
	 * Function is edit product present in cart 
	 * @param productId
	 * @param quantity
	 * @return
	 */
	public Status editCartProduct(int productId, int quantity) {
		status = Status.FAILED;
		//if cart is not empty and product is present in cart then update its quantity
		if(isCartEmpty()==Status.NOT_EMPTY && isProductPresentInCart(productId)==Status.PRESENT){
			cartItems.edit(productId, quantity);
			status = Status.UPDATED;
		}
		return status;
	}
	
	/**
	 * Function is used to remove product from cart
	 * 
	 * @param productId
	 * @return
	 */
	public Status removeOrderFromCartByProductId(int productId) {
		status = Status.FAILED;
		//if cart is not empty and product is present in cart then remove it
		if(isCartEmpty()==Status.NOT_EMPTY && isProductPresentInCart(productId)==Status.PRESENT){
			cartItems.remove(productId);
			status = Status.REMOVED;
		}
		return status;
	}
	
	/**
	 * Function is used to retrieve order from cart by id
	 * @param productId
	 * @return
	 */
	public Cart retrieveOrderFromCartById(int productId) {
		//if cart is not empty and product is present in cart then retrieve the order
		if(isCartEmpty()==Status.NOT_EMPTY && isProductPresentInCart(productId)==Status.PRESENT){
			order = (Cart) cartItems.retrieve(productId);
		}
		return order;
	}
	
	/**
	 * Reset the cart
	 */
	public static void resetCart() {
		((InMemoryCartDao)cartItems).resetCartList();
	}
	
	/**
	 * toString function is override to display the cart to user
	 */
	@Override
	public String toString() {
		double totalAmount=0;
		String cartDetails;
		/*
		 * if cart is empty then display message
		 * else display the order present in cart with details
		 */
		if (isCartEmpty() == Status.EMPTY) {
			cartDetails = "\nCart is Empty  Buy some Product\n";
		}else{
			cartDetails = "\nYour Products in cart\n\n";
			//loop continue till end of map
			for (Map.Entry<Integer, BaseEntity> entry : cartItems.getList().entrySet()) {
				order = (Cart) entry.getValue();
				cartDetails += order.getId()
						+ "  -->  "
						+ order.getProduct().getName()
						+ "  -->  "
						+ order.getProduct().getType()
						+ "  -->  Price :  Rs "
						+ order.getProduct().getPrice()
						+ "*"
						+ order.getQuantity()
						+ " = Rs "
						+ order.getProduct().getPrice()
						* order.getQuantity()+"\n";
				totalAmount+=order.getProduct().getPrice()* order.getQuantity();
			}
			cartDetails+=" Total Amount = "+ totalAmount + "\n";
		}
		return cartDetails;
	}
}
