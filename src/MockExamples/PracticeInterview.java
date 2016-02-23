package MockExamples;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;


public class PracticeInterview {
	public static boolean isUnique(LinkedList<String> input) {
	    HashSet<String> set = new HashSet<String>();
	    if (input == null) {
	        return true;
	    }
	    for (String element : input) {
	        if (set.contains(element)) {
	            return false;
	        }
	        set.add(element);
	     }
	     return true;
	}
	
	public static boolean[][] nextIteration(boolean[][] input) {
		int numCol = input.length;
		int numRow = input[0].length;
		boolean[][] res = new boolean[numCol][numRow];
		for (int i = 0; i < numCol; i++) {
			for (int j = 0; j < numRow; j++) {
				int numAlive = 0;
				if (j > 0) { //check row above
					if (i > 0) {
						if (input[i-1][j-1]) {
							numAlive++;
						}
					}
					if (i < numCol-1) {
						if (input[i+1][j-1]) {
							numAlive++;
						}
					}
					if (input[i][j-1]) {
						numAlive++;
					}
				}
				if (j < numRow-1) { //check row below
					if (i > 0) {
						if (input[i-1][j+1]) {
							numAlive++;
						}
					}
					if (i < numCol-1) {
						if (input[i+1][j+1]) {
							numAlive++;
						}
					}
					if (input[i][j+1]) {
						numAlive++;
					}
				}
				if (i > 0) { //check left
					if (input[i-1][j]) {
						numAlive++;
					}
				}
				if (i < numCol-1) { //check right
					if (input[i+1][j]) {
						numAlive++;
					}
				}
				if (numAlive == 3) {
					res[i][j] = true;
				}
				else if (numAlive == 2) {
					res[i][j] = input[i][j];
				}
			}
		}
		return res;
	}
	
	public static void printGrid(boolean[][] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				if (input[i][j]) {
					System.out.print("* ");
				}
				else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static double findAverage(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		int count = 0;
		int sum = 0;
		while (sc.hasNextLine()) {
			count++;
			sum += sc.nextInt();
		}
		sc.close();
		return sum / count;
	}
	
	public static void main(String args[]) throws InterruptedException, FileNotFoundException {
		String name = "nums.txt";
		double res = findAverage(new File(name).getAbsoluteFile());
		System.out.println(res);
		// this commented out code makes a glider move across the grid
		/*boolean[][] input = new boolean[20][20];
		input[2][0] = true;
		input[2][1] = true;
		input[2][2] = true;
		input[1][2] = true;
		input[0][1] = true;
		//System.out.println("Input:");
		printGrid(input);
		Thread.sleep(5000);
		while (true) {
			input = nextIteration(input);
			printGrid(input);
			Thread.sleep(500);
			System.out.print("\b\b\b\b\b\b\b\b\b");
		}*/
	}
}
