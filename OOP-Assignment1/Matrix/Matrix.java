import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Implement Matrix Class as discussed in session. Write proper unit test for
 * addElements, transpose, show, multiplication methods.
 * 
 * @author Prateek Jain
 * Dated : 19/07/2017
 *
 */
public class Matrix {
	private int data[][];
	private	int noOfRows;
	private int	noOfColumns;
	/**
	 * Constructor Initializing the variable
	 * @param row
	 * @param column
	 */
	public Matrix(int row, int column){
		this.noOfRows = row;
		this.noOfColumns = column;
		data = new int[row][column];
	}
	/**
	 * Function adding elements to the matrix 
	 * @param rowIndex
	 * @param columnIndex
	 * @param value
	 */
	public void addElements(int rowIndex, int columnIndex, int value){
		this.data[rowIndex][columnIndex] = value;
	}
	/**
	 * Function returns the transpose of matrix
	 * @return
	 */
	public Matrix transpose(){
		Matrix matrixTranspose = new Matrix(this.noOfColumns, this.noOfRows);
		//Stores martix.data[rowIndex][columnIndex] into matrixTranspose.data[columnIndex][rowIndex]
		for(int rowIndex =0; rowIndex < this.noOfRows; rowIndex++){
			for(int columnIndex = 0; columnIndex< this.noOfColumns; columnIndex++){
				matrixTranspose.data[columnIndex][rowIndex] = this.data[rowIndex][columnIndex];
			}
		}
		return matrixTranspose;
	}
	/**
	 * Function to print multiplication of two matrixes
	 * @param matrix
	 * @return
	 */
	public Matrix multiplication(Matrix matrix){
		//Checking number of rows of one matrix is equal to number of columns of another matrix
		if(this.noOfColumns == matrix.noOfRows){
			Matrix matrixMultiplied = new Matrix(this.noOfRows, matrix.noOfColumns);
			for (int rowIndex = 0; rowIndex < this.noOfRows; rowIndex++) {
				for (int columnIndex = 0; columnIndex < matrix.noOfColumns; columnIndex++) {
					for (int loop = 0; loop < this.noOfColumns; loop++) {
						matrixMultiplied.data[rowIndex][columnIndex] += this.data[rowIndex][loop]
																		* matrix.data[loop][columnIndex];
					}
				}
			}
			return matrixMultiplied;
		}
		return null;
	}
	/**
	 * Function prints the matrix
	 */
	public String show(){
		String matrix = new String();
		for(int rowIndex =0; rowIndex < this.noOfRows; rowIndex++){
			for(int columnIndex = 0; columnIndex< this.noOfColumns; columnIndex++){
				System.out.print(this.data[rowIndex][columnIndex]+" ");
				matrix += this.data[rowIndex][columnIndex]+" ";
			}
			matrix +="\n";
			System.out.println();
		}
		return matrix;
	}
	
	public static void main(String[] args) {
		int noOfRow;
		int noOfColumn;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of rows and number of columns matrix");
		try {
			noOfRow = scanner.nextInt();
			noOfColumn = scanner.nextInt();
			Matrix matrix = new Matrix(noOfRow, noOfColumn);
			Matrix transposedMatrix;
			Matrix multipliedMatrix;
			/*
			 * if number of rows and columns are greater than zero then do the matrix operation
			 * else throw  an exception to display a message 
			 */
			if (noOfRow > 0 && noOfColumn > 0) {
				System.out.println("Enter the elements of matrix");
				for (int rowIndex = 0; rowIndex < noOfRow; rowIndex++) {
					for (int columnIndex = 0; columnIndex < noOfColumn; columnIndex++) {
						matrix.addElements(rowIndex, columnIndex,
								scanner.nextInt());
					}
				}
				System.out.println("\nThe matrix is");
				matrix.show();
				transposedMatrix = matrix.transpose();
				System.out.println("\nThe Transpose of matrix is");
				transposedMatrix.show();
				multipliedMatrix = transposedMatrix.multiplication(matrix);
				/*
				 * If multipliedMatrix is not not null then display the matrix
				 * else display the message
				 */
				if (multipliedMatrix != null) {
					System.out.println("\nThe Multiplication of transposed matrix and original matrix is");
					multipliedMatrix.show();
				} else {
					System.out.println("Matrix cannot be multiplied");
				}
			} else {
				throw new NegativeArraySizeException();
			}
		} catch (NegativeArraySizeException na) {
			System.out.println("Enter the values greater than zero");
		}catch (InputMismatchException exception) {
			System.out.println("Enter the integer value");
		} finally {
			scanner.close();
		}
	}
}
