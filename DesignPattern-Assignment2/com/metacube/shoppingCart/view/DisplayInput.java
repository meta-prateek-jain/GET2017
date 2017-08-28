package com.metacube.shoppingCart.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.metacube.shoppingCart.controller.CartController;
import com.metacube.shoppingCart.enums.Status;

/**
 * Class is used to take inputs according to option selected 
 * @author Prateek Jain
 *
 */
public class DisplayInput {
	private static Scanner scan;
	private CartController controller;
	private static DisplayInput input;
	
	/**
	 * Constructor to initialize the controller
	 */
	public DisplayInput(){
		controller = CartController.getInstance();
	}
	/**
	 * Function to make class a singleton
	 * @return
	 */
	public static DisplayInput getInstance() {
		//if input is null then initialize it
		if (input == null) {
			//synchronized the function and double check condition
			synchronized (DisplayInput.class) {
				if (input == null) {
					input = new DisplayInput();
				}
			}
		}
		return input;
	}
	/**
	 * Function displays the menu to take input and call function according to choice 
	 */
	public void displayInput(){
		scan = new Scanner(System.in);
		System.out.println("Welcome to Shopping Cart Application\n\n");
		boolean flag = false;
		int choice;
		//display all products list
		displayProductList();
		//loop continues till user choose to exit
		while (!flag) {
			try {
				System.out.println("1.Buy Product\n2.Cart\n3.Exit.\n");
				System.out.println("Enter Your choice");
				choice = scan.nextInt();
				//select the case according to choice
				switch (choice) {
				case 1:
					getDetailsToBuyProduct();
					break;
				case 2:
					cart();
					break;
				case 3:
					flag = true;
					break;
				default:
					System.out.println("Invalid choice");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid choice. Try again");
				scan.next();
			}
		}
	}
	/**
	 * Function Display the cart menu
	 */
	private void cart() {
		boolean back = false;
		//loop continue till user go back to previous menu
		while (!back) {
			try{
				System.out.println("1.Display Cart");
				System.out.println("2.Remove Product From Cart");
				System.out.println("3.Edit Product in Cart");
				System.out.println("4.Checkout");
				System.out.println("5.Back");
				int choice = scan.nextInt();
				//case selected according to choice and function called
				switch (choice) {
				case 1:
					displayCart();
					break;
				case 2:
					removeFromCart();
					break;
				case 3:
					editCart();
					break;
				case 4:
					generateBill();
					break;
				case 5:
					back = true;
					break;
				default:
					System.out.println("Invalid choice");
				}
			} catch (InputMismatchException e) {
				System.out.println("Please Enter Correct choice");
				scan.next();
			}
		}
	}

	/**
	 * Function is used to call controller to generate the final Bill
	 */
	private void generateBill() {
		controller.generateBill();
	}
	/**
	 * Function is used to call controller to display all available products list
	 */
	public void displayProductList(){
		controller.displayProductList();
	}
	/**
	 * Function is used to call controller to take details for buying product and add product to cart
	 */
	public void getDetailsToBuyProduct() {
		int count = 0;
		int id;
		int quantity;
		boolean flag = false;
		//loop continues till all details entered are correct
		while (!flag) {
			try {
				System.out.println("Enter number of products you want to buy");
				count = scan.nextInt();
				//if count is less than and equal to zero then display message and ask to enter again
				if(count<=0){
					System.out.println("Number should be greater than zero ");
				}
				//loop continues till required number of products added to cart 
				while (count > 0 ) {
					try {
						System.out.println("Enter the Product id");
						id = scan.nextInt();
						/*
						 * if id is valid then continue
						 * else print invalid id message
						 */
						if(controller.checkIdValidity(id) == Status.VALID){
							System.out.println("Enter the quantity");
							quantity = scan.nextInt();
							//loop continue until a valid quantity is entered
							while(quantity<=0){
								System.out.println("Quantity should be greater than zero ");
								quantity = scan.nextInt();
							}
							controller.buyProduct(id, quantity);
							count--;
						}else{
							System.out.println("Invalid product Id");
						}
					} catch (InputMismatchException e) {
						System.out.println("Please enter valid input");
						scan.next();
					}
					flag = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter valid input");
				scan.next();
			}
		}
	}

	/**
	 * Function to display the cart details
	 */
	public void displayCart() {
		controller.displayCart();
	}

	/**
	 * Function to edit the order present in cart
	 */
	public void editCart(){
		int id;
		int quantity;
		boolean flag=false;
		//loop continue until valid input entered
		while(!flag){
			/*
			 * if cart is not empty then continue
			 * else display cart is empty 
			 */
			if(controller.checkCartSize()!=Status.EMPTY){
				try{
					System.out.println("Enter the Product id");
					id = scan.nextInt();
					/*
					 * if product is present in cart then update its quantity
					 * else display message
					 */
					if(controller.checkIdPresentInCart(id)==Status.PRESENT){
						System.out.println("Enter the new quantity");
						quantity = scan.nextInt();
						while(quantity <= 0){
							System.out.println("Quantity should be greater than zero");
							quantity = scan.nextInt();
						}
						controller.editCart(id, quantity);
					}else{
						System.out.println("No product with this id is present in cart.");
					}
					flag = true;
				}catch(InputMismatchException e){
					System.out.println("Please enter valid input");
					scan.next();
				}
			}else{
				displayCart();
				flag = true;
			}
		}
	}
	/**
	 * Function to remove order from cart
	 */
	public void removeFromCart(){
		int id;
		boolean flag=false;
		//loop continue until valid input is entered
		while(!flag){
			/*
			 * if cart is not empty then continue
			 * else display cart is empty 
			 */
			if(controller.checkCartSize()==Status.NOT_EMPTY){
				try{
					System.out.println("Enter the Product id");
					id = scan.nextInt();
					/*
					 * if product with this id is present then remove it 
					 * else display message
					 */
					if(controller.checkIdPresentInCart(id)==Status.PRESENT){
						controller.removeOrderFromCart(id);
					}else{
						System.out.println("Product is not present in Cart.");
					}
					flag = true;
				}catch(InputMismatchException e){
					System.out.println("Please enter valid id");
					scan.next();
				}
			}else{
				displayCart();
				flag = true;
			}
		}
	}
}
