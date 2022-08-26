/*
 * Given a positive integer n, generate an n x n matrix filled with elements 
 * from 1 to n2 in spiral order.
 */

import java.util.Arrays;

public class SpiralMatrix2 {
	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int cnt = 1;
		int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int d = 0;
		int row = 0;
		int col = 0;
		while (cnt <= n * n) {
			result[row][col] = cnt++;
			// System.out.println("row and col before floorMod:" + row + "," + col);
			int r = Math.floorMod(row + dir[d][0], n);
			int c = Math.floorMod(col + dir[d][1], n);
			// System.out.println("r and c after floorMod:" + r + "," + c);

			// change direction if next cell is non zero
			if (result[r][c] != 0)
				d = (d + 1) % 4;

			row += dir[d][0];
			col += dir[d][1];
		}
		return result;
	}

	public static void main(String[] args) {
		SpiralMatrix2 spiralMatrix2 = new SpiralMatrix2();
		System.out.println(Arrays.deepToString(spiralMatrix2.generateMatrix(5)));
		System.out.println(Arrays.deepToString(spiralMatrix2.generateMatrix(6)));
	}
}
