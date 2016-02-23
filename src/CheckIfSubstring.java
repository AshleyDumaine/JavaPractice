import java.util.Scanner;
public class CheckIfSubstring {
	public static boolean isSubstring(String string, String substring) {
		return(substring.length() <= string.length() && string.indexOf(substring) != -1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two strings: ");
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		boolean res1 = isSubstring(str1, str2);
		boolean res2 = isSubstring(str2, str1);
		System.out.println(str2 + (res1 ? " is " : " is not ") + "a substring of " + str1);
		System.out.println(str1 + (res2 ? " is " : " is not ") + "a substring of " + str2);
		sc.close();
	}
}
