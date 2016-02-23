import java.util.Scanner;

public class CheckIfRot {
	//check if a string is a rotation of another
	public static boolean isRotation(String str, String rot) {
		return(str.length() == rot.length() && (str + str).indexOf(rot) != -1);
	}

	//driver program
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two strings: ");
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		boolean res = isRotation(str1, str2);
		System.out.println(res);
		sc.close();
	}
}
