import java.util.Scanner;
public class FindMax {
	public static int findMax(int a, int b) {
		return ((a + b) + Math.abs(a - b))/2;
	}
	//driver program
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two numbers: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		int res = findMax(a, b);
		System.out.println("Max: " + res);
	}
}