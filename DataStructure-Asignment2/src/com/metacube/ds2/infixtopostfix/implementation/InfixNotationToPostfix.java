package com.metacube.ds2.infixtopostfix.implementation;

import com.metacube.ds2.stack.Stack;

/**
 * This class is used to convert the infix notation to postfix
 * 
 * @author Prateek Jain
 *
 */
public class InfixNotationToPostfix {

	private String infixExpression;
	private int expressionLength;
	private String postfixExpression;
	private Stack operatorList = new Stack();

	// constructor to initialize the local variables
	public InfixNotationToPostfix() {
		infixExpression = "";
		postfixExpression = "";
		expressionLength = 0;
	}

	/**
	 * Method is used to convert the expression from infix to postfix
	 * 
	 * @param expression
	 * @return
	 */
	public String convert(String expression) {
		infixExpression = expression;
		expressionLength = infixExpression.length();
		// if expression length is greater than zero then continue the conversion
		if (expressionLength > 0) {
			/*
			 *  if expression is valid then continue
			 *  else invalid expression
			 */
			if (validateExpression(infixExpression) != -1) {
				int index = 0;
				//loop continue till end of expression is reached
				while (index < expressionLength) {
					char character = infixExpression.charAt(index++);
					//switch case to perform operation according to character present at that index in expression
					switch (character) {
					/*
					 * push the character in stack if it is '('
					 * pop the characters from stack if an operand is get until ')' is got
					 * pop the characters from stack add it to postfix Expression until ')' is got
					 * by default add the character to postfix expression
					 */
					case '(':
						operatorList.push(character);
						break;

					case '+':
					case '-':
					case '*':
					case '/':
					case '^':
						//loop continue until operator list top character precedence is greater than current operator  
						while (operatorList.getSize() != 0 && getPrecedence(character) <= getPrecedence((char) operatorList.peek())) {
							postfixExpression += operatorList.pop();
						}
						operatorList.push(character);
						break;

					case ')':
						//loop until character '(' is found or list is empty
						while (operatorList.getSize() != 0) {
							char symbol = (char) operatorList.pop();
							if (symbol == '(') {
								break;
							}
							postfixExpression += symbol;
						}
						break;
					default:
						postfixExpression += character;
						break;
					}
				}
			} else {
				postfixExpression = "Invalid Expression.";
			}
		} else {
			postfixExpression = "Please Enter the expression in infix order to convert it into postfix";
		}
		return postfixExpression;
	}

	/**
	 * Method is used to validate expression
	 * @param expression
	 * @return
	 */
	private int validateExpression(String expression) {
		int flag = -1;
		int count = 0;
		int countStartingBraces = 0;
		int countClosingBraces = 0;
		expression = "(" + infixExpression;
		infixExpression = expression;
		expression = infixExpression + ")";
		infixExpression = expression;
		expressionLength += 2;
		//loop continue till end of expression is reached
		while (count < expressionLength) {
			/*
			 * if character at this index is ( then increase start brace count
			 * else if character at this index is ) then increase end brace count
			 */
			if (expression.charAt(count) == '(') {
				countStartingBraces++;
			} else if (expression.charAt(count) == ')') {
				countClosingBraces++;
			}
			count++;
		}
		// if no of starting braces is equal to no of ending braces then set flag = 0 
		if (countStartingBraces == countClosingBraces) {
			flag = 0;
		}
		return flag;
	}

	/**
	 * Method is used to get the precedence order of the character
	 * @param character
	 * @return
	 */
	private int getPrecedence(char character) {
		int precedence = 0;
		/*
		 * if character is + or - then set precedence is 1
		 * else if characeter is * or / then set precedence is 2
		 * else if character is ^ then precedence is 3
		 */
		if (character == '+' || character == '-') {
			precedence = 1;
		} else if (character == '*' || character == '/') {
			precedence = 2;
		} else if (character == '^') {
			precedence = 3;
		}
		return precedence;
	}
}