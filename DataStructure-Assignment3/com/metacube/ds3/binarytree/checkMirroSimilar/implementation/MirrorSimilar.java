package com.metacube.ds3.binarytree.checkMirroSimilar.implementation;

import com.metacube.ds3.binarytree.enums.Status;
import com.metacube.ds3.binarytree.node.Node;

/**
 * Checks if two trees are mirror images of each other or not.
 * 
 * @author Prateek Jain
 */
public class MirrorSimilar {

	/**
	 * Method is used to check is firstTree and secondTree are mirror similar or not
	 * 
	 * @param firstTree
	 * @param secondTree
	 * @return
	 */
	public static Status check(Node firstTree, Node secondTree) {
		Status status = Status.INVALID;
		/*
		 * if firstTree and secondTree are null then valid 
		 * else if only one of them is null then InValid 
		 * else check if left subtree of each tree is 
		 * mirror similar to right subtree of other tree or not
		 */
		if (firstTree == null && secondTree == null) {
			status = Status.VALID;
		} else if (firstTree == null || secondTree == null) {
			status = Status.INVALID;
		} else {
			/*
			 *  check if Both trees root is equal or not, and 
			 *  left subtree of each tree is mirror similar to right subtree of the other tree, and vice versa
			 */
			if ((firstTree.data == secondTree.data) && (check(firstTree.left, secondTree.right) == Status.VALID)
					&& (check(firstTree.right, secondTree.left) == Status.VALID)) {
				status = Status.VALID;
			}
		}
		return status;
	}
}
