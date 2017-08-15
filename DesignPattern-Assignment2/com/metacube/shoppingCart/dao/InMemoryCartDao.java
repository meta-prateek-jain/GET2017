package com.metacube.shoppingCart.dao;

import java.util.HashMap;
import java.util.Map;

import com.metacube.shoppingCart.model.*;
/**
 * Class is used to access the cart items
 *  
 * @author Prateek Jain
 *
 */
public class InMemoryCartDao implements CartDao {
	private static InMemoryCartDao cartDao;
	private static Map<Integer,BaseEntity> cartItems ;
	
	/**
	 * Initialize the cartItems map
	 */
	private InMemoryCartDao() {
		cartItems = new HashMap<Integer, BaseEntity>();
	}
	
	/**
	 * Function to get instance of this singleton class
	 * @return
	 */
	public static InMemoryCartDao getInstance(){
		//if cartDao is not null then get instance;
		if(cartDao==null){
			cartDao = new InMemoryCartDao();
		}
		return cartDao;
	}
	
	/**
	 * Function to add product or place order to cart
	 */
	public void add(BaseEntity product){
		cartItems.put(product.getId(), product);
	}
	
	/**
	 * Function to remove order from cart 
	 */
	public void remove(int productId){
		cartItems.remove(productId);
	}
	
	/**
	 * Function to edit product present in the cart
	 */
	public void edit(int productId,int quantity){
		((Cart)cartItems.get(productId)).setQuantity(quantity);
	}
	
	/**
	 * Function to retrieve particular order by its id
	 */
	@Override
	public Cart retrieve(int id) {
		return (Cart)cartItems.get(id);
	}
	
	/**
	 * Function to retrieve cart items Map
	 */
	public Map<Integer,BaseEntity> getList(){
		return cartItems;
	}
	
	/**
	 * Reset the cartItems Map
	 */
	public void resetCartList() {
		cartItems = new HashMap<Integer, BaseEntity>();
	}
}
