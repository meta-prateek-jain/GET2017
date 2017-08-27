package com.metacube.ds2.infixtopostfix;

import java.util.Scanner;

import com.metacube.ds2.infixtopostfix.implementation.InfixNotationToPostfix;

/**
 * Class is used to Convert the expression from infix to postfix expression
 * @author Prateek Jain
 *
 */
public class ConvertInfixToPostfix {
	public static void main(String[] args) {
		InfixNotationToPostfix infixToPostfix = new InfixNotationToPostfix();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Expression.");
		String infixExpression = scan.next();
		String postFix = infixToPostfix.convert(infixExpression);
		System.out.println(postFix);
		scan.close();
	}
}
