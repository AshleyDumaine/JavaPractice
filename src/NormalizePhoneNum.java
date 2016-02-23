
public class NormalizePhoneNum {
	public static void main(String args[]) {
		System.out.println(standardizeTelephoneNumber("86/asdfasdf09/108/67/45"));
	}
	
	public static String standardizeTelephoneNumber(String phoneNumber) {
		if (phoneNumber.length() < 10) {
			return "";
		}
		int numCount = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < phoneNumber.length(); i++) {
			if (Character.isDigit(phoneNumber.charAt(i))) {
				numCount++;
				sb.append(phoneNumber.charAt(i));
				if (numCount == 3 || numCount  == 6) {
					sb.append("-");
				}
			}
		}
		if (numCount != 10) {
			return "";
		}
		return sb.toString();
	}
}
