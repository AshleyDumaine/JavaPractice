import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Numbers {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		try {
			PrintWriter pw = new PrintWriter("output.txt", "UTF-8");
			int numCases = Integer.parseInt(sc.nextLine());
			for (int i =0; i < numCases; i++) {
				int exp = sc.nextInt();
				String ans = solve(exp);
				pw.println("Case #" + (i+1) + ": " + ans);
			}
			sc.close();
			pw.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static String solve(int exp) {
		double num = Math.pow(3 + Math.sqrt(5), exp);
		int rounded = Math.floorDiv((int) num, 1);
		int ans = rounded % 1000;
		return String.format("%03d", ans);
	}
}
