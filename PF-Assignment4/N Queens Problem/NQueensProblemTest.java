import static org.junit.Assert.*;

import org.junit.Test;

public class NQueensProblemTest {
	// The testQueen object of class NQueensProblem
	private static NQueensProblem testQueen = new NQueensProblem();
	
	/**
	 * This will test NQueen when board is empty
	 */
	@Test
	public void testNQueenForNull() {
		int board1[][] = {} ;
		boolean status = testQueen.nQueen(board1, 0, board1.length - 1);
		assertTrue(status);
	}
	/**
	 * This will test NQueen when board length is 3
	 */
	@Test
	public void testNQueenFor3() {
		int board[][] = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		boolean status = testQueen.nQueen(board, 0, board.length - 1);
		assertFalse(status);
	}
	/**
	 * This will test NQueen when board length is 4
	 */
	@Test
	public void testNQueenFor4() {
		int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 } };
		boolean status = testQueen.nQueen(board, 0, board.length - 1);
		assertTrue(status);
	}
	
}