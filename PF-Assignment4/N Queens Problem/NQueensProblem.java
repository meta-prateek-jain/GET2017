public class NQueensProblem {
	/**
	 * This is a Recursive function To solve the N Queens Problem
	 * 
	 * @param board
	 * @param startRow
	 * @param dimensionOfMatrix
	 * @return
	 */
	boolean nQueen(int[][] board, int startRow, int dimensionOfMatrix) {
		// If all queens are placed then print the board and return true
		if (startRow >= board.length) {
			printSolution(board);
			return true;
		}
		// Consider this column and try placing this queen in all rows one by one
		for (int loop = 0; loop < board.length; loop++) {
			// Check if queen can be placed on board[startRow][loop]
			if (checkSafe(board, startRow, loop)) {
				board[startRow][loop] = 1;
				// Place this queen in board[startRow][loop] recur to place rest of the queens
				if (nQueen(board, startRow + 1, dimensionOfMatrix)) {
					return true;
				}
				/*
				 * If placing queen in board[startRow][loop] doesn't lead to a
				 * solution then remove queen from board[startRow][loop]
				 */
				board[startRow][loop] = 0;
			}
		}
		//If queen can not be place in any column in this row, then return false
		return false;
	}
	
	
	/**
	 * This function print the board
	 * @param board
	 */
	void printSolution(int board[][]) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(" " + board[i][j] + " ");
			}
			System.out.println();
		}
	}
	 /**
	  * Checks whether position board[row][column] is not under attack by any
	  * other queen
	  * @param board
	  * @param row
	  * @param column
	  * @return true if and false if not safe
	  */
	boolean checkSafe(int[][] board, int row, int column)throws ArrayIndexOutOfBoundsException {
		int loopColumn;
		int loopRow;
		try{
			//Checks this column on upper side
			for (loopColumn = 0; loopColumn < row; loopColumn++) {
				if (board[loopColumn][column] == 1) {
					return false;
				}
			}
			//Check upper diagonal on left side
			for (loopRow = row, loopColumn = column; loopRow >= 0
					&& loopColumn >= 0; loopRow--, loopColumn--) {
				if (board[loopRow][loopColumn] == 1) {
					return false;
				}
			}
			//Check upper diagonal on Right side
			for (loopRow = row, loopColumn = column; loopRow >= 0
					&& loopColumn < board.length; loopRow--, loopColumn++) {
				if (board[loopRow][loopColumn] == 1) {
					return false;
				}
			}
		} catch (ArrayIndexOutOfBoundsException error) {
			return false;
		}
		return true;
	}

	public static void main(String args[]) {
		NQueensProblem object = new NQueensProblem();
		int board[][] = {};
		System.out.println(board.length);
		boolean status = object.nQueen(board, 0, board.length - 1);
		if(status == false){
			System.out.println("Solution does not exist");
		}
	}
}
