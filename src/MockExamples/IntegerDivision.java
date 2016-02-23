package MockExamples;
import java.util.HashMap;
public class IntegerDivision {
	public static void main(String args[]) {
		System.out.println(divide(494532,99));
	}
	public static String divide(int dividend, int divisor) {
		StringBuilder sb = new StringBuilder();
		int rem = dividend;
		int counter = 1; // 0 for before decimal, 1 for decimal
		HashMap<Integer, Integer> rems = new HashMap<Integer, Integer>();
		while (rem != 0) {
			int times = rem / divisor;
			if (sb.length() == 0) {
				sb.append(times).append(".");
				counter += Math.floor(Math.log10(times) + 1);
			}
			else {
				sb.append(times);
			}
			rem = (rem - (times * divisor)) * 10;
			if (rems.containsKey(rem)) {
				sb.insert(rems.get(rem), "[").append("]");
				return sb.toString();	
			}
			rems.put(rem, counter++);
		}
		return sb.toString();
	}
}
