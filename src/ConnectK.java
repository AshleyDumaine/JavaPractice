import java.io.*;
import java.util.*;

public class ConnectK{
	public static String solve(Scanner sc) throws IOException {
		int n = sc.nextInt();
		int k = sc.nextInt();
		char[][] f = new char[n][n];
		for (int row = 0; row < n; ++row) {
			f[row] = sc.next().toCharArray();
			char[] r = f[row];
			for (int i = n - 1, j = n - 1; i >= 0; --i) {
				if (r[i] != '.') {
					r[j] = r[i];
					if (j != i) {
						r[i] = '.';
					}
					--j;
				}
			}
		}
		boolean red = false, blue = false;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				final int[] dx = {0, 1, 1, 1};
				final int[] dy = {1, 1, 0, -1};
				for (int d = 0; d < dx.length; ++d) {
					if (i + dx[d] * k >= -1 && i + dx[d] * k <= n &&
						j + dy[d] * k >= -1 && j + dy[d] * k <= n) {
						char c = ' ';
						for (int t = 0; t < k; ++t) {
							char cc = f[i + dx[d] * t][j + dy[d] * t];
							if (c == ' ' || c == cc) {
								c = cc;
							} else {
								c = '.';
							}
						}
						if (c == 'R') {
							red = true;
						}
						if (c == 'B') {
							blue = true;
						}
					}
				}
			}
		}
		if (red)
			return(blue ? "Both" : "Red");
		else
			return(blue ? "Blue" : "Neither");
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter writer = new PrintWriter("output2.txt", "UTF-8");
		int tests = Integer.parseInt(sc.nextLine());
		for (int test = 0; test < tests; ++test) {
			String res = solve(sc);
			writer.println("Case #" + (test+1) + ": " + res);
		}
		writer.close();
	}
}
