import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This is a test class for matrix
 * @author Prateek Jain
 * 
 */
public class MatrixTest {
	// Test case for testing addElements
	@Test
	public void testaddElements() {
		Matrix matrix = new Matrix(2, 3);
		matrix.addElements(0, 1, 4);
		matrix.addElements(0, 2, 7);
		matrix.addElements(1, 0, 9);
		matrix.addElements(1, 1, 3);
		matrix.addElements(1, 2, 1);
		String matrixReturn = matrix.show();
		String matrixExpected = new String("0 4 7 \n9 3 1 \n");
		assertEquals(matrixExpected, matrixReturn);
	}

	// Test case for testing transpose of matrix
	@Test
	public void testTranspose() {
		Matrix matrix = new Matrix(2, 3);
		matrix.addElements(0, 1, 4);
		matrix.addElements(0, 2, 7);
		matrix.addElements(1, 0, 9);
		matrix.addElements(1, 1, 3);
		matrix.addElements(1, 2, 1);
		Matrix matrixTranspose = matrix.transpose();
		String matrixReturn = matrixTranspose.show();
		String matrixExpected = new String("0 9 \n4 3 \n7 1 \n");
		assertEquals(matrixExpected, matrixReturn);
	}

	// Test case for testing show function
	@Test
	public void testShow() {
		Matrix matrix = new Matrix(2, 3);
		matrix.addElements(0, 1, 4);
		matrix.addElements(0, 2, 7);
		matrix.addElements(1, 0, 9);
		matrix.addElements(1, 1, 3);
		matrix.addElements(1, 2, 1);
		String matrixReturn = matrix.show();
		String matrixExpected = new String("0 4 7 \n9 3 1 \n");
		assertEquals(matrixExpected, matrixReturn);
	}

	// Test case for testing multiplication of matrix
	@Test
	public void testMultiplication() {
		Matrix matrix = new Matrix(2, 3);
		matrix.addElements(0, 1, 4);
		matrix.addElements(0, 2, 7);
		matrix.addElements(1, 0, 9);
		matrix.addElements(1, 1, 3);
		matrix.addElements(1, 2, 1);
		Matrix matrix2 = new Matrix(3, 2);
		matrix2.addElements(0, 0, 6);
		matrix2.addElements(0, 1, 1);
		matrix2.addElements(1, 1, 9);
		matrix2.addElements(2, 1, 4);
		matrix2.addElements(2, 0, 2);
		Matrix matrixMultiplied = matrix.multiplication(matrix2);
		String matrixReturn = matrixMultiplied.show();
		String matrixExpected = new String("14 64 \n56 40 \n");
		assertEquals(matrixExpected, matrixReturn);
	}

	// Test case for matrix can't multiplied
	@Test
	public void testNotMultiply() {
		Matrix matrix = new Matrix(2, 3);
		matrix.addElements(0, 1, 4);
		matrix.addElements(0, 2, 7);
		matrix.addElements(1, 0, 9);
		matrix.addElements(1, 1, 3);
		matrix.addElements(1, 2, 1);
		Matrix matrix2 = new Matrix(23, 2);
		matrix2.addElements(0, 0, 6);
		matrix2.addElements(0, 1, 1);
		matrix2.addElements(1, 0, 9);
		matrix2.addElements(1, 1, 4);
		Matrix matrixMultiplied = matrix.multiplication(matrix2);
		assertNull(matrixMultiplied);
	}
}
