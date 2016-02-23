//idea: sort one list in ascending order, the other in descending, and then take scalar product
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.*;

public class MinScalarProduct {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		try {
			PrintWriter writer = new PrintWriter("output2.txt", "UTF-8");
			int numCases = Integer.parseInt(sc.nextLine());
			for (int i =0; i < numCases; i++) {
				int numNumbers = Integer.parseInt(sc.nextLine());
				Long[] vec1 = new Long[numNumbers];
				Long[] vec2 = new Long[numNumbers];
				for (int j = 0; j < numNumbers; j++) {
					vec1[j] = sc.nextLong();
				}
				sc.nextLine(); //consume newline char
				for (int k =0; k < numNumbers; k++) {
					vec2[k] = sc.nextLong();
				}
				sc.nextLine(); //consume newline char
				long res = minScalarProduct(vec1, vec2);
				writer.println("Case #" + (i+1) + ": " + res);
			}
			writer.close();
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public static long minScalarProduct(Long[] first, Long[] second) {
		if (first.length != second.length) {
			System.out.println("Arrays must be of equal size.");
			return Long.MAX_VALUE;
		}
		else {
		Arrays.sort(first);
		Arrays.sort(second, Collections.reverseOrder());
		long res = 0;
		for (int i = 0; i < first.length; i++) {
			res += first[i] * second[i];
		}
		return res;
		}
	}
}
