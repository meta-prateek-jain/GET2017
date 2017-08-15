package com.metacube.shoppingCart.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.metacube.shoppingCart.controller.ProductController;
import com.metacube.shoppingCart.enums.Status;

/**
 * Class is used to take inputs according to option selected 
 * @author Prateek Jain
 *
 */
public class DisplayInput {
	private static Scanner scan;
	private ProductController controller;
	private static DisplayInput input;
	
	/**
	 * Constructor to initialize the controller
	 */
	public DisplayInput(){
		controller = ProductController.getInstance();
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
		boolean flag = false;
		int choice;
		//loop continues till user choose to exit
		while (!flag) {
			try{
				System.out.println("1.Display Product List");
				System.out.println("2.Add Product in List");
				System.out.println("3.Remove Product From List");
				System.out.println("4.Edit Product in List");
				System.out.println("5.Exit");
				choice = scan.nextInt();
				//case selected according to choice and function called
				switch (choice) {
				case 1:
					displayProductList();
					break;
				case 2:
					addProductInList();
					break;
				case 3:
					removeProductFromList();
					break;
				case 4:
					editProduct();
					break;
				case 5:
					flag = true;
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
	 * Function to add product to list
	 */
	private void addProductInList() {
		scan = new Scanner(System.in);
		int id;
		String name;
		String type;
		int productPrice;
		boolean flag=false;
		//loop continue until valid input entered
		System.out.println("Enter name of product");
		name = scan.nextLine();
		System.out.println("Enter the type of product");
		type = scan.nextLine();
		if(controller.checkProduct(name, type)==Status.NOT_PRESENT){
			id=controller.generateId();
			while(!flag){
				try{
					System.out.println("Enter the product Price");
					productPrice=scan.nextInt();
					while(productPrice<=0){
						System.out.println("Price Sholud be greater than zero");
						productPrice=scan.nextInt();
					}
					controller.addProductInList(id, name, type, productPrice);
					flag=true;
				}catch(InputMismatchException e){
					System.out.println("Please enter valid input");
					scan.next();
				}
			}
		}
	}
	
	/**
	 * Function is used to call controller to display all available products list
	 */
	public void displayProductList(){
		controller.displayProductList();
	}
	
	/**
	 * Function to edit the Product present in List
	 */
	public void editProduct(){
		scan = new Scanner(System.in);
		int id;
		int price;
		boolean flag=false;
		//loop continue until valid input entered
		while(!flag){
			/*
			 * if list is not empty then continue
			 * else display List is empty 
			 */
			if(controller.checkList()!=Status.EMPTY){
				try{
					System.out.println("Enter the Product id");
					id = scan.nextInt();
					/*
					 * if product is present in cart then update its quantity
					 * else display message
					 */
					if(controller.checkProductId(id)==Status.PRESENT){
						System.out.println("Enter the new Price");
						price = scan.nextInt();
						while(price <= 0){
							System.out.println("Price should be greater than zero");
							price = scan.nextInt();
						}
						controller.editCart(id, price);
					}else{
						System.out.println("No product with this id is present in Product List.");
					}
					flag = true;
				}catch(InputMismatchException e){
					System.out.println("Please enter valid input");
					scan.next();
				}
			}else{
				displayProductList();;
				flag = true;
			}
		}
	}
	/**
	 * Function to remove order from cart
	 */
	public void removeProductFromList(){
		scan = new Scanner(System.in);
		int id;
		boolean flag=false;
		//loop continue until valid input is entered
		while(!flag){
			/*
			 * if cart is not empty then continue
			 * else display cart is empty 
			 */
			if(controller.checkList()==Status.NOT_EMPTY){
				try{
					System.out.println("Enter the Product id");
					id = scan.nextInt();
					/*
					 * if product with this id is present then remove it 
					 * else display message
					 */
					if(controller.checkProductId(id)==Status.PRESENT){
						controller.removeProduct(id);
					}else{
						System.out.println("Product is not present in Cart.");
					}
					flag = true;
				}catch(InputMismatchException e){
					System.out.println("Please enter valid id");
					scan.next();
				}
			}else{
				displayProductList();
				flag = true;
			}
		}
	}
}
