public class pathsAndCoins {
	public static void main(String args[]) {
		int[][] matrix = {{1, 2, 3},{4, 6, 5},{3, 2, 1}};
		System.out.println(numPathsWithKCoins(matrix, 2, 2, 12));
	}
	
	public static int numPathsWithKCoins(int[][] matrix, int endX, int endY, int k) {
		if (endX < 0 || endY < 0) {
			return 0;
		}
		if (endX == 0 && endY == 0) {
			return (matrix[endX][endY] == k) ? 1 : 0;
		}
		return numPathsWithKCoins(matrix, endX - 1, endY, k - matrix[endX][endY]) +
				numPathsWithKCoins(matrix, endX, endY - 1, k - matrix[endX][endY]);
	}
}
