//divide without divison operator
public class AlternateDivision {
	public static int divide(int dividend, int divisor) {
		int res = 0;
		int current = 1;
		if (divisor > dividend) return 0;
		if (divisor == dividend) return 1;
		while (divisor <= dividend) {
			divisor <<= 1;
			current <<= 1;
		}
		divisor >>= 1;
		current >>= 1;
		while (current != 0) {
			if (dividend >= divisor) {
				dividend =- divisor;
				res |= current;
			}
			current >>= 1;
			divisor >>= 1;
		}
		return res;
	}
	
	public static String revStr(String str) {
		int start = 0;
		int end = str.length() - 1;
		StringBuilder sb = new StringBuilder(str);
		while (start < end) {
			char temp = str.charAt(start);
			sb.setCharAt(start++, str.charAt(end));
			sb.setCharAt(end--, temp);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
			String res = revStr("this is a test");
			System.out.println(res);
	}
}