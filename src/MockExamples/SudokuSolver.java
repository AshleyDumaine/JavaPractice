package MockExamples;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SudokuSolver {
	public static void main(String args[]) {
		try {
			Scanner fs = new Scanner(new File("sudoku.txt").getAbsoluteFile());
			int size = 9;
			int[][] startingGrid = new int[size][size];
			String row = fs.nextLine();
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					startingGrid[i][j] = Character.getNumericValue(row.charAt(j));
					if (j == size - 1 && fs.hasNextLine()) {
						row = fs.nextLine();
					}
				}
			}
			fs.close();
			System.out.println("Input: ");
			printGrid(startingGrid);
			solve(startingGrid, 0, 0);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void solve(int[][] grid, int xIndex, int yIndex) {
		int maxNum = grid.length;
		if (yIndex == maxNum) {
			System.out.println("Solution: ");
			printGrid(grid);
		}
		else {
			int nextY = (xIndex == 8) ? yIndex + 1 : yIndex;
			int nextX = (xIndex == 8) ? 0 : xIndex + 1;
			if (grid[yIndex][xIndex] != 0) {
				solve(grid, nextX, nextY);
			}
			else {
				for (int i = 1; i <= maxNum; i++) {
					if (!existsInSquare(grid, yIndex, xIndex, i)
							&& !existsInRow(grid, yIndex, i)
							&& !existsInCol(grid, xIndex, i)) {
						grid[yIndex][xIndex] = i;
						solve(grid, nextX, nextY);
					}
				}
				// something placed before was wrong and should be reset
				grid[yIndex][xIndex] = 0;
			}
		}
	}

	public static boolean existsInSquare(int[][] grid, int row, int col, int num) {
		int size = grid.length;
		int squareRow = (int) Math.floor(row / Math.sqrt(size));
		int squareCol = (int) Math.floor(col / Math.sqrt(size));
		int rowStart = (int) (squareRow * Math.sqrt(size));
		int colStart = (int) (squareCol * Math.sqrt(size));
		for (int i = rowStart; i < rowStart + Math.sqrt(size); i++) {
			for (int j = colStart; j < colStart + Math.sqrt(size); j++) {
				if (grid[i][j] == num) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean existsInRow(int[][] grid, int row, int num) {
		for (int col = 0; col < grid.length; col++) {
			if (grid[row][col] == num) {
				return true;
			}
		}
		return false;
	}

	public static boolean existsInCol(int[][] grid, int col, int num) {
		for (int row = 0; row < grid[0].length; row++) {
			if (grid[row][col] == num) {
				return true;
			}
		}
		return false;
	}

	public static void printGrid(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if ((j % 3) != 2 || j == grid.length - 1) {
					System.out.print(grid[i][j] + " ");
				}
				else {
					System.out.print(grid[i][j] + " | ");
				}
			}
			if ((i % 3) == 2 && i != grid.length - 1) {
				System.out.println();
				System.out.print("---------------------");
			}
			System.out.println();
		}
		System.out.println();
	}
}