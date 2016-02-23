import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Boggle {
	public static void main(String args[]) {
		try {
			Scanner fs = new Scanner(new File("boggle.txt").getAbsoluteFile());
			final int size = 4;
			char[][] startingBoard = new char[size][size];
			String row = fs.nextLine();
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					startingBoard[i][j] = row.charAt(j);
					if (j == size - 1 && fs.hasNextLine()) {
						row = fs.nextLine();
					}
				}
			}
			fs.close();
			System.out.println("Input: ");
			printGrid(startingBoard);
			HashSet<String> res = findWords(startingBoard, 0, 0);
			for (String word : res) {
				System.out.println(word);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static HashSet<String> findWords(char[][] board, int x, int y) {
		HashSet<String> res = new HashSet<String>();
		
		return res;
	}
	
	public static void printGrid(char[][] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				System.out.print(input[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
