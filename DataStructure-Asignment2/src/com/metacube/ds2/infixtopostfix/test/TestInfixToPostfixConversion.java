package com.metacube.ds2.infixtopostfix.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.metacube.ds2.infixtopostfix.implementation.InfixNotationToPostfix;

/**
 * This is a Test class of Infix to Postfix Conversion
 * 
 * @author Prateek Jain
 *
 */
public class TestInfixToPostfixConversion {

	InfixNotationToPostfix infixToPostfix;
	/**
	 * Method is used to set up the infixToPostfix class object
	 */
	@Before
	public void setUp() {
		infixToPostfix = new InfixNotationToPostfix();
	}
	/**
	 * Method is used to test the conversion when Non Parenthesized Numerical Expression is used as input 
	 */
	@Test
    public void testConversionForNonParenthesizedNumbericalExpression() {
        String infix = "54+46+45+46+465+45-44*55/5+89";
        String postfix = infixToPostfix.convert(infix);
        String expectedPostfix="5446+45+46+465+45+4455*5/-89+";
        assertEquals(expectedPostfix,postfix);
        
    }
	/**
	 * Method is used to test the conversion when Non Parenthesized Expression is used as input
	 */
    @Test
    public void testConversionForNonParenthesizedExpression() {
        String infix = "A+B*C/D-E*F";
        String postfix = infixToPostfix.convert(infix);
        String expectedPostfix="ABC*D/+EF*-";
        assertEquals(expectedPostfix,postfix);
        
    }
    /**
	 * Method is used to test the conversion when Parenthesized Numerical Expression is used as input
	 */
    @Test
    public void testConversionForParenthesizedNumbericalExpression() {
        String infix = "(54*13)+9-7*(4/6)";
        String postfix = infixToPostfix.convert(infix);
        String expectedPostfix="5413*9+746/*-";
        assertEquals(expectedPostfix,postfix);
        
    }
    /**
	 * Method is used to test the conversion when Parenthesized Alphabetic Expression is used as input
	 */
    @Test
    public void testConversionForParenthesizedAlphabeticExpression() {
        String infix="(A*(B+(C/D)))";
        String postfix = infixToPostfix.convert(infix);
        String expectedPostfix="ABCD/+*";
        assertEquals(expectedPostfix,postfix);
        
    }
    /**
	 * Method is used to test the conversion when expression is invalid
	 */
    @Test
    public void testConversionForInfixToPostfixConversionForInvalidExpression() {
    	String infix="(A+(*(B+(C/D)))";
        String postfix = infixToPostfix.convert(infix);
        String expectedPostfix="Invalid Expression.";
        assertEquals(expectedPostfix,postfix);
    }
}
