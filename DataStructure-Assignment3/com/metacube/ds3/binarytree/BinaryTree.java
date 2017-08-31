package com.metacube.ds3.binarytree;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.metacube.ds3.binarytree.implementation.BinaryTreeImplementation;

/**
 * This is a main class which is used to create the binary tree from queue of elements
 * and traverse the binary tree in preOrder and postOrder
 * 
 * @author Prateek Jain
 *
 */
public class BinaryTree {

	/**
	 * Main method to start the application in console
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeImplementation binaryTree = new BinaryTreeImplementation();
		Scanner scan = new Scanner(System.in);
		Queue<String> elementsList = new LinkedList<String>();
		int size = 0;
		System.out.println("Enter the number of elements of which Binary tree need to be create");
		//loop continue till valid number is entered
		while(true){
			try{
				size = scan.nextInt();
				/*
				 * if size is less than or equal to zero then diplay message and take input again
				 * else break the loop  
				 */
				if(size <= 0){
					System.out.println("Size should be greater than zero. Try Again");
				}else{
					break;
				}
			}catch(InputMismatchException e){
				System.out.println("Invalid input .Try again");
				scan.next();
			}
		}
		System.out.println("Enter the elements.");
		//loop continue till all the elements are entered
		for(int index = 0 ; index < size; index++){
			elementsList.add(scan.next());
		}
		binaryTree.create(elementsList);
		System.out.println("PreOrder Traversal of tree");
		System.out.println(binaryTree.preOrderTraversal(binaryTree.getRoot()));
		System.out.println("PostOrder Traversal of tree");
		System.out.println(binaryTree.postOrderTraversal(binaryTree.getRoot()));
		scan.close();
	}
}
